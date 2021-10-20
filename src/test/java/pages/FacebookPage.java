package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookPage {

    WebDriver driver;

    public FacebookPage(WebDriver driver){ // ilk yapilmasi gereken boyle bir constructor olusturup
        // icine alttaki pageFactory satirini yazmak.
        this.driver=driver;
        PageFactory.initElements(driver,this);
        // bunu basta yazinca ustteki driver olmadigi icin hata verdi ve ustteki driver i urettik
    }
        // burada locatorlerimizi yapiyoruz
    @FindBy(id="email")
    public WebElement mailKutusu;

    @FindBy(id="pass")
    public WebElement sifreKutusu;

    @FindBy(name = "login")
    public WebElement loginTusu;

    @FindBy(className="_9ay7")
    public WebElement girilemediYaziElementi;

    public void cookiesgec(){ // bu genel olmayip cookis i gecmek icin oldugu icin bu classta olusturduk
        driver.findElement(By.xpath("//button[@class='_42ft _4jy0 _9xo7 _4jy3 _4jy1 selected _51sy']")).click();
    }
}