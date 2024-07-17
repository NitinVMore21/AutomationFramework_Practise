package testClasses;

import org.testng.annotations.Test;

public class RadioButtonTest extends BaseClass{
	

	@Test(priority = 2)
	
	public void validatingRadioButton() throws Exception
	{
		rob.RadiobuttonElement();
	}
}
