package com.test.POM;

import java.util.List;
import java.util.Random;
import java.util.RandomAccess;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.test.GenericUtility.FileUtility;
import com.test.GenericUtility.WebDriverUtility;

public class Registrations extends WebDriverUtility {

	WebDriver driver;
	
	public static FileUtility f = new FileUtility();

	public Registrations(WebDriver driver) {

		PageFactory.initElements(driver, this);
		this.driver = driver;

	}

	Random r = new Random();

	int random = r.nextInt();

	@FindBy(xpath = "//a[contains(.,'Login or register')]")
	private WebElement registerOrLogin;

	@FindBy(xpath = "//button[@title='Continue']")
	private WebElement continueBtn;

	@FindBy(xpath = "//input[@id='AccountFrm_firstname']")
	private WebElement firstName;

	@FindBy(xpath = "//input[@id='AccountFrm_lastname']")
	private WebElement lastName;

	@FindBy(xpath = "//input[@id='AccountFrm_email']")
	private WebElement email;

	@FindBy(xpath = "//input[@id='AccountFrm_telephone']")
	private WebElement telephonNum;

	@FindBy(xpath = "//input[@id='AccountFrm_company']")
	private WebElement companyName;

	@FindBy(xpath = "//input[@id='AccountFrm_address_1']")
	private WebElement address1;

	@FindBy(xpath = "//input[@id='AccountFrm_address_2']")
	private WebElement address2;

	@FindBy(xpath = "//input[@id='AccountFrm_city']")
	private WebElement city;

	@FindBy(xpath = "//Select[@id='AccountFrm_zone_id']")
	private WebElement State;

	@FindBy(xpath = "//Select[@id='AccountFrm_zone_id']/option")
	private List<WebElement> allState;

	@FindBy(xpath = "//input[@id='AccountFrm_postcode']")
	private WebElement zipCode;

	@FindBy(xpath = "//select[@id='AccountFrm_country_id']")
	private WebElement country;

	@FindBy(xpath = "//select[@id='AccountFrm_country_id']/option")
	private WebElement Allcountry;

	@FindBy(xpath = "//input[@id='AccountFrm_loginname']")
	private WebElement loginName;

	@FindBy(xpath = "//input[@id='AccountFrm_password']")
	private WebElement password;

	@FindBy(xpath = "//input[@id='AccountFrm_confirm']")
	private WebElement confirmPass;

	@FindBy(xpath = "//input[@id='AccountFrm_newsletter0']")
	private WebElement noSubscribe;

	@FindBy(xpath = "//input[@id='AccountFrm_agree']")
	private WebElement termsAnCondition;
	
	@FindBy(xpath="//section[@class='mb40']/descendant::p[contains(.,'Congratulations! Your new account has been successfully created!')]")
	private WebElement confimationMessage;
	

	public void userRegistrationClick() throws InterruptedException {

		registerOrLogin.click();

		continueBtn.click();
		firstName.sendKeys("Dinga");
		lastName.sendKeys("Vino");
		email.sendKeys("dingaasdf" + r.nextInt(10000) + "@gmail.com");
		telephonNum.sendKeys("9898987654");
		companyName.sendKeys("UST");
		address1.sendKeys("soth east USA");
		address2.sendKeys("xyz");
		city.sendKeys("Pune");

		SelectOption(State, "Bristol");

		zipCode.sendKeys("440009");

		SelectOption(country, "United Kingdom");

		loginName.sendKeys("skumar"+r.nextInt(1000));
		
		String loginName1=loginName.getAttribute("value");
		Reporter.log("UserName=========================================================== ********* : "+loginName1);
		
		password.sendKeys("Shonuk");
		confirmPass.sendKeys("Shonuk");
		Reporter.log("User Password=====================================================================********* : Shonuk");
		noSubscribe.click();
		termsAnCondition.click();
		continueBtn.click();
		Thread.sleep(3000);

	}
	
	public void registrationConfirmation() throws Throwable {
		
		String actual=f.getDataFromJson("registrationConfim").toString();
		
		if(actual.equalsIgnoreCase(confimationMessage.getText())){
			
			System.out.println(confimationMessage.getText());
			
			
		}
		
		Assert.assertEquals(actual, confimationMessage.getText(),"Registaion can not be done*****************************");
		
	}

}
