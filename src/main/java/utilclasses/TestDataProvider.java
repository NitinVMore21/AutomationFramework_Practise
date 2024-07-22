package utilclasses;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

	@DataProvider(name = "data")

	public Object[][] readExcelData()

	{

		return ExcelReader.readData("C:\\Users\\nitin.more\\eclipse-workspace\\Automation_Practise\\testdataDemoqa.xlsx", "WebtablesElement");
		//return new ExcelReader(getClass()).readData("C:\\Users\\nitin.more\\Desktop\\TestDataForMapping.xlsx","Sheet1");
	}
	
//	@Test(dataProvider = "data")
//
//	public void m5(Map<String, String> input)
//
//	{
//		System.out.println(input.get("firstName"));
//		System.out.println(input.get("lastName"));
//		System.out.println(input.get("userEmail"));
//		System.out.println(input.get("age"));
//		System.out.println(input.get("salary"));
//		System.out.println(input.get("department"));
//	}
}



