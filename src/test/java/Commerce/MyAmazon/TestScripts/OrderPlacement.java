package Commerce.MyAmazon.TestScripts;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Commerce.MyAmazon.BaseClass.ExcelOperations;
import Commerce.MyAmazon.Pages.AuthenticationPage;
import Commerce.MyAmazon.Pages.HomePage;
import Commerce.MyAmazon.Pages.MyProfilePage;
import Commerce.MyAmazon.Pages.ProductCategoryPage;
import Commerce.MyAmazon.Pages.ProductDetailsPage;
import Pogo.ProductDetailsPojo;

public class OrderPlacement extends TestBase {
	
	@Test(dataProvider="validLoginDataProvider")
	public void E2E_OrderPlacement(String emailAddress, String password) throws IOException, InterruptedException{
		
		//Step: Click on SighIn
		System.out.println("Step: Click on SighIn");
		HomePage homePage = new HomePage();
		homePage.clickOnSignIn();
		
		//Step: Login with valid credentials
		System.out.println("Step: Login with valid credentials");
		AuthenticationPage authenticationPage = new AuthenticationPage();
		MyProfilePage myProfilePage = authenticationPage.doLogin(emailAddress, password);	
		
		//Step: Click on categorySection
		System.out.println("Step: Click on category");
		ProductCategoryPage productCategoryPage  = myProfilePage.selectCategory("WOMEN");
		System.out.println("Category selected");
		
		//Step: Get the product list
		System.out.println("Step: Get the product list");
		List<WebElement> productList = productCategoryPage.getProductList();
		//SoftAssert soft = new SoftAssert();
		//soft.assertTrue(productList.size() >= 1);
		
		System.out.println("Product List Size:"+ productList.size());
		
		
		System.out.println("Got the product list");
		
		//Step: Click on first visible product
		System.out.println("Step: Click on first visible product");
		ProductDetailsPage productDetailsPage = productCategoryPage.clickOnFirstVisibleProduct(productList);
		
		//Step: Set the Qty, Size and Color
		System.out.println("Step: Set the Qty, Size and Color");
		 productDetailsPage.setQty("5");
		 productDetailsPage.setSize("S");
		 productDetailsPage.setColor("BLUE");
		 
		//Step: Capture the set details inside pojo class
		 System.out.println("Step: Capture the set details inside pojo class");
		 ProductDetailsPojo productDetailsPojo = new ProductDetailsPojo();
		 productDetailsPojo = productDetailsPage.captureProductDetails(productDetailsPojo);
		 
		 productDetailsPage.clickAddToCart();
		 
		 Assert.assertEquals(productDetailsPage.verifyProductName(), productDetailsPojo.getProductName());
		 Assert.assertEquals(productDetailsPage.verifyProductQty(), productDetailsPojo.getQty());
		 Assert.assertEquals(productDetailsPage.verifySizeAndColor(), productDetailsPojo.getColor()+", "+productDetailsPojo.getSize());
		 
		 String qun = productDetailsPojo.getQty();
		 String price = productDetailsPojo.getPrice();
	
		 double totalPrice = Integer.parseInt(qun) * Integer.parseInt(price);
		 productDetailsPojo.setTotalBill(String.format("%.2f", totalPrice));
			
		 Assert.assertEquals(productDetailsPage.verifyTotalPrice(), productDetailsPojo.getPrice());
		
		 
	
		 
		 
		 
		 
		 
		 
		 
		
		
		
		
		
		
		
		
		
		
		
		System.out.println("End");
	}
	
	@DataProvider
	public Object[][] validLoginDataProvider() throws IOException{
		
		return ExcelOperations.getExcelData("Test_Data.xlsx", "Valid_Login_TestData");
	}
}
