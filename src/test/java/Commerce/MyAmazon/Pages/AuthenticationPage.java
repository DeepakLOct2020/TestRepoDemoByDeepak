package Commerce.MyAmazon.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Commerce.MyAmazon.BaseClass.PreDefinedActions;

public class AuthenticationPage extends PreDefinedActions {
	
	
	public void enterEmailAddress(String emailAddress) {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email_create']"))).sendKeys(emailAddress);
		System.out.println("Enter a email address to create an account with the same email address");
	}
	
	public CreateAccountPage clickOnCreateAccount() {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='SubmitCreate']"))).click();
		driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();
		System.out.println("Clicked on submit button");
		return new CreateAccountPage();
	}
	
	public void alreadyRegistered() {
		
		
	}
	
	public boolean isAuthenticationHeaderVisible() {
		
		WebDriverWait wait = new WebDriverWait(driver,5);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Authentication']")));
		return element.isDisplayed();
		
	}

}
