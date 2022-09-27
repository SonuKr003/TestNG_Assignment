package com.test.POM;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.GenericUtility.ExtentReporter;

public class LoginPage extends ExtentReporter {
	WebDriver driver;

	ExtentReporter report=new ExtentReporter();
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(xpath = "//a[contains(.,'Login or register')]")
	private WebElement registerOrLogin;

	@FindBy(xpath = "//input[@id='loginFrm_loginname']")
	private WebElement usernameTF;

	@FindBy(xpath = "//input[@id='loginFrm_password']")
	private WebElement passwordTF;

	@FindBy(xpath = "//button[@title='Login']")
	private WebElement loginBtn;

	
	
	public ProuctAdingE2E login(String username, String password) {
		report.report();
		registerOrLogin.click();
		usernameTF.sendKeys(username);
		passwordTF.sendKeys(password);
		loginBtn.click();
		return new ProuctAdingE2E(driver);
	}

}
