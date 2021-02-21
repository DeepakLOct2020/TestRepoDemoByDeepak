package Commerce.MyAmazon.TestScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Commerce.MyAmazon.BaseClass.ExcelOperations;
import Commerce.MyAmazon.Pages.AuthenticationPage;
import Commerce.MyAmazon.Pages.HomePage;
import Commerce.MyAmazon.Pages.MyProfilePage;


public class LoginTest extends TestBase {

	@Test(dataProvider="validLoginDataProvider")
	public void verifyLoginWithValidCredentials(String emailAddress, String password) throws IOException{

		//Step: Click on SighIn
		System.out.println("Step: Click on SighIn");
		HomePage homePage = new HomePage();
		homePage.clickOnSignIn();

		//Step: Enter valid email address and valid password
		System.out.println("Step: Enter valid email address and valid password");
		AuthenticationPage authenticationPage = new AuthenticationPage();
		authenticationPage.doLogin(emailAddress, password);

		//Step: Get the user name after successful Login
		System.out.println("Verify: User name is displayed on MyProfile page after successful login");
		MyProfilePage myProfilePage = new MyProfilePage();
		String actualUserName = myProfilePage.getUserNameAfterLogin();


		//Verify: User name is as expected 
		System.out.println("Verify: User name is as expected");
		String expectedUserName = "Tejas Kolhe";
		Assert.assertEquals(expectedUserName, actualUserName);

	}

	@DataProvider(name="validLoginDataProvider")
	public Object[][] loginDataProvider() throws IOException{

		return ExcelOperations.getExcelData("Test_Data.xlsx", "Valid_Login_TestData");
	}

	@Test(dataProvider="invalidLoginDatProvider")
	public void invalidLoginAttempt(String emailAddress, String password, String expErrorMsg) throws IOException {

		//Step: Click on sigh In
		System.out.println("Step: Click on sigh In");
		HomePage homePage = new HomePage();
		homePage.clickOnSignIn();

		//Step: Enter invalid email address and password
		System.out.println("Step: Enter invalid email address and password");
		AuthenticationPage authenticationPage = new AuthenticationPage();
		authenticationPage.doLogin(emailAddress, password);

		//Step: Get the error messages 
		String expErrorMessage = expErrorMsg;
		String actualMessag = authenticationPage.getErrorMesssage();

		//Verify: expected error message and actual message are same
		Assert.assertEquals(actualMessag, expErrorMessage);
	}

	@DataProvider
	public Object[][] invalidLoginDatProvider() throws IOException{

		return ExcelOperations.getExcelData("Test_Data.xlsx", "Invalid_Login_TestData");
	}
}
