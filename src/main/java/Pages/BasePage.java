package Pages;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static java.time.Duration.ofSeconds;

public class BasePage {


    protected WebDriver driver;
    protected Logger log;


    public BasePage(WebDriver driver ,Logger log) {
        this.driver = BaseTest.getDriver();
        this.log = log;
        PageFactory.initElements(new AppiumFieldDecorator(driver, ofSeconds(10)),this);

      }

    protected void waitFor(ExpectedCondition<WebElement> condition, Integer timeOutInSeconds) {
        timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : 10;
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);

        wait.until(condition);
    }





    protected void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected boolean click(WebElement el) {
        if (el == null)
            return false;
        for (int i = 0; i < 2; i++) { // 2 tries to make tap
            try {
                waitFor(ExpectedConditions.elementToBeClickable(el),10);
                waitFor(ExpectedConditions.elementToBeClickable(el),10);
                el.click();
                sleep(200);
                return true;
            } catch (Exception e) {
                log.error("click(): FAILED\n" + e.getMessage());
               // TestUtilities.takeScreenshot("taking screenshot of unclickable element");
            }
            System.out.println("click(): RETRY '" + i + "' ----------------");
        }
        return false;
    }


    protected boolean  longPress(WebElement el) {
        if (el == null)
            return false;
        try {
            TouchAction action = new TouchAction((PerformsTouchActions) driver);

            action.longPress(new LongPressOptions().withElement(new
                    ElementOption().withElement(el))).perform();
            return true;
        }
        catch (Exception e)
        {
            log.error("longpress (): FAILED\n" + e.getMessage());


        }
        return false;

    }



    protected boolean mytype(WebElement el, String text) {
        if (el == null)
            return false;
        try {
            el.sendKeys(text);
            sleep(1000);
            return true;
        } catch (Exception e) {
            log.error("type(): FAILED\n" + e.getMessage());
        }
        return false;
    }


    protected void  type (WebElement el,String text){
       // waitForVisibilityOf(el,5);

        el.sendKeys(text);

    }

    protected void  cleanAntType (WebElement el,String text){
        el.clear();
        el.sendKeys(text);
    }


    protected void waitForVisibilityOf(WebElement element, Integer... timeOutInSeconds) {
        int attempts = 0;

        while(attempts < 2) {
            try {
                this.waitFor(ExpectedConditions.visibilityOfElementLocated((By) element), timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : null);
                break;
            } catch (StaleElementReferenceException var5) {
                ++attempts;
            }
        }

    }



    protected String text(WebElement el) {
        String a=null;
        int count = 0;
        boolean succesed = false;
        while (count < 2 && !succesed)
            try {
                a=el.getText();
                succesed = true;
                sleep(200);
            } catch (StaleElementReferenceException e) {
                e.toString();
                System.out.println("Trying to recover from a stale element :" + e.getMessage());
                count = count + 1;
            }
        return a;
    }

    protected boolean getTextElement(WebElement el) {
        if (el == null)
            return false;

        for (int i = 0; i < 2; i++) { // 2 tries to make tap
            try {
                el.getText();
                return true;
            } catch (Exception e) {
               // System.out.println("click(): FAILED\n" + e.getMessage());
                log.info("click(): FAILED\n" + e.getMessage());
            }
           // System.out.println("click(): RETRY '" + i + "' ----------------");
            log.info("click(): RETRY '" + i + "' ----------------");
        }
        return false;
    }


    protected void openUrl(String url)
    {
        driver.get(url);
    }




    protected WebElement find (By locator)
    {
        return driver.findElement( locator);
    }

    protected List <WebElement>  findAll(By locator) {
        return driver.findElements(locator);
    }



//    protected Alert ddd()
//    {
//
//        WebDriverWait wait = new WebDriverWait(driver, 5);
//        wait.until(ExpectedCondition.alertIsPresent());
//        return new driver.switchTo().alert();
//
//    }


//    protected void   scrollToElement(By locator) {
//        return driver.findElements(locator);
//    }



    protected void  switchToIframe (WebElement el) {
        //driver.switchTo().frame(driver.findElement(By.name("iFrameTitle")));
        log.info("swich to frame :"+" "+ el);
        driver.switchTo().frame(el);

    }

//
//    protected JSONObject getDataFile(String dataFileName) {
//        String dataFilePath = "src/test/resources/";
//        JSONObject testObject = null;
//
//        try {
//            FileReader reader = new FileReader(dataFilePath + dataFileName);
//            JSONParser jsonParser = new JSONParser();
//            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
//            testObject = (JSONObject) jsonObject;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return testObject;
//    }








}
