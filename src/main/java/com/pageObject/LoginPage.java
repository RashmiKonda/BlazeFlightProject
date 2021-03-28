package com.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
	this.driver = driver;
	}
	
	By email = By.id("email");
	By passowrd = By.xpath("//input[@type='password']");
	By loginBtn= By.xpath("//button[@type='submit']");
	By welcomeMsg = By.xpath("//div[@class='container']/h1");
			

	public WebElement getEmail() {
		return driver.findElement(email);
	}
	
	public WebElement getPassword() {
		return driver.findElement(passowrd);
	}
	public WebElement getLoginBtn() {
		return driver.findElement(loginBtn);
	}
	public WebElement getWelcomeMsg() {
		return driver.findElement(welcomeMsg);
	}


}
