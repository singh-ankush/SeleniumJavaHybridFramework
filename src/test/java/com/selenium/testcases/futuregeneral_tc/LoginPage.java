package com.selenium.testcases.futuregeneral_tc;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.selenium.base.TestBase;
import com.selenium.listeners.ExtentManager;
import com.selenium.testdata.DataReader;
import com.selenium.util.ReusableFunctions;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

public class LoginPage extends TestBase {
    public static com.selenium.pages.futuregeneral.LoginPage _loginPage;
    public static com.selenium.pages.futuregeneral.CreateBI _createBI;
    public static com.selenium.pages.futuregeneral.ConvertApplication _convApp;
    public static SoftAssert _softAssert;

    public static String testCaseName = null;
    public static ExtentTest logger = null;
    public static ExtentManager extManager = null;
    public static ExtentReports extent = null;

    public static HashMap<String, HashMap<String, String>> tcData = DataReader.testDataMappedToTestName(prop.getProperty("TestDataExcelFileName_fg"), prop.getProperty("TestDataSheetName_fg"));
    public static HashMap<String, HashMap<String, String>> tcData_app = DataReader.testDataMappedToTestName(prop.getProperty("TestDataExcelFileName_fg"), prop.getProperty("TestDataSheetName_fg_app"));
    public static HashMap<String, HashMap<String, String>> tcData_login = DataReader.testDataMappedToTestName(prop.getProperty("TestDataExcelFileName_fg"), prop.getProperty("TestDataSheetName_fg_login"));


    public LoginPage(){
        super();
    }

    @BeforeTest
    public  static  void setDriver() throws Exception{

        initialization();

        _loginPage = new com.selenium.pages.futuregeneral.LoginPage();
        _createBI = new com.selenium.pages.futuregeneral.CreateBI();
        _convApp = new com.selenium.pages.futuregeneral.ConvertApplication();

    }

    @BeforeMethod
    public static void setUp(Method method) throws IOException {
////        initialization();
//        _loginPage = new com.selenium.pages.futuregeneral.LoginPage();
//        _createBI = new com.selenium.pages.futuregeneral.CreateBI();
        _softAssert = new SoftAssert();

        testCaseName = method.getName();
        extManager = new ExtentManager(extent);
        extent = ExtentManager.getReporter();
        logger = ExtentManager.getLogger(testCaseName);
    }

//    @Test(priority=1)
    public void verifyElements(){
        if (!_loginPage.verifyElementsPresent(driver)) {
            _softAssert.fail("Element not present on the page");
        }
        _softAssert.assertAll();
    }

    @Test(priority = 1)
    public  void login_check_true(){
        String usrname = tcData_login.get(testCaseName).get("Username");
        String psword = tcData_login.get(testCaseName).get("Password");

        if(!_loginPage.login(driver, usrname, psword)){
            _softAssert.fail("Given username and password no not match " +usrname+" "+psword );
        }
        _softAssert.assertAll();
    }

//    @Test(priority = 3)
    public  void login_check_false(){
        String usrname = tcData.get(testCaseName).get("Username");
        String psword = tcData.get(testCaseName).get("Password");

        if(_loginPage.login(driver, usrname, psword)){
            _softAssert.fail("Given username and password no not match " +usrname+" "+psword );
        }
        _softAssert.assertAll();
    }

//    @Test(priority = 4)
    public  void login_check_empty(){
        if(!_loginPage.login(driver, "", "")){
            _softAssert.fail("Given username and password no not match " );
        }
        _softAssert.assertAll();
    }

