package Commerce.MyAmazon.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Commerce.MyAmazon.BaseClass.PreDefinedActions;
import Pogo.CreateAccountDetailsPogo;
import Util.PropertiesFileReader;

public class CreateAccountPage extends PreDefinedActions {
	
	 PropertiesFileReader CreateAccountPage;
	 
	 public CreateAccountPage() {
		 
		 CreateAccountPage = new PropertiesFileReader(".\\src\\test\\java\\property\\CreateAccountPageProperties.properties");
	 }
	
	public void selectGender(boolean isMale) throws InterruptedException {
		
		WebDriverWait wait  = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CreateAccountPage.getValue("customerFirstNameTxtBox"))));
		Thread.sleep(1000);
		//Step: Select Mr. as title
		System.out.println("Step: Select title");
		if(isMale) {
			Thread.sleep(10000);
			WebElement gender = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CreateAccountPage.getValue("genderMale"))));
			gender.click();
		}
		else {
			WebElement gender = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CreateAccountPage.getValue("genderFemale"))));
			gender.click();
		}
		
	}
	
	public void enterFirstName(String firstName) {
		
		System.out.println("Step: Enter first name");
		if(firstName != null) {
			driver.findElement(By.cssSelector(CreateAccountPage.getValue("customerFirstNameTxtBox"))).sendKeys(firstName);
		}
		else
			System.out.println("First Name field is blank");
	}
	
	public void enterLastName(String lastName) {
		
		System.out.println("Step: Enter last name");
		if(lastName != null) {
			driver.findElement(By.cssSelector(CreateAccountPage.getValue("customerLastNameTxtBox"))).sendKeys(lastName);
		}
		else
			System.out.println("Last Name field is blank");
	}
	
	public void enterPassword(String password) {
		
		System.out.println("Step: Enter password");
		if(password != null) {
			driver.findElement(By.cssSelector(CreateAccountPage.getValue("passwordTxtBox"))).sendKeys(password);	
		}
		else
			System.out.println("Password field is empty");
		
	}
	
	public void selectBirthDay(String day) {
		
		System.out.println("Step: Select birth day");
		if(day != null) {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CreateAccountPage.getValue("days")))).click();
			Select s = new Select(driver.findElement(By.id("days")));
			s.selectByValue(day);
			System.out.println("Birth date selected from drop-down");
		}
		else
			System.out.println("Day field is empty");
	}
	
	public void selectBirthMonth(String month) {
		
		System.out.println("Step: Select birth year");
		if(month != null) {
			Select s = new Select(driver.findElement(By.id(CreateAccountPage.getValue("month"))));
			s.selectByVisibleText(month+" ");
			System.out.println("Birth month selected from drop-down");
		}
		else
			System.out.println("Month field is empty");
	}
	
	public void selectBirthYear(String year) {
		
		System.out.println("Step: Select birth year");
		if(year != null) {
			Select s = new Select(driver.findElement(By.id(CreateAccountPage.getValue("year"))));
			s.selectByValue(year);
			System.out.println("Birth year selected from drop-down");
		}
		else
			System.out.println("Year field is empty");
	}
	
	public void enterCompanyName(String companyName) {
		
		System.out.println("Step: Enter Company name");
		if(companyName != null) {
			driver.findElement(By.cssSelector(CreateAccountPage.getValue("companyName"))).sendKeys(companyName);
		}
		else
			System.out.println("Company field is empty");	
	}
	
	public void enterAddress(String address) {
		
		System.out.println("Step: Enter address");
		if(address != null) {
			driver.findElement(By.cssSelector(CreateAccountPage.getValue("address1"))).sendKeys(address);
		}
		else
			System.out.println("Address field is empty");
	}
	
	public void enterCity(String city){
		
		System.out.println("Step: Enter city");
		if(city != null) {
			driver.findElement(By.cssSelector(CreateAccountPage.getValue("city"))).sendKeys(city);
		}
		else
			System.out.println("City field is empty");
	}
	
	public void selectState(String state) {
		
		System.out.println("Step: Select state");
		if(state != null) {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement elementState = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CreateAccountPage.getValue("state"))));
			Select s = new Select(elementState);
			s.selectByVisibleText(state);
			System.out.println("State is selected");
		}
		else
			System.out.println("State field is empty");
	}
	
	public void enterPostalCode(String postalCode) {
		
		System.out.println("Step: Enter post code");
		if(postalCode != null) {
			driver.findElement(By.cssSelector(CreateAccountPage.getValue("postcode"))).sendKeys(postalCode);
		}
		else
			System.out.println("Postal code field is empty");	
	}
	
	public void enterMobile(String mobileNumber) {
		
		System.out.println("Step: Enter mobile number");
		if(mobileNumber != null) {
			driver.findElement(By.cssSelector(CreateAccountPage.getValue("mobileNumber"))).sendKeys(mobileNumber);
		}
		else
			System.out.println("Mobile number field is empty");
	}
	
	public void enterAddressAlias(String addressAlias) {
		
		System.out.println("Enter Address alias");
		if(addressAlias != null) {
			driver.findElement(By.cssSelector(CreateAccountPage.getValue("addressAlias"))).sendKeys(addressAlias);
		}
		else
			System.out.println("Address alias field is empty");
	}
	
	
	public boolean isPageHeadingTextDisplayed() {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		return wait.until(ExpectedConditions.textToBe(By.cssSelector(CreateAccountPage.getValue("createAccountHeadingTxt")), "CREATE AN ACCOUNT"));
	}
	
	public void enterCreateAccountDetails(CreateAccountDetailsPogo createAccountDetailsPogo) throws InterruptedException {
		
		//Step: Select Gender
		selectGender(createAccountDetailsPogo.isMale());
		
		//Step: Enter first name
		enterFirstName(createAccountDetailsPogo.getFirstName());
		
		//Step: Enter last name
		enterLastName(createAccountDetailsPogo.getLastName());
		
		
		//Step: Enter password
		enterPassword(createAccountDetailsPogo.getPassword());
		
		//Step: Select birth Day
		selectBirthDay(createAccountDetailsPogo.getDay());
		
		
		//Step: Select birth month
		selectBirthMonth(createAccountDetailsPogo.getMonth());
		
		//Step: Select birth year
		selectBirthYear(createAccountDetailsPogo.getYear());
	
		//Step: Enter Company name
		enterCompanyName(createAccountDetailsPogo.getCompany());
		
		//Step: Enter address
		enterAddress(createAccountDetailsPogo.getAddress1());
	
		//Step: Enter city
		enterCity(createAccountDetailsPogo.getCity());
		
		//Step: Select state
		selectState(createAccountDetailsPogo.getState());
		
		//Step: Enter post code
		enterPostalCode(createAccountDetailsPogo.getPostcode());
			
		//Step: Enter mobile number
		enterMobile(createAccountDetailsPogo.getmNumber());
		
		//Step: Enter address alias
		enterAddressAlias(createAccountDetailsPogo.getAddressAlias());
	}
	
	public MyProfilePage clickOnRegister() {
		
		driver.findElement(By.id(CreateAccountPage.getValue("registerBtn"))).click();
		System.out.println("Clicked on Registration button");
		return new MyProfilePage();
	}

	public List<String> getErrorMessages() {
		
		java.util.List<WebElement> listOfErrors = driver.findElements(By.xpath(CreateAccountPage.getValue("errorMessagesList")));
		
		java.util.List<String> errorTextList = new ArrayList<String>();
		String totalErrorCount = driver.findElement(By.cssSelector(CreateAccountPage.getValue("errorCount"))).getText();
		errorTextList.add(totalErrorCount);
		
		for(WebElement list : listOfErrors) {
			errorTextList.add(list.getText());
		}
		
		return errorTextList;
	}

}
