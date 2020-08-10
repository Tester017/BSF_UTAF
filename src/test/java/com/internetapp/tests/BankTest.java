package com.internetapp.tests;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.internetapp.pages.OpenAirHome;
import com.internetapp.pages.OutlookLogin;
import com.internetapp.tests.functions.BankFunctions;
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
			new BankFunctions().loginToOutlook(tcId);
			break;
		
		case "openAirProcess":
			//new BankFunctions().updateTimesheet(tcId);
			break;	
		}

	}

}
}
