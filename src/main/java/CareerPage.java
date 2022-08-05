import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class CareerPage extends BasePage {

    private final By locations = By.cssSelector("[class='category-title-media ml-0']");
    private final By teams = By.cssSelector("[class='btn btn-outline-secondary rounded text-medium mt-5 mx-auto py-3 loadmore']");
    private final By life = By.xpath(".//h2[text()='Life at Insider']");
    private final By qa = By.xpath(".//h3[text()='Quality Assurance']");

    public CareerPage(WebDriver driver) {
        super(driver);
    }
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public CareerPage chekCareerPage () {
        log.info(driver.getTitle());
        if(driver.getTitle() != null && driver.getTitle().contains("Insider Careers")){
            log.info("");
            log.info("Web page is opened");
        }
        else{
            log.info("Web page could not open.");
        }
        return this;
    }

    public CareerPage checkBlockPage (String expectedText1,String expectedText2,String expectedText3) {
        waitForElementToBeVisible(locations);
        String text1 = driver.findElement(locations).getText();
        log.info(text1);

        waitForElementToBeVisible(teams);
        String text2 = driver.findElement(teams).getText();
        log.info(text2);

        waitForElementToBeVisible(life);
        String text3 = driver.findElement(life).getText();
        log.info(text3);

        Assert.assertEquals(text1,expectedText1,"Kontrol başarısız");
        Assert.assertEquals(text2,expectedText2,"Kontrol başarısız");
        Assert.assertEquals(text3,expectedText3,"Kontrol başarısız");

        return this;
    }

    public CareerPage seeAllTeamsClick () {

        WebElement button =driver.findElement(By.cssSelector("[class='btn btn-outline-secondary rounded text-medium mt-5 mx-auto py-3 loadmore']"));
        js.executeScript("arguments[0].click();", button);
        js.executeScript("window.scrollBy(0,1900)");
        log.info("Click See All Teams");

        return this;
    }

    public CareerPage selectQualityAssurance () throws InterruptedException {
                WebElement button = driver.findElement(By.xpath(".//h3[text()='Quality Assurance']"));
                clickJS(button);
                log.info("select Quality Assurance");

        return this;
    }

}
