package Commerce.MyAmazon.Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Commerce.MyAmazon.BaseClass.PreDefinedActions;
import Util.PropertiesFileReader;

public class AuthenticationPage extends PreDefinedActions {
	
	PropertiesFileReader authPage;
	
	public AuthenticationPage(){
		
		authPage = new PropertiesFileReader(".\\src\\test\\java\\property\\AuthenticationPageProperties.properties");		
	}
	
	public void enterEmailAddress(String emailAddress) {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(authPage.getValue("createAccountEmail")))).sendKeys(emailAddress);
		System.out.println("Enter a email address to create an account with the same email address");
	}
	
	public CreateAccountPage clickOnCreateAccount() {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(authPage.getValue("createAnAccountButton")))).click();
		driver.findElement(By.xpath(authPage.getValue("createAnAccountButton"))).click();
		System.out.println("Clicked on submit button");
		return new CreateAccountPage();
	}
		
	public boolean isAuthenticationHeaderVisible() {
		
		WebDriverWait wait = new WebDriverWait(driver,5);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(authPage.getValue("authenticationHeader"))));
		return element.isDisplayed();
	}
	
	public MyProfilePage doLogin(String emailAddress, String password) throws IOException {
		
		AuthenticationPage authenticationPage = new AuthenticationPage();
		
		authenticationPage.enterEmailAddressSignIn(emailAddress);
		authenticationPage.enterPasswordSignIn(password);
		authenticationPage.clickOnSignIn();

		//enterEmailAddressSignIn(emailAddress);
		//enterPasswordSignIn(password);
		//clickOnSignIn();

		return new MyProfilePage();
	}

	public void enterEmailAddressSignIn(String emailAddress) {

		WebDriverWait wait = new WebDriverWait(driver,5);
		WebElement emailTxtBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(authPage.getValue("loginEmail"))));
		emailTxtBox.sendKeys(emailAddress);
	}

	public void enterPasswordSignIn(String password) {

		WebDriverWait wait = new WebDriverWait(driver,5);
		WebElement passwordTxtBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(authPage.getValue("loginPassword"))));
		passwordTxtBox.sendKeys(password);
	}

	public void clickOnSignIn() {

		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(authPage.getValue("signInButton")))).click();
	}

	public String getErrorMesssage() {

		WebDriverWait wait = new WebDriverWait(driver,5);
		WebElement errorText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(authPage.getValue("createAccountErrorMessage"))));
		return errorText.getText();
	}
}
