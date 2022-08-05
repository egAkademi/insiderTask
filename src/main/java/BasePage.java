import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    WebDriver driver;
    protected WebDriverWait wait;
    static Logger log = LogManager.getLogger(BasePage.class.getName());

    private static final long DRIVER_WAIT_TIME = 240;

    public BasePage(WebDriver driver){
        this.wait = new WebDriverWait(driver, DRIVER_WAIT_TIME);
        this.driver=driver;
    }

    public void clickJS(WebElement element) throws InterruptedException {

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void click(By by){
        try {
            driver.findElement(by).click();
        }   catch (Exception e){
            e.printStackTrace();
        }
    }

    public boolean isDisplayed(WebElement webElement){
        try {
            return webElement.isDisplayed();
        }   catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean isDisplayed(By by){
        try {
            return driver.findElement(by).isDisplayed();
        }   catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public void sendKey(WebElement webElement, String key){
        try {
            webElement.sendKeys(key);
        }   catch (Exception e){
            e.printStackTrace();
        }
    }

    public void sendKey(By by, String key){
        try {
            driver.findElement(by).sendKeys(key);
        }   catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getText(WebElement webElement){
        try {
            return webElement.getText();
        }   catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public String getText(By by){
        try {
            return driver.findElement(by).getText();
        }   catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public WebElement waitForElementToBeVisible(By element){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

}
