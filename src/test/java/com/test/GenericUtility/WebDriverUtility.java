package com.test.GenericUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility {

	/**
	 * this method wait for 20 sec for page loading
	 */
	public void waitUntilPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	public void waitForElementVisibility(WebDriver driver, WebElement element, int i) {
		// WebDriverWait wait = new WebDriverWait(driver, 20);

		// wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void SelectOption(WebElement element, String option) {
		Select select = new Select(element);
		select.selectByVisibleText(option);

	}

	public void SelectOption(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void mouseOver(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();

	}
	
	public void mouseOverAndCLick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).click().perform();

	}

	public void rightClick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}

	public void switchToWindow(WebDriver driver, String partialWinTitle) {
		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		while (it.hasNext()) {
			String winId = it.next();
			String title = driver.switchTo().window(winId).getTitle();
			if (title.contains(partialWinTitle)) {
				break;
			}

		}

	}

	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public void scrollToWebElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int y = element.getLocation().getY();
		js.executeScript("window.scrollBy(0," + y + ")", element);
	}

	public void switchFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	public void switchFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	public void switchFrame(WebDriver driver, String idOrName) {
		driver.switchTo().frame(idOrName);
	}

	public String takeScreenshot(WebDriver driver, String screenshotName) throws Throwable {
		String screenshotPath = "./screenshot/" + screenshotName + JavaUtility.getCurrentSystemDate() + ".PNG";
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(screenshotPath);
		Files.copy(src, dest);
		return screenshotPath;
	}

	public void pressEnterKey() throws Throwable {

		Robot rc = new Robot();
		rc.keyPress(KeyEvent.VK_ENTER);
		rc.keyRelease(KeyEvent.VK_ENTER);
	}

	public void waitAndClick(WebElement element) throws InterruptedException {
		int count = 0;
		while (count < 40) {
			try {
				element.click();
				break;
			} catch (Throwable e) {
				Thread.sleep(1000);
				count++;
			}
		}
	}
}
