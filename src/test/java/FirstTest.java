
import org.testng.annotations.Test;

public class FirstTest extends Common{

    MainPage mainPage ;
    CareerPage careerPage ;
    QaPage qaPage ;
    FormPage formPage;

    @Test
    public void firstTest() throws InterruptedException {

        mainPage = new MainPage(driver);
        careerPage = new CareerPage(driver);
        qaPage = new QaPage(driver);
        formPage = new FormPage(driver);

        //!!Common classından browser seçilir.
        mainPage.openInsiderWeb("https://useinsider.com/");
        mainPage.clickMore();
        mainPage.clickCareer();

        careerPage.chekCareerPage();
        careerPage.checkBlockPage("Our Locations","See all teams","Life at Insider");
        careerPage.seeAllTeamsClick();
        careerPage.selectQualityAssurance();

        qaPage.clickSeeAllQaJobs();
        qaPage.filterJobs("firefox","Istanbul, Turkey");
        qaPage.checkJobBilgileri();

        formPage.clickApplyNow();
        formPage.checkRedirectsUsToLeverApplicationformPage();
    }
}
