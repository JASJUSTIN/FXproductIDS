package TestCases;

import Pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.*;

import java.io.IOException;

public class ReservationExistingGuestWithExistingCompany {


    WebDriver driver = TestApp2.getInstance().getDriver();

    Loginpage loginpage;
    HomePage homePage;
    FXReservationPage fxReservationPage;
    Createnewguest createnewguest;
    CreateSource createSource;
    DBconnectionUtils dBconnectionUtils = new DBconnectionUtils();


    ExcelReader reader = new ExcelReader("src/test/resources/FXIDSDataSheet.xlsx");
    ExcelReader reader2 = new ExcelReader("src/test/resources/Book.xlsx");

    String useremail = reader.getCellData("LoginPage", "Useremail\n", 2);
    String password = reader.getCellData("LoginPage", "Password\n", 2);


    String firstname = reader.getCellData("CreatrnewGuest", "firstname", 15);
    String middlename = reader.getCellData("CreatrnewGuest", "middlename\n", 15);
    String lastname = reader.getCellData("CreatrnewGuest", "lastname\n", 15);
    String email = reader.getCellData("CreatrnewGuest", "email\n", 15);
    String mobile = reader.getCellData("CreatrnewGuest", "mobile\n", 15);

    PropertyFileReader prop = new PropertyFileReader();
    String Firstname = prop.getProperty("sql", "Existingguestname");
    String visitpurposes = prop.getProperty("sql", "VisitPurpose");
    String Customertype = prop.getProperty("sql", "Customertype");

    String Existingcompany = prop.getProperty("sql", "ExistingCompany");

//create new travel agent


 //

   // String Companyname = dBconnectionUtils.Dbconnect(Existingcompany);
    String roomcountforcreation=reader.getCellData("setRate","Roomcount\n",2);
    String rate=reader.getCellData("setRate","Rate\n",2);
    String travelagentname = reader.getCellData("CreateTravelAgent", "Name\n", 2);
    String contactname = reader.getCellData("CreateTravelAgent", "Contactname\n", 2);
    String mobiletravel = reader.getCellData("CreateTravelAgent", "Mobile\n", 2);

    //create new source
    String sourcename = reader.getCellData("CreateSource", "Name\n", 2);
    String sourcecontactname = reader.getCellData("CreateSource", "Contactname\n", 2);
    String sourcemobile = reader.getCellData("CreateSource", "Mobile\n", 2);


    // setrate from excel sheet



    //Db connection via sql properties file
  String FIRSTNAME = dBconnectionUtils.Dbconnect(Firstname,"6200");
  String Companyname=dBconnectionUtils.Dbconnect(Existingcompany,"COM5953");
 // String visitpurpose = dBconnectionUtils.Dbconnect(visitpurposes);
 // String customertype = dBconnectionUtils.Dbconnect(Customertype);
//
    @BeforeMethod
    public void setUp() {




        TestApp2.getInstance().getDriver();
        TestApp2.getInstance().openBrowser();
        TestApp2.getInstance().navigateToURL();





    }
    @Test
    public void testReservationExistingGuestWithExistingCompany() throws InterruptedException, IOException {


        loginpage = new Loginpage();
        homePage = new HomePage();
        fxReservationPage = new FXReservationPage();
        createnewguest = new Createnewguest();
        createSource = new CreateSource();
        dBconnectionUtils=new DBconnectionUtils();


      //  System.out.println(visitpurpose);
     //   System.out.println(customertype);

        loginpage.setuseremail(useremail)
                .setpassword(password)
                .clickLogin()
                .clickFXReservation()

                .SETGUESTNAME(FIRSTNAME)
                .setCompanyname(Companyname);


              Thread.sleep(2000);

        fxReservationPage.setNight_GO(roomcountforcreation)
                .ClickRate_set(rate,"RATESLB - 256")
                .clickFetchRate();


              //  .setPurposeofcustomertype(visitpurpose)
              //  .setCustomertype(customertype)
        fxReservationPage            .clickConfirmRate()
                .clickSaveReservation();




    }

    @AfterMethod
    public void tearDown() throws IOException {
        TakeScreenShot.TakeScreenshot("ExistingGuestWithExistingCompany");

        boolean eleSelected = TestApp2.getInstance().getDriver().findElement(By.xpath("//*[@id=\"myModal\"]/div/div[1]/h2")).isDisplayed();
        if (eleSelected == true) {
            System.out.println("ExistingGuestWithExistingCompany is Passed");
            reader2.setCellData("Scenarios", "Status", 5, "passed");
        } else {
            reader2.setCellData("Scenarios", "Status", 5, "failed");
        }
        TestApp2.getInstance().getDriver().close();
    }
}