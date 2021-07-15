package TestCases;

import Pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.*;

import java.io.IOException;

public class ReservationNewGuestWithExistingCompany {

    WebDriver driver = TestApp2.getInstance().getDriver();

    Loginpage loginpage;
    HomePage homePage;
    FXReservationPage fxReservationPage;
    Createnewguest createnewguest;
    CreateSource createSource;
    Dbconnection dbconnection;
    DBconnectionUtils dBconnectionUtils = new DBconnectionUtils();


    ExcelReader reader = new ExcelReader("src/test/resources/FXIDSDataSheet.xlsx");
    ExcelReader reader2=new ExcelReader("src/test/resources/Book.xlsx");
    String useremail = reader.getCellData("LoginPage", "Useremail\n", 2);
    String password = reader.getCellData("LoginPage", "Password\n", 2);


    String firstname = reader.getCellData("CreatrnewGuest", "firstname", 19);
    String middlename = reader.getCellData("CreatrnewGuest", "middlename\n", 19);
    String lastname = reader.getCellData("CreatrnewGuest", "lastname\n", 19);
    String email = reader.getCellData("CreatrnewGuest", "email\n", 19);
    String mobile = reader.getCellData("CreatrnewGuest", "mobile\n", 19);
    String ISD=reader.getCellData("CreatrnewGuest","ISD\n",2);
    String title=reader.getCellData("CreatrnewGuest","Title\n",2);
    String Nationality=reader.getCellData("CreatrnewGuest","Nationality\n",2);

      PropertyFileReader prop=new PropertyFileReader();


    String Firstname = prop.getProperty("sql", "sql1");
    String visitpurposes = prop.getProperty("sql", "VisitPurpose");
    String Customertype = prop.getProperty("sql", "Customertype");



    String roomcountforcreation=reader.getCellData("setRate","Roomcount\n",2);
    String rate=reader.getCellData("setRate","Rate\n",2);



 //   String visitpurpose = dBconnectionUtils.Dbconnect(visitpurposes);
   // String customertype = dBconnectionUtils.Dbconnect(Customertype);
    String Existingcompany = prop.getProperty("sql", "ExistingCompany");
    String Companyname=dBconnectionUtils.Dbconnect(Existingcompany,"COM5953");

    @BeforeMethod
    public void setUp() {
        TestApp2.getInstance().getDriver();
        TestApp2.getInstance().openBrowser();
        TestApp2.getInstance().navigateToURL();

    }


    @Test
    public void testReservationNewGuestWithExistingCompany() throws InterruptedException, IOException {

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





               .clicknewGuestcreate()
                .SetTitle(title)
                //AUTOIT Windows automation need to research and do
                //  .uploadPic();
                .setfirstname(firstname)

                .setmiddlename(middlename)
                .setLastname(lastname)
                //.setGendder("Male")
                .setemail(email)
                .setmobile(mobile, Nationality)

              //  .setISD(ISD, Keys.TAB)
                // .setCompanyDetails("Kiran", Keys.TAB, "softwareengineer", "abcd")
                .clickSave();
               createnewguest .closewindow();
                Thread.sleep(2000);


        fxReservationPage .setCompanyname(Companyname);
                           Thread.sleep(2000);

        fxReservationPage.setNight_GO(roomcountforcreation)
                         .ClickRate_set(rate,"RATESLB - 256")
                         .clickFetchRate();

                    Thread.sleep(1000);


         fxReservationPage//.setPurposeofcustomertype(visitpurpose)
                          //.setCustomertype(customertype)
                          .clickConfirmRate()
                       .clickSaveReservation();

         TakeScreenShot.TakeScreenshot("NewGuestWithExistingCompany");

        boolean eleSelected= driver.findElement(By.xpath("//*[@id=\"myModal\"]/div")).isDisplayed();
        if (eleSelected==true)
        {
            reader2.setCellData("Scenarios","Status",6,"passed");
        }
        else
        {
            reader2.setCellData("Scenarios","Status",6,"failed");
        }


    }
}