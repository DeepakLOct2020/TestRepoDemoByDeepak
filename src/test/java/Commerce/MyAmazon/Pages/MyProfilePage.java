package Commerce.MyAmazon.Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Commerce.MyAmazon.BaseClass.PreDefinedActions;

public class MyProfilePage extends PreDefinedActions {

	public String getHeaderText() {
		
		String expectedHeaderText = "Tejas Kolhe";
		String actuaHeaderText = driver.findElement(By.xpath("//a[@class='account']")).getText();
		Assert.assertTrue(expectedHeaderText.equals(actuaHeaderText));
		return actuaHeaderText;
	}
	
	public String getUserNameAfterLogin() {

		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".account>span")));
		return user.getText();
	}
}
