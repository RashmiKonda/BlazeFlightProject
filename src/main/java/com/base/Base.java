package com.base;


import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class Base {
	
	public static WebDriver driver;
	public static Properties envProp;
	
	@BeforeSuite	
	public WebDriver InitializeBrowser() throws IOException {
		

		FileReader reader = new FileReader("C:\\Users\\Sudar\\eclipse-workspace\\FlightBooking\\environment.properties");
		envProp = new Properties();
		envProp.load(reader);
		
	    String browserName = envProp.getProperty("browser");
	    if(browserName.equalsIgnoreCase("chrome")) {
	    	System.setProperty("webdriver.chrome.driver","C:\\Users\\Sudar\\Downloads\\chromedriver.exe");
			 driver = new ChromeDriver();
	    }
	    else if(browserName.equalsIgnoreCase("firefox")) {
	    	//firefox code
	    }
	    else if(browserName.equalsIgnoreCase("IE")) {
	    	//IE code
	    }
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	    return driver;
	}
	
	@BeforeTest
	public void getURL() {
		driver.get(Base.envProp.getProperty("url"));
	}
	
	@AfterTest
	public void closeUrl() {
		driver.close();
	}
	
	@AfterSuite
	public void tearDown() {
		driver.quit();
	}

}
