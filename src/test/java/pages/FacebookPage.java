package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookPage {

    WebDriver driver;

    Public FacebookPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }

    public FacebookPage(){}

    @FindBy(id="email")
    public WebElement mailKutusu;

    @FindBy(id="pass")
    public WebElement sifreKutusu;

    @FindBy(name="login")
    public WebElement loginKutusu;

    @FindBy(className="_9ay7")
    public WebElement girilemediYaziElementi;

    public void
}