    @Test(priority = 2)
    public void create_BI(){

        String user = tcData.get(testCaseName).get("user");
        String pass = tcData.get(testCaseName).get("pass");
        String salutation = tcData.get(testCaseName).get("salutation");
        String firstname = tcData.get(testCaseName).get("firstname");
        String lastname = tcData.get(testCaseName).get("lastname");
        String dateofbirth = tcData.get(testCaseName).get("dateofbirth");
        String nation = tcData.get(testCaseName).get("nation");
        String ph_no = tcData.get(testCaseName).get("ph_no");
        String lf_stg = tcData.get(testCaseName).get("lf_stg");
        String incm = tcData.get(testCaseName).get("incm");
        String cat_pol = tcData.get(testCaseName).get("cat_pol");
        String lf_goal = tcData.get(testCaseName).get("lf_goal");
        String curr_goal = tcData.get(testCaseName).get("curr_goal");
        String tm_acc = tcData.get(testCaseName).get("tm_acc");
        String pc_term = tcData.get(testCaseName).get("pc_term");
        String pc_ppt = tcData.get(testCaseName).get("pc_ppt");
        String plan_opt = tcData.get(testCaseName).get("plan_opt");
        String inc_opt = tcData.get(testCaseName).get("inc_opt");
        String sur_ben_frq = tcData.get(testCaseName).get("sur_ben_frq");
        String db_multiple = tcData.get(testCaseName).get("db_multiple");
        String mod_prem = tcData.get(testCaseName).get("mod_prem");
        String rd_ad_pc = tcData.get(testCaseName).get("rd_ad_pc");
        String rd_ad_pt = tcData.get(testCaseName).get("rd_ad_pt");
        String rd_ad_sa = tcData.get(testCaseName).get("rd_ad_sa");
        String rd_ad_rop = tcData.get(testCaseName).get("rd_ad_rop");
        String rd_ad_bp = tcData.get(testCaseName).get("rd_ad_bp");
        String rd_ad_if = tcData.get(testCaseName).get("rd_ad_if");
        String rd_ad_id = tcData.get(testCaseName).get("rd_ad_id");

        if(!_createBI.createBI(driver, user, pass, salutation, firstname, lastname, dateofbirth, nation, ph_no, lf_stg, incm, cat_pol, lf_goal, curr_goal, tm_acc, pc_term, pc_ppt, plan_opt, inc_opt, sur_ben_frq, db_multiple, mod_prem, rd_ad_pc, rd_ad_pt, rd_ad_sa, rd_ad_rop, rd_ad_bp, rd_ad_if, rd_ad_id)
        ){
            _softAssert.fail("Unexpected error occured" );
        }
        _softAssert.assertAll();

    }

