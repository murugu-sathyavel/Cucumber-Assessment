package stepdefenition;

import cucumber.api.java.After;
import cucumber.api.java.Before;
//import drivers.DriverImplementation;
import drivers.DriverImplementation;

public class TestBase{
	
	DriverImplementation di;
	@Before
	public void initializeBrowser() {
		System.out.println("Browser Opened : Mock");
		di = new DriverImplementation("chrome");
		di.invokeApp();
	}
	
	@After()
	public void tearDown() {
		System.out.println("Browser closed : Mock");
		di.closeBrowser();
	}

}
