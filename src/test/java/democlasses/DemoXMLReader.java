package democlasses;

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

public class DemoXMLReader {

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

            // Parse the testng-failed.xml file
            File xmlFile = new File("D:\\eclipse_workspace\\Automation_Practise\\AutomationFramework_Practise\\test-output\\testng-failed.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            // Get all test methods under the specific class
            NodeList testMethodNodes = doc.getElementsByTagName("include");

            // Write the failed test cases to the status column (e.g., column 5 which is index 4)
            int statusColumnNumber = 4;

            for (int i = 0; i < testMethodNodes.getLength(); i++) {
                String methodName = testMethodNodes.item(i).getAttributes().getNamedItem("name").getNodeValue();

                boolean isMethodNameFound = false;
                for (Row row : sheet) {
                    Cell cell = row.getCell(1); // Assuming the test case name is in the second column (index 1)
                    if (cell != null && cell.getCellType() == CellType.STRING) {
                        String cellValue = cell.getStringCellValue();
                        if (cellValue.equals(methodName)) {
                            isMethodNameFound = true;
                        }
                    }

                    if (isMethodNameFound) {
                        Cell statusCell = row.getCell(statusColumnNumber);
                        if (statusCell == null) {
                            statusCell = row.createCell(statusColumnNumber);
                        }
                        statusCell.setCellValue("FAIL");

                        // Check if the next row belongs to the same test case
                        Row nextRow = sheet.getRow(row.getRowNum() + 1);
                        if (nextRow != null) {
                            Cell nextCell = nextRow.getCell(1);
                            if (nextCell == null || nextCell.getCellType() != CellType.STRING || !nextCell.getStringCellValue().isEmpty()) {
                                isMethodNameFound = false;
                            }
                        } else {
                            isMethodNameFound = false;
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

