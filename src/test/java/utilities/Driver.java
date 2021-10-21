package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private Driver() {

    }

    private static WebDriver driver; // public static olunca her yerden ve class ismi ile ulasilabilir, obje olusturulmadan dahi
    // biz private yaptik ki baska class lardan sadece Driver ismi ile cagirabilelim.
    // henuz driver ile ilgili ayarlar yapmadigimiz icin baska classlar bunu yanlislikla kullanmasin diye private yaptik.

    public static WebDriver getDriver() {

        if (driver==null) {
            // if i bu method her calistiginda yeni bir driver olusturmamasi icin kullaniyoruz
            // if driver i kontrol edecek eger bir deger atamasi yapilmissa yeni bir driver olusturmayacak

            switch (ConfigReader.getProperty("browser")) {
                // case i istedigimiz browser da calistirmak icin kullaniyoruz.
                // configuratuin.properties dosyasinda browser olarak ne yazdiysak tum testlerimiz o browser da calisacak
                // browser secimi yapilmadiysa default olarak chrome devreye girecek
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "opera":
                    WebDriverManager.operadriver().setup();
                    driver = new OperaDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "safari":
                    WebDriverManager.getInstance(SafariDriver.class);
                    driver = new SafariDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();

            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        } // bu if in parantezi
        return driver;
    }

    public static void closeDriver() {
        if (driver!=null) {
            driver.quit();
        }
        driver=null;
        // burada yeniden null degeri atamamizin nedeni bir sonraki getDriver methodu cagirdigimizda
        // yeni deger atayabilmek icin.

    }

}
