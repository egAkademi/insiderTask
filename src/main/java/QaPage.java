import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.List;

public class QaPage extends BasePage {

    private final By qa = By.xpath("//a[text()='See all QA jobs']");
    private final By locations = By.id("select2-filter-by-location-container");

    public QaPage(WebDriver driver) {
        super(driver);
    }

    public QaPage clickSeeAllQaJobs() {
        isDisplayed(qa);
        click(qa);
        log.info("click See all QA jobs");
        return this;
    }

    @Parameters({"browser"})
    public QaPage filterJobs (@Optional("browser") String browser,String locationsName) throws InterruptedException {

        switch (browser){
            case "chrome"-> {
                wait.until(ExpectedConditions.elementToBeClickable(locations)).click();
                WebElement e = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//option[text()='" +locationsName + "']")));
                log.info(e);
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
                e.click();
                wait.until(ExpectedConditions.elementToBeClickable(locations)).click();
                log.info("filter jobs by Location - Istanbul, Turkey and department");
            }
            case "firefox"-> {
                Thread.sleep(2000);
                driver.findElement(By.id("select2-filter-by-location-container")).click();
                WebElement e = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//li[text()='"+locationsName+"']")));
                log.info(e);
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
                e.click();
            }
        }
        return this;
    }

    public QaPage checkJobBilgileri () throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,250)");
        Thread.sleep(1000);
        log.info("currentResult Total Count" + driver.findElement(By.id("deneme")).getText());

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("jobs-list")));

        List<WebElement> elements = driver.findElements(By.id("jobs-list"));
        log.info("Number of elements:" +elements.size());

        for (WebElement e : elements){
            log.info("Radio button text:" + e.getText());
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='jobs-list']//div/span[1]")));

        String job1 = driver.findElements(By.xpath("//div[@id='jobs-list']//div/span[1]")).get(0).getText();
        log.info(job1);
        Assert.assertEquals(job1,"Quality Assurance","Kontrol başarısız");

        String job2 = driver.findElements(By.xpath("//div[@id='jobs-list']//div/span[1]")).get(1).getText();
        log.info(job2);
        Assert.assertEquals(job2,"Quality Assurance","Kontrol başarısız");

        String location1 = driver.findElements(By.xpath("//div[@id='jobs-list']//div/div//div[1]")).get(0).getText();
        log.info(location1);
        Assert.assertEquals(location1,"Istanbul, Turkey","Kontrol başarısız");

        String location2 = driver.findElements(By.xpath("//div[@id='jobs-list']//div/div//div[1]")).get(1).getText();
        log.info(location2);
        Assert.assertEquals(location2,"Istanbul, Turkey","Kontrol başarısız");

        ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='jobs-list']//div/div//a[@target='_blank']"));

        return this;
    }
}
