package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonPage {

    WebDriver driver;
    // bir page sayfasi olusturuldugunda mutlaka yapmamiz gereken sey
    // bir constructor olusturup driver a ilk degeri atamaktir (instantiate)
    public AmazonPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        // bu her page sayfasi icin mutlaka olmasi gereken olmazsa olmaz satirdir
        // bunu da constructor in icine yaziyoruz.
    }

    public AmazonPage() {

    }

    @FindBy(id="twotabsearchtextbox")
    public WebElement aramaKutusu;

    @FindBy(xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']")
    public WebElement sonucYazisiElementi;

    @FindBy(id="searchDropdownBox")
    public WebElement dropDownMenu;

    @FindBy(xpath = "(//span[@class='a-size-base a-color-base a-text-normal'])[1]")
    public WebElement ilkUrunIsim;

}
