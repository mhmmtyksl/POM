package tests.day14;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcortHotelPage;
import utilities.TestBase;

public class C01_ConcortHotelLoginPositive extends TestBase {
    // 1 ) Bir Class olustur : PositiveTest
    // 2) Bir test method olustur positiveLoginTest()

    @Test
    public void positiveLoginTest() {

        // https://www.concorthotel.com/ adresine git
        driver.get("https://www.concorthotel.com/");
        ConcortHotelPage concortHotelPage=new ConcortHotelPage(driver);
        // bu sekilde oncelikle confortHotelPage class indan obje uretiyoruz

        // login butonuna bas
        concortHotelPage.ilkLoginLinki.click();

        // test data username: manager ,
        concortHotelPage.userNameKutusu.sendKeys("manager");

        // test data password : Manager1!
        concortHotelPage.passwordKutusu.sendKeys("Manager1!");
        concortHotelPage.loginButonu.click();

        // Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        Assert.assertTrue(concortHotelPage.basariliGirisYazisiElementi.isDisplayed());
    }

}


// bu islemleri kolaylastirmak i