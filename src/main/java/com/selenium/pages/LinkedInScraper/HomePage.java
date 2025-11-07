package com.selenium.pages.LinkedInScraper;

import com.selenium.pages.MainPage;
import com.selenium.util.ReusableFunctions;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage {
    static Logger logger = Logger.getLogger(MainPage.class.getName());
    ReusableFunctions _reusableFunc = new ReusableFunctions();

    public final By search = By.xpath("//input[@placeholder='Search']");

    public boolean search(WebDriver driver){
        boolean flag = true;
        try{
            if(_reusableFunc.waitForElementPresent(driver, search)){
                _reusableFunc.enterText(driver,search,"\"selenium\" AND \"2 years\" AND \"hiring\""+ Keys.ENTER);
            }
        }

        catch(Exception e){
            flag = false;
            logger.error("Unable to search the input : "+e.getMessage());
        }
        return flag;
    }
}
