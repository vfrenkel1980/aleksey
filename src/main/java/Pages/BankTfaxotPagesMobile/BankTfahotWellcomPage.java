package Pages.BankTfaxotPagesMobile;

import Pages.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.List;

public class BankTfahotWellcomPage  extends BasePage {
    public BankTfahotWellcomPage(WebDriver driver, Logger log) {
        super(driver, log);
    }



    @AndroidFindBy(className = "android.widget.EditText")
    private List<MobileElement> logins;

    @AndroidFindBy(className = "android.widget.Button")
    private List<MobileElement> loginsButtons;


    @AndroidFindBy(uiAutomator = "new UiSelector().textMatches(\"הודעת שגיאה\")")
    public AndroidElement errorMessage;


//    ffbe3ed4-c07c-44da-9fda-56ff4cc63488

//    @AndroidFindBy (xpath= "//android.widget.ImageButton[@content-desc="Back"]")
//    public AndroidElement loginButton;

   // how=How.XPATH,using=("//android.widget.Button[contains(text(),‘כניסה לחש’)



//    @AndroidFindBy(xpath= "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[4]/android.widget.Button")
//    public AndroidElement loginButton;

///hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[4]/android.widget.Button





    public void type_user_ID(String id) {
        log.info(" type user id: "+ id);
        Assert.assertTrue(mytype(logins.get(0),id));
    }
    public void type_user_pass(String pass){
        log.info(" type user pass: "+ pass);
        Assert.assertTrue(mytype(logins.get(1),pass));
    }


    public String getTitleOfCurrentPage() {
        return text(loginsButtons.get(4));

    }


    public String getErrorMessage() {
        return text(errorMessage);

    }



    public OverVeshavPage clickOnLoginButton(){
        log.info(" clciking on login button");
        Assert.assertTrue(click(loginsButtons.get(4)));
        return  new OverVeshavPage(driver,log);
    }




}
