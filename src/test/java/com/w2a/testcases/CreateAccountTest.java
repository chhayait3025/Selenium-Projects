package com.w2a.testcases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.w2a.basepage.BasePage;
import com.w2a.pages.CRMAccountsPage;
import com.w2a.pages.CreateAccountsPage;
import com.w2a.pages.ZohoAppPage;
import com.w2a.utilities.Utilities;

public class CreateAccountTest {
	
	
	@Test(dataProviderClass = Utilities.class, dataProvider = "dp")
	public void createAccountTest(Hashtable<String,String> data) {
		
		ZohoAppPage zoho = new ZohoAppPage();
		zoho.goToCRM();
		zoho.goToAccessZohoCRM();
	    CRMAccountsPage ap = BasePage.topmenu.goToAccounts();
	    
        CreateAccountsPage cap = ap.goToCreateAccount();
        cap.createAccount(data);
//        cap.createAccount(data.get("AccountName"));
//        cap.createAccount(data.get("actsite"));
//        cap.createAccount(data.get("rating"));
//        cap.createAccount(data.get("phone"));
//        cap.createAccount(data.get("actnumber"));
//        
//        cap.createAccount(data.get("acttype"));
//        cap.createAccount(data.get("industry"));
//        cap.createAccount(data.get("annualrev"));
//        
//        cap.createAccount(data.get("ticketsymbol"));
//        
//        cap.createAccount(data.get("ownership"));
//        cap.createAccount(data.get("employee"));
//        cap.createAccount(data.get("sidcode"));
        	
		
	}

}
