package Commerce.MyAmazon.TestScripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Commerce.MyAmazon.BaseClass.PreDefinedActions;

public class TestBase {
	
	@BeforeMethod
	public void setUp() {
		
		//Browser Start code
		System.out.println("Step: Open Browser");
		PreDefinedActions.start();
	}
	
	@AfterMethod
	public void tearDown() {
		
		//Browser close
		System.out.println("Step: Close Browser");
		PreDefinedActions.close(); 
		
	}

}
