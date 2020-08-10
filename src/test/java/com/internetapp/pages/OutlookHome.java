package com.internetapp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.maveric.core.common.functions.CommonDef;

public class OutlookHome extends CommonDef{
	
	@FindBy(id="O365_MainLink_NavMenu") private WebElement eMenu;
	@FindBy(xpath="//span[text()='OpenAir (PSA) ']") private WebElement eMenuOpenAir;
	
	public OutlookHome clickMenu() 
	{      
    	click(eMenu);                 
        return this;
    }
	public OpenAirHome clickMenuOpenAir() 
	{      
    	click(eMenuOpenAir);                 
        return new OpenAirHome();
    }


}
