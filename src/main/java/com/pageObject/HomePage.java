package com.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	public WebDriver driver;
	
	public HomePage(WebDriver driver) {
	this.driver = driver;
	}
	
	By departureCity = By.xpath("//select[@name='fromPort']");
	By destinationCity =  By.xpath("//select[@name='toPort']");
	By findFlightBtn = By.xpath("//input[@value='Find Flights']");
	
	public WebElement getDepartureCity() {
		return driver.findElement(departureCity);
	}


	public WebElement getDestinationCity() {
		return driver.findElement(destinationCity);
	}

	public WebElement getFindFlightBtn() {
		return driver.findElement(findFlightBtn);
	}

}
