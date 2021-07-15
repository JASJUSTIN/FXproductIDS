package TestCases;

import Pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.*;

import java.io.IOException;

public class ReservationNewGuestWithNewCompany {

    WebDriver driver= TestApp2.getInstance().getDriver();

    Loginpage loginpage;
    HomePage homePage;
    FXReservationPage fxReservationPage;
    Createnewguest createnewguest;
    CreateSource createSource;
    Dbconnection dbconnection;

    DBconnectionUtils dBconnectionUtils = new DBconnectionUtils();
    ExcelReader reader =new ExcelReader("src/test/resources/FXIDSDataSheet.xlsx");
    ExcelReader reader2=new ExcelReader("src/test/resources/Book.xlsx");
    String useremail=reader.getCellData("LoginPage","Useremail\n",2);
    String password=reader.getCellData("LoginPage","Password\n",2);

    // NEW GUEST CREATION
    String firstname=reader.getCellData("CreatrnewGuest","firstname",15);
    String middlename=reader.getCellData("CreatrnewGuest","middlename\n",15);
    String lastname=reader.getCellData("CreatrnewGuest","lastname\n",15);
    String email=reader.getCellData("CreatrnewGuest","email\n",15);
    String mobile=reader.getCellData("CreatrnewGuest","mobile\n",15);

    //
    String rate=reader.getCellData("setRate","Rate\n",2);
    String Nationality=reader.getCellData("CreatrnewGuest","Nationality\n",2);

    //NEW COMPANY CREATION
    //Company new creation from my excelsheet
    String Companyname=reader.getCellData("CreateCompany","Name\n",4);
    String Companycontactname=reader.getCellData("CreateCompany","Contactname\n",4);
    String companymobile=reader.getCellData("CreateCompany","Mobile\n",4);




    PropertyFileReader prop=new PropertyFileReader();
    String visitpurposes = prop.getProperty("sql", "VisitPurpose");
    String Customertype = prop.getProperty("sql", "Customertype");

  //  String visitpurpose = dBconnectionUtils.Dbconnect(visitpurposes);
   // String customertype = dBconnectionUtils.Dbconnect(Customertype);

    String roomcountforcreation=reader.getCellData("setRate","Roomcount\n",2);

    @BeforeMethod
    public void setUp() {
        TestApp2.getInstance().getDriver();
        TestApp2.getInstance().openBrowser();
        TestApp2.getInstance().navigateToURL();

    }


    @Test
    public void testReservationNewGuestWithNewCompany() throws InterruptedException, IOException {

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
             //   .setGendder("Male")
                .setemail(email)

                // .setISD("+93", Keys.TAB)
                .setmobile(mobile,Nationality)
                //  .setCompanyDetails("Kiran",Keys.TAB,"softwareengineer","abcd")

                .clickSave()
                .closewindow();

              fxReservationPage  .ClickNewCompany()
                                 .setCompanyNmae(Companyname)
                                 .setCompanycontactname(Companycontactname)
                                 .setMobilenumber(companymobile)
                                 .ClickSaaveButton();


        fxReservationPage.setNight_GO(roomcountforcreation)
                        .ClickRate_set(rate,"RATESLB - 256")
                       .clickFetchRate();
        Thread.sleep(1000);


        fxReservationPage//.setPurposeofcustomertype(visitpurpose)
                         //.setCustomertype(customertype)
                         .clickConfirmRate()

                       .clickSaveReservation();

        TakeScreenShot.TakeScreenshot("NewGuestWithNewCompany");

        boolean eleSelected= driver.findElement(By.xpath("//*[@id=\"myModal\"]/div")).isDisplayed();
        if (eleSelected==true)
        {
            reader2.setCellData("Scenarios","Status",7,"passed");
        }
        else
        {
            reader2.setCellData("Scenarios","Status",7,"failed");
        }


    }



    }
