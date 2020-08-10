package com.internetapp.tests;

import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.internetapp.pages.OutlookLogin;
import com.maveric.core.testng.BaseTest;
import com.maveric.core.testng.listeners.DriverListener;
import com.maveric.core.utils.data.ExcelDataReader;

public class BankTest extends BaseTest {
	
	@Test(groups = {"web"},dataProvider="ExcelInputs")
	public void KeywordTest(String tcId) throws FilloException, InterruptedException 
	{
		DriverListener.testCase.set(tcId);
		System.out.println(ExcelDataReader.getData("Sheet2", tcId, "lifecycle"));
		String[] lifecycles = ExcelDataReader.getData("Sheet2", tcId, "lifecycle").split(";");
		for (String lifecycle : lifecycles) {
				
		switch(lifecycle)
		{
		
		case "outlookLogin": 
			new OutlookLogin()
				.outlookNavigate(ExcelDataReader.getData("Sheet2", tcId, "url"), ExcelDataReader.getData("Sheet2", tcId, "driverType"))
				.enterUserName(ExcelDataReader.getData("Sheet2", tcId, "userName"))
				.clickNext()
				.enterPassword(ExcelDataReader.getData("Sheet2", tcId, "password"))
				.clickNext()
				.clickStaySignNo();
			break;
		
		case "openAirProcess":
//			steps.updateTimesheet();
			break;	
		}

	}

}
}
