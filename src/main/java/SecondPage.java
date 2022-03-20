import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class SecondPage extends BasePage{

    public SecondPage(WebDriver driver){
        super(driver);
    }

    public static final By ikinciUrun =By.id("i1");
    public static final By secondProduct=By.xpath("//ul[@id='1']/li[2]");
    public static final By btnAddToCart = By.id("addToCart");
    public static final By txtmesaj = By.cssSelector("[class='checkoutui-ProductOnBasketHeader-22Wrk']");

    public SecondPage urunSec() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@id='1']/li[2]")));
        Thread.sleep(2000);
        System.out.println(getText(By.id("i0")) + " "+ getText(By.id("i1")));

        click(secondProduct);
        log.info("ikinci ürün seçilir.");
        return this;
    }

    public SecondPage sekmeDegistirveSepeteEkle() throws InterruptedException {
        Thread.sleep(2000);
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        // hold all window handles in array list
        //switch to new tab
        driver.switchTo().window(newTab.get(1));

        driver.manage().timeouts().pageLoadTimeout(3,TimeUnit.SECONDS);

        click(btnAddToCart);
        log.info("yeni sekmede ürün sepete eklenir.");
        log.info("Page title of new tab:" + driver.getTitle());

        driver.switchTo().frame(1);
        driver.switchTo().defaultContent();
        log.info(driver.switchTo().defaultContent());
        Thread.sleep(5000);
        String mesaj = getText(txtmesaj);
        Assert.assertEquals(mesaj,"Ürün sepetinizde","Hata");
        return this;
    }

    public SecondPage anaSekmeyeGec() throws InterruptedException {
        Thread.sleep(2000);
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        //switch to parent window
        driver.switchTo().window(newTab.get(0));
        driver.switchTo().defaultContent();
        //driver.navigate().refresh();//firefoxda çalışmadı
        //((JavascriptExecutor)driver).executeScript("document.location.reload()");

        log.info("ana sekmeye geçilir");
        return this;
    }

    @Parameters({"browser"})
    public SecondPage ekranYenile (@Optional("firefox") String browser) {

        switch (browser){
            case "chrome"-> {
                driver.navigate().refresh();
                log.info("ekran yenilenri");
            }
            case "firefox"-> {

                ((JavascriptExecutor)driver).executeScript("document.location.reload()");
                log.info("ekran yenilenri");
            }
        }
        return this;
    }

}