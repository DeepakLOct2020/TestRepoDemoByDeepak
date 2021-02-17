package Commerce.MyAmazon.Pages;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import Commerce.MyAmazon.BaseClass.PreDefinedActions;
import Pogo.ProductDetailsPojo;

public class ProductDetailsPage extends PreDefinedActions  {

	public ProductDetailsPojo captureProductDetails(ProductDetailsPojo productDetailsPojo) {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		String productName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1"))).getText();
		String unitPrice = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#our_price_display"))).getText();
		unitPrice = unitPrice.substring(1);
		
		String productQty = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#quantity_wanted"))).getText();
		String size = driver.findElement(By.cssSelector("#uniform-group_1>span")).getText();
		
		productDetailsPojo.setProductName(productName);
		productDetailsPojo.setPrice(unitPrice);
		productDetailsPojo.setQty(productQty);
		productDetailsPojo.setSize(size);
		System.out.println("Step: Values captured inside pojo");
		
		return productDetailsPojo;
	}
	
	
	public void setQty(String qty) {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("quantity_wanted"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("quantity_wanted"))).sendKeys(qty);
		System.out.println("Step: Quantity entered");
	}
	
	public void setSize(String size) {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement sizeDropDown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uniform-group_1")));
		Select s = new Select(sizeDropDown);
		s.selectByValue(size);
		System.out.println("Step: Size selected");
	}
	
	public void setColor(String color) {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		switch(color.toUpperCase()) {
		
		case "BLUE":
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("color_13"))).click();
			break;
			
		case "ORANGE":
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("color_14"))).click();
		break;
		
		default:
			break;
		}
		
		System.out.println("Step: Color selected");
	}
		
	public String verifyProductName() {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		String productName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("layer_cart_product_title"))).getText();
		return productName;
	}
	
	public String verifyProductQty() {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		String productQty = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("layer_cart_product_quantity"))).getText();
		return productQty;
	}
	
	public String verifySizeAndColor() {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		String productColorSizeTxt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("layer_cart_product_attributes"))).getText();
		return productColorSizeTxt;
	}
	
	public String verifyTotalPrice() {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		String totalPrice = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("layer_cart_product_price"))).getText();
		return totalPrice;
	}	
	
	public static void clickAddToCart() {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		WebElement addToCartBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#add_to_cart button")));
		addToCartBtn.click();
		System.out.println("Step: Clicked on Add To Cart Button");
	}
}
