package tests.day19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class C02_WindowHandleRaporlu extends TestBaseRapor { // raporlama methodlarinin oldugu class a extends yapiyoruz


    @Test
    public void test() {
        // burada deger atamasi yapiyoruz
        extentTest=extentReports.createTest("window handle test", "yeni sayfada new window yazi test");
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        extentTest.info("istenen adrese gidildi"); // bunlarin icine raporda gozukecek yazilari yaziyoruz

        Driver.getDriver().findElement(By.linkText("Click Here")).click();
        extentTest.info("linke tiklandi");

        ReusableMethods.switchToWindow("New Window");
        extentTest.info("yeni sayfaya gecildi");

        WebElement newWindowYaziElementi=Driver.getDriver().findElement(By.tagName("h3"));
        extentTest.info("test edecegimiz yazi locate edildi");

        Assert.assertTrue(newWindowYaziElementi.isDisplayed());
        extentTest.info("yazinin gorunur oldugu test edildi");
    }

}

// bunu calistirinca raporlar diye bir package olustu
// onun altinda rapor.html asag tiklayip open in Browser Chrome seciliyor ve sonuc gorunuyor