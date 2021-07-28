package Pages.BankTfaxotPagesSite;

import Pages.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class BankTfahotWellcomPageSite  extends BasePage {
    public BankTfahotWellcomPageSite(WebDriver driver, Logger log) {
        super(driver, log);
    }



    @FindBy(xpath = "//span[contains(text(),'כניסה לחשבון')]")
    private WebElement loginsButtons;

    @FindBy(name  = "username_he")
    private WebElement loginsUser;


    @FindBy(name  = "password_he")
    private WebElement loginsPassword;

    @FindBy(id ="iframeLogIn")
    private WebElement loginFrame;

    @FindBy(xpath ="//button[contains(text(),'כניסה')]")
    private WebElement enterButton;

    @FindBy(xpath ="//span[contains(text(),'פרטי ההזדהות שהזנת שגויים, באפשרותך לנסות שנית.')]")
    private WebElement errorMessage;





    public void type_user_ID(String id) {
        log.info(" type user id: "+ id);
        cleanAntType(loginsUser,id);
        
        
    }

    public void type_user_pass(String pass) {

        log.info(" type user pass: "+ pass);
        cleanAntType(loginsPassword,pass);



    }

    public String getTitleOfCurrentPage() {

        return text(loginsButtons);
    }

    public void clickOnLoginButton() {
        log.info(" clciking on login button");
        Assert.assertTrue(click(loginsButtons));


    }

    public void switchToIframe() {

        switchToIframe(loginFrame);
    }

    public OverVeshaPageSite clickEnterButton() {

        log.info(" clicking  on enter  button");
        Assert.assertTrue(click(enterButton));
        return new OverVeshaPageSite(driver,log);
    }

    public String getErrorMessage() {

        return text(errorMessage);
    }
}
