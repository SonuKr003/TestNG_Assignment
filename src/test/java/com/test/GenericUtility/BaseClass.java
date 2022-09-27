package com.test.GenericUtility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.test.POM.LoginPage;
import com.test.POM.ProuctAdingE2E;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	public static WebDriver staticDriver;

	public FileUtility fUtil = new FileUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	public ProuctAdingE2E productPage;

//	@Parameters("browser")
	
	@BeforeClass()
	public void configBC() throws Throwable {

		String browserName = fUtil.getPropertyKeyValue("browser");

		if (browserName.equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();

			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("EDGE")) {
			WebDriverManager.edgedriver().setup();
			driver = new InternetExplorerDriver();
		}
		staticDriver = driver;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@BeforeMethod()
	public void configBM() throws Throwable {
		String url = fUtil.getPropertyKeyValue("url");
		String username = fUtil.getPropertyKeyValue("username");
		String password = fUtil.getPropertyKeyValue("password");
		driver.get(url);
		
		LoginPage lp=new LoginPage(driver);
		productPage=lp.login(username, password);
		

	}

	@AfterMethod()
	public void configAM() throws Throwable {
		
	}

	@AfterClass()
	public void configAC() {

		staticDriver = driver;
		 driver.quit();
	}

}
