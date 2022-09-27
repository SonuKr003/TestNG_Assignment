package com.test.TestNG;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.test.GenericUtility.BaseClass;
import com.test.GenericUtility.FileUtility;
import com.test.POM.Registrations;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateNewResgistration extends BaseClass {

	WebDriver driver;
	public Registrations regOrLogin;

	@Test
	public void test1() throws Throwable {

		driver = super.driver;
		regOrLogin = new Registrations(driver);
		regOrLogin.userRegistrationClick();
		regOrLogin.registrationConfirmation();

	}

}
