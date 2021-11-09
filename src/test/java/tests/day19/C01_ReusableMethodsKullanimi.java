package tests.day19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Set;

public class C01_ReusableMethodsKullanimi {

    @Test
    public void test() {

        // https://the-internet.herokuapp.com/windows adresine gidiniz
        // click here yazisina tiklayiniz

        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        String ilkSayfaHandleDegeri=Driver.getDriver().getWindowHandle();

        Driver.getDriver().findElement(By.linkText("Click Here")).click();

        Set<String> windowHandleKumesi=Driver.getDriver().getWindowHandles();
        String ikinciSayfaHandleDegeri="";
        for (String each:windowHandleKumesi) {
            if (!each.equals(ilkSayfaHandleDegeri)) {
                ikinciSayfaHandleDegeri=each;
            }
        }
        Driver.getDriver().switchTo().window(ikinciSayfaHandleDegeri);
        System.out.println(Driver.getDriver().getTitle());

        // yeni sayfada new window yazisinin gorundugunu test ediniz
        WebElement newWindowYaziElementi=Driver.getDriver().findElement(By.tagName("h3"));
        Assert.assertTrue(newWindowYaziElementi.isDisplayed());

        Driver.closeDriver();
    }

    // burada yukaridaki methodun aynisini bu yontemle yapacagiz daha basit sekilde
    @Test
    public void testReusableIle(){
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        Driver.getDriver().findElement(By.linkText("Click Here")).click();
        // bu ilk iki adim yukari ile ayni
        // sonra ReusableMethods taki hazir methodlari kullaniyoruz.
        ReusableMethods.switchToWindow("New Window");
        WebElement newWindowYaziElementi=Driver.getDriver().findElement(By.tagName("h3"));
        Assert.assertTrue(newWindowYaziElementi.isDisplayed());
        ReusableMethods.waitFor(5);
        Driver.closeDriver();
    }
}