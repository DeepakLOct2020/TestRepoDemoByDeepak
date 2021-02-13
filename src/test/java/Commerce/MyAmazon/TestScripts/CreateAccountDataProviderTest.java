package Commerce.MyAmazon.TestScripts;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateAccountDataProviderTest {


	@Test(dataProvider="CreateAccountDataProvider")
	public void createAccountWithDataProvider(String username, String password, String result, String city) {

		System.out.println(username + "" + password + "" + result);


	}

	@DataProvider(name="CreateAccountDataProvider")
	public Object[][] createAccountDataProvider(){

		Object[][] data = new Object[3][4];


		data[0][0] = "Deepak123";
		data[0][1] = "deep@123";
		data[0][2] = "Valid Set";
		data[0][3] = "Amravati";

		data[1][0] = "Tejas123";
		data[1][1] = "teja@123";
		data[1][2] = "Invalid Set";
		data[1][3] = "Badnera";

		data[2][0] = "Akshay123";
		data[2][1] = "Akshay@123";
		data[2][2] = "Valid Set";
		data[2][3] = "Akola";

		return data;
	}

}