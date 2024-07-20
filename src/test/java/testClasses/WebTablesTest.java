package testClasses;

import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utilclasses.ExcelReader;

public class WebTablesTest extends BaseClass{
	
	@DataProvider(name = "data")

	public Object[][] readExcelData()

	{
		return ExcelReader.readData(WORKING_DIR + "\\testdataDemoqa.xlsx", "WebtablesElement");
		//return new ExcelReader(getClass()).readData("C:\\Users\\nitin.more\\Desktop\\TestDataForMapping.xlsx","Sheet1");
	}
	
	@Test (dataProvider = "data")
	public void validatingWebTables(Map<String, String> input) throws Exception
	{
		wtb.webTablesElement(input);
	}

}
