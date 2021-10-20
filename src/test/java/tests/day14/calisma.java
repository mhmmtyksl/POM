package tests.day14;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import pages.ConcortHotelPage;
import utilities.ConfigReader;
import utilities.TestBase;

public class calisma extends TestBase {

    @Test
    public void test() {
        driver.get(ConfigReader.getProperty("CHUrl"));

        ConcortHotelPage concortHotelPage=new ConcortHotelPage(driver);
        concortHotelPage.ilkLoginLinki.click();
        concortHotelPage.userNameKutusu.sendKeys(ConfigReader.getProperty("CHInvalidUsername"));
        concortHotelPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHInvalidPassword"));
        concortHotelPage.loginButonu.click();
        Assert.assertTrue(concortHotelPage.basarisizGirisYazisiElementi.isDisplayed());



    }
}
