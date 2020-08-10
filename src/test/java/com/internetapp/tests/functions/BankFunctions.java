package com.internetapp.tests.functions;

import java.util.HashMap;

import com.codoid.products.exception.FilloException;
import com.internetapp.pages.OpenAirHome;
import com.internetapp.pages.OutlookLogin;
import com.maveric.core.utils.data.ExcelDataReader;

public class BankFunctions {
	
	public void loginToOutlook(String tcId) throws FilloException
	{
		new OutlookLogin()
		.outlookNavigate(ExcelDataReader.getData("Sheet2", tcId, "url"), ExcelDataReader.getData("Sheet2", tcId, "driverType"))
		.enterUserName(ExcelDataReader.getData("Sheet2", tcId, "userName"))
		.clickNext()
		.enterPassword(ExcelDataReader.getData("Sheet2", tcId, "password"))
		.clickNext()
		.clickStaySignNo();
	}
	
	/*public static void openAirFromOutlook() 
	{
		try 
		{			
			MethodDef.click(outlookHome.menuNavigation());
			MethodDef.click(outlookHome.openAirMenu());						
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			ExReporter.log(LogStatus.FAIL, e.getMessage());
	}
	}
	
	public void updateTimesheet(String tcId) 
	{
		try { 
			
			if(ExcelDataReader.getData("Sheet2", tcId, "timesheetCreated").equalsIgnoreCase("Yes"))
			{
				new OpenAirHome()
					.clickTimesheetsMenu()
					.clickTimeSheetCategory(ExcelDataReader.getData("Sheet2", tcId, "timesheetCategory"))
					.selectTimesheet(ExcelDataReader.getData("Sheet2", tcId, "weekstarting"));				
			}
			else
			{
				new OpenAirHome()
					.clickCreateMenu()
					.clickTimesheetNew()
					.
				MethodDef.click(openAirHome.createMenu());
				MethodDef.click(openAirHome.timesheetNew());
				CommonDef.dropdown(openAirHome.createTimesheetDropDown(), TestData.getConfig("weekstarting"));
				MethodDef.click(openAirHome.saveCreatedTimesheet());
			}
			
			HashMap<String, Integer> weekColumn = new HashMap<String,Integer>();
			weekColumn.put("mon", 5);
			weekColumn.put("tue", 6);
			weekColumn.put("wed", 7);
			weekColumn.put("thu", 8);
			weekColumn.put("fri", 9);
			weekColumn.put("sat", 10);
			weekColumn.put("sun", 11);

			ArrayList<String> rowExecution = new ArrayList<String>();
			String[] elementList = TestData.getConfig("rowDriver").split("_");
			int rowCount=elementList.length;

			for(int i=0;i<elementList.length;i++) 
				{
					rowExecution.add(elementList[i]);
					System.out.println(elementList[i]);
				}
			int i=1;
			for(String weekInput : rowExecution) 
			{
				CommonDef.dropdown(openAirHome.DropDown("ts_c1_r"+i), TestData.getConfig("project"+i));
				CommonDef.dropdown(openAirHome.DropDown("ts_c2_r"+i), TestData.getConfig("task"+i));
				CommonDef.dropdown(openAirHome.DropDown("ts_c3_r"+i), TestData.getConfig("timeType"+i));
				CommonDef.dropdown(openAirHome.DropDown("ts_c4_r"+i), TestData.getConfig("location"+i));
				
				
					String[] weeks = weekInput.split(";");
					
					for (String week : weeks) 
					{
						String column = "ts_c"+weekColumn.get(week)+"_r"+i;
						MethodDef.sendKeys(openAirHome.inputHours(column), TestData.getConfig(week+i));
						MethodDef.click(openAirHome.addtlInfoLink(column));
						CommonDef.dropdown(openAirHome.premiseSelect(),TestData.getConfig("premise"));	
						MethodDef.click(openAirHome.addtlInfoOK());
					}
				i++;
				if(i>rowCount) break;
				
			}
			
			MethodDef.click(openAirHome.saveSubmitButton());

			}
		catch (Exception e) {
			// TODO Auto-generated catch block
//			ExReporter.log(LogStatus.FAIL, e.getMessage());
	}
	}*/

}
