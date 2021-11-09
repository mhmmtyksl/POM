package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GMIBankPage;

public class Test1_GMIBank_PozitifTest {

    @Test
    public void SignInTest() {

        GMIBankPage gmiBankPage=new GMIBankPage();
        gmiBankPage.GMIBankLogin();

        Assert.assertTrue(gmiBankPage.girisOnay.isDisplayed());

    }

    @Test
    public void signOutTest() {
        GMIBankPage gmiBankPage=new GMIBankPage();
        gmiBankPage.girisOnay.click();
        gmiBankPage.signOutButonu.click();


    }
}
