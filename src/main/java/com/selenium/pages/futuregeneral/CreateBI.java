package com.selenium.pages.futuregeneral;

import com.selenium.pages.MainPage;
import com.selenium.util.ReusableFunctions;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateBI {
    static Logger logger = Logger.getLogger(MainPage.class.getName());
    ReusableFunctions _reusableFunc = new ReusableFunctions();

    public static com.selenium.pages.futuregeneral.LoginPage _loginPage;

    public final By gotoCreateBI = By.xpath("//*[text()='Create BI']/ancestor::*[1]");
    public final By createnewBI = By.xpath("//*[text()='Create new']");

    public final By skip = By.xpath("//*[text()='SKIP']");

    //suitability analysis
    public final By title_ = By.xpath("//input[@name='salutation']/ancestor::*[1]/div");
    public final By fname = By.xpath("//input[@name='FirstName']");
    public final By lname = By.xpath("//input[@name='LastName']");
    public final By dob = By.xpath("//input[@name='DOB1']"); //dd-mm-yyyy
    public final By gender = By.xpath("//label[text()='Male']");
    public final By smoker = By.xpath("//label[text()='Yes']");
    public final By nationality = By.xpath("//input[@id='Nationality']");
    public final By contact = By.xpath("//input[@id='MobileNumber']");
    public final By life_stage = By.xpath("//label[text()='Life stage']/ancestor::*[1]/div");
    public final By income = By.xpath("//input[@id='AnnualIncome']"); //lakhs
    public final By policy_category = By.xpath("//label[text()='Policy Category']/ancestor::*[1]/div");
    public final By existing_li_portfolio = By.xpath("//*[text()='0']");
    public final By risk_profile = By.xpath("//*[text()='High']");
    public final By life_goal = By.xpath("//*[text()='Saving']"); //saving
    public final By currentgoal_val = By.xpath("//input[@name='CurrentValue']");
    public final By time_accomplish = By.xpath("//div[@id='PolicyTerm']");
    public final By submit = By.xpath("//button[text()='SUBMIT DETAILS']");

    //choose insurance
    public final By insurance_type = By.xpath("//*[text()='Generali Central Long Term Income Plan']/parent::*/following-sibling::*//button[normalize-space(text())='buy now']"); //generali central long term insurance plan

    //premium calculator
    public final By policy_term = By.xpath("//input[@name='@PR_PT']/ancestor::*[1]/div");
    public final By premium_paying_term = By.xpath("//input[@name='@PR_PPT']/ancestor::*[1]/div");
    public final By frequency = By.xpath("//label[text()='Yearly']");
    public final By category_ = By.xpath("//label[text()='None']");
    public final By plan_option = By.xpath("//input[@name='OptionLevelId_1']/ancestor::*[1]/div");
    public final By income_option = By.xpath("//input[@name='OptionLevelId_2']/ancestor::*[1]/div");
    public final By survivalbenifit_frequency = By.xpath("//input[@name='OptionLevelId_3']/ancestor::*[1]/div");
    public final By modal_premium = By.xpath("//input[@id='outlined-basic']");

    //riders
    public final By accidental_death = By.xpath("//*[text()='Generali Central Non-Linked Accidental Death Benefit Rider']");
    public final By riderad_policy_term = By.xpath("//input[@name='@RD_PT']/ancestor::*[1]/div");
    public final By riderad_premium_term = By.xpath("//input[@name='@RD_PPT']/ancestor::*[1]/div");
    public final By riderad_sumassured = By.xpath("//input[@aria-invalid='Sum Assured is required']");
    public final By riderad_rop = By.xpath("//label[text()='Return Of Premium']/parent::*[1]");
    public final By riderad_benefitpayout = By.xpath("//label[text()='Benefit Type Payout']/parent::*[1]");

    public final By death_benifitmult = By.xpath("//label[text()='Death Benefit Multiple']/parent::*[1]");
    public final By inc_freq = By.xpath("//label[text()='Income Frequency']/parent::*[1]");
    public final By inc_dur = By.xpath("//label[text()='Income Duration']/parent::*[1]");
    public final By accidental_disability = By.xpath("");
    public final By term_rider = By.xpath("");

    public final By calculate_premium = By.xpath("//*[text()='CALCULATE PREMIUM']");

    public final By base_modal = By.xpath("//label[text()='Base Modal premium']/following-sibling::*[1]");
    public final By rider_modal = By.xpath("//label[text()='Base Rider premium']/following-sibling::*[1]");
    public final By gst = By.xpath("//label[text()='Total GST']/following-sibling::*[1]");
    public final By total_premium = By.xpath("//label[text()='Total Premium']/following-sibling::*[1]");

    public static int parseAmt(String amount){
        String cleaned = amount.replace("Rs.", "").replace(",", "").trim();
        return Integer.parseInt(cleaned);
    }

    public static boolean checkSum(String a, String b, String c, String d) {
        int valA = parseAmt(a);
        int valB = parseAmt(b);
        int valC = parseAmt(c);
        int valD = parseAmt(d);

        return (valA + valB + valC) == valD;
    }

    //premium amount page
    public final By viewBI = By.xpath("//button[text()='VIEW BI']");
    public final By generateBI = By.xpath("//button[text()='Generate BI']");

    public boolean createBI(WebDriver driver, String user, String pass, String salutation, String firstname, String lastname,String dateofbirth,
                            String nation, String ph_no, String lf_stg, String incm, String cat_pol, String lf_goal, String curr_goal, String tm_acc,
                            String pc_term, String pc_ppt, String plan_opt, String inc_opt, String sur_ben_frq, String db_multiple, String mod_prem, String rd_ad_pc,
                            String rd_ad_pt, String rd_ad_sa, String rd_ad_rop, String rd_ad_bp, String rd_ad_if, String rd_ad_id ){
        boolean flag = true;
        try {
            logger.info("Verifying BI creation");


            Thread.sleep(500);

            //create BI
            _reusableFunc.waitForElementPresent(driver, gotoCreateBI);
            _reusableFunc.click(driver, gotoCreateBI);
            // create new BI
            _reusableFunc.waitForElementPresent(driver, createnewBI);
            _reusableFunc.click(driver, createnewBI);
            //skip button
            _reusableFunc.waitForElementPresent(driver, skip);
            _reusableFunc.click(driver, skip);

            //suitability analysis
            _reusableFunc.dropdown_selectbyvisibletext(driver, title_, salutation);
            _reusableFunc.enterText(driver, fname, firstname);
            _reusableFunc.enterText(driver,lname,lastname);
            _reusableFunc.click(driver,dob);
            _reusableFunc.enterText(driver,dob,dateofbirth); // -dd/mm/yyyy
            _reusableFunc.click(driver, gender);
            _reusableFunc.click(driver,smoker);
            _reusableFunc.dropdown_selectbyvisibletext(driver, nationality, nation);
            _reusableFunc.click(driver,contact);
            _reusableFunc.enterText(driver,contact, ph_no);
            _reusableFunc.dropdown_selectbyvisibletext(driver,life_stage, lf_stg);
            _reusableFunc.enterText(driver, income, incm);
            _reusableFunc.dropdown_selectbyvisibletext(driver, policy_category, cat_pol);
            _reusableFunc.click(driver, existing_li_portfolio);
            _reusableFunc.click(driver, risk_profile);
            _reusableFunc.click(driver,life_goal);
            _reusableFunc.enterText(driver,currentgoal_val, curr_goal);
            _reusableFunc.dropdown_selectbyvisibletext(driver,time_accomplish, tm_acc);
            _reusableFunc.click(driver,submit);

            _reusableFunc.waitForElementPresent(driver,insurance_type);
            _reusableFunc.click(driver, insurance_type);

            Thread.sleep(500);
            _reusableFunc.waitForElementPresent(driver,policy_term);
            _reusableFunc.dropdown_selectbyvisibletext(driver, policy_term, pc_term);
            _reusableFunc.dropdown_selectbyvisibletext(driver, premium_paying_term, pc_ppt);
            _reusableFunc.click(driver,frequency);
            _reusableFunc.click(driver, category_);
            _reusableFunc.dropdown_selectbyvisibletext(driver,plan_option,plan_opt);
            _reusableFunc.dropdown_selectbyvisibletext(driver, income_option, inc_opt);
            _reusableFunc.dropdown_selectbyvisibletext(driver, survivalbenifit_frequency, sur_ben_frq);
            _reusableFunc.dropdown_selectbyvisibletext(driver,death_benifitmult, db_multiple);
            _reusableFunc.enterText(driver, modal_premium,mod_prem);

            _reusableFunc.click(driver,accidental_death);
            _reusableFunc.waitForElementPresent(driver, riderad_policy_term);
            _reusableFunc.dropdown_selectbyvisibletext(driver,riderad_policy_term,rd_ad_pc);
            _reusableFunc.dropdown_selectbyvisibletext(driver,riderad_premium_term,rd_ad_pt);
            _reusableFunc.enterText(driver, riderad_sumassured, rd_ad_sa);
            _reusableFunc.dropdown_selectbyvisibletext(driver,riderad_rop,rd_ad_rop);
            _reusableFunc.dropdown_selectbyvisibletext(driver,riderad_benefitpayout,rd_ad_bp);

            _reusableFunc.dropdown_selectbyvisibletext(driver,inc_freq,rd_ad_if);
            _reusableFunc.dropdown_selectbyvisibletext(driver,inc_dur, rd_ad_id);
            _reusableFunc.click(driver,calculate_premium);

            String base =_reusableFunc.getTextByInnerText(driver,base_modal);
            String rider =_reusableFunc.getTextByInnerText(driver,rider_modal);
            String gstamt =_reusableFunc.getTextByInnerText(driver, gst);
            String totAmt = _reusableFunc.getTextByInnerText(driver,total_premium);

            if(!checkSum(base,rider,gstamt,totAmt)){
                flag = false;
            }


            _reusableFunc.waitForElementPresent(driver,viewBI);
            _reusableFunc.click(driver,viewBI);
            Thread.sleep(5000);
            _reusableFunc.switchToTab(0);

            _reusableFunc.click(driver, generateBI);

            Thread.sleep(3000);

            flag = !_reusableFunc.waitForElementPresent(driver,viewBI);
        }
        catch(Exception e){
            logger.error("Creation of BI error :"+ e.getMessage());
        }
        return flag;
    }

}
