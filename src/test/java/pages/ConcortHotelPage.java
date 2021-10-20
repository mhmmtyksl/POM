package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConcortHotelPage {

    //tum locatorleri burada yapiyoruz daha sonra ihtiyac oldukca hepsini buradan cagiriyoruz

    WebDriver driver;

    public ConcortHotelPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(linkText = "Log in")
        public WebElement ilkLoginLinki;

    @FindBy(id = "UserName")
        public WebElement userNameKutusu;

    @FindBy(id = "Password")
    public WebElement passwordKutusu;

    @FindBy(id = "btnSubmit")
    public WebElement loginButonu;

    @FindBy(xpath = "//span[@class='caption-subject font-green-sharp bold uppercase']")
    public WebElement basariliGirisYazisiElementi;

    @FindBy (xpath = "//*[.='Try again please']")
    public WebElement basarisizGirisYazisiElementi;



}
