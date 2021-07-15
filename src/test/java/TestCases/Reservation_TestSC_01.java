package TestCases;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.*;

import java.io.IOException;

public class Reservation_TestSC_01 {

  WebDriver driver= TestApp2.getInstance().getDriver();

    Loginpage loginpage;
    HomePage homePage;
    FXReservationPage fxReservationPage;
    Createnewguest createnewguest;
    CreateSource createSource;
    DBconnectionUtils dBconnectionUtils = new DBconnectionUtils();


    ExcelReader reader = new ExcelReader("src/test/resources/FXIDSDataSheet.xlsx");


    String useremail = reader.getCellData("LoginPage", "Useremail\n", 2);
    String password = reader.getCellData("LoginPage", "Password\n", 2);




    PropertyFileReader prop = new PropertyFileReader();

    String Firstname = prop.getProperty("sql", "Existingguestname");
    String visitpurposes = prop.getProperty("sql", "VisitPurpose");
    String Customertype = prop.getProperty("sql", "Customertype");
    String Companynamewithcreditlimit = prop.getProperty("sql", "Companynamewithcredit");
    String Companylimit = prop.getProperty("sql", "Creditlimitofcompany");

    String roomcountforcreation=reader.getCellData("setRate","Roomcount\n",2);
    String rate=reader.getCellData("setRate","Rate\n",2);
//create new travel agent


    String FIRSTNAME = dBconnectionUtils.Dbconnect(Firstname,"6200");
   // String visitpurpose = dBconnectionUtils.Dbconnect(visitpurposes);
 //   String customertype = dBconnectionUtils.Dbconnect(Customertype);
    String Companyname = dBconnectionUtils.Dbconnect(Companynamewithcreditlimit,"917");
    String Companylimitamout = dBconnectionUtils.Dbconnect(Companylimit,"917");

    @BeforeTest
    public void LoginFx() throws InterruptedException {


        TestApp2.getInstance().getDriver();
        TestApp2.getInstance().openBrowser();
        TestApp2.getInstance().navigateToURL();

        loginpage = new Loginpage();
        homePage = new HomePage();
        fxReservationPage = new FXReservationPage();
        createnewguest = new Createnewguest();
        createSource = new CreateSource();


        loginpage.setuseremail(useremail)
                 .setpassword(password)
                 .clickLogin()
                 .clickFXReservation();

    }

    @Test(priority = 0)
    public void testReservationWithCompanyHavingCreditLimit() throws InterruptedException, IOException {

        String creditlimit = Companylimitamout;
        float creditlimitfloat = Float.parseFloat(creditlimit);
        int CreditAmoutInt;
        CreditAmoutInt = Math.round(creditlimitfloat);

        int reducedamount = CreditAmoutInt - 2000;
        String VALUE = Integer.toString(reducedamount);


       // String NEW = String.valueOf(new Integer(reducedamount));

        fxReservationPage.SETGUESTNAME(FIRSTNAME)
                         .setCompanyname(Companyname);

          fxReservationPage.setNight_GO("1")


                           .ClickRate_set(rate,"RATESLB - 256")
                           .clickFetchRate();

            Thread.sleep(2000);
            fxReservationPage.setChargeLimit()


         //       .setPurposeofcustomertype(visitpurpose)
             //   .setCustomertype(customertype)
                .clickConfirmRate();
                 Thread.sleep(3000);
                 TakeScreenShot.TakeScreenshot("VerifyRateAmountAndTotal");
                 fxReservationPage.clickSaveReservation();



    }

    @Test(priority = 1)
    public void testReservationExistingGuestWithExistingCompany() throws InterruptedException, IOException {

        WebDriver driver=TestApp2.getInstance().getDriver();

        String currenturl=driver.getCurrentUrl();
        System.out.println(currenturl);
        driver.get(currenturl);
        driver.navigate().refresh();

        fxReservationPage .SETGUESTNAME(FIRSTNAME)
                          .setCompanyname(Companyname);



        Thread.sleep(2000);

        fxReservationPage.setNight_GO(roomcountforcreation)
                .ClickRate_set(rate,"RATESLB - 256")
                .clickFetchRate()


          //      .setPurposeofcustomertype(visitpurpose)
          //      .setCustomertype(customertype)
                .clickConfirmRate()
                .clickSaveReservation();



    }
}
