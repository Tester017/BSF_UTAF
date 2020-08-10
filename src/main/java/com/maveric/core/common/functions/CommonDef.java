package com.maveric.core.common.functions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.maveric.core.driver.DriverFactory;
import com.maveric.core.utils.web.WebActions;


public class CommonDef extends WebActions{
	
    DriverFactory driverFactory=new DriverFactory();

	public void startApp(String url,String driverType) {
		try 
		{
			if(driverType.contains("desktop"))
			{
				driver = driverFactory.driverSetup();
//	    		driver = new RecheckDriver((RemoteWebDriver) driver); 	
			}
			if(driverType.contains("mobile")) 
			{	    		
	    		driver=driverFactory.mobdriverSetup();
//	    		driver = new RecheckDriver((RemoteWebDriver) driver); 
	    	}
	
			driver.navigate().to(url);
//			waitForPageLoad();
			System.out.println(driver);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	        logScreenshot("login");

		} 
		catch (Exception e) 
		{
			System.err.println("The Browser Could not be Launched. Hence Failed");
			throw new RuntimeException();
		} 

	}
	
	public void click(WebElement ele) {
		String text="";
		try {

			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			text = ele.getText();
			ele.click();
	        logScreenshot("The Element "+text+" clicked");
		} catch (StaleElementReferenceException e) {
			logScreenshot("The Element "+text+" could not be clicked");
			throw new RuntimeException();
		} 
	}
	
	public void clearAndType(WebElement ele, String data) {
		try {
			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(ele));
			ele.clear();
			ele.sendKeys(data);
			logScreenshot("The Data :"+data+" entered Successfully");
		} catch (ElementNotInteractableException e) {
			logScreenshot("The Element "+ele+" is not Interactable");
			throw new RuntimeException();
		}
	}
	
	/*Author: Praveen Description: To Enter Keys into a field*/
	
	public void sendKeys(By ele, String data) {
		try {
			//daniel
			driver.findElement(ele).sendKeys(data);
			logScreenshot("The Data :"+data+" entered Successfully");
		} catch (ElementNotInteractableException e) {
			logScreenshot("The Element "+ele+" is not Interactable");
			throw new RuntimeException();
		}
	}
	
	public void waitForPageLoad() {
//		driver = DriverFactory.getCurrentDriver();
		ExpectedCondition<Boolean> expect = new ExpectedCondition<Boolean>() 
		{
			public Boolean apply(WebDriver driver) 
			{
				System.out.println(driver);

				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		wait = new WebDriverWait(driver, 120);
		try {
			wait.until(expect);
		} catch (Exception E) {
//			ExReporter.log(LogStatus.INFO, "Page Load Condition failed. Continuing with test");
		}
	}
	
	public WebElement findElement(By by) 
	{
			return driver.findElement(by);
	}
	
	public void dropdown(By by, String keysToSend) {
		try {
		Select select= new Select(findElement(by));
		select.selectByVisibleText(keysToSend);
		logScreenshot(keysToSend+" is selected successfully ");
		} catch (Exception E) {
		logScreenshot(keysToSend+" is not selected successfully ");
		throw new RuntimeException();
		}
		}

		
		
	


}
