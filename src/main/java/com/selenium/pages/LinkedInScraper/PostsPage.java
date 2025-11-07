package com.selenium.pages.LinkedInScraper;

import com.selenium.pages.MainPage;
import com.selenium.testdata.GoogleSheetsWriter;
import com.selenium.util.ReusableFunctions;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.python.antlr.ast.Str;

import java.util.List;

public class PostsPage {
    static Logger logger = Logger.getLogger(MainPage.class.getName());
    ReusableFunctions _reusableFunc = new ReusableFunctions();

    public final By posts_nav = By.xpath("//nav//button[text()='Posts']");
    public final By searchFilter = By.xpath("//button[@id='searchFilter_datePosted']");
    public final By weekFilter = By.xpath("(//*[text()='Past 24 hours'])[1]"); //error
    public final By showRes = By.xpath("(//*[text()='Show results'])[1]/.."); //error

    public final By postsEach = By.xpath("((//div[@class='fie-impression-container'])//span[contains(@class,'break')])"); //this shows multiple posts
    public final By postsMoreBtn = By.xpath("(//div[@class='fie-impression-container']//*[text()='…more'])"); //this is multiple buttons

    public boolean filter_search(WebDriver driver){
        boolean flag = true;
        try{
            if(_reusableFunc.waitForElementPresent(driver,posts_nav)){
                _reusableFunc.click(driver,posts_nav);
                _reusableFunc.click(driver,searchFilter);
                _reusableFunc.click(driver,weekFilter);
                _reusableFunc.click(driver,showRes);
            }
        }

        catch(Exception e){
            flag = false;
            logger.error("Unable to filter posts : "+e.getMessage());
        }
        return flag;
    }

    public  boolean scrape_content(WebDriver driver){
        boolean flag = true;
        try {
            logger.info("Trying to scrape content");

            List<String> posts = _reusableFunc.scrapeData50posts(driver);

            GoogleSheetsWriter.writeToSheet(posts);
        }
        catch (Exception e){

        }
        return flag;
    }

}
