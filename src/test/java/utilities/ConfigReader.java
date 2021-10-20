package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    // bu dosya test Class lari ile test datalarimizi tuttugumuz configuration.properties arasinda bir
    // kopru gorevi gorur. bunu yapabilmak icin asagidaki 3 adima ihtiyacimiz vardir.

    // 1) Properties objesi olusturacagiz
    static Properties properties; // static blok icerisinden bunu kullanabilmek icin static yapmamiz gerekir.

    // 2) Bu class in amaci configration.properties dosyasini okumak ve oradaki key value
    //    ikililerini kullanarak istedigimiz key e ait value yi bize getirmek.
    static { // oncelikle bu asamada bir static blok olusturmaliyiz.
        String dosyaYolu="configuration.properties";// bunu configuration.properties ne sag tiklayarak paht From Content Root u secerek aliyoruz
        try {
            FileInputStream fileInputStream=new FileInputStream(dosyaYolu);
            properties=new Properties();
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) { // ya okuyamazsam icin
            e.printStackTrace();
        } catch (IOException e) { // ya yukleyemezsem icin
            e.printStackTrace();
        } // catch de onemli olan kucuk olanin uste yazilmasi aksi halde buyuk olan hepsini kapsayacagi
        // icin alttakine gerek kalmaz.

    }

    // 3) Test class larindan configReader class ina ulasip yukaridaki islemleri yapmamizi
    //    saglayacak bir method olusturulmasi.
    public static String getProperty (String key) { // her yerden ulasilabilmesi icin static yapiyoruz
        // biz buna String key gonderecez
        String value=properties.getProperty(key); // bu bize String value dondurecek
        return value;
    }

}
// configuration.properties olusturmak icin projeye safg tiklayip file olustur diyoruz. onemli
// olan uzantisinin mutlaka .properties olmasi gerekir.