package com.selenium.pages.futuregeneral;

import com.selenium.pages.MainPage;
import com.selenium.util.ReusableFunctions;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class LoginPage {

    static Logger logger = Logger.getLogger(MainPage.class.getName());
    ReusableFunctions _reusableFunc = new ReusableFunctions();

    public final By username = By.xpath("//input[@name='userId']");
    public final By password = By.xpath("//input[@name='password']");
    public final By role = By.xpath("//label[text()='Agent']");
    public final By checkbox = By.xpath("//input[@type='checkbox']");
    public final By login_btn = By.xpath("//button[text()='Login securely']");
    public final By login_error = By.xpath("//div[contains(@style, 'transition')]");

    public boolean verifyElementsPresent(WebDriver driver){
        boolean flag = true;
        try{
            logger.info("verifying all elements present in login");
            _reusableFunc.waitForElementPresent(driver, username);

            ArrayList<By> locators = new ArrayList<By>();

            locators.add(username);
            locators.add(password);
            locators.add(role);
            locators.add(checkbox);
            locators.add(login_btn);

            if (!_reusableFunc.verifyElementsLocated(driver, locators)){
                logger.info("All Main Page Elements Displayed.");
            }else {
                flag = false;
                logger.error("Main Page Elements Not Displayed.");
            }
        }

        catch(Exception e){
            flag = false;
            logger.error("Exception Occurred While Verifying Login Page Elements: "+e.getMessage());
        }
        return flag;
    }

    public boolean login(WebDriver driver, String usrn, String pass){
        boolean flag = true;
        try{
            logger.info("Trying login with provided credentials");
            _reusableFunc.waitForElementPresent(driver, username);
            _reusableFunc.enterText(driver, username, usrn);
            _reusableFunc.enterText(driver, password, pass);
            _reusableFunc.click(driver,role);
            _reusableFunc.waitForElementClickable(driver, login_btn);
            _reusableFunc.click(driver, login_btn);

            flag = !_reusableFunc.waitForElementPresent(driver, login_error);
        }
        catch(Exception e){
            logger.error("Cannot login due to :"+ e.getMessage());
        }
        return flag;
    }

}
