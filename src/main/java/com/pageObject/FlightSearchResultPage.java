package com.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.base.CommonLibrary;

public class FlightSearchResultPage {
    public WebDriver driver;
	CommonLibrary commonLibrary = CommonLibrary.getInstance();
	
	
	public FlightSearchResultPage(WebDriver driver) {
	this.driver = driver;
	}
	
	By chooseFlightTable = By.xpath("//table/tbody/tr");
	By flightSearchResultMsg = By.xpath("//div[@class='container']/h2");


	public WebElement getChooseFlightTable() {
		return driver.findElement(chooseFlightTable);
	}
	

	public WebElement getFlightSearchResultMsg() {
		return driver.findElement(flightSearchResultMsg);
	}
	
	public void selectFlight(String airline) {
		boolean matchFound = false;
		List<WebElement> airlines = driver.findElements(chooseFlightTable);
		
		for(int i=1;i<=airlines.size();i++) {
			String selectAirLine = driver.findElement(By.xpath("//table/tbody/tr[" + i +"]" + "/td[3]")).getText();
			
			if(selectAirLine.equalsIgnoreCase(airline)) {
				driver.findElement(By.xpath("//table/tbody/tr[" + i +"]" + "/td[1]//input[@type='submit']")).click();
				matchFound = true;
				break;
			}
		}
		
		if(!matchFound) {
			Assert.fail();
		}
	}
	

}
