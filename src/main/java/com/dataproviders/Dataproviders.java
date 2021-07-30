package com.dataproviders;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.utility.ExcelLibrary;

public class Dataproviders {


	ExcelLibrary obj = new ExcelLibrary();

	//Class --> LoginPageTest,HomePageTest Test Case--> loginTest, wishListTest, orderHistoryandDetailsTest
	
	@DataProvider(name = "AddUser")
	public Object[][] newUserTestData() {
		// Totals rows count
		int rows = obj.getRowCount("User"); //Sheet name
		// Total Columns
		int column = obj.getColumnCount("User");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj.getCellData("User", j, i + 2);
			}
		}
		return data;
	}

		@DataProvider(name = "credentials")
		public Object[][] getCredentials() {
			// Totals rows count
			int rows = obj.getRowCount("Credentials");
			// Total Columns
			int column = obj.getColumnCount("Credentials");
			int actRows = rows - 1;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					data[i][j] = obj.getCellData("Credentials", j, i + 2);
				}
			}
			return data;
		}

	//Class --> AccountCreationPage  Test Case--> verifyCreateAccountPageTest	
		@DataProvider(name = "AddEmployee")
		public Object[][] addEmpDetails() {
			// Totals rows count
			int rows = obj.getRowCount("NewEmployeeDetails"); //Sheet name
			// Total Columns
			int column = obj.getColumnCount("NewEmployeeDetails");
			int actRows = rows - 1;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					data[i][j] = obj.getCellData("NewEmployeeDetails", j, i + 2);
				}
			}
			return data;
		}

		@DataProvider(name = "AddReport")
		public Object[][] addReportsDetails() {
			// Totals rows count
			int rows = obj.getRowCount("PIMReports"); //Sheet name
			// Total Columns
			int column = obj.getColumnCount("PIMReports");
			int actRows = rows - 1;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					data[i][j] = obj.getCellData("PIMReports", j, i + 2);
				}
			}
			return data;
		}
		
		@DataProvider(name = "AddPost")
		public Object[][] newPostTestData() {
			// Totals rows count
			int rows = obj.getRowCount("BuzzPageData"); //Sheet name
			// Total Columns
			int column = obj.getColumnCount("BuzzPageData");
			int actRows = rows - 1;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					data[i][j] = obj.getCellData("BuzzPageData", j, i + 2);
				}
			}
			return data;
		}


	//Class --> 
		@DataProvider(name = "checkValidations")
		public Object[][] checkValidations() {
			// Totals rows count
			int rows = obj.getRowCount("FieldValidationErrorMsgs");
			// Total Columns
			int column = obj.getColumnCount("FieldValidationErrorMsgs");
			int actRows = rows - 1;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					data[i][j] = obj.getCellData("FieldValidationErrorMsgs", j, i + 2);
				}
			}
			return data;
		}

		
		@DataProvider(name = "AssignLeaveDetails")
		public Object[][] getAssignLeaveDetails() {
			// Totals rows count
			int rows = obj.getRowCount("AssignLeave");
			// Total Columns
			int column = obj.getColumnCount("AssignLeave");
			int actRows = rows - 1;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					data[i][j] = obj.getCellData("AssignLeave", j, i + 2);
				}
			}
			return data;
		}
		
		@DataProvider(name = "newAcountDetailsData")
		public Object[][] accountCreation() {

			// Totals rows count
			int rows = obj.getRowCount("AccountCreationData");
			// Total Columns
			int column = obj.getColumnCount("AccountCreationData");
			int actRows = rows - 1;
			//Created an object of array to store data
			Object[][] data = new Object[actRows][1];
			
			for (int i = 0; i < actRows; i++) {
				Map<String, String> hashMap = new HashMap<String, String>();
				for (int j = 0; j < column; j++) {
					hashMap.put(obj.getCellData("AccountCreationData", j, 1),
							obj.getCellData("AccountCreationData", j, i + 2));
				}
				data[i][0]=hashMap;
			}
			return data;
		}

				@DataProvider(name = "SignupData")
				public Object[][] Signupdata() {
					// Totals rows count
					int rows = obj.getRowCount("signup"); //Sheet name
					// Total Columns
					int column = obj.getColumnCount("signup");
					int actRows = rows - 1;

					Object[][] data = new Object[actRows][column];

					for (int i = 0; i < actRows; i++) {
						for (int j = 0; j < column; j++) {
							data[i][j] = obj.getCellData("signup", j, i + 2);
						}
					}
					return data;
				}


}
