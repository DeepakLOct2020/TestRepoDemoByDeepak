package Commerce.MyAmazon.Pages;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Commerce.MyAmazon.BaseClass.PreDefinedActions;
import ExceptionHandeling.ProductNotFoundException;
import Util.PropertiesFileReader;

public class ProductCategoryPage extends PreDefinedActions {
	
	PropertiesFileReader categoryPage;
	
	public ProductCategoryPage() {
		
		categoryPage = new PropertiesFileReader(".\\src\\test\\java\\property\\ProductCategoryPageProperties.properties");
	}
	
	public List<WebElement> getProductList() {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.cssSelector(categoryPage.getValue("listOfProducts"))));
		
		List<WebElement> productList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(categoryPage.getValue("listOfProducts"))));
		
		return productList;
	}

	public ProductDetailsPage clickOnFirstVisibleProduct(List<WebElement> productList ) {
		
		try {
			
			if(productList.size()>0) {
				productList.get(0).click();
				System.out.println("We have clicked on First Product");
			}
			else {
				throw new ProductNotFoundException("Product not available inside the list");
			}
			
		} catch(ProductNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return new ProductDetailsPage() ;
	
	}
	
	
}
