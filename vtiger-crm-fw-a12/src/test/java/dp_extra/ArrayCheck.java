package dp_extra;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ArrayCheck {

		@Test(dataProvider = "get data")
		public void loginToSauceDemo(String username, String password) {
//			String username = "Dinga";
//			String password = "Dingi@143";
			System.out.println(username);
			System.out.println(password);

	}
		
		@DataProvider
		public Object[][] getData() {
			Object[][] cred = new Object[5][2];
//								  row => number of executions
//								  col => number of parameters

			cred[0][0] = "Diksha";
			cred[0][1] = "Diksha@123";

			cred[1][0] = "Keerti";
			cred[1][1] = "Shakya";

			cred[2][0] = "Apoorva";
			cred[2][1] = "Apoorva@2588";

			cred[3][0] = "Sonali";
			cred[3][1] = "Sonali@123";

			cred[4][0] = "Vishakha";
			cred[4][1] = "Vishu@123";

			return cred;
		}
	}
