package TestCases;

import Pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.*;

import java.io.IOException;

public class ReservationWithNewGuest {

    WebDriver driver = TestApp2.getInstance().getDriver();

    Loginpage loginpage;
    HomePage homePage;
    FXReservationPage fxReservationPage;
    Createnewguest createnewguest;
    CreateSource createSource;
    Dbconnection dbconnection;

    DBconnectionUtils dBconnectionUtils = new DBconnectionUtils();
    ExcelReader reader = new ExcelReader("src/test/resources/FXIDSDataSheet.xlsx");
    ExcelReader reader2 = new ExcelReader("src/test/resources/Book.xlsx");

    String useremail = reader.getCellData("LoginPage", "Useremail\n", 2);
    String password = reader.getCellData("LoginPage", "Password\n", 2);


    String firstname = reader.getCellData("CreatrnewGuest", "firstname", 3);
    String middlename = reader.getCellData("CreatrnewGuest", "middlename\n", 3);
    String lastname = reader.getCellData("CreatrnewGuest", "lastname\n", 3);
    String email = reader.getCellData("CreatrnewGuest", "email\n", 3);
    String mobile = reader.getCellData("CreatrnewGuest", "mobile\n", 3);

    String roomcountforcreation = reader.getCellData("setRate", "Roomcount\n", 2);
    String rate = reader.getCellData("setRate", "Rate\n", 2);

//create new travel agent


    String travelagentname = reader.getCellData("CreateTravelAgent", "Name\n", 2);
    String contactname = reader.getCellData("CreateTravelAgent", "Contactname\n", 2);
    String mobiletravel = reader.getCellData("CreateTravelAgent", "Mobile\n", 2);

    //create new source
    String sourcename = reader.getCellData("CreateSource", "Name\n", 2);
    String sourcecontactname = reader.getCellData("CreateSource", "Contactname\n", 2);
    String sourcemobile = reader.getCellData("CreateSource", "Mobile\n", 2);
    PropertyFileReader prop = new PropertyFileReader();
    String visitpurposes = prop.getProperty("sql", "VisitPurpose");
    String Customertype = prop.getProperty("sql", "Customertype");

  //  String visitpurpose = dBconnectionUtils.Dbconnect(visitpurposes);
  //  String customertype = dBconnectionUtils.Dbconnect(Customertype);


    @BeforeMethod
    public void setUp() {
        TestApp2.getInstance().getDriver();
        TestApp2.getInstance().openBrowser();
        TestApp2.getInstance().navigateToURL();

    }


    @Test
    public void testReservationWithNewGuest() throws InterruptedException, IOException {

        dbconnection = new Dbconnection();
        loginpage = new Loginpage();
        homePage = new HomePage();
        fxReservationPage = new FXReservationPage();
        createnewguest = new Createnewguest();
        createSource = new CreateSource();


        loginpage.setuseremail(useremail)
                .setpassword(password)
                .clickLogin()
                .clickFXReservation()
                //    .setname(firstname)
                .clicknewGuestcreate()
                .SetTitle("Mr")
                //  .uploadPic();
                .setfirstname(firstname)

                .setmiddlename(middlename)
                .setLastname(lastname)
                //  .setGendder("Male")
                .setemail(email)

                //   .setISD("+93", Keys.TAB)
                .setmobile(mobile, "Indian")
                //   .setCompanyDetails("Kiran",Keys.TAB,"softwareengineer","abcd")

                .clickSave()
                .checktitleofguest();

        String nameoutput = createnewguest.checktitleofguest();

        Assert.assertEquals(nameoutput, firstname + " " + middlename + " " + lastname, "New guest is created successfully");
        TakeScreenShot.TakeScreenshot("Guestnewcreate");



        createnewguest.closewindow();


        Thread.sleep(2000);

        fxReservationPage.setNight_GO(roomcountforcreation)
                         .ClickRate_set(rate,"RATESLB - 256");
        Thread.sleep(2000);
        fxReservationPage.clickFetchRate();


       fxReservationPage//.setPurposeofcustomertype(visitpurpose)
                          //.setCustomertype(customertype)
                          .clickConfirmRate()
                          .clickSaveReservation();

       TakeScreenShot.TakeScreenshot("NewGuest");

        //  WebElement FINALELEMENT=driver.findElement(By.xpath("//*[@id=\"myModal\"]/div"));
        boolean eleSelected = TestApp2.getInstance().getDriver().findElement(By.xpath("//*[@id=\"myModal\"]/div/div[1]/h2")).isDisplayed();
        if (eleSelected == true) {
            reader2.setCellData("Scenarios", "Status", 2, "passed");
        } else {
            reader2.setCellData("Scenarios", "Status", 2, "failed");
        }


    }
}






