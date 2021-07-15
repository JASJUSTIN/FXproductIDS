package TestCases;

import Pages.*;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.*;

import java.io.IOException;

public class ReservationExistingGuestWithNewCompany {

    Loginpage loginpage;
    HomePage homePage;
    FXReservationPage fxReservationPage;
    Createnewguest createnewguest;
    CreateSource createSource;
    DBconnectionUtils dBconnectionUtils = new DBconnectionUtils();


    ExcelReader reader = new ExcelReader("src/test/resources/FXIDSDataSheet.xlsx");
    ExcelReader reader2 = new ExcelReader("src/test/resources/Book.xlsx");
    String roomcountforcreation=reader.getCellData("setRate","Roomcount\n",2);
    String rate=reader.getCellData("setRate","Rate\n",2);

    String useremail = reader.getCellData("LoginPage", "Useremail\n", 2);
    String password = reader.getCellData("LoginPage", "Password\n", 2);

    //Company new creation from my excelsheet
    String Companyname=reader.getCellData("CreateCompany","Name\n",4);
    String Companycontactname=reader.getCellData("CreateCompany","Contactname\n",4);
    String companymobile=reader.getCellData("CreateCompany","Mobile\n",4);

    // setRate
    String rateforcreation=reader.getCellData("setRate","Rate\n",2);
    //roomcount


    PropertyFileReader prop = new PropertyFileReader();
    String Firstname = prop.getProperty("sql", "Existingguestname");
    String visitpurposes = prop.getProperty("sql", "VisitPurpose");
    String Customertype = prop.getProperty("sql", "Customertype");





    String FIRSTNAME = dBconnectionUtils.Dbconnect(Firstname,"6200");
  //  String visitpurpose = dBconnectionUtils.Dbconnect(visitpurposes);
  //  String customertype = dBconnectionUtils.Dbconnect(Customertype);


    @BeforeMethod
    public void setUp() {

        // dBconnectionUtils.Dbconnect();

        TestApp2.getInstance().getDriver();
        TestApp2.getInstance().openBrowser();
        TestApp2.getInstance().navigateToURL();


    }

    @AfterMethod
    public void tearDown() throws IOException {
        TakeScreenShot.TakeScreenshot("ExistingGuestWithNewCompany");

        boolean eleSelected = TestApp2.getInstance().getDriver().findElement(By.xpath("//*[@id=\"myModal\"]/div/div[1]/h2")).isDisplayed();
        if (eleSelected == true) {
            reader2.setCellData("Scenarios", "Status", 4, "passed");
        } else {
            reader2.setCellData("Scenarios", "Status", 4, "failed");
        }
        TestApp2.getInstance().getDriver().close();
    }

    @Test
    public void testReservationExistingGuestWithNewCompany() throws InterruptedException, IOException {


        loginpage = new Loginpage();
        homePage = new HomePage();
        fxReservationPage = new FXReservationPage();
        createnewguest = new Createnewguest();
        createSource = new CreateSource();



       System.out.println(rateforcreation);
        loginpage.setuseremail(useremail)
                .setpassword(password)
                .clickLogin()
                .clickFXReservation()
                .SETGUESTNAME(FIRSTNAME)
                .ClickNewCompany()
                .setCompanyNmae(Companyname)
                .setCompanycontactname(Companycontactname)
                .setMobilenumber(companymobile)
                .ClickSaaveButton();


             fxReservationPage.setNight_GO(roomcountforcreation)
                              .ClickRate_set(rate,"RATESLB - 256")
                              .clickFetchRate();
             Thread.sleep(1000);



        fxReservationPage //.setPurposeofcustomertype(visitpurpose)
                          //.setCustomertype(customertype)
                          .clickConfirmRate()
                          .clickSaveReservation();

        TakeScreenShot.TakeScreenshot("ExistingGuestWithNewCompany");
        boolean eleSelected = TestApp2.getInstance().getDriver().findElement(By.xpath("//*[@id=\"myModal\"]/div/div[1]/h2")).isDisplayed();
        if (eleSelected == true) {
            System.out.println("ExistingGuestWithNewCompany is Passed");
            reader2.setCellData("Scenarios", "Status", 4, "passed");
        } else {
            reader2.setCellData("Scenarios", "Status", 4, "failed");
        }


    }
}













