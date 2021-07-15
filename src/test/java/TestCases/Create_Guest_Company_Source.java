package TestCases;

import Pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.*;

import java.io.IOException;
import java.util.List;

public class Create_Guest_Company_Source {


    Loginpage loginpage;
    HomePage homePage;
    FXReservationPage fxReservationPage;
    Createnewguest createnewguest;
    CreateSource createSource;
    Dbutils2 dbutils2;
    DBconnectionUtils dBconnectionUtils = new DBconnectionUtils();
    private String NewCreatedGuestID;


    ExcelReader reader = new ExcelReader("src/test/resources/FXReservationMasterDataFile.xlsx");


    String useremail = reader.getCellData("UserloginDetails", "Useremail\n", 2);
    String password = reader.getCellData("UserloginDetails", "Password\n", 2);

    String firstnameofnewguest = reader.getCellData("CreateGuestforSC", "Firstname\n", 21);
    String middlenameofnewguest = reader.getCellData("CreateGuestforSC", "Middlename\n", 21);
    String lastnameofnewguest = reader.getCellData("CreateGuestforSC", "Lastname\n", 21);
    String ISDofnewguest = reader.getCellData("CreateGuestforSC", "ISD\n", 21);
    String mobileofnewguest = reader.getCellData("CreateGuestforSC", "Mobile\n", 21);
    String emailofnewguest = reader.getCellData("CreateGuestforSC", "Email\n", 21);


    PropertyFileReader prop = new PropertyFileReader();
    String Firstname = prop.getProperty("sql", "Existingguestname");


    String Companynamewithcreditlimit = prop.getProperty("sql", "Companynamewithcredit");
    String Companylimit = prop.getProperty("sql", "Creditlimitofcompany");

    String roomcountforcreation = reader.getCellData("setRate", "Roomcount\n", 2);
    String rate = reader.getCellData("setRate", "Rate\n", 2);


    @BeforeTest
    public void setUp() throws InterruptedException {

        TestApp2.getInstance().getDriver();
        TestApp2.getInstance().openBrowser();
        TestApp2.getInstance().navigateToURL();

        loginpage = new Loginpage();
        homePage = new HomePage();
        fxReservationPage = new FXReservationPage();
        createnewguest = new Createnewguest();
        createSource = new CreateSource();
        dbutils2 = new Dbutils2();


        loginpage.setuseremail(useremail)
                .setpassword(password)
                .clickLogin()
                .clickFXReservation();


    }

    @Test(priority = 1)
    public void testCreateNewGuestforSC() throws InterruptedException, IOException {

        // dbconnection = new Dbconnection();
        loginpage = new Loginpage();
        homePage = new HomePage();
        fxReservationPage = new FXReservationPage();
        createnewguest = new Createnewguest();
        createSource = new CreateSource();


        fxReservationPage.clicknewGuestcreate()
                .SetTitle("Mr")
                .setfirstname(firstnameofnewguest)
                .setmiddlename(middlenameofnewguest)
                .setLastname(lastnameofnewguest)
                //  .setGendder("Male")
                .setemail(emailofnewguest)

                //   .setISD("+93", Keys.TAB)
                .setmobile(mobileofnewguest, "Indian")
                //   .setCompanyDetails("Kiran",Keys.TAB,"softwareengineer","abcd")

                .clickSave()
                .checktitleofguest();



        String GUESTID = dbutils2.Dbconnect("SELECT MAX(Guestid) FROM guest");

        System.out.println("Your new guest ID is " + GUESTID);
        ExcelReader reader = new ExcelReader("src/test/resources/FXReservationMasterDataFile.xlsx");
        reader.setCellData("CreateGuestforSC", "GuestID\n", 2, GUESTID);

        NewCreatedGuestID = GUESTID;

    }

    //   @Test
    //  public void testCretaeNewCompanyforSC()

    // {


    //  }

    // @Test(dependsOnMethods = "testCreateNewGuestforSC")
    // public void testResrvationExistingGuestWithnewCompany()
    // {

    //  }

    @Test(priority = 1, dependsOnMethods = "testCreateNewGuestforSC")
    public void testResrvaionWithExistingGuest() throws IOException, InterruptedException {

        // String primaryguestname=dBconnectionUtils.Dbconnect(Firstname,NewCreatedGuestID);

        //  fxReservationPage .SETGUESTNAME(primaryguestname);

        fxReservationPage.setNight_GO(roomcountforcreation)
                         .ClickRate_set("Rack-1", "RATESL - RATE");


                         Thread.sleep(2000);
                       fxReservationPage.clickFetchRate();
    int  RATECOUNT=fxReservationPage.ValidateRateAndTotal();

    TakeScreenShot.TakeScreenshot("Please_Check_Rate_ratecatagory");
  //  System.out.println("rATECOUNT IS "+RATECOUNT);
        fxReservationPage       .clickConfirmRate();

         String RATEAMOUNTTEXT= fxReservationPage.RATE();
          String MEALPLANTEXT=  fxReservationPage.Mealplan();
           String ADDONTEXT=    fxReservationPage.Addon();
           String taxamounttext= fxReservationPage.Tax();
            String Totalamounttext=fxReservationPage.Total();


            String ratetext = fxReservationPage.RATE();
          float ratefloat = Float.parseFloat(ratetext);
          int Ratwintamount;
           Ratwintamount = Math.round(ratefloat);


        String mealtext = fxReservationPage.Mealplan();
        float mealfloat = Float.parseFloat(mealtext);
        int mealintamount;
        mealintamount = Math.round(mealfloat);

        String addontext = fxReservationPage.Addon();
        float addfloat = Float.parseFloat(addontext);
        int addonintamount;
        addonintamount = Math.round(addfloat);

        String taxtext = fxReservationPage.Tax();
        float taxfloat = Float.parseFloat(taxtext);
        int taxintamount;
        taxintamount = Math.round(taxfloat);

        String totaltext = fxReservationPage.RATE();
        float totalfloat = Float.parseFloat(totaltext);
        int totalintamount;
        totalintamount = Math.round(totalfloat);

        int Calculation=Ratwintamount+mealintamount+addonintamount+taxintamount;

      //  Assert.assertEquals(totalintamount,Calculation,"Rate calculations are incorrect ");

         fxReservationPage.clickSaveReservation();


    }

    @Test(priority = 1, dependsOnMethods = "testCreateNewGuestforSC")
    public void testReservationNewGuestNewCompany() {

        TestApp2.getInstance().getDriver().navigate().refresh();
        String GUESTID=NewCreatedGuestID;


    }
}

// public void testReservationNewguestNewCompany()

   // {


  //  }
//}

