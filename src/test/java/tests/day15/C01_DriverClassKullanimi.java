package tests.day15;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_DriverClassKullanimi {

    @Test
    public void test() {
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        Driver.getDriver().get(ConfigReader.getProperty("CHUrl"));

        Driver.getDriver().get(ConfigReader.getProperty("facebookUrl"));

        // Driver driver=new Driver();
        // Driver class indan obje uretilemesin dedigimiz icin Driver class i singleton yapiyoruz
        // bunun icin default constroctur yerine parametresiz bir constroctur olusturup
        // access modifier i private seciyoruz. buna da singleton class yada yapi denir

        // Driver driver=new Driver("Ben istedim ama olmadi");
        // Driver class inda parametreli contructor olmadigi icin parametreli de kullanamayiz

        Driver.closeDriver();
    }
}
