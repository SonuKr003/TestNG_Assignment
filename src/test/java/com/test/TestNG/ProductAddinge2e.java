package com.test.TestNG;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.test.GenericUtility.BaseClass;
import com.test.POM.ProuctAdingE2E;

public class ProductAddinge2e extends BaseClass {

	WebDriver driver;
	ProuctAdingE2E product;

	@Test
	public void Test2() throws Throwable {

		driver = super.driver;
		product=new ProuctAdingE2E(driver);
		product.menProductLinkclick();
		product.addTocartAndPlaceOrder();
	}

}
