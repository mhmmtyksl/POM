package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.TestBase;

public class C01_Pages extends TestBase { // burada normalde driver yok ama extends oldugu icin calistirabiliyoruz

    // amazon sayfasina gidin
    // "nutella" icin arama yapin
    // sonuc sayisini yazdirin ve sonuc yazisinin "nutella" icerdigini test edin
    @Test(groups = "birinciGrup")
    public void test() { // burasi normal yaptigimiz onceki yontemle yapmak

        driver.get("https://www.amazon.com");
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("nutella"+ Keys.ENTER);
        WebElement sonucYazisiElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonucYazisiElementi.getText());
        Assert.assertTrue(sonucYazisiElementi.getText().contains("nutella"));
    }

    @Test
    public void testPOM() { // burasi ise yeni ogrendigimiz sekilde yapmak icin uretilen method

        driver.get("https://www.amazon.com");
        AmazonPage amazonPage=new AmazonPage(driver); // eger parantez icindeki deriver i yazmazsak
        // calismaz
        amazonPage.aramaKutusu.sendKeys("nutella"+Keys.ENTER);
        System.out.println(amazonPage.sonucYazisiElementi.getText());
        Assert.assertTrue(amazonPage.sonucYazisiElementi.getText().contains("nutella"));
    }

}
