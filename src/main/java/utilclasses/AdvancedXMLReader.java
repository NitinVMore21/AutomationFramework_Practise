package utilclasses;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileInputStream;

public class AdvancedXMLReader {

    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        Workbook workbook = null;

        try {
            // Open the existing Excel file
            File excelFile = new File(System.getProperty("user.dir") + "\\TestCases_Report.xlsx");
            fileInputStream = new FileInputStream(excelFile);
            workbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheetAt(0); // Assuming you want to write to the first sheet

            // List of XML files to parse need to mention pass or failed xml name in path
            String[] xmlFiles = {
                "D:\\eclipse_workspace\\Automation_Practise\\AutomationFramework_Practise\\test-output\\testng-failed.xml",
                "D:\\eclipse_workspace\\Automation_Practise\\AutomationFramework_Practise\\test-output\\testng-passed.xml"
            };

            // XPath for extracting test methods
            XPath xpath = XPathFactory.newInstance().newXPath();
            String expression = "//include";

            for (String xmlFilePath : xmlFiles) {
                File xmlFile = new File(xmlFilePath);
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(xmlFile);
                doc.getDocumentElement().normalize();

                NodeList testMethodNodes = (NodeList) xpath.compile(expression).evaluate(doc, XPathConstants.NODESET);

                // Determine the status based on the XML file name
                String status = xmlFilePath.contains("failed") ? "FAIL" : "PASS";

                // Write the test results to the status column (e.g., column 5 which is index 4)
                int statusColumnNumber = 4;

                for (int i = 0; i < testMethodNodes.getLength(); i++) {
                    String methodName = testMethodNodes.item(i).getAttributes().getNamedItem("name").getNodeValue();

                    // Iterate through rows to find the matching test case name
                    for (Row row : sheet) {
                        Cell cell = row.getCell(1); // Assuming the test case name is in the second column (index 1)
                        if (cell != null && cell.getCellType() == CellType.STRING) {
                            String cellValue = cell.getStringCellValue();
                            if (cellValue.equals(methodName)) {
                                Cell statusCell = row.getCell(statusColumnNumber);
                                if (statusCell == null) {
                                    statusCell = row.createCell(statusColumnNumber);
                                }
                                statusCell.setCellValue(status);
                            }
                        }
                    }
                }
            }

            // Write the output to the existing Excel file
            fileInputStream.close(); // Close the input stream before writing the file
            fileOutputStream = new FileOutputStream(excelFile);
            workbook.write(fileOutputStream);

            System.out.println("Test cases have been written to the specified column in the existing Excel file");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the resources
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (workbook != null) {
                try {
                    workbook.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
