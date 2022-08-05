import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {

    private final By cmbMore = By.xpath("//div[@id='navbarNavDropdown']/ul/li[6]");
    private final By hrefCaree1r = By.xpath(".//p[text()='Ready to disrupt? Explore opportunities and see what it’s like learn and grow with an amazing team.']");
    private final By hrefCareer = By.xpath("//div[@class='dropdown-menu show']/div/div[3]");

    public MainPage(WebDriver driver) {super(driver);}

    public MainPage openInsiderWeb (String endPoint) {
        driver.get(endPoint);
        log.info("visit https://useinsider.com/");
        return this;
    }

    public MainPage clickMore(){
        wait.until(ExpectedConditions.elementToBeClickable(cmbMore));
        click(cmbMore);
        log.info("select More menü");
        return this;
    }

    public MainPage clickCareer() {
        isDisplayed(hrefCaree1r);
        click(hrefCaree1r);
        log.info("select career");
        return this;
    }
}
