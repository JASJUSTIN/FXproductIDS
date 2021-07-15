package TestCases;

import Pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.*;

import java.io.IOException;

public class ReservationWithExistingGuest {

    WebDriver driver= TestApp2.getInstance().getDriver();

    Loginpage loginpage;
    HomePage homePage;
    FXReservationPage fxReservationPage;
    Createnewguest createnewguest;
    CreateSource createSource;
    DBconnectionUtils dBconnectionUtils =new DBconnectionUtils();





    ExcelReader reader =new ExcelReader("src/test/resources/FXIDSDataSheet.xlsx");
    //ExcelReader reader2=new ExcelReader("src/test/resources/Book.xlsx");

    String useremail=reader.getCellData("LoginPage","Useremail\n",2);
    String password=reader.getCellData("LoginPage","Password\n",2);
 //    int rowcounts=reader2.getRowCount("Scenarios");

    String firstname=reader.getCellData("CreatrnewGuest","firstname",15);
    String middlename=reader.getCellData("CreatrnewGuest","middlename\n",15);
    String lastname=reader.getCellData("CreatrnewGuest","lastname\n",15);
    String email=reader.getCellData("CreatrnewGuest","email\n",15);
    String mobile=reader.getCellData("CreatrnewGuest","mobile\n",15);

   PropertyFileReader prop=new PropertyFileReader();
   String Firstname=prop.getProperty("sql","Existingguestname");
   String visitpurposes=prop.getProperty("sql","VisitPurpose");
    String Customertype=prop.getProperty("sql","Customertype");

    String roomcountforcreation=reader.getCellData("setRate","Roomcount\n",2);
    String rate=reader.getCellData("setRate","Rate\n",2);

//create new travel agent


     String FIRSTNAME=dBconnectionUtils.Dbconnect(Firstname,"6200");
  //  String visitpurpose=dBconnectionUtils.Dbconnect(visitpurposes);
  //  String customertype=dBconnectionUtils.Dbconnect(Customertype);


    String travelagentname=reader.getCellData("CreateTravelAgent","Name\n",2);
    String contactname=reader.getCellData("CreateTravelAgent","Contactname\n",2);
    String mobiletravel=reader.getCellData("CreateTravelAgent","Mobile\n",2);

    //create new source
    String sourcename=reader.getCellData("CreateSource","Name\n",2);
    String sourcecontactname=reader.getCellData("CreateSource","Contactname\n",2);
    String sourcemobile=reader.getCellData("CreateSource","Mobile\n",2);





    @BeforeMethod
    public void setUp() {

        // dBconnectionUtils.Dbconnect();

        TestApp2.getInstance().getDriver();
        TestApp2.getInstance().openBrowser();
        TestApp2.getInstance().navigateToURL();


    }

    @Test
    public void testReservationWithExistingGuest() throws InterruptedException, IOException {


        loginpage=new Loginpage();
        homePage=new HomePage();
        fxReservationPage =new FXReservationPage();
        createnewguest =new Createnewguest();
        createSource=new CreateSource();




       loginpage.setuseremail(useremail)
                .setpassword(password)
                .clickLogin()
                .clickFXReservation()
                .SETGUESTNAME(FIRSTNAME);

        // room details
            fxReservationPage.setNight_GO(roomcountforcreation)
                                 .ClickRate_set(rate,"RATESLB - 256")
                                 .clickFetchRate()
                                 //.setPurposeofcustomertype(visitpurpose)
                                // .setCustomertype(customertype)
                                 .clickConfirmRate();






                             //    .clickSaveReservation();







}

    @AfterMethod
    public void tearDown() throws IOException {
     /*   TakeScreenShot.TakeScreenshot("ExistingGuest");

        boolean eleSelected= driver.findElement(By.xpath("//*[@id=\"myModal\"]/div")).isDisplayed();
        if (eleSelected==true)
        {
            reader2.setCellData("Scenarios","Status",3,"passed");
        }
        else
        {
            reader2.setCellData("Scenarios","Status",3,"failed");
        }
        TestApp2.getInstance().getDriver().close();*/

    }
}
