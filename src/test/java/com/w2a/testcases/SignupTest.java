package com.w2a.testcases;

import com.w2a.pages.SignupPage;

public class SignupTest {
	
      public static void main(String[] args) {
		
    	 
		//HomePage home = new HomePage(driver);
		//home.goToSignUp();
		
		SignupPage signup = new SignupPage();
		signup.doSignUp("chhaya.singh0902@gmail.com","Password@#$%6@12345");
	}

}
