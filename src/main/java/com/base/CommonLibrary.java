package com.base;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonLibrary extends Base{

	private static CommonLibrary commonLib;

	private CommonLibrary() {

	}

	public static CommonLibrary getInstance() {
		if (commonLib == null) {
			commonLib = new CommonLibrary();
		}
		return commonLib;
	}
	
	public void selectbyValue(WebElement locator, String value) {
		Select select = new Select(locator);
		select.selectByValue(value);
	}
	
	public void clickButton(WebElement locator) {
		locator.click();
	}
	
	public void explicitWaitForText(WebElement locator, String text) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.textToBePresentInElement(locator, text));
		
	}
	
	public void explicitWaitForElement(WebElement locator) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(locator));
		
	}
	
	public void enterText(WebElement locator, String text) {
		locator.sendKeys(text);
	}

}
