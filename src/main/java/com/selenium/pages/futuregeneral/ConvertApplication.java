package com.selenium.pages.futuregeneral;

import com.selenium.pages.MainPage;
import com.selenium.util.ReusableFunctions;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConvertApplication {
    static Logger logger = Logger.getLogger(MainPage.class.getName());
    ReusableFunctions _reusableFunc = new ReusableFunctions();
    public static com.selenium.pages.futuregeneral.CreateBI _CreateBI;

    public final By PLVC = By.xpath("//label[text()='PLVC Without Voice']");
    public final By convert_to_app = By.xpath("//button[text()='GENERATE APPLICATION']");

    //main app
    public final By phy_kyc = By.xpath("//button[text()='Use Physical KYC']");
    public final By no_btn = By.xpath("//button[text()='No']");



    public final By healthDetails_btn = By.xpath("//h3[text()='Health Details']/ancestor::*[2]");
    public final By lifestyleDetails_btn = By.xpath("//h3[text()='Life Style Details']/ancestor::*[2]");
    public final By otherDetailsLA_btn = By.xpath("//h3[text()='Others details for Life assured']/ancestor::*[2]");
    public final By fatcaDetails_btn = By.xpath("//h3[text()='FATCA details']/ancestor::*[2]");
    public final By form60LA_btn = By.xpath("//h3[text()='Form 60 of Life assured']/ancestor::*[2]");


    public final By app_and_bi = By.xpath("//h2[contains(text(),'Application No.')]");




    public final By email = By.xpath("//input[@placeholder='Email Address']");
    public final By edu_qual = By.xpath("//input[@id='EducationQualification']//ancestor::*[1]/div");
    public final By curr_occ = By.xpath("//input[@id='combo-box-demo']//ancestor::*[2]/label[text()='Current Occupation']//ancestor::*[1]/div");
    public final By nature_duties = By.xpath("//input[@id='combo-box-demo']//ancestor::*[2]/label[text()='Nature Of Duties']//ancestor::*[1]/div");
    public final By work_env = By.xpath("//label[@for='134_false']");
    public final By emp_name = By.xpath("//input[@name='FirmOrEmployerName']");
    public final By designation = By.xpath("//input[@name='Designation']");
    public final By ckyc = By.xpath("//input[@placeholder='Ckyc Number']"); //14 digit
    public final By sub_details = By.xpath("//button[text()='SUBMIT DETAILS']");




    public final By close_modal = By.xpath("//span[@class='icon-close']");


    //comm details
    public final By comm_perma_same = By.xpath("//input[@id='IsPASameCA']");
    public final By add_line1 = By.xpath("//input[@placeholder='Address line 1']");
    public final By add_line2 = By.xpath("//input[@placeholder='Address line 2']");
    public final By pincode = By.xpath("//input[@placeholder='Pincode']");
    public final By sub_details_comm = By.xpath("//button[text()='SUBMIT DETAILS']");




    //fam details/father
    public final By title_fr = By.xpath("(//input[@placeholder='Title']/ancestor::*[1]/div)[1]");
    public final By name_father = By.xpath("(//input[@placeholder='First Name'])[1]");
    public final By lname_father = By.xpath("(//input[@placeholder='Last Name'])[1]");
    public final By vital_status_fr = By.xpath("(//label[text()='Deceased'])[1]");
    public final By cause_death_fr = By.xpath("(//input[@placeholder='Cause Of Death'])[1]");
    public final By ageofdeath_fr = By.xpath("(//input[@placeholder='Age At Death'])[1]");

    //fam details/mother
    public final By title_mo = By.xpath("(//input[@placeholder='Title']/ancestor::*[1]/div)[2]");
    public final By name_mother = By.xpath("(//input[@placeholder='First Name'])[2]");
    public final By lname_mother = By.xpath("(//input[@placeholder='Last Name'])[2]");
    public final By vital_status_mo = By.xpath("(//label[text()='Deceased'])[2]");
    public final By cause_death_mo = By.xpath("(//input[@placeholder='Cause Of Death'])[2]");
    public final By ageofdeath_mo = By.xpath("(//input[@placeholder='Age At Death'])[2]");

    public final By title_dd = By.xpath("//input[@name='Title_0']//ancestor::*[1]/div");
    public final By firstName_txt = By.xpath("//input[@placeholder='First Name']");
    public final By lastName_txt = By.xpath("//input[@placeholder='Last Name']");
    public final By relation_dd = By.xpath("//input[@placeholder='Relation']//ancestor::*[1]/div");
    public final By dob_txt = By.xpath("//input[@id='DOB_0']");
    public final By mobileNo_txt = By.xpath("//input[@placeholder='Mobile Number']");
    public final By nomineePercent_txt = By.xpath("//input[@placeholder='Nominee Percentage']");
    public final By bankAccNo_txt = By.xpath("//input[@placeholder='Bank Account Number']");
    public final By ifsc_txt = By.xpath("//input[@placeholder='IFSC']");
    public final By bankName_txt = By.xpath("//input[@placeholder='Bank Name']");
    public final By branch_txt = By.xpath("//input[@placeholder='Branch Location']");
    public final By confirmNominee_btn = By.xpath("//button[text()='CONFIRM NOMINEE']");
    public final By submitDetails_btn = By.xpath("//button[text()='SUBMIT DETAILS']");



    public final By nextButton = By.xpath("//button[text()='Next']");

    public final By height_txt = By.xpath("//input[@placeholder='Height (CM)']");
    public final By weight_txt = By.xpath("//input[@placeholder='Weight (KG)']");

    public final By weightGained_btn = By.xpath("//label[@for='3169_false']");
    public final By respiratoryDisease_btn = By.xpath("//label[@for='3177_false']");
    public final By digestiveDisease_btn = By.xpath("//label[@for='3184_false']");
    public final By boneDisorder_btn = By.xpath("//label[@for='3191_false']");
    public final By blood_btn = By.xpath("//label[@for='3198_false']");
    public final By heart_btn = By.xpath("//label[@for='3212_false']");
    public final By heredity_btn = By.xpath("//label[@for='3219_false']");
    public final By jaundice_btn = By.xpath("//label[@for='3226_false']");
    public final By diabetes_btn = By.xpath("//label[@for='3233_false']");
    public final By throatSkin_btn = By.xpath("//label[@for='3240_false']");
    public final By hypertension_btn = By.xpath("//label[@for='3247_false']");
    public final By hivAids_btn = By.xpath("//label[@for='3254_false']");
    public final By mental_btn = By.xpath("//label[@for='3261_false']");
    public final By disability_btn = By.xpath("//label[@for='3268_false']");
    public final By brain_btn = By.xpath("//label[@for='3275_false']");
    public final By thyroid_btn = By.xpath("//label[@for='3282_false']");
    public final By reproductive_btn = By.xpath("//label[@for='3289_false']");
    public final By last5YrsTreatment_btn = By.xpath("//label[@for='3296_false']");
    public final By cancerTumor_btn = By.xpath("//label[@for='3205_false']");
    public final By mammography_btn = By.xpath("//label[@for='3303_false']");
    public final By pregnancy_btn = By.xpath("//label[@for='3310_false']");
    public final By confirm_btn = By.xpath("//label[@for='confirm']");
    public final By covid = By.xpath("//label[@for='4991_false']");
    public final By tobacco = By.xpath("//label[@for='5000_No']");
    public final By alcohol = By.xpath("//label[@for='5009_false']");
    public final By narcotics = By.xpath("//label[@for='5017_No']");
    public final By hazard_hobby = By.xpath("//label[@for='5023_false']");
    public final By twowheeler = By.xpath("//span[text()='Two Wheeler']/ancestor::*[1]");
    public final By land = By.xpath("//span[text()='Land']/ancestor::*[1]");



    public final By meetLa = By.xpath("//label[@for='meetLaOrProposer_yes']");
    public final By sus = By.xpath("//label[@for='explainedSuitabilityPlan_yes']");
    public final By longyrs = By.xpath("//input[@name='howLongKnowYears']");
    public final By longmo = By.xpath("//input[@name='howLongKnowMonths']");
    public final By longday = By.xpath("//input[@name='howLongKnowDays']");
    public final By ifrelated = By.xpath("//label[@for='laOrProposerRealted_no']");
    public final By statedage = By.xpath("//label[@for='insuredOlderThanAppearsStatedAge_no']");
    public final By coostatus = By.xpath("//label[@for='anyRiskWithOccupation_no']");
    public final By incomeconf = By.xpath("//label[@for='confirmIncomeDetails_no']");
    public final By acrconf = By.xpath("//label[@for='confirmACR_yes']");
    public final By agentplace = By.xpath("//input[@name='agentPlace']");




    public final By accNo = By.xpath("//input[@placeholder='Account number']");
    public final By reEnterAcc = By.xpath("//input[@placeholder='Re-enter account number']");
    public final By ifsc = By.xpath("//input[@placeholder='IFSC']");
    public final By electronic = By.xpath("//label[@for='5253_false']");
    public final By chargeSheet = By.xpath("//label[@for='2310_false']");
    public final By politics = By.xpath("//label[@for='2314_false']");
    public final By phyCopy = By.xpath("//label[@for='5523_false']");
    public final By abc = By.xpath("//label[@for='2318_false']");


    //fatca
    public final By indJuri = By.xpath("//label[@for='1546_false']");


    //form 60
    public final By pan = By.xpath("//label[@for='1590_false']");
    public final By agriInc = By.xpath("//input[@placeholder='Agricultural income (Rs.)']");
    public final By otherInc = By.xpath("//input[@placeholder='Other than agricultural income (Rs.)']");
    public final By idDoc = By.xpath("//input[@id='IdentityDocument']/ancestor::*[4]");
    public final By idNo1 = By.xpath("(//input[@placeholder='Document identification number'])[1]");
    public final By docIssue1 = By.xpath("//input[@placeholder='Name Of Document Issuer']");
    public final By addDoc = By.xpath("//input[@id='SupportOfAddressDocument']/ancestor::*[4]");
    public final By idNo2 = By.xpath("(//input[@placeholder='Document identification number'])[2]");
    public final By docIssue2 = By.xpath("(//label[text()='Name Of Document Issuer']/following-sibling::*[1]/input)[position()=2]");



    public final By completeSign = By.xpath("//*[text()='Congratulation on completing application & payment']");
    public final By cont_sign = By.xpath("//button[text()='Continue']");




    public final By pd_summ = By.xpath("//h3[text()='Personal details']");
    public final By cd_summ = By.xpath("");
    public final By fd_summ = By.xpath("");
    public final By nd_summ = By.xpath("");
    public final By prd_summ = By.xpath("");
    public final By hd_summ = By.xpath("");
    public final By lsd_summ = By.xpath("");
    public final By odla_summ = By.xpath("");
    public final By fatca_summ = By.xpath("");
    public final By f60_summ = By.xpath("");
    public final By cis_summ = By.xpath("");
    public final By nx1 = By.xpath("(//button[text()='Next'])[position()=1]");
    public final By nx2 = By.xpath("(//button[text()='Next'])[position()=2]");
    public final By nx3 = By.xpath("(//button[text()='Next'])[position()=3]");
    public final By nx4 = By.xpath("(//button[text()='Next'])[position()=4]");
    public final By nx5 = By.xpath("(//button[text()='Next'])[position()=5]");
    public final By nx6 = By.xpath("(//button[text()='Next'])[position()=6]");
    public final By nx7 = By.xpath("(//button[text()='Next'])[position()=7]");
    public final By nx8 = By.xpath("(//button[text()='Next'])[position()=8]");
    public final By nx9 = By.xpath("(//button[text()='Next'])[position()=9]");
    public final By nx10 = By.xpath("(//button[text()='Next'])[position()=10]");
    public final By declareSumm = By.xpath("//label[@for='agreeConditions']");
    public final By place = By.xpath("//input[@placeholder='Place']");
    public final By yes_btn_summ = By.xpath("//button[text()='Yes']");


    public final By payment_button = By.xpath("//a[text()='Payment']");
    public final By payemnt_opt = By.xpath("//label[@for='cash']");
    public final By renewal_opt = By.xpath("//label[@for='CASH']");
    public final By payor_notedit = By.xpath("//label[@for='payor']");



    //document upload screen
    public final By cash_auth = By.xpath("(//label[text()='Cash Authorization Letter']//following-sibling::*[1]//div)[2]");
    public final By full_pic = By.xpath("(//label[text()='Full Photo']//following-sibling::*[1]//div)[2]");
    public final By age_proof_dd = By.xpath("(//input[@placeholder='Select']/ancestor::*[1]/div)[1]");
    public final By age_proof = By.xpath("(//label[text()='Age Proof']//following-sibling::*[1]//div)[7]");
    public final By add_proof_dd = By.xpath("(//input[@placeholder='Select']/ancestor::*[1]/div)[2]");
    public final By add_proof = By.xpath("(//label[text()='Address Proof']//following-sibling::*[1]//div)[7]");
    public final By id_proof_dd = By.xpath("(//input[@placeholder='Select']/ancestor::*[1]/div)[3]");
    public final By id_proof = By.xpath("(//label[text()='Identity Proof']//following-sibling::*[1]//div)[7]");
    public final By bank_proof = By.xpath("(//label[text()='Bank Proof Document']//following-sibling::*[1]//div)[2]");





    public boolean convertApp(WebDriver driver){
        boolean flag = true;

        try{

            logger.info("Trying to convert to application:");

            _reusableFunc.waitForElementPresent(driver, convert_to_app);
            _reusableFunc.click(driver,PLVC);
            _reusableFunc.click(driver,convert_to_app);

        }
        catch (Exception e){

            logger.error("Error while converting to app:"+e.getMessage());
            flag = false;
        }

        return flag;
    }



    public boolean clickpyKyc(WebDriver driver){
        boolean flag = true;
        try{
            logger.info("Selecting physical kyc");

            _reusableFunc.waitForElementPresent(driver, phy_kyc);
            String APP_BI = _reusableFunc.getTextByInnerText(driver,app_and_bi);
            String[] parts = APP_BI.split("\\|");

            String appNo = parts[0].split("Application No\\.")[1].trim();
            String biNo = parts[1].split("BI No\\.")[1].trim();
            System.out.println(appNo+" "+ biNo);

            _reusableFunc.click(driver,phy_kyc);
            _reusableFunc.click(driver,no_btn);

        } catch (Exception e) {

            logger.error("error while physical kyc"+e.getMessage());
            flag = false;
        }
        return flag;
    }



    public boolean personalDet(WebDriver driver, String mail, String edqual, String currocc, String dutynature, String nameemp, String desig, String ckyc_)
    {
        boolean flag = true;
        try{
            logger.info("Trying operation on main page");

            _reusableFunc.waitForElementPresent(driver,email);

            _reusableFunc.enterText(driver,email,mail);
            _reusableFunc.dropdown_selectbyvisibletext(driver,edu_qual,edqual);
            _reusableFunc.dropdown_selectbyvisibletext(driver,curr_occ,currocc);
            _reusableFunc.dropdown_selectbyvisibletext(driver, nature_duties,dutynature);
            _reusableFunc.click(driver,work_env);
            _reusableFunc.enterText(driver,emp_name,nameemp);
            _reusableFunc.enterText(driver,designation, desig);
            _reusableFunc.enterText(driver,ckyc,ckyc_);
            _reusableFunc.click(driver, sub_details);
        } catch (Exception e) {
            logger.error("Exception occured in main app page:"+e.getMessage());
            flag = false;
        }
        return flag;
    }




    public boolean commDetails(WebDriver driver, String address1, String address2, String pinC){
        boolean flag = true;
        try{
            logger.info("Entering communication details:");

            _reusableFunc.waitForElementPresent(driver,close_modal);

            _reusableFunc.click(driver,close_modal);
            _reusableFunc.click(driver,comm_perma_same);
            _reusableFunc.enterText(driver,add_line1, address1);
            _reusableFunc.enterText(driver,add_line2, address2);
            _reusableFunc.enterText(driver,pincode,pinC);
            Thread.sleep(1000);
            _reusableFunc.click(driver,sub_details);
        }
        catch (Exception e){
            logger.error("error entering comm details");
            flag = false;

        }
        return flag;
    }




    public boolean famDetails(WebDriver driver, String fr_title, String fr_name, String fr_lanme, String fr_dtcause, String fr_dtage, String mo_title, String mo_name, String mo_lanme, String mo_dtcause, String mo_dtage)
    {
        boolean flag = true;
        try{
            logger.info("Entering family details");

            _reusableFunc.waitForElementPresent(driver,title_fr);

            _reusableFunc.dropdown_selectbyvisibletext(driver,title_fr,fr_title);
            _reusableFunc.enterText(driver, name_father, fr_name);
            _reusableFunc.enterText(driver,lname_father,fr_lanme);
            _reusableFunc.click(driver,vital_status_fr);
            _reusableFunc.enterText(driver,cause_death_fr, fr_dtcause);
            _reusableFunc.enterText(driver,ageofdeath_fr, fr_dtage);

            _reusableFunc.dropdown_selectbyvisibletext(driver,title_mo, mo_title);
            _reusableFunc.enterText(driver, name_mother, mo_name);
            _reusableFunc.enterText(driver,lname_mother,mo_lanme);
            _reusableFunc.click(driver,vital_status_mo);
            _reusableFunc.enterText(driver,cause_death_mo, mo_dtcause);
            _reusableFunc.enterText(driver,ageofdeath_mo, mo_dtage);

            _reusableFunc.click(driver,sub_details);

            _reusableFunc.click(driver, sub_details);
        }
        catch (Exception e){
            logger.error("Unexpected error occured when entering family details:"+e.getMessage());
            flag = false;
        }
        return flag;
    }



    public boolean addNominee(WebDriver driver, String titleValue, String firstNameValue, String lastNameValue, String relationValue, String dobValue, String mobileNoValue, String nomineePercentValue, String bankAccNoValue, String ifscValue, String bankNameValue, String branchValue)
    {
        boolean flag = true;
        try {
            logger.info("Trying to add nominee:");

            _reusableFunc.waitForElementPresent(driver,title_dd);

            _reusableFunc.dropdown_selectbyvisibletext(driver, title_dd, titleValue);
            _reusableFunc.enterText(driver, firstName_txt, firstNameValue);
            _reusableFunc.enterText(driver, lastName_txt, lastNameValue);
            _reusableFunc.dropdown_selectbyvisibletext(driver, relation_dd, relationValue);
            _reusableFunc.enterText(driver, dob_txt, dobValue);
            _reusableFunc.enterText(driver, mobileNo_txt, mobileNoValue);
            _reusableFunc.enterText(driver, nomineePercent_txt, nomineePercentValue);
            _reusableFunc.enterText(driver, bankAccNo_txt, bankAccNoValue);
            _reusableFunc.enterText(driver, ifsc_txt, ifscValue);
            _reusableFunc.enterText(driver, bankName_txt, bankNameValue);
            _reusableFunc.enterText(driver, branch_txt, branchValue);

            _reusableFunc.click(driver, confirmNominee_btn);
            _reusableFunc.click(driver, submitDetails_btn);

        } catch (Exception e) {
            logger.error("Exception in adding nominee:"+e.getMessage());
            flag=false;
        }
        return flag;
    }






    public boolean healthDetails(WebDriver driver, String height, String weight) {
        boolean flag = true;
        try {
            logger.info("adding health details");

            _reusableFunc.waitForElementPresent(driver,healthDetails_btn);

            _reusableFunc.click(driver,healthDetails_btn);

            _reusableFunc.enterText(driver, height_txt, height);
            _reusableFunc.enterText(driver, weight_txt, weight);

            _reusableFunc.click(driver, weightGained_btn);
            _reusableFunc.click(driver, respiratoryDisease_btn);
            _reusableFunc.click(driver, digestiveDisease_btn);
            _reusableFunc.click(driver, boneDisorder_btn);
            _reusableFunc.click(driver, blood_btn);
            _reusableFunc.click(driver, heart_btn);
            _reusableFunc.click(driver, heredity_btn);
            _reusableFunc.click(driver, jaundice_btn);
            _reusableFunc.click(driver, diabetes_btn);
            _reusableFunc.click(driver, throatSkin_btn);
            _reusableFunc.click(driver, hypertension_btn);
            _reusableFunc.click(driver, hivAids_btn);
            _reusableFunc.click(driver, mental_btn);
            _reusableFunc.click(driver, disability_btn);
            _reusableFunc.click(driver, brain_btn);
            _reusableFunc.click(driver, thyroid_btn);
            _reusableFunc.click(driver, reproductive_btn);
            _reusableFunc.click(driver, last5YrsTreatment_btn);
            _reusableFunc.click(driver, cancerTumor_btn);
//            _reusableFunc.click(driver, mammography_btn);
//            _reusableFunc.click(driver, pregnancy_btn);
            _reusableFunc.scrollIntoView(driver,confirm_btn);
            _reusableFunc.click(driver,confirm_btn);
            _reusableFunc.click(driver,sub_details);

        } catch (Exception e) {
            logger.error("error while adding details:"+e.getMessage());
            flag = false;
        }
        return flag;
    }

    public boolean lifestyleDetails(WebDriver driver){
        boolean flag = true;
        try{
            logger.info("trying to enter lifestyle details");
            _reusableFunc.waitForElementClickable(driver,lifestyleDetails_btn);

            _reusableFunc.click(driver,lifestyleDetails_btn);
            _reusableFunc.click(driver,covid);
            _reusableFunc.click(driver,tobacco);
            _reusableFunc.click(driver,alcohol);
            _reusableFunc.click(driver,narcotics);
            _reusableFunc.click(driver,hazard_hobby);
            _reusableFunc.click(driver,twowheeler);
            _reusableFunc.click(driver,land);
            _reusableFunc.click(driver,confirm_btn);
            _reusableFunc.click(driver,sub_details);


        } catch (Exception e) {
            logger.error("error while entering lifestyle details");
            flag = false;
        }
        return flag;
    }



    public boolean laDetails(WebDriver driver, String accLA, String ifscLA){
        boolean flag = true;
        try{
            logger.info("trying to enter la details");
            _reusableFunc.waitForElementPresent(driver,otherDetailsLA_btn);

            _reusableFunc.click(driver,otherDetailsLA_btn);
            _reusableFunc.enterText(driver,accNo,accLA);
            _reusableFunc.enterText(driver,reEnterAcc,accLA);
            _reusableFunc.enterText(driver,ifsc,ifscLA);
            Thread.sleep(1000);
            _reusableFunc.click(driver,electronic);
            _reusableFunc.click(driver,chargeSheet);
            _reusableFunc.click(driver,politics);
            _reusableFunc.click(driver,phyCopy);
            _reusableFunc.click(driver,abc);
            _reusableFunc.click(driver,submitDetails_btn);
            _reusableFunc.waitForElementPresent(driver,close_modal);
            _reusableFunc.click(driver,close_modal);


        } catch (Exception e) {
            logger.error("error while entering la details");
            flag = false;
        }
        return flag;
    }






    public boolean FATCA(WebDriver driver){
        boolean flag = true;
        try{

            logger.info("Entering fatca details");
            _reusableFunc.waitForElementPresent(driver,fatcaDetails_btn);
            _reusableFunc.click(driver,fatcaDetails_btn);
            _reusableFunc.click(driver,indJuri);
            _reusableFunc.click(driver,submitDetails_btn);
        } catch (Exception e) {
            logger.error("error while fatca details");
            flag = false;
        }
        return flag;
    }







    public boolean form60(WebDriver driver, String agriinc, String otherinc, String iddoc, String idno1, String docissue1, String adddoc, String idno2, String docissue2){
        boolean flag = true;
        try{
            logger.info("Entering form 60 details");
            _reusableFunc.waitForElementPresent(driver,form60LA_btn);
            _reusableFunc.click(driver,form60LA_btn);
            _reusableFunc.click(driver,pan);
            _reusableFunc.waitForElementPresent(driver,agriInc);
            _reusableFunc.enterText(driver,agriInc,agriinc);
            _reusableFunc.enterText(driver,otherInc,otherinc);
            _reusableFunc.dropdown_selectbyvisibletext(driver,idDoc,iddoc);
            _reusableFunc.click(driver,idNo1);
            _reusableFunc.enterText(driver,idNo1,idno1);
            _reusableFunc.enterText(driver,docIssue1,docissue1);
            _reusableFunc.dropdown_selectbyvisibletext(driver,addDoc,adddoc);
            _reusableFunc.click(driver,idNo2);
            _reusableFunc.enterText(driver,idNo2,idno2);
            _reusableFunc.enterText(driver,docIssue2,docissue2);
            _reusableFunc.click(driver,submitDetails_btn);

            _reusableFunc.waitForElementPresent(driver, submitDetails_btn);
            _reusableFunc.click(driver,submitDetails_btn);

        } catch (Exception e) {
            logger.error("Error in form 60");
            flag = false;
        }
        return flag;
    }





    public boolean subSummary(WebDriver driver, String placeSumm){
        boolean flag = true;
        try{
            logger.info("Trying to enter summary");
            _reusableFunc.waitForElementPresent(driver,pd_summ);
            _reusableFunc.click(driver,pd_summ);
            _reusableFunc.click(driver,nx1);
//            _reusableFunc.click(driver,cd_summ);
            _reusableFunc.click(driver,nx2);
//            _reusableFunc.click(driver,fd_summ);
            _reusableFunc.click(driver,nx3);
//            _reusableFunc.click(driver,nd_summ);
            _reusableFunc.click(driver,nx4);
//            _reusableFunc.click(driver,prd_summ);
            _reusableFunc.click(driver,nx5);
//            _reusableFunc.click(driver,hd_summ);
            _reusableFunc.click(driver,nx6);
//            _reusableFunc.click(driver,lsd_summ);
            _reusableFunc.click(driver,nx7);
//            _reusableFunc.click(driver,odla_summ);
            _reusableFunc.click(driver,nx8);
//            _reusableFunc.click(driver,fatca_summ);
            _reusableFunc.click(driver,nx9);
//            _reusableFunc.click(driver,f60_summ);
            _reusableFunc.click(driver,nx10);
            _reusableFunc.scrollIntoView(driver,submitDetails_btn);
            _reusableFunc.click(driver,submitDetails_btn);

            _reusableFunc.waitForElementPresent(driver,declareSumm);
            _reusableFunc.click(driver,declareSumm);
            _reusableFunc.waitForElementPresent(driver,yes_btn_summ);
            _reusableFunc.click(driver,yes_btn_summ);
            _reusableFunc.enterText(driver,place,placeSumm);
            _reusableFunc.click(driver,submitDetails_btn);
        } catch (Exception e) {
            logger.error("Unable to enter summary");
            flag = false;
        }
        return flag;
    }




    public final By otp1 = By.xpath("//input[@aria-label='Please enter OTP character 1']");
    public final By continue_otp = By.xpath("//button[text()='CONTINUE']");

    public boolean otpLA(WebDriver driver){
        boolean flag = true;
        try{
            logger.info("Trying to enter otp");


            _reusableFunc.openAndSwitchToNewTab("https://www.microsoft.com/en-us/microsoft-365/outlook/log-in");
            _reusableFunc.waitForElementPresent(driver,By.linkText("Sign in"));
            _reusableFunc.click(driver,By.linkText("Sign in"));
            _reusableFunc.enterText(driver,By.id("i0116"),"ankushkumar.singh@planittesting.com");
            _reusableFunc.click(driver,By.id("idSIButton9"));
            _reusableFunc.enterText(driver,By.id("i0118"),"Automation#1");
            _reusableFunc.click(driver,By.id("idSIButton9"));
            _reusableFunc.click(driver,By.id("idBtn_Back"));
            if(_reusableFunc.waitForElementPresent(driver,By.xpath("(//div[@class='S2NDX']/div/div)[1]"))){
                String nameemail = _reusableFunc.getTextByInnerText(driver,By.xpath("(//div[@class='S2NDX']/div/div)[1]"));
                if (nameemail.equalsIgnoreCase("future generali")){
                    _reusableFunc.click(driver,By.xpath("(//div[@class='S2NDX']/div/div)[1]"));
                }
            }
            String rawotp = _reusableFunc.getTextByInnerText(driver,By.xpath("(//div[@class='Zgp3k'])[1]"));
            String finalotp = _reusableFunc.OTPExtract(rawotp);
            System.out.println(finalotp);
            _reusableFunc.switchToFirstTab();



            _reusableFunc.waitForElementPresent(driver,otp1);
            _reusableFunc.click(driver,otp1);
            _reusableFunc.enterText(driver,otp1,finalotp);

            _reusableFunc.click(driver,continue_otp);

        } catch (Exception e) {
            logger.error("error entering otp");
            flag=false;
        }
        return flag;
    }



    public boolean payment(WebDriver driver){
        boolean flag = true;
        try{
            logger.info("Trying to enter payment details");
//            _reusableFunc.waitForElementPresent(driver,payment_button);
//            _reusableFunc.click(driver,payment_button);
            _reusableFunc.waitForElementPresent(driver,payemnt_opt);
            _reusableFunc.click(driver,payemnt_opt);
            _reusableFunc.click(driver, renewal_opt);
            _reusableFunc.click(driver, payor_notedit);
            _reusableFunc.click(driver,submitDetails_btn);
        } catch (Exception e) {
            logger.error("Error entering payment details");
            flag = false;
        }
        return flag;
    }



    public boolean paymentComplete(WebDriver driver){
        boolean flag = true;
        try {

            logger.info("checking if payment done");
//            if(!_reusableFunc.waitForElementPresent(driver,completeSign)){
//                flag = false;
//            }
            _reusableFunc.click(driver,cont_sign);

        } catch (Exception e) {
            logger.error("payment validation error");
            flag = false;
        }
        return flag;
    }


    public boolean uploadDoc(WebDriver driver){
        boolean flag = true;
        try{
            logger.info("Trying to upload docs");

            _reusableFunc.waitForElementPresent(driver,cash_auth);
            _reusableFunc.click(driver,cash_auth);
            Thread.sleep(2000);
            _reusableFunc.runAutoIT();
            Thread.sleep(5000);
            _reusableFunc.click(driver,close_modal);

            _reusableFunc.click(driver,full_pic);
            Thread.sleep(2000);
            _reusableFunc.runAutoIT();
            Thread.sleep(5000);
            _reusableFunc.click(driver,close_modal);

            _reusableFunc.dropdown_selectbyvisibletext(driver,age_proof_dd,"Passport");

            _reusableFunc.click(driver,age_proof);
            Thread.sleep(2000);
            _reusableFunc.runAutoIT();
            Thread.sleep(5000);
            _reusableFunc.click(driver,close_modal);

            _reusableFunc.dropdown_selectbyvisibletext(driver,add_proof_dd,"Passport");

            _reusableFunc.click(driver,add_proof);
            Thread.sleep(2000);
            _reusableFunc.runAutoIT();
            Thread.sleep(5000);
            _reusableFunc.click(driver,close_modal);

            _reusableFunc.dropdown_selectbyvisibletext(driver,id_proof_dd,"Passport");

            _reusableFunc.click(driver,id_proof);
            Thread.sleep(2000);
            _reusableFunc.runAutoIT();
            Thread.sleep(5000);
            _reusableFunc.click(driver,close_modal);

            _reusableFunc.click(driver,bank_proof);
            Thread.sleep(2000);
            _reusableFunc.runAutoIT();
            Thread.sleep(5000);
            _reusableFunc.click(driver,close_modal);

            _reusableFunc.click(driver,submitDetails_btn);

        } catch (Exception e) {
            logger.error("cannot upload");
            flag = false;
        }
        return flag;
    }

    public boolean scrSubmit(WebDriver driver){
        boolean flag = true;
        try {
            logger.info("trying to submit scr");

            _reusableFunc.waitForElementPresent(driver, meetLa);

            _reusableFunc.click(driver,meetLa);
            _reusableFunc.click(driver,sus);
            _reusableFunc.enterText(driver,longyrs,"1");
            _reusableFunc.enterText(driver,longmo,"1");
            _reusableFunc.enterText(driver,longday,"1");
            _reusableFunc.click(driver,ifrelated);
            _reusableFunc.click(driver,statedage);
            _reusableFunc.click(driver,coostatus);
            _reusableFunc.click(driver,incomeconf);
            _reusableFunc.click(driver,acrconf);
            _reusableFunc.enterText(driver,agentplace,"Mumbai");

            _reusableFunc.click(driver,submitDetails_btn);
        } catch (Exception e) {
            logger.error("cannot submit "+e);
        }
        return flag;
    }
}
