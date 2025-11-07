package com.selenium.util;

import org.apache.commons.io.FileUtils;
import com.selenium.base.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReusableFunctions extends TestBase {

    static Logger logger = Logger.getLogger(ReusableFunctions.class.getName());

    private int timeout;

    public int timeoutValue() {
        try {
            timeout = Integer.parseInt(prop.getProperty("Timeout"));
        } catch (Exception Ex) {
            logger.error("Exception Occurred While Getting Timeout Property.");
        }
        return timeout;
    }

    public boolean waitForElementPresent(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutValue());
        boolean flag = true;
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception Ex) {
            flag = false;
            logger.error("Exception Occurred While Locating The Element: " + Ex.getMessage());
        }
        return flag;
    }

    public boolean waitForElementPresent(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutValue());
        boolean flag = true;
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception Ex) {
            flag = false;
            logger.error("Exception Occurred While Locating The Element: " + Ex.getMessage());
        }
        return flag;
    }

    public boolean verifyElementsLocated(WebDriver driver, ArrayList<By> arrayList) {
        boolean flag = true;
        try {
            for (By locator : arrayList) {
                WebElement element = driver.findElement(locator);
                if (waitForElementPresent(driver, element)) {
                    logger.info(element.toString() + ": element is displayed.");
                } else {
                    logger.error(element.toString() + ": element isn't displayed.");
                    flag = false;
                }
            }
        } catch (Exception Ex) {
            logger.error("Exception Occurred While Locating The Elements: " + Ex.getMessage());
        }
        return flag;
    }

    public boolean waitForElementClickable(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutValue());
        boolean flag = true;
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator));
        } catch (Exception Ex) {
            flag = false;
            logger.error("Exception Occurred While Locating The Element: " + Ex.getMessage());
        }
        return flag;
    }

    public void enterText(WebDriver driver, By locator, String value) {
        try {
            if (waitForElementClickable(driver, locator)) {
                WebElement element = driver.findElement(locator);
                element.sendKeys(value);
            }
        } catch (Exception Ex) {
            logger.error("Exception Occurred While Entering The Text: " + Ex.getMessage());
        }

    }

    public void click(WebDriver driver, By locator) {
        try {
            if (waitForElementClickable(driver, locator)) {
                WebElement element = driver.findElement(locator);
                element.click();
            }
        } catch (Exception Ex) {
            logger.error("Exception Occurred While Clicking The Element: " + Ex.getMessage());
        }

    }

    public String getTextByAttributeValue(WebDriver driver, By locator) {
        String text = null;
        try {
            if (waitForElementClickable(driver, locator)) {
                WebElement element = driver.findElement(locator);
                text = element.getAttribute("value");
            }
        } catch (Exception Ex) {
            logger.error("Exception Occurred While Getting The Text: " + Ex.getMessage());
        }
        return text;
    }

    public String getTextByInnerText(WebDriver driver, By locator) {
        String text = null;
        try {
            if (waitForElementClickable(driver, locator)) {
                WebElement element = driver.findElement(locator);
                text = element.getText();
            }
        } catch (Exception Ex) {
            logger.error("Exception Occurred While Getting The Text: " + Ex.getMessage());
        }
        return text;
    }

    public static String takeScreenShot(WebDriver driver, String screenshotName) {
        String destination = null;
        try {
            String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);

            destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
            File finalDestination = new File(destination);
            FileUtils.copyFile(source, finalDestination);

            destination = finalDestination.getAbsolutePath();
            logger.info("Saving screenshot to failed repo: " + destination);

        } catch (Exception Ex) {
            logger.error("Exception Occurred While Getting The Text: " + Ex.getMessage());
        }
        return destination;
    }


    public static boolean verifyTextMatch(WebDriver driver, String actualText, String expectedText) {
        boolean flag = false;
        try {
            logger.info("Actual Text From Application Web UI --> :: " + actualText);
            logger.info("Expected Text From Application Web UI --> :: " + expectedText);

            if (actualText.equals(expectedText)) {
                logger.info("### VERIFICATION TEXT MATCHED !!!");
                flag = true;
            } else {
                logger.error("### VERIFICATION TEXT DOES NOT MATCHED !!!");
            }

        } catch (Exception Ex) {
            logger.error("Exception Occurred While Verifying The Text Match: " + Ex.getMessage());
        }
        return flag;
    }

