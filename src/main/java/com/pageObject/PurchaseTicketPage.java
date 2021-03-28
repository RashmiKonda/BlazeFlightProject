package com.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.base.CommonLibrary;

public class PurchaseTicketPage {
   public WebDriver driver;
   CommonLibrary commonLibrary = CommonLibrary.getInstance();
	
	public PurchaseTicketPage(WebDriver driver) {
	this.driver = driver;
	}
	
	By name = By.xpath("//input[@id='inputName']");
	By address = By.xpath("//input[@id='address']");
	By city = By.xpath("//input[@id='city']");
	By state = By.xpath("//input[@id='state']");
	By zipCode = By.xpath("//input[@id='zipCode']");
	By cardTypeDropDown = By.xpath("//select[@id='cardType']");
	By creditCardNum = By.xpath("//input[@name='creditCardNumber']");
	By month = By.id("creditCardMonth");
	By Year = By.xpath("//input[@id='creditCardYear']");
	By nameOnCard = By.cssSelector("input[id='nameOnCard']");
	By remembermeChkBox = By.xpath("//label[@class='checkbox']");
	By purchaseBtn = By.xpath("//input[@value='Purchase Flight']");
	By purchaseTicketMsg = By.xpath("//div[@class='container']/h2");

	
	public WebElement getPurchaseTicketMsg() {
		return driver.findElement(purchaseTicketMsg);
	}

	public WebElement getName() {
		return driver.findElement(name);
	}


	public WebElement getAddress() {
		return driver.findElement(address);
	}


	public WebElement getCity() {
		return driver.findElement(city);
	}


	public WebElement getState() {
		return driver.findElement(state);
	}


	public WebElement getZipCode() {
		return driver.findElement(zipCode);
	}


	public WebElement getCardTypeDropDown() {
		return driver.findElement(cardTypeDropDown);
	}


	public WebElement getCreditCardNum() {
		return driver.findElement(creditCardNum);
	}


	public WebElement getMonth() {
		return driver.findElement(month);
	}


	public WebElement getYear() {
		return driver.findElement(Year);
	}


	public WebElement getNameOnCard() {
		return driver.findElement(nameOnCard);
	}


	public WebElement getPurchaseBtn() {
		return driver.findElement(purchaseBtn);
	}
	
	//The data to be entered can be parameterized from excel, but due to time constraint hardcoding the data
	//Also there can be many scenarios here like each field will have validation if it can take numeric, 
	//alphanumeric, number of characters allowed in the text field and so bo.
	public void purchaseTicket() {
		commonLibrary.enterText(getName(), "Name One");
		commonLibrary.enterText(getAddress(), "Address 123, Boston, Massachusetts ");
		commonLibrary.enterText(getCity(), "Boston ");
		commonLibrary.enterText(getState(), "Massachusetts");
		commonLibrary.enterText(getZipCode(), "123456");
		commonLibrary.selectbyValue(getCardTypeDropDown(), "visa");
		commonLibrary.enterText(getCreditCardNum(), "12345");
		commonLibrary.enterText(getMonth(), "3");
		commonLibrary.enterText(getYear(), "2021");
		commonLibrary.enterText(getNameOnCard(), "Name One");
		commonLibrary.clickButton(getPurchaseBtn());	
		
	}

}
