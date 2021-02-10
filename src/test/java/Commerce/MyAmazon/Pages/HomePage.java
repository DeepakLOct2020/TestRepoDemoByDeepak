package Commerce.MyAmazon.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Commerce.MyAmazon.BaseClass.PreDefinedActions;

public class HomePage extends PreDefinedActions {
	
	public AuthenticationPage clickOnSignIn() {
		
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(".header_user_info")))).click();
		System.out.println("Clicked on SignIn");
		return new AuthenticationPage();
	}

	public String getTitleHomePage() {
		
		String pageTitle = driver.getTitle();
		return pageTitle;
	}
}
