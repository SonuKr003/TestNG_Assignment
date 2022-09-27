package com.test.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.test.GenericUtility.FileUtility;
import com.test.GenericUtility.WebDriverUtility;

public class ProuctAdingE2E extends WebDriverUtility {
	WebDriver driver;
	
	ExtentReports reports=new ExtentReports();

	FileUtility f = new FileUtility();

	public ProuctAdingE2E(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ul[@class='nav-pills categorymenu']/li/a[contains(.,'Men')]")
	private WebElement MenSection;

	@FindBy(xpath = "//div/a[contains(.,'Body & Shower')]")
	private WebElement bodyShower;

	@FindBy(xpath = "//div[@class=\"pricetag jumbotron\"]/a[@data-id=\"75\"]")
	private WebElement addToCart;

	@FindBy(xpath = "//a[@data-id='75']/ancestor::div[@class=\"pricetag jumbotron added_to_cart\"]//a[contains(@title,'Added to cart')]")
	private WebElement moveToCart;

	@FindBy(xpath = "//div[@class='col-md-6 cart-info totals pull-right table-responsive']/a[@title='Checkout']")
	private WebElement checkout;

	@FindBy(xpath = "//button[@title='Confirm Order']")
	private WebElement confirmButton;

	@FindBy(xpath = "//div[@class=\"col-md-12 col-xs-12 mt20\"]//span[@class='maintext']")
	private WebElement confirmMessage;

	@FindBy(xpath = "//a[contains(.,'Login or register')]")
	private WebElement registerOrLogin;

	public void menProductLinkclick() throws InterruptedException {

		mouseOverAndCLick(driver, MenSection);
		bodyShower.click();
	}

	public void addTocartAndPlaceOrder() throws Throwable {

		addToCart.click();
		moveToCart.click();
		checkout.click();

		waitForElementVisibility(driver, confirmButton, 10);
		confirmButton.click();
		Reporter.log(confirmMessage.getText());
		String actualMessage = f.getPropertyKeyValue("confirmMessage");
		
		

		String expectedMessage = confirmMessage.getText();

		Assert.assertEquals(actualMessage, expectedMessage, "Order has fialed");
		
	}

}
