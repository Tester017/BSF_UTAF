package com.internetapp.pages;

import org.openqa.selenium.By;

import com.maveric.core.common.functions.CommonDef;

public class OpenAirHome extends CommonDef{
	
	public OpenAirHome clickTimesheetsMenu() 
	{     
    	click(findElement(By.xpath("//div[@class='item-inner']//span[contains(text(),'Timesheets')]")));                 
        return this;
    }
	public OpenAirHome clickTimeSheetCategory(String category) 
	{     
    	click(findElement(By.xpath("//ul[@class='nav-menu-list']//span[contains(text(),'Timesheets')]//..//following::span[contains(text(),'"+ category +"')]")));                 
        return this;
    }
	public OpenAirHome clickCreateMenu() 
	{     
    	click(findElement(By.xpath("//span[contains(text(),'Create')]")));                 
        return this;
    }
	public OpenAirHome clickTimesheetNew() 
	{     
    	click(findElement(By.xpath("//span[contains(text(),'Timesheets: Timesheet, New')]")));                 
        return this;
    }

}
