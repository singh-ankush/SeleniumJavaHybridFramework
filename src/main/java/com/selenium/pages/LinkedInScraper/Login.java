package com.selenium.pages.LinkedInScraper;

import com.selenium.pages.MainPage;
import com.selenium.util.ReusableFunctions;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class Login {

    static Logger logger = Logger.getLogger(MainPage.class.getName());
    ReusableFunctions _reusableFunc = new ReusableFunctions();

    public final By id = By.xpath("//*[@id='username']");
    public final By pass = By.xpath("//*[@id='password']");
    public final By logbtn = By.xpath("//button[contains(text(),'Sign in')]");

    public boolean login(WebDriver driver){
        boolean flag = true;
        try{
            if(_reusableFunc.waitForElementPresent(driver, id)){
                _reusableFunc.enterText(driver,id,"ankushoffice10@gmail.com");
                _reusableFunc.enterText(driver,pass,"Automation#1");
                _reusableFunc.click(driver,logbtn);
            }
        }

        catch(Exception e){
            flag = false;
            logger.error("Cannot login in right now : "+e.getMessage());
        }
        return flag;
    }
}
