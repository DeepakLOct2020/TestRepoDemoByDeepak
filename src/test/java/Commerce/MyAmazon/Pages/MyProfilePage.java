package Commerce.MyAmazon.Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Commerce.MyAmazon.BaseClass.PreDefinedActions;
import Util.PropertiesFileReader;

public class MyProfilePage extends PreDefinedActions {
	
	PropertiesFileReader myProfilePage;
	
	public MyProfilePage(){
		
		myProfilePage = new PropertiesFileReader(".\\src\\test\\java\\property\\MyProfileProperties.properties");	
	}
	
	public String getHeaderText() {
		
		String expectedHeaderText = "Tejas Kolhe";
		String actuaHeaderText = driver.findElement(By.xpath(myProfilePage.getValue("userNameBlock"))).getText();
		Assert.assertTrue(expectedHeaderText.equals(actuaHeaderText));
		return actuaHeaderText;
	}
	
	public String getUserNameAfterLogin() {

		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(myProfilePage.getValue("userNameTxt"))));
		return user.getText();
	}
	
	public ProductCategoryPage selectCategory(String sectionName) {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement element = null;
		
		switch (sectionName.toUpperCase()) {
		
		case "WOMEN":
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(myProfilePage.getValue("categoryWomen"))));
			element.click();
			break;
			
		case "DRESSES":
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(myProfilePage.getValue("categoryDresses"))));
			element.click();
			break;
			
		case "T-SHIRTS":
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(myProfilePage.getValue("categoryT-Shirts"))));
			element.click();
			break;
		
			default:
				break;
		}
	
		return new ProductCategoryPage();	
	}	
	}

