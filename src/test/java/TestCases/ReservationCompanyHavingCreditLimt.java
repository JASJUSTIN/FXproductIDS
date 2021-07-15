package TestCases;

import Pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.*;

import java.io.IOException;

public class ReservationCompanyHavingCreditLimt {


    WebDriver driver = TestApp2.getInstance().getDriver();

    Loginpage loginpage;
    HomePage homePage;
    FXReservationPage fxReservationPage;
    Createnewguest createnewguest;
    CreateSource createSource;
    DBconnectionUtils dBconnectionUtils = new DBconnectionUtils();


   ExcelReader reader = new ExcelReader("src/test/resources/FXIDSDataSheet.xlsx");
  //  ExcelReader reader2 = new ExcelReader("src/test/resources/Book.xlsx");

    String useremail = reader.getCellData("LoginPage", "Useremail\n", 2);
      String password = reader.getCellData("LoginPage", "Password\n", 2);
  //  int rowcounts = reader2.getRowCount("Scenarios");


    PropertyFileReader prop = new PropertyFileReader();

    String Firstname = prop.getProperty("sql", "Existingguestname");
    String visitpurposes = prop.getProperty("sql", "VisitPurpose");
    String Customertype = prop.getProperty("sql", "Customertype");
    String Companynamewithcreditlimit = prop.getProperty("sql", "Companynamewithcredit");
    String Companylimit = prop.getProperty("sql", "Creditlimitofcompany");

    String roomcountforcreation = reader.getCellData("setRate", "Roomcount\n", 2);
    String rate = reader.getCellData("setRate", "Rate\n", 2);
//create new travel agent


    String FIRSTNAME = dBconnectionUtils.Dbconnect(Firstname,"6200");
  //  String visitpurpose = dBconnectionUtils.Dbconnect(visitpurposes);
   // String customertype = dBconnectionUtils.Dbconnect(Customertype);
    String Companyname = dBconnectionUtils.Dbconnect(Companynamewithcreditlimit,"917");
    String Companylimitamout = dBconnectionUtils.Dbconnect(Companylimit,"917");

    // String roomcountforcreation=reader.getCellData("setRate","Roomcount\n",2);
    String travelagentname = reader.getCellData("CreateTravelAgent", "Name\n", 2);
    String contactname = reader.getCellData("CreateTravelAgent", "Contactname\n", 2);
    String mobiletravel = reader.getCellData("CreateTravelAgent", "Mobile\n", 2);

    //create new source
    String sourcename = reader.getCellData("CreateSource", "Name\n", 2);
    String sourcecontactname = reader.getCellData("CreateSource", "Contactname\n", 2);
    String sourcemobile = reader.getCellData("CreateSource", "Mobile\n", 2);


    @BeforeMethod
    public void setUp() {

        // System.out.println(Companyname);
        //   System.out.println(Companylimitamout);
        String creditlimit = Companylimitamout;
        float creditlimitfloat = Float.parseFloat(creditlimit);
        int CreditAmoutInt;
        CreditAmoutInt = Math.round(creditlimitfloat);

        int reducedamount = CreditAmoutInt - 2000;
        String VALUE = Integer.toString(reducedamount);


        String NEW = String.valueOf(new Integer(reducedamount));


        TestApp2.getInstance().getDriver();
        TestApp2.getInstance().openBrowser();
        TestApp2.getInstance().navigateToURL();


    }


    @Test
    public void testReservationWithCompanyHavingCreditLimit() throws InterruptedException, IOException {


        loginpage = new Loginpage();
        homePage = new HomePage();
        fxReservationPage = new FXReservationPage();
        createnewguest = new Createnewguest();
        createSource = new CreateSource();


        loginpage.setuseremail(useremail)
                .setpassword(password)
                .clickLogin()
                .clickFXReservation();
      /*          .SETGUESTNAME(FIRSTNAME)
                .setCompanyname(Companyname);

        fxReservationPage.setNight_GO(roomcountforcreation)
                .ClickRate_set(rate)
                .clickLoad1();

        Thread.sleep(2000);
        fxReservationPage.setChargeLimit()


                .setPurposeofcustomertype(visitpurpose)
                .setCustomertype(customertype)
                .clickConfirmRate()
                .clickSaveReservation();


    }

    @AfterMethod
    public void tearDown() throws IOException {

        System.out.println(FIRSTNAME);
      /*  TakeScreenShot.TakeScreenshot("CompanyHavingCreditLimit");

        boolean eleSelected = TestApp2.getInstance().getDriver().findElement(By.xpath("//*[@id=\"myModal\"]/div/div[1]/h2")).isDisplayed();
        if (eleSelected == true) {
            System.out.println("ReservationWithCompanyHavingCreditLimit is Passed");
            reader2.setCellData("Scenarios", "Status", 10, "passed");
        } else {
            reader2.setCellData("Scenarios", "Status", 10, "failed");
        }

        TestApp2.getInstance().getDriver().close();*/
    }
}