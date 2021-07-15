package TestCases;

import Pages.FXReservationPage;
import Pages.HomePage;
import Pages.Loginpage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.ExcelReader;
import utils.TestApp2;

public class Mdnthrowexception {

    Loginpage loginpage;
    HomePage homePage;
    FXReservationPage fxReservationPage;
    ExcelReader reader = new ExcelReader("src/test/resources/FXIDSDataSheet.xlsx");
    String useremail = reader.getCellData("LoginPage", "Useremail\n", 2);
    String password = reader.getCellData("LoginPage", "Password\n", 2);


    @BeforeTest
    public void testCheckForMDM() throws InterruptedException {

        TestApp2.getInstance().getDriver();
        TestApp2.getInstance().openBrowser();
        TestApp2.getInstance().navigateToURL();
        fxReservationPage = new FXReservationPage();
        Thread.sleep(2000);
        //button[@type='button']

        loginpage = new Loginpage();
        homePage = new HomePage();
        fxReservationPage = new FXReservationPage();
        loginpage.setuseremail(useremail)
                .setpassword(password)
                .clickLogin()
                .clickFXReservation();
        Thread.sleep(3000);




       boolean VALUE=TestApp2.getInstance().getDriver().findElement(By.xpath("//*[text()=\" MDM \"]")).isDisplayed();
        //Assert.assertEquals("","","");
     //   Assert.assertTrue(VALUE==false,"MDM is enabled So cant continue tests");


    }

    @Test(priority=1)
    public void testName()

    {
        System.out.println("priority 1");
    }

    @Test( priority=2)
    public void test0()
    {
        System.out.println("priority 2");
    }


    @Test(priority=0)
    public void test1()
    {
        System.out.println("priority 0");
    }

}
