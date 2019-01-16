package com.crm.qa.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	public LoginPageTest()
	{
		super();   //To call constructor of base class 
	}
	@BeforeMethod
	public void setup()
	{
	     Initialization();
	     loginpage = new LoginPage();
	}
	
	@Test(priority = 1)
	public void LoginPageTitleTest()
	{
		String title = loginpage.ValidateLoginPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
	}
	@Test (priority = 2)
	public void CRMLodoImageTest()
	{
		boolean flag = loginpage.ValidateCRMImage();
		Assert.assertTrue(flag);
	}
	@Test(priority = 3)
	public void LoginTest()
	{
		homepage =loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	
	
	
	
	
	
	
	
	@AfterMethod
	
	public void TearDown()
	{
		driver.quit();
	}

}
