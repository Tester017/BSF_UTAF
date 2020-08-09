package com.maveric.core.testng;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.LinkedHashSet;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import com.codoid.products.exception.FilloException;
import com.maveric.core.driver.DriverFactory;
import com.maveric.core.testng.listeners.DriverListener;
import com.maveric.core.utils.data.ExcelDataReader;
import com.maveric.core.utils.web.WebActions;

@Listeners({DriverListener.class/*,ExtentITestListenerClassAdapter.class*/})
public class BaseTest extends WebActions{
	
    DriverFactory driverFactory=new DriverFactory();

	
	@DataProvider(name="inputs",parallel=true)
	public Object[][] getData() {
		return new Object[][] {
			{"TC001"},
			{"TC002"},/*,
			{"TC003"},
			{"TC004"},
			{"TC005"},
			{"TC006"},*/
		};
	}
	
	@DataProvider(name="ExcelInputs",parallel=true)
	public Object[] getExcelData() throws FilloException {
		return ExcelDataReader.getControlData("Sheet1", "TC_ID");
	}
	
    /**	
	* Method Name			:	beforeSuite 
	* Use					:	Prints Suite name
	* Return Type			:	Has no Return Type
	* Designed By			:	Daniel
	* Date Last Modified	:	05-Aug-2020
	*/
    @BeforeSuite(alwaysRun = true)
	public static void beforeSuite(ITestContext ctx) {
		System.out.println("*******Start of BeforeSuite****suite**************");
		String suiteName = ctx.getCurrentXmlTest().getSuite().getName();
		System.out.println(suiteName);
		System.out.println("*******End of BeforeSuite****suite**************");

	}

    /**	
	* Method Name			:	beforeSuite 
	* Use					:	Testing
	* Return Type			:	Has no Return Type
	* Designed By			:	Daniel
	* Date Last Modified	:	05-Aug-2020
	*/
	@AfterSuite(alwaysRun = true)
	public static void afterSuite(ITestContext ctx) throws MalformedURLException, IOException {
		System.out.println("*******Start of AfterSuite****EndOfsuite**************");
		String suiteName = ctx.getCurrentXmlTest().getSuite().getName();
		System.out.println(suiteName);
		System.out.println("*******End of AfterSuite****EndOfsuite**************");

	}

	/**	
	* Method Name			:	beforeSuite 
	* Use					:	Testing
	* Return Type			:	Has no Return Type
	* Designed By			:	Daniel
	* Date Last Modified	:	05-Aug-2020
	*/
	@BeforeClass(alwaysRun = true)
	public void beforeClass(ITestContext ctx) {
		System.out.println("*******Start of @BeforeClass******************");
		String className = this.getClass().getSimpleName();
		String suiteName = ctx.getCurrentXmlTest().getSuite().getName();
		String testName = ctx.getCurrentXmlTest().getName();		
		System.out.println(suiteName+" - "+className+" - "+testName);
		System.out.println("*******End of @BeforeClass******************");
		
	}

	/**	
	* Method Name			:	afterClass 
	* Use					:	Function for execution of methods and Extent Reports Closure after the execution of a class 
	* Return Type			:	Has no Return Type and Input is from Test Data Sheets
	* Designed By			:	surya kumar
	* Date Last Modified	:	20-Aug-2017
	*/
	@AfterClass(alwaysRun = true)
	public void afterClass(ITestContext ctx) {
		System.out.println("*******Start of @AfterClass******************");
		String suiteName = ctx.getCurrentXmlTest().getSuite().getName();
		String className = this.getClass().getSimpleName();
		System.out.println(suiteName+" - "+className);
		System.out.println("*******End of @AfterClass******************");
	}

	/**	
	* Method Name			:	beforeMethod 
	* Use					:	Function for execution of methods and Extent Reports and Test Data Initialization before the execution of a Method 
	* Return Type			:	Has no Return Type and Input is from Test Data Sheets
	* Designed By			:	surya kumar
	* Date Last Modified	:	20-Aug-2017
	 * @throws InterruptedException 
	*/
	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(Object[] testArgs, ITestContext ctx, Method method) throws IOException, InterruptedException {
		System.out.println("*******Start of @BeforeMethod******************");
		/*String driverType=ConfigProperties.DRIVER_TYPE.get();
		
    	if(driverType.contains("desktop")) 
    	{
    		if(ConfigProperties.BROWSER.get().equalsIgnoreCase("CHROME")) driver = driverFactory.driverSetup();
//    		driver = new RecheckDriver((RemoteWebDriver) this.driver); 

    	}
    	
    	if(driverType.contains("mobile")) 
    	{    		
    		System.out.println("Mobile Driver to be set");
    		this.driver=driverFactory.mobdriverSetup();
//    		driver = new RecheckDriver((RemoteWebDriver) this.driver); 
    		System.out.println("mobile driver is ready");
    	}
    	
		System.out.println("desktop driver is ready");
    	System.out.println("Driver Instantiated is : " + driver);
    	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.navigate().to("http://dbankdemo.com/login");

        wait=new WebDriverWait(driver, 30);
        Thread.sleep(5000);
        logScreenshot("login");
        log("sample log");
		System.out.println(test);*/
 
		System.out.println("*******End of @BeforeMethod******************");
		
	}

	/**	
	* Method Name			:	afterMethod 
	* Use					:	Function for execution of methods and Extent Reports and Test Data closure after the execution of a Method 
	* Return Type			:	Has no Return Type and Input is from Test Data Sheets
	* Designed By			:	surya kumar
	* Date Last Modified	:	20-Aug-2017
	*/
	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestContext context, Method method, ITestResult result) 
	{
		System.out.println("*******Start of @AfterMethod******************");
//		driver.close();
		System.out.println("*******End of @AfterMethod******************");		
	}

}
