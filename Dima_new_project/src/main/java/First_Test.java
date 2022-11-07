import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class First_Test {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
       // System.setProperty("webdriver.chrome.driver","E:\\Drivers\\chromedriver.exe");
        //ChromeDriver driver=new ChromeDriver();
        ChromeOptions chromeOptions=new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        chromeOptions.addArguments("--disable-notifications");
        driver=new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://google.com/");
        Thread.sleep(3000);

        //input[@class="gNO89b"]

        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("selenium");

        WebElement button=driver.findElement(By.xpath("//input[@class='gNO89b']"));

        button.click();
        Thread.sleep(5000);
        driver.navigate().back();

        Thread.sleep(5000);
       // element.sendKeys(Keys.ENTER);

        Thread.sleep(4000);
        Thread.sleep(4000);
        driver.quit();













    }








}
