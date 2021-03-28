package com.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PurchaseConfirmationPage {

public WebDriver driver;
	
	public PurchaseConfirmationPage(WebDriver driver) {
	this.driver = driver;
	}
	
	By purchaseSuccessmessage = By.xpath("//div[@class='container hero-unit']/h1");
	By transId = By.xpath("//table/tbody/tr[1]/td[2]");
	By status = By.xpath("//table/tbody/tr[2]/td[2]");
	By confirmationMsg = By.xpath("/html/body/div[2]/div/h1");


	public WebElement getPurchaseSuccessmessage() {
		return driver.findElement(purchaseSuccessmessage);
	}
	
	public WebElement getTransId() {
		return driver.findElement(transId);
	}
	
	public WebElement getStatus() {
		return driver.findElement(status);
	}
	
	public WebElement getConfirmationMsg() {
		return driver.findElement(confirmationMsg);
	}
}
