package Pages.BankTfaxotPagesSite;

import Pages.BasePage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OverVeshaPageSite extends BasePage {
    public OverVeshaPageSite(WebDriver driver, Logger log) {
        super(driver, log);
    }


    @FindBy(xpath = "//span[contains(text(),'איזור אישי')]")
    private WebElement afterLoginText;



    public String getTitleAfterLogin() {

        return text(afterLoginText);
    }
}
