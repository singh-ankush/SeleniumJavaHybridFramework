package com.selenium.testcases.LinkedInScraper_tc;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.selenium.base.TestBase;
import com.selenium.listeners.ExtentManager;
import com.selenium.util.ReusableFunctions;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.lang.reflect.Method;

public class Scraper extends TestBase {
    public static com.selenium.pages.LinkedInScraper.Login _login;
    public static com.selenium.pages.LinkedInScraper.HomePage _homePage;
    public static com.selenium.pages.LinkedInScraper.PostsPage _postsPage;

    public static SoftAssert _softAssert;

    public static String testCaseName = null;
    public static ExtentTest logger = null;
    public static ExtentManager extManager = null;
    public static ExtentReports extent = null;

    public Scraper(){
        super();
    }

    @BeforeTest
    public  static  void setDriver() throws Exception{

        initialization();

        _login = new com.selenium.pages.LinkedInScraper.Login();
        _homePage = new com.selenium.pages.LinkedInScraper.HomePage();
        _postsPage = new com.selenium.pages.LinkedInScraper.PostsPage();

    }

    @BeforeMethod
    public static void setUp(Method method) throws IOException {

        _softAssert = new SoftAssert();

        testCaseName = method.getName();
        extManager = new ExtentManager(extent);
        extent = ExtentManager.getReporter();
        logger = ExtentManager.getLogger(testCaseName);
    }



    @Test
    public  void login_check_empty(){
        if(!_login.login(driver)){
            _softAssert.fail("Given username and password no not match " );
        }
        if(!_homePage.search(driver)){
            _softAssert.fail("Search failed " );
        }
        if(!_postsPage.filter_search(driver)){
            _softAssert.fail("filter failed " );
        }
        if(!_postsPage.scrape_content(driver)){
            _softAssert.fail("scrape failed " );
        }
        _softAssert.assertAll();
    }




    @AfterMethod
    public void getResult(ITestResult result) throws Exception{

        if(result.getStatus() == ITestResult.FAILURE){
            String screenShotPath = ReusableFunctions.takeScreenShot(driver, "SeleniumTestScreen");
            logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test case FAILED due to below issues:", ExtentColor.RED));
            logger.fail(result.getThrowable());
            logger.fail("Snapshot below: " + logger.addScreenCaptureFromPath(screenShotPath, testCaseName));

        }else if(result.getStatus() == ITestResult.SKIP){
            logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" Test case SKIPPED due to below issues:", ExtentColor.GREY));
            logger.skip(result.getThrowable());

        }else if(result.getStatus() == ITestResult.SUCCESS){
            logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test case PASSED.", ExtentColor.GREEN));
        }

//        if (driver != null) {
//            driver.manage().deleteAllCookies();
//            driver.quit();
//        }
    }
    @AfterTest
    public void tearDown(){

        if (driver != null) {
            driver.manage().deleteAllCookies();
            driver.quit();
        }
        extent.flush();
    }
}
