package Screenshot;

import Pages.BaseTest;
import Utils.TestUtilities;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.IOException;

public class GetScreenshot {


    protected void takeScreenshot(String fileName) {
        File scrFile = BaseTest.getDriver().getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir")
                + File.separator + "test-output"
                + File.separator + "screenshots"
//                + File.separator + getTodaysDate()
//                + File.separator + testSuiteName
//                + File.separator + testName
//                + File.separator + testMethodName
                + File.separator //+ TestUtilities
                + " " + fileName + ".png";
        try {
            //FileUtils.copyFile(scrFile, new File(path));
            FileUtils.copyFile(scrFile, new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
