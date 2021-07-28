package Pages.whatsappPages;

import Pages.BasePage;
import Utils.TestUtilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class WhatsUpCallPage  extends BasePage {



    public WhatsUpCallPage(WebDriver driver, Logger log) {
        super(driver,log);
    }

    public List<String> searchResultsAggregate = new ArrayList<>(); //searchResultsAgrregate= new ArrayList <WebElement>;


    @AndroidFindBy(id ="com.whatsapp:id/search_src_text")
    public AndroidElement searchInput;

    @AndroidFindBy(xpath ="//android.widget.TextView[@content-desc=\"Search\"]")
    public AndroidElement searchIcon;

    @AndroidFindBy(id ="com.whatsapp:id/search_mag_icon")
    public AndroidElement backButton;

    @AndroidFindBy(id ="com.whatsapp:id/contact_name")
    public AndroidElement contact_name;


    public List<String> getTextOfOptions(int  size) {
        List <String >  listOfOptions = new ArrayList<>();
        listOfOptions = TestUtilities.getListOfOptionsFromMenu(size);

//        for(int i=1;i <= size ;) {
//            AndroidElement element= (AndroidElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[" + i + "]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView"));
//            sleep(1500);
//           // waitForVisibilityOf (element);
//            temp.add(element.getText());
//            i = i + 1;
        //}
        return listOfOptions;
    }



    public  void clickOnSearchButtonFromCallsSectionAndTypeText(String text)
    {

        log.info("clicking on statusIcon " +  text(searchIcon));
        Assert.assertTrue(click(searchIcon)," click on icon failed");
        log.info("typing text into searchIcon" +  text(searchInput));
        type(searchInput,text);
    }


    public void findSearchResults()
    {
        List <WebElement>  searchResultsWebEL = new ArrayList<>();
        searchResultsWebEL = findAll(By.id("com.whatsapp:id/contact_name"));


        List <String>  searchResultsWebText = new ArrayList<>();
        searchResultsWebText = TestUtilities.convertFromWebElentsToString(searchResultsWebEL);
        TestUtilities.CopyList(searchResultsWebText,searchResultsAggregate);

    }


    public void  clickOnBackButtonInSearch()
    {
        click(backButton);

    }



}
