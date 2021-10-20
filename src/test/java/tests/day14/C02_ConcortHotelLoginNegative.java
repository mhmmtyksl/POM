package tests.day14;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcortHotelPage;
import utilities.TestBase;

public class C02_ConcortHotelLoginNegative extends TestBase {

        //Bir test method olustur NegativeLoginTest()
    @Test
    public void positiveLoginTest() {

        // https://www.concorthotel.com/ adresine git
        driver.get("https://www.concorthotel.com/");

        // login butonuna basmadan once obje olusturmamiz gerekir
        ConcortHotelPage concortHotelPage = new ConcortHotelPage(driver);

        // login butonuna bas
        concortHotelPage.ilkLoginLinki.click();

        // test data username: manager1 ,
        concortHotelPage.userNameKutusu.sendKeys("manager1");

        // test data password : manager1!
        concortHotelPage.passwordKutusu.sendKeys("manager1!");
        concortHotelPage.loginButonu.click();

        // Degerleri girildiginde sayfaya girilemedigini test et
        Assert.assertTrue(concortHotelPage.basarisizGirisYazisiElementi.isDisplayed());

    }
}