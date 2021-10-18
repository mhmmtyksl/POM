package tests.day13;

import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.TestBase;

public class C02_PagesFacebook extends TestBase {



    @Test
    public void test() {

        // facebook login sayfasina gidin
        driver.get("https://www.facebook.com");
        FacebookPage facebookPage=new FacebookPage(driver);

        // page sayfasinda cookiesGec methodu olusturun
        facebookPage.cookiesGec();

        // kullanici adi : techproed@hotmail.com
        facebookPage.mailKutusu.sendKeys("techproed@hotmail.com");

        // sifre : 12345
        facebookPage.sifreKutusu.sendKeys("12345");

        // yazdiginizda giris yapamadiginizi test edin
        facebookPage.loginTusu.click();
        Assert.assertTrue(facebookPage.girilemediYaziElementi.isDisplayed());


    }



}
