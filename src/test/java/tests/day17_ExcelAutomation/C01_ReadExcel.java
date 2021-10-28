package tests.day17_ExcelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class C01_ReadExcel {

    @Test(groups = "birinciGrup")
    public void test() throws IOException {

        //7. Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/test/java/resources/ulkeler.xlsx";

        //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fileInputStream=new FileInputStream(dosyaYolu);

        //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //10. WorkbookFactory.create(fileInputStream)
        Workbook workbook=WorkbookFactory.create(fileInputStream);


        //11. Worksheet objesi olusturun workbook.getSheetAt(index)
        Sheet sheet= workbook.getSheet("Sayfa1");

        //12. Row objesi olusturun sheet.getRow(index)
        Row row= sheet.getRow(2);

        //13. Cell objesi olusturun row.getCell(index)
        Cell cell= row.getCell(3);

        System.out.println(cell);
    }

    @Test
    public void test2() throws IOException {

        //7. Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/test/java/resources/ulkeler.xlsx";

        //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fileInputStream=new FileInputStream(dosyaYolu);

        //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //10. WorkbookFactory.create(fileInputStream)
        Workbook workbook=WorkbookFactory.create(fileInputStream);


        //11. Worksheet objesi olusturun workbook.getSheetAt(index)


        //12. Row objesi olusturun sheet.getRow(index)


        //13. Cell objesi olusturun row.getCell(index)
        Cell cell=workbook.getSheet("Sayfa1").getRow(5).getCell(3);

        System.out.println(cell);

        // secilen hucredeki yazinin Luanda oldugunu test edin

        // Assert.assertEquals(cell,"Luanda");
        // cell in data turu Cell, Luanda ise String
        // dolayisiyla data turleri ayni olmadigi icin equals olamaz
        // Cell data turu yazdirilabilir ancak String methodlari ile kullanilamaz
        // String manipulation yapmak icin Cell data turunu String e cast yapmaliyiz
        Assert.assertEquals(cell.toString(),"Luanda"); // string e cevirmek icin toString() de kullanilabilir
        Assert.assertEquals(cell.getStringCellValue(),"Luanda"); // getStringCellValue() de kullanilabilir

        // index i 3 olan satirdaki index i 2 olan hucredeki yaziyi buyuk harfle yazdirin.
        Cell cell1=workbook.getSheet("Sayfa1").getRow(3).getCell(2);
        System.out.println(cell1.toString().toUpperCase()); // CEZAYIR yazdirdi

        System.out.println(workbook.getSheet("Sayfa1").getLastRowNum()); // 190 normalde 191 ama index aldigi icin 190 getirdi
        // bu bize son satirin index ini verir

        System.out.println(workbook.getSheet("Sayfa1").getPhysicalNumberOfRows()); // 191 yazdirdi
        // bu ise bize fiili olarak kullanilan satir sayisini verir.
        // aralarda bos satirlar varsa bunlari saymaya dahil etmez

    }

    @Test
    public void test3() throws IOException {

        // tablodaki 2. sutunu bir liste olarak yazdirin
        List<String> ikinciSutun = new ArrayList<>();
        String dosyaYolu="src/test/java/resources/ulkeler.xlsx";
        FileInputStream fileInputStream=new FileInputStream(dosyaYolu);
        Workbook workbook=WorkbookFactory.create(fileInputStream);

        for (int i=0; i<=workbook.getSheet("Sayfa1").getLastRowNum(); i++) {
            ikinciSutun.add(workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString());
        }
        System.out.println(ikinciSutun);

        // A ile baslayan sehirleri liste yapip yazdirin
        List<String> aIleBaslayanSehirler=new ArrayList<>();

        for (String each: ikinciSutun) {
            if (each.startsWith("A")) {
                aIleBaslayanSehirler.add(each);
            }
        }
        System.out.println(aIleBaslayanSehirler);

        // eger tum datayi java da kullanilabilir bir collection a cevirmek istesek
        // en uygun yapi map olur
        // map icin unique degerlere sahip bir sutunu key
        // geriye kalan tum sutunlari ise virgulle ayrilan string ler olarak value yapmaliyiz.
        // key=Turkey value=Ankara, Turkiye, Ankara

        Map<String, String> ulkelerMap=new HashMap<>();
        String key="";
        String value="";
        for (int i=0; i<=workbook.getSheet("Sayfa1").getLastRowNum();i++){
            key=workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
            value=workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString()+", "+
                    workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString()+", "+
                    workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
            ulkelerMap.put(key,value);
        }
        System.out.println(ulkelerMap);



    }
}
