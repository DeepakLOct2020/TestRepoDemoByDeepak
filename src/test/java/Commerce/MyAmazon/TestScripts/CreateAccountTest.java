package Commerce.MyAmazon.TestScripts;


import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;
import Commerce.MyAmazon.BaseClass.PreDefinedActions;
import Commerce.MyAmazon.Pages.AuthenticationPage;
import Commerce.MyAmazon.Pages.CreateAccountPage;
import Commerce.MyAmazon.Pages.HomePage;
import Commerce.MyAmazon.Pages.MyProfilePage;
import Pogo.CreateAccountDetailsPogo;

public class CreateAccountTest extends TestBase {
	
	@Test
	public void createAccountLoginTest() throws InterruptedException  {
		
		//Verify: Page Title
		HomePage homePage = new HomePage();
		String actualTitle = homePage.getTitleHomePage();
		Assert.assertTrue(actualTitle.equals("My Store"));
		
		//Step: Click on SignIn
		System.out.println("Step: Click on SignIn");
		AuthenticationPage authenticationPage =  homePage.clickOnSignIn();
		
		//Verify: is Authentication header is displayed
		System.out.println("Verify: Authentication Header is displayed");
		authenticationPage.isAuthenticationHeaderVisible();
		
		//Step: Enter email address to register
		System.out.println("Step: Enter email address to register");
		authenticationPage.enterEmailAddress("abcd12745@gmail.com");
		
		//Click on createAccount
		System.out.println("Step: Click on createAccount");
		CreateAccountPage createAccountPage = authenticationPage.clickOnCreateAccount();
		
		//Verify: Create an account page heading is displayed
		System.out.println("Verify: Create an account page heading is displayed");
		boolean headingText = createAccountPage.isPageHeadingTextDisplayed();
		Assert.assertTrue(headingText);
		
		
		//Step: On create Account page enter personal details
		System.out.println("Step: On create account page Enter Personal Information");
		
		CreateAccountDetailsPogo createAccountDetailsPogo = new CreateAccountDetailsPogo();
		
		createAccountDetailsPogo.setMale(true);
		createAccountDetailsPogo.setFirstName("automation");
		createAccountDetailsPogo.setLastName("automation");
		createAccountDetailsPogo.setPassword("Automation123");
		createAccountDetailsPogo.setDay("12");
		createAccountDetailsPogo.setMonth("January");
		createAccountDetailsPogo.setYear("2021");
		createAccountDetailsPogo.setCompany("Globant");
		createAccountDetailsPogo.setAddress1("Bren Road 1035");
		createAccountDetailsPogo.setCity("Nashville");
		createAccountDetailsPogo.setState("Tennessee");
		createAccountDetailsPogo.setPostcode("00000");
		createAccountDetailsPogo.setmNumber("8547123657");
		createAccountDetailsPogo.setAddressAlias("Home");
	
		createAccountPage.enterCreateAccountDetails(createAccountDetailsPogo);
		MyProfilePage myProfilePage = createAccountPage.clickOnRegister();
		String actual = myProfilePage.getHeaderText();
		String expected = "automation automation";
		Assert.assertEquals(actual, expected, "Verification Header Text Failed");
	}
	
	
	@Test
	public void createAccountUIValidationTest() throws InterruptedException  {
		
		//Browser Start code
		System.out.println("Step: Open Browser");
		PreDefinedActions.start(); 
		
		//Verify: Page Title
		HomePage homePage = new HomePage();
		String actualTitle = homePage.getTitleHomePage();
		Assert.assertTrue(actualTitle.equals("My Store"));
		
		//Step: Click on SignIn
		System.out.println("Step: Click on SignIn");
		AuthenticationPage authenticationPage =  homePage.clickOnSignIn();
		
		//Verify: is Authentication header is displayed
		System.out.println("Verify: Authentication Header is displayed");
		authenticationPage.isAuthenticationHeaderVisible();
		
		//Step: Enter email address to register
		System.out.println("Step: Enter email address to register");
		authenticationPage.enterEmailAddress("abcd12745@gmail.com");
		
		//Click on createAccount
		System.out.println("Step: Click on createAccount");
		CreateAccountPage createAccountPage = authenticationPage.clickOnCreateAccount();
		
		//Verify: Create an account page heading is displayed
		System.out.println("Verify: Create an account page heading is displayed");
		boolean headingText = createAccountPage.isPageHeadingTextDisplayed();
		Assert.assertTrue(headingText);
		
		createAccountPage.clickOnRegister();
		
		java.util.List<String> expectedErrorMessages = new ArrayList<String>();
		expectedErrorMessages.add("There are 8 errors");
		expectedErrorMessages.add("You must register at least one phone number.");
		expectedErrorMessages.add("lastname is required.");
		expectedErrorMessages.add("firstname is required.");
		expectedErrorMessages.add("passwd is required.");
		expectedErrorMessages.add("address1 is required.");
		expectedErrorMessages.add("city is required.");
		expectedErrorMessages.add("The Zip/Postal code you've entered is invalid. It must follow this format: 00000");
		expectedErrorMessages.add("This country requires you to choose a State.");
		
		java.util.List<String> actualErrorMessageList = createAccountPage.getErrorMessages();
		
		Assert.assertEquals(expectedErrorMessages, actualErrorMessageList);	
	}
}
