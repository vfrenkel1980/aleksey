package Utils;

import Pages.BasePage;
import Pages.BaseTest;
//import org.apache.logging.log4j.core.util.FileUtils;
//import org.apache.logging.log4j.core.util.FileUtils;
import io.appium.java_client.*;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class TestUtilities extends BasePage {


    public TestUtilities(AndroidDriver driver, Logger log) {
        super(driver, log);
    }

    public static void takeScreenshot(String fileName) {
            File scrFile = BaseTest.getDriver().getScreenshotAs(OutputType.FILE);
            String path = System.getProperty("user.dir")
                    + File.separator + "test-output"
                    + File.separator + "screenshots"
                    + File.separator + getTodaysDate()
                    + File.separator + BaseTest.testSuiteName
                    + File.separator + BaseTest.testName
                    + File.separator + BaseTest.testMethodName
                + File.separator + getSystemTime()
                + " " + fileName + ".png";
        try {
            FileUtils.copyFile(scrFile, new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** Todays date in yyyyMMdd format */
    private static String getTodaysDate() {
        return (new SimpleDateFormat("yyyyMMdd").format(new Date()));
    }




    /** Current time in HHmmssSSS */
    private static String getSystemTime() {
        return (new SimpleDateFormat("HHmmssSSS").format(new Date()));
    }


    public static Boolean compareTwoStringLists(List<String> list1, List<String> list2) {
        for (final String s1 : list1) {
            int i;
            for (i = 0; i < list2.size(); i++) {
                if (s1.equals(list2.get(i))) {
                    break;
                }
            }
            if (i == list2.size()) {
                return false;
            }
        }
        return true;
    }



    public static List <String> compareTwoStringLists2 (List<String> list1, List<String> list2) {
        List<String> differences = list1.stream()
                .filter(element -> !list2.contains(element))
                .collect(Collectors.toList());
        return differences;
    }


    public static void AndroidBack  (int howMuch) {
        for(int i=1 ;i<= howMuch ;i++) {
            BaseTest.getDriver().pressKey(new KeyEvent(AndroidKey.BACK));
        }
    }


    public static  List<String> getListOfOptionsFromMenu(int  size){
        List <String >  temp = new ArrayList<>();

        for(int i=1;i <= size ;) {
            AndroidElement element= (AndroidElement) BaseTest.getDriver().findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[" + i + "]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView"));
            temp.add(element.getText());
            i = i + 1;
        }
        return temp;
    }


    public static  List<String> convertFromWebElentsToString( List<WebElement> lst){
        List <String >  listStrings = new ArrayList<String>();
        listStrings.clear();
        for(WebElement a: lst)
        {
            listStrings.add(a.getText());

        }
        return listStrings;
    }


    public static void scrollToText_Android(String text) throws InterruptedException {
        AndroidElement  getElementByText= (AndroidElement) BaseTest.getDriver().findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector())" +
                ".scrollIntoView(new UiSelector().text(\"" + text + "\"));"));

        getElementByText.click();


    }

    public static void scrollDown_Android() throws InterruptedException {
        Dimension dimension = BaseTest.getDriver().manage().window().getSize();
        int scrollStart = (int) (dimension.getHeight()* 0.999);
        int scrollEnd = (int) (dimension.getHeight() * 0.001);


        new TouchAction((PerformsTouchActions) BaseTest.getDriver() )
                .press(PointOption.point(0, scrollStart))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(0, scrollEnd))
                .release().perform();



        int scrollEndtt = (int) (dimension.getHeight() * 0.1);

    }


    public static List <String> CopyList(List <String> sourceList,List <String > searchResultsAggregate)
    {
        searchResultsAggregate.addAll(sourceList);
        return   searchResultsAggregate;

    }








    public static void scrollToText_AndroidEmpty(String text) throws InterruptedException {
            for (int i = 0; i < 2; i++) { // 2 tries to make tap
                try {
                    AndroidElement  getElementByText= (AndroidElement) BaseTest.getDriver().findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector())" +
                            ".scrollIntoView(new UiSelector().text(\"" + text + "\"));"));
                    getElementByText.click();

                    break;
                } catch (Exception e) {
                    System.out.println(("find text(): FAILED\n" + e.getMessage()));

                }
                System.out.println("find text(): RETRY '" + i + "' ----------------");

            }
        }







}
