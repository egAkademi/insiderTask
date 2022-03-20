import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ThirdPage extends BasePage {

    public ThirdPage(WebDriver driver){
        super(driver);
    }

    public static final By btnSepet = By.xpath("//a[@href='https://checkout.hepsiburada.com/sepetim']");
    public static final By btnUrunSil =By.xpath("//a[@aria-label='Ürünü Kaldır']");
    public static final By textSepetBos = By.cssSelector("[class='content_Z9h8v']");

    public ThirdPage sepeteGit() throws InterruptedException {
        Thread.sleep(2000);
        //wait.until(ExpectedConditions.elementToBeClickable(By.id("myAccount")));
        click(btnSepet);
        log.info("sepete gidilir.");
        return this;
    }

    public ThirdPage urunSil() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@aria-label='Ürünü Kaldır']")));
        click(btnUrunSil);
        log.info("sepetten ürün silinir.");

        String gelenText=getText(textSepetBos);
        String beklenenText="Sepetin şu an boş\n" +
                "Sepetini Hepsiburada’nın fırsatlarla dolu dünyasından doldurmak için\n" +
                "aşağıdaki ürünleri incelemeye başlayabilirsin.";
        Assert.assertEquals(gelenText,beklenenText,"Hata");
        log.info("silme  işlemi sonrası uyarı mesajı: " + gelenText + " kontrolü yapılır.");

        return this;
    }
}
