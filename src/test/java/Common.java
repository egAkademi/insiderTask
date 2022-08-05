import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class Common {

    WebDriver driver;

    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(@Optional("firefox") String browser){

        switch (browser){
            case "chrome"-> {
                System.out.println("chrome açıldı");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("disable-infobars");
                chromeOptions.addArguments("--disable-extensions");
                chromeOptions.addArguments("--disable-web-security");
                chromeOptions.addArguments("--test-type");
                chromeOptions.addArguments("--no-sandbox");
                chromeOptions.addArguments("--disable-application-cache");
                chromeOptions.addArguments("--disable-dev-shm-usage");
                chromeOptions.addArguments("--proxy-server=");
                chromeOptions.addArguments("--disable-notifications");
                chromeOptions.setCapability("chrome.verbose", false);


                driver=new ChromeDriver(chromeOptions);
            }
            case "firefox"-> {
                System.out.println("firefox açıldı");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
//                firefoxOptions.addArguments("--disable-notifications");
//                firefoxOptions.addArguments("--disable-extensions");
//                firefoxOptions.addArguments("--disable-web-security");
//                firefoxOptions.addArguments("--test-type");
//                firefoxOptions.addArguments("--no-sandbox");
//                firefoxOptions.addArguments("--disable-application-cache");
//                firefoxOptions.addArguments("--disable-dev-shm-usage");
//                firefoxOptions.addArguments("--proxy-server=");
                driver=new FirefoxDriver(firefoxOptions);
            }
            case "default"-> {
                System.out.println("chrome açıldı");
                driver= new ChromeDriver();
            }
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @AfterMethod
    public void tearDown() throws Exception {
        takeSnapShot(driver, "C:\\snapshot\\.jpg");
            //driver.quit();
    }

    public static void takeSnapShot(WebDriver driver,String fileWithPath) throws Exception {

        //Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        //Call getScreenshotAs method to create image file
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(SrcFile, new File(fileWithPath));
    }
}
