package Utils;

import Pages.BaseTest;
//import org.apache.logging.log4j.core.util.FileUtils;
//import org.apache.logging.log4j.core.util.FileUtils;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class TestUtilities  {


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


    public static void AndroidBack  () {
        BaseTest.getDriver().pressKey(new KeyEvent(AndroidKey.BACK));
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


}
