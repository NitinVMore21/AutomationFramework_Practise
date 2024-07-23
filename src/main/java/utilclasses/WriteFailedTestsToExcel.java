package utilclasses;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileInputStream;

public class WriteFailedTestsToExcel {

    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        Workbook workbook = null;

        try {
            // Open the existing Excel file
            File excelFile = new File("C:\\ws\\Automation_Practise\\AutomationFramework_Practise\\TestCases_Report.xlsx");
            fileInputStream = new FileInputStream(excelFile);
            workbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheetAt(0); // Assuming you want to write to the first sheet

            // Parse the testng-failed.xml file
            File xmlFile = new File("C:\\ws\\Automation_Practise\\AutomationFramework_Practise\\test-output\\testng-failed.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            // Get all failed test methods
            NodeList testMethodNodes = doc.getElementsByTagName("test-method");

            // Write the failed test cases to the status column (e.g., column 2 which is index 1)
            int statusColumnNumber = 1;

            for (int i = 0; i < testMethodNodes.getLength(); i++) {
                if (testMethodNodes.item(i).getAttributes().getNamedItem("Status").getNodeValue().equalsIgnoreCase("FAIL")) {
                    String testCaseName = testMethodNodes.item(i).getAttributes().getNamedItem("name").getNodeValue();

                    // Iterate through rows to find the matching test case name
                    for (Row row : sheet) {
                        Cell cell = row.getCell(0); // Assuming the test case name is in the first column (index 0)
                        if (cell != null && cell.getCellType() == CellType.STRING) {
                            String cellValue = cell.getStringCellValue();
                            if (cellValue.equals(testCaseName)) {
                                Cell statusCell = row.getCell(statusColumnNumber);
                                if (statusCell == null) {
                                    statusCell = row.createCell(statusColumnNumber);
                                }
                                statusCell.setCellValue("FAIL");
                                break;
                            }
                        }
                    }
                }
            }

            // Write the output to the existing Excel file
            fileInputStream.close(); // Close the input stream before writing the file
            fileOutputStream = new FileOutputStream(excelFile);
            workbook.write(fileOutputStream);

            System.out.println("Failed test cases have been written to the specified column in the existing Excel file");

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
