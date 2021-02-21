package Commerce.MyAmazon.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Commerce.MyAmazon.BaseClass.PreDefinedActions;
import Util.PropertiesFileReader;

public class HomePage extends PreDefinedActions {
	
	PropertiesFileReader homePage;

	public HomePage() {
		
		homePage = new PropertiesFileReader(".\\src\\test\\java\\property\\HomePageProperties.properties");
	}
	
	
	public AuthenticationPage clickOnSignIn() {
		
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(homePage.getValue("signIn"))))).click();
		System.out.println("Clicked on SignIn");
		return new AuthenticationPage();
	}

	public String getTitleHomePage() {
		
		String pageTitle = driver.getTitle();
		return pageTitle;
	}
}
