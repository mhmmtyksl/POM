package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonPage {

    // locatorlari koydugumuz class a page classi diyoruz


    WebDriver driver;
    // bir page sayfasi olusturuldugunda mutlaka yapmamiz gereken sey
    // bir constructor olusturup driver'a ilk degeri atamaktir (instantiate)
    public AmazonPage(WebDriver driver){ // burada constructor urettik bunun public olmasi lazim ki ulasilabilir olsun
        this.driver=driver; // burada mor driver ile diger class tan gelen beyaz driver i birbirine esitliyoruz
        PageFactory.initElements(driver,this);// bu satir mutlaka yapilmasi gereken olmazsa olmazdir
    }

    public AmazonPage(){ // bunu default constructor in yerine urettik bos driver ama uretilmeyedebilir

    }

    //WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
    @FindBy(id="twotabsearchtextbox")
    public WebElement aramaKutusu; // bunu bu sekilde olusturduk ve artik Pages sayfasinda Web element olusturmadan bunu kuzllanacagiz

    @FindBy(xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']")
    public WebElement sonucYazisiElementi;

    @FindBy(id="searchDropdownBox")
    public WebElement dropdownMenu;

    @FindBy(xpath = "//span[@class='a-size-medium a-color-base a-text-normal']")
    public WebElement ilkUrunIsim;

}