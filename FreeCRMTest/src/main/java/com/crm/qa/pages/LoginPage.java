package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//page factory or or
	@FindBy(name = "username")
	WebElement username;
	
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath ="//input[@type ='submit']")  //input[contains(@type ,'submit')]
	WebElement Login;
	
	@FindBy(xpath = "//a[@class='navbar-brand']//img[contains(@class ,'img-responsive')]")
	WebElement CRMLogo;
	//Initializing page objects
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public String ValidateLoginPageTitle()
	{
		return driver.getTitle();
	}
	public boolean ValidateCRMImage()
	{
		return CRMLogo.isDisplayed() ;
	}
	
	public HomePage login(String un,String pw)
	{
		username.sendKeys(un);
		password.sendKeys(pw);
		Login.click();
		return new HomePage();//By clicking this method returns homepage
	}
	
	
	
	
	
	

}
