package utilclasses;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelReader {

	public static DataFormatter dataFormatter = new DataFormatter();

	public static Logger logger = Logger.getLogger(ExcelReader.class.getName());


	public static final String excelPath = "C:\\Users\\nitin.more\\Desktop\\TestDataForMapping.xlsx";

	public static final String sheetName = "Sheet1";

	public ExcelReader(Class<? extends TestDataProvider> class1) 
	{
	}

	public static Object[][] readData(String excelPath,String sheetName) {

		List<Object[]> excelData = new ArrayList<Object[]>();

		Map<String, String> rowData = null;

		try

		{
			FileInputStream fis = new FileInputStream(excelPath);

			XSSFWorkbook workbook = new XSSFWorkbook(fis);

			XSSFSheet sheet = workbook.getSheet(sheetName);

			if (sheet == null) {

				throw new IllegalArgumentException("Sheet not found: " + sheetName);

			}

			Map<Integer, String> columnHeaders = getColumnHeaders(sheet);

			int numRows = sheet.getLastRowNum();

			for (int i = 1; i <= numRows; i++) {

				rowData = getRowData(sheet, i, columnHeaders);

				excelData.add(new Object[] { rowData });

			}

			// rowData.forEach((k,v) -> System.out.println("key: "+k+" value:"+v));

			//			for (int i = 0; i < excelData.size(); i++)
			//
			//			{
			//
			//				System.out.println("the " + excelData.get(i));
			//
			//			}



			rowData.forEach((k,v) -> System.out.println("key: "+k+" value:"+v));

			for (int i = 0; i < excelData.size(); i++)

			{

				System.out.println("the " + excelData.get(i));

			}


		} catch (IOException e) {

			logger.warn(e.getMessage());

		}

		return excelData.toArray(new Object[0][]);

	}

	private static Map<Integer, String> getColumnHeaders(XSSFSheet sheet) 
	{

		XSSFRow headerRow = sheet.getRow(0);

		if (headerRow == null) {

			return new HashMap<Integer, String>();

		}

		int numCells = headerRow.getLastCellNum();

		Map<Integer, String> columnHeaders = new HashMap<Integer, String>();

		for (int i = 0; i < numCells; i++) {

			String header = dataFormatter.formatCellValue(headerRow.getCell(i));

			columnHeaders.put(i, header);

		}

		return columnHeaders;

	}

	private static Map<String, String> getRowData(XSSFSheet sheet, int rowIndex, Map<Integer, String> columnHeaders)
	{

		XSSFRow row = sheet.getRow(rowIndex);

		if (row == null) {

			return new HashMap<String, String>();

		}

		Map<String, String> rowData = new HashMap<String, String>();

		int numCells = row.getLastCellNum();

		for (int i = 0; i < numCells; i++) {

			String header = columnHeaders.get(i);

			String value = dataFormatter.formatCellValue(row.getCell(i));

			rowData.put(header, value);

		}

		return rowData;

	}

}
