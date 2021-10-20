package tests.day14;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcortHotelPage;
import utilities.ConfigReader;
import utilities.TestBase;

public class C03_PositiveTestConfigReaderIle extends TestBase {

    @Test
    public void posotiveTestConfig() {

        // https://www.concorthotel.com/ adresine git
        driver.get(ConfigReader.getProperty("CHUrl"));
        // bunun anlami hey driver cinfigReader class indan CHUrl yi getir demek

        ConcortHotelPage concortHotelPage=new ConcortHotelPage(driver);

        // login butonuna bas
        concortHotelPage.ilkLoginLinki.click();

        // test data username: manager ,
        concortHotelPage.userNameKutusu.sendKeys(ConfigReader.getProperty("CHValidUsername"));
        // bunun anlami hey driver cinfigReader class indan CHValidUsername yi getir demek

        // test data password : Manager1!
        concortHotelPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHValidPassword"));
        concortHotelPage.loginButonu.click();

        // Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        Assert.assertTrue(concortHotelPage.basariliGirisYazisiElementi.isDisplayed());

    }

}