//    public void dropdown_selectbyvisibletext(WebDriver driver, By locator, String text) {
//        try {
//            if (waitForElementPresent(driver, locator)) {
//                WebElement el = driver.findElement(locator);
//                Select select = new Select(el);
//                select.selectByVisibleText(text);
//            }
//        } catch (Exception e) {
//        }
//    }

    public void dropdown_selectbyvisibletext(WebDriver driver, By locator, String text){
        try{
            JavascriptExecutor js = (JavascriptExecutor) driver;
            Thread.sleep(500);
            waitForElementPresent(driver, locator);
            WebElement wel = driver.findElement(locator);
            js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", wel);
            wel.click();
            Thread.sleep(500);
            WebElement opt = driver.findElement(By.xpath("//li[text()='"+text+"']"));
            js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", opt);
            opt.click();
        }
        catch(Exception ex){
            logger.error("Exception Occurred While Selecting The Dropdown: " + ex.getMessage());
        }
    }
    public void scrollIntoView(WebDriver driver, By locator) {
        try {
            WebElement element = driver.findElement(locator);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
        } catch (Exception e) {
            System.out.println("Error while scrolling: " + e.getMessage());
        }
    }



    public void switchToTab(int tabIndex) {
        Set<String> windowHandles = driver.getWindowHandles();

        if (tabIndex < 0 || tabIndex >= windowHandles.size()) {
            throw new IllegalArgumentException("Invalid tab index: " + tabIndex);
        }

        String[] handles = windowHandles.toArray(new String[0]);
        driver.switchTo().window(handles[tabIndex]);
    }

    public void switchToLastTab() {
        Set<String> windowHandles = driver.getWindowHandles();
        String lastHandle = windowHandles.toArray(new String[0])[windowHandles.size() - 1];
        driver.switchTo().window(lastHandle);
    }

    public void switchToFirstTab() {
        Set<String> windowHandles = driver.getWindowHandles();
        String firstHandle = windowHandles.toArray(new String[0])[0];
        driver.switchTo().window(firstHandle);
    }

    public void openNewTab(String url) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.open('" + url + "', '_blank');");
    }

    public void openAndSwitchToNewTab(String url) {

        // Open a new tab
        openNewTab(url);

        // Switch to the new tab (most recent one)
        switchToLastTab();

        // Navigate to a new page within the new tab
        driver.get(url); // This will start the page navigation on the new tab

        // Wait for the new page to finish loading (you can adjust the condition here if needed)
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlToBe(url)); // Wait until the URL of the new tab matches the one we just loaded

    }


    public void closeCurrentTab() {
        driver.close();
        // After closing the tab, you can switch to the last tab
        switchToLastTab();
    }

    public String getCurrentTabTitle() {
        return driver.getTitle();
    }


    public void keyPress(WebDriver driver,By locator, String key){
        WebElement inputField = driver.findElement(locator);

        Actions actions = new Actions(driver);
        actions.moveToElement(inputField).click().sendKeys(key).perform();
    }

    public void keyPress(WebDriver driver, String key) throws InterruptedException {

        Actions actions = new Actions(driver);
        actions.click().sendKeys(key).perform();
        Thread.sleep(500);
    }


    public void robot_fileUpload(String filePath) throws Exception {
        Thread.sleep(1000);
        Robot robot = new Robot();
        for (char ch : filePath.toCharArray()) {
            robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(ch));
            robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(ch));
        }
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(5000);
    }


        public String OTPExtract(String text) {

        String otp="";
            // Regex to match 6 digits
            String regex = "\\b\\d{6}\\b";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);

            // Find and print the 6-digit OTP
            if (matcher.find()) {
                otp = matcher.group();
                System.out.println("Extracted OTP: " + otp);
            } else {
                System.out.println("No OTP found in the text.");
            }
            return otp;
        }

        public void runAutoIT(){
            try {
                Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\upload.exe");
            } catch (IOException e) {
                logger.error("Cannot upload");
            }
        }

        public void scroll5times(WebDriver driver){
        try{
            JavascriptExecutor js = (JavascriptExecutor) driver;

            for(int i = 1; i <= 5 ; i++){
                js.executeScript("window.scrollBy(0,500);");
                Thread.sleep(2000);
            }
        }
        catch (Exception e){
            logger.error("Cannot scroll 5 times");
        }
        }





        // linkedin scraper
        public List<String> scrapeData50posts(WebDriver driver){

        List<String> outerHTMLList = new ArrayList<>();

        try{
            JavascriptExecutor js = (JavascriptExecutor) driver;
            for(int i = 1 ; i<=50 ; i++){
                WebElement element = driver.findElement(By.xpath("((//div[@class='fie-impression-container'])//span[contains(@class,'break')])"+"["+i+"]"));
                String outerHTMLText = (String) js.executeScript("return arguments[0].outerHTML;", element);
                System.out.println(outerHTMLText);
                outerHTMLList.add(outerHTMLText);
            }
        }
        catch (Exception e){
            logger.error("Cannot scrape "+e);
        }
        return outerHTMLList;

        //List<String> posts = scrapeData50posts(driver);
        }

    }


