package tests.smokeTest;

import org.apache.hc.core5.reactor.Command;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class NegativeTest {

    //1) smokeTest paketi altinda yeni bir Class olustur: NegativeTest
    //3 Farkli test Methodunda 3 senaryoyu test et
    // - yanlisSifre
    // - yanlisKulllanici
    // - yanlisSifreKullanici
    //test data yanlis username: manager1 , yanlis password : manager1!

    QAConcortPage qaConcortPage; // burada sadece obje yi class levelde olusturduk asagida deger atamasi yaptik

    @Test(priority = -5) // diger methodlara sira vermedigimiz onlari 0 kabul eder bu yuzden buna negatif verdikki ilk sirada calisssin.
    public void yanlisSifreTest() {

        //2) https://qa-environment.concorthotel.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));

        qaConcortPage=new QAConcortPage(); // burada deger atamasi yaptik

        //3) Login butonuna bas
        qaConcortPage.ilkLoginLinki.click();

        //4) Verilen senaryolar ile giris yapilamadigini test et
        qaConcortPage.userNameKutusu.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));

        qaConcortPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHQAInvalidPassword"));

        qaConcortPage.loginButonu.click();

        Assert.assertTrue(qaConcortPage.basarisizGirisYazisiElementi.isDisplayed());

}
    @Test(dependsOnMethods = "yanlisSifreTest")
    public void yanlisKullaniciTest() { // burada tekrardan url ye gitmeye gerek yok
        // ancak hangi sayfanin once calisacagi da belli olmadigi icin priority ile sira numarasi verdik
        // ve bunlari da ilk method a depends on yaptik bagimli kildik

        qaConcortPage=new QAConcortPage();

        //3) Login butonuna bas
        qaConcortPage.ilkLoginLinki.click();

        //4) Verilen senaryolar ile giris yapilamadigini test et
        qaConcortPage.userNameKutusu.clear(); // onceki girilen verileri temizlemek icin bunu kullandik
        qaConcortPage.userNameKutusu.sendKeys(ConfigReader.getProperty("CHQAInvalidUsername"));

        qaConcortPage.passwordKutusu.clear();
        qaConcortPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));

        qaConcortPage.loginButonu.click();

        Assert.assertTrue(qaConcortPage.basarisizGirisYazisiElementi.isDisplayed());
    }

    @Test(dependsOnMethods = "yanlisSifreTest")
    public void yanlisSifreKullaniciTest() {
        qaConcortPage=new QAConcortPage();

        //3) Login butonuna bas
        qaConcortPage.ilkLoginLinki.click();

        //4) Verilen senaryolar ile giris yapilamadigini test et
        qaConcortPage.userNameKutusu.clear();// onceki girilen verileri temizlemek icin bunu kullandik
        qaConcortPage.userNameKutusu.sendKeys(ConfigReader.getProperty("CHQAInvalidUsername"));

        qaConcortPage.passwordKutusu.clear();
        qaConcortPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHQAInvalidPassword"));

        qaConcortPage.loginButonu.click();

        Assert.assertTrue(qaConcortPage.basarisizGirisYazisiElementi.isDisplayed());

        Driver.closeDriver();
    }
}
