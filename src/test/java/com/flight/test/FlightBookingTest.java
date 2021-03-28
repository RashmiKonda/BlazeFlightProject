package com.flight.test;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.Base;
import com.base.CommonLibrary;
import com.base.ConstantMessages;
import com.pageObject.FlightSearchResultPage;
import com.pageObject.HomePage;
import com.pageObject.LoginPage;
import com.pageObject.PurchaseConfirmationPage;
import com.pageObject.PurchaseTicketPage;



public class FlightBookingTest extends Base{

	
	@Test(dataProvider = "getData")
	public void bookFlight(String departure, String destination, String airLine) throws IOException, InterruptedException {	
		
		HomePage homepage = new HomePage(driver);
		FlightSearchResultPage flightSearchPage = new FlightSearchResultPage(driver);
		PurchaseConfirmationPage purchaseConfPage = new PurchaseConfirmationPage(driver);
		PurchaseTicketPage purchaseTicket = new PurchaseTicketPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		//Commonlibrary is made as singleton as it will be used by all tests
		CommonLibrary commonLibrary = CommonLibrary.getInstance();
	
		commonLibrary.explicitWaitForText(loginPage.getWelcomeMsg(),ConstantMessages.welcomeMessage );
				
		//Find flight by selecting departure and destination
		commonLibrary.selectbyValue(homepage.getDepartureCity(), departure);
		commonLibrary.selectbyValue(homepage.getDestinationCity(), destination);
		commonLibrary.clickButton(homepage.getFindFlightBtn());
		
		commonLibrary.explicitWaitForElement(flightSearchPage.getChooseFlightTable());
		
		//Choose flight depending on data provided by dataprovider
		flightSearchPage.selectFlight(airLine);
		
		commonLibrary.explicitWaitForText(purchaseTicket.getPurchaseTicketMsg(),ConstantMessages.purchaseWelcomeMsg );
		
		//Enter card details to purchase ticket
		purchaseTicket.purchaseTicket();
		commonLibrary.explicitWaitForText(purchaseConfPage.getConfirmationMsg(),ConstantMessages.purchaseConfirmationWelcomeMsg );
		
		System.out.println("Transaction Id : " + purchaseConfPage.getTransId().getText() + " is generated successfully!");
		
		String status = purchaseConfPage.getStatus().getText();
		Assert.assertEquals(status, "PendingCapture");
	}
	
	@DataProvider
	public Object[][] getData() {
		
		Object[][] data = new Object[1][3];
		data[0][0] = "Paris";
		data[0][1] = "Rome";
		data[0][2] = "Virgin America";


		return data;
		
		
		
	}

}
