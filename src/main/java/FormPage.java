import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class FormPage extends BasePage{
    private final By btnApplyForJob = By.cssSelector("[class='postings-btn-wrapper']");

    public FormPage(WebDriver driver) {
        super(driver);
    }
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public FormPage clickApplyNow () throws InterruptedException {
        Thread.sleep(1000);
        WebElement button =driver.findElement(By.xpath("//div[@id='jobs-list']//div/div//a[@target='_blank']"));
        js.executeScript("arguments[0].click();", button);
        return this;
    }

    public FormPage checkRedirectsUsToLeverApplicationformPage() {
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(1));
        System.out.println(driver.getTitle());
        return this;
    }

}
