package Commerce.MyAmazon.Pages;

import org.junit.Assert;
import org.openqa.selenium.By;

import Commerce.MyAmazon.BaseClass.PreDefinedActions;

public class MyProfilePage extends PreDefinedActions {

	public static String getHeaderText() {
		
		String expectedHeaderText = "Jhon Doe";
		String actuaHeaderText = driver.findElement(By.xpath("//a[@class='account']")).getText();
		Assert.assertTrue(expectedHeaderText.equals(actuaHeaderText));
		return actuaHeaderText;
	}
	
}