    @Test(priority = 3)
    public void CreateApplication(){

        String mail = tcData_app.get(testCaseName).get("mail");
        String edqual = tcData_app.get(testCaseName).get("edqual");
        String currocc = tcData_app.get(testCaseName).get("currocc");
        String dutynature = tcData_app.get(testCaseName).get("dutynature");
        String nameemp = tcData_app.get(testCaseName).get("nameemp");
        String desig = tcData_app.get(testCaseName).get("desig");
        String ckyc_ = tcData_app.get(testCaseName).get("ckyc_");

        String add1 = tcData_app.get(testCaseName).get("address1");
        String add2 = tcData_app.get(testCaseName).get("address2");
        String pincode = tcData_app.get(testCaseName).get("pinC");

        String fr_title = tcData_app.get(testCaseName).get("fr_title");
        String fr_name = tcData_app.get(testCaseName).get("fr_name");
        String fr_lanme = tcData_app.get(testCaseName).get("fr_lanme");
        String fr_dtcause = tcData_app.get(testCaseName).get("fr_dtcause");
        String fr_dtage = tcData_app.get(testCaseName).get("fr_dtage");
        String mo_title = tcData_app.get(testCaseName).get("mo_title");
        String mo_name = tcData_app.get(testCaseName).get("mo_name");
        String mo_lanme = tcData_app.get(testCaseName).get("mo_lanme");
        String mo_dtcause = tcData_app.get(testCaseName).get("mo_dtcause");
        String mo_dtage = tcData_app.get(testCaseName).get("mo_dtage");

        String titleValue = tcData_app.get(testCaseName).get("titleValue");
        String firstNameValue = tcData_app.get(testCaseName).get("firstNameValue");
        String lastNameValue = tcData_app.get(testCaseName).get("lastNameValue");
        String relationValue = tcData_app.get(testCaseName).get("relationValue");
        String dobValue = tcData_app.get(testCaseName).get("dobValue");
        String mobileNoValue = tcData_app.get(testCaseName).get("mobileNoValue");
        String nomineePercentValue = tcData_app.get(testCaseName).get("nomineePercentValue");
        String bankAccNoValue = tcData_app.get(testCaseName).get("bankAccNoValue");
        String ifscValue = tcData_app.get(testCaseName).get("ifscValue");
        String bankNameValue = tcData_app.get(testCaseName).get("bankNameValue");
        String branchValue = tcData_app.get(testCaseName).get("branchValue");

        String height = tcData_app.get(testCaseName).get("height");
        String weight = tcData_app.get(testCaseName).get("weight");

        String panD = tcData_app.get(testCaseName).get("panD");
        String agriinc = tcData_app.get(testCaseName).get("agriinc");
        String otherinc = tcData_app.get(testCaseName).get("otherinc");
        String iddoc = tcData_app.get(testCaseName).get("iddoc");
        String idno1 = tcData_app.get(testCaseName).get("idno1");
        String docissue1 = tcData_app.get(testCaseName).get("docissue1");
        String adddoc = tcData_app.get(testCaseName).get("adddoc");
        String idno2 = tcData_app.get(testCaseName).get("idno2");
        String docissue2 = tcData_app.get(testCaseName).get("docissue2");

        String accLA = tcData_app.get(testCaseName).get("accLA");
        String ifscLA = tcData_app.get(testCaseName).get("ifscLA");
        String placeSumm = tcData_app.get(testCaseName).get("placeSumm");



        if(!_convApp.convertApp(driver)){
            _softAssert.fail("Unexpected error in application");
        }

        if(!_convApp.clickpyKyc(driver)){
            _softAssert.fail("physical kyc failed");
        }

        if(!_convApp.personalDet(driver,mail,edqual,currocc,dutynature,nameemp,desig,ckyc_)){
            _softAssert.fail("Unexpected error in personal details");
        }

        if(!_convApp.commDetails(driver,add1,add2,pincode)){
            _softAssert.fail("Unexpected error in communication details");
        }

        if(!_convApp.famDetails(driver,fr_title, fr_name, fr_lanme, fr_dtcause, fr_dtage, mo_title, mo_name, mo_lanme, mo_dtcause, mo_dtage)){
            _softAssert.fail("Unexpected error in family details");
        }

        if(!_convApp.addNominee(driver,titleValue, firstNameValue, lastNameValue, relationValue, dobValue, mobileNoValue, nomineePercentValue, bankAccNoValue, ifscValue, bankNameValue, branchValue)){
            _softAssert.fail("Unexpected error in nominee details");
        }

        if(!_convApp.healthDetails(driver, height, weight)){
            _softAssert.fail("Unexpected error in health details");
        }

        if(!_convApp.lifestyleDetails(driver)){
            _softAssert.fail("Unexpected error in lifestyle details");
        }

        if(!_convApp.laDetails(driver,accLA,ifscLA)){
            _softAssert.fail("Unexpected error in LA details");
        }

        if(!_convApp.FATCA(driver)){
            _softAssert.fail("Unexpected error in FATCA details");
        }

        if(!_convApp.form60(driver,agriinc,otherinc,iddoc,idno1,docissue1,adddoc,idno2, ifscLA)){
            _softAssert.fail("Unexpected error in Form 60");
        }

        if(!_convApp.subSummary(driver,placeSumm)){
            _softAssert.fail("Failed to submit summary");
        }

        if(!_convApp.otpLA(driver)){
            _softAssert.fail("Failed to enter otp");
        }
        if(!_convApp.payment(driver)){
            _softAssert.fail("payment screen not submitted");
        }
        if(!_convApp.paymentComplete(driver)){
            _softAssert.fail("payment failed");
        }
        if(!_convApp.uploadDoc(driver)){
           _softAssert.fail("File upload failed");
        }
        if(!_convApp.scrSubmit(driver)){
            _softAssert.fail("SCR cant be submitted");
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
