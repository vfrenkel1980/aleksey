package Pages.BankTfaxotPagesMobile;

import Pages.BasePage;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class OverVeshavPage extends BasePage {


    public OverVeshavPage(WebDriver driver, Logger log) {
        super(driver,log);
    }


    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"יתרה\")")
    public AndroidElement afterLoginText;


    public String getTitleAfterLogin() {


        return text(afterLoginText);

    }



}
