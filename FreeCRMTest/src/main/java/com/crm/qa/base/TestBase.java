package com.crm.qa.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.qa.utility.TestUtil;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public TestBase()
	{
		try
		{
			prop = new Properties();
			FileInputStream ip =  new FileInputStream("C:/Users/mohsharm4/eclipseWorkspace/FreeCRMTest/src/main/java/com/crm/qa/config/config.properties");
		prop.load(ip); 
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static void Initialization()
	{
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:/Users/mohsharm4/Downloads/chromedriver_win32/chromedriver.exe");
			 driver =new ChromeDriver();
		}
		else
		{
			System.out.println("Browser not available");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.page_Load_TimeOut, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicit_Wait, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}

}
