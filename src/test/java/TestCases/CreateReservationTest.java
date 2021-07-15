package TestCases;

import Pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ExcelReader;
import utils.TakeFullScreenShots;
import utils.TakeScreenShot;
import utils.TestApp2;

import java.io.IOException;


public class CreateReservationTest {

  WebDriver driver= TestApp2.getInstance().getDriver();

    Loginpage loginpage;
    HomePage homePage;
    FXReservationPage fxReservationPage;
    Createnewguest createnewguest;
    CreateSource createSource;
    Dbconnection dbconnection;


  ExcelReader reader =new ExcelReader("src/test/resources/FXIDSDataSheet.xlsx");

  String useremail=reader.getCellData("LoginPage","Useremail\n",2);
  String password=reader.getCellData("LoginPage","Password\n",2);


  String firstname=reader.getCellData("CreatrnewGuest","firstname",15);
  String middlename=reader.getCellData("CreatrnewGuest","middlename\n",15);
  String lastname=reader.getCellData("CreatrnewGuest","lastname\n",15);
  String email=reader.getCellData("CreatrnewGuest","email\n",15);
  String mobile=reader.getCellData("CreatrnewGuest","mobile\n",15);


//create new travel agent
    String travelagentname=reader.getCellData("CreateTravelAgent","Name\n",2);
    String contactname=reader.getCellData("CreateTravelAgent","Contactname\n",2);
    String mobiletravel=reader.getCellData("CreateTravelAgent","Mobile\n",2);

    //create new source
    String sourcename=reader.getCellData("CreateSource","Name\n",2);
    String sourcecontactname=reader.getCellData("CreateSource","Contactname\n",2);
    String sourcemobile=reader.getCellData("CreateSource","Mobile\n",2);





    @BeforeMethod
    public void setUp() {
        TestApp2.getInstance().getDriver();
        TestApp2.getInstance().openBrowser();
        TestApp2.getInstance().navigateToURL();

    }


    @Test
    public void testCreateGuest() throws InterruptedException, IOException {

        dbconnection =new Dbconnection();
        loginpage=new Loginpage();
        homePage=new HomePage();
        fxReservationPage =new FXReservationPage();
        createnewguest =new Createnewguest();
        createSource=new CreateSource();




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
                  .setGendder("Male")
                // .setemail(email)

                 .setISD("+93", Keys.TAB)
                 .setmobile(mobile,"Indian")
                .setCompanyDetails("Kiran",Keys.TAB,"softwareengineer","abcd")
                .setCompany_Status_classfication("Vvip","Regular")
                .setDob_Anndate("1993")
              //  .setLinkProfile();
        //data from excelsheet
        //*[@id="mat-slide-toggle-45"]/label/div/div/div[1]
        //*[@id="mat-slide-toggle-45"]/label/div/div/div[1]

                 .clickSave()
                 .checktitleofguest();

        String nameoutput=createnewguest.checktitleofguest();

         Assert.assertEquals(nameoutput,firstname +" "+middlename+" "+lastname,"New guest is created successfully");
        TakeScreenShot.TakeScreenshot("Guestnewcreate");
         System.out.println("TC01 - New Guest is created and successfully validated with names");


        createnewguest.closewindow();


        // create new travel agent

        fxReservationPage.click3dotofTAGENT()
                         .setname(travelagentname)
                         .setContactname(contactname)
                         .setmobile(mobiletravel)

                           .clickSave();

        System.out.println("TC02 - New Travel is created successfully");
        Thread.sleep(1000);
        TakeScreenShot.TakeScreenshot("Travelagentcreate");


        //create new source
        fxReservationPage.clickcreatesource();
         createSource.setSourcename(sourcename)
                    .setsourcecontactname(sourcecontactname)
                    .setsourcemobile(sourcemobile)
                    .ClicksaveSource();


        TakeScreenShot.TakeScreenshot("Sourcecreate");
        System.out.println("TC03 - source is created successfully");


   //Room details
    fxReservationPage.setNight_GO("3")
                      .ClickRate_set("Rack-1","RATESLB - 256")

                      .ClickLoad()
                      .clickConfirmRate();

    TakeScreenShot.TakeScreenshot("Afterclickconfirmrate");

    }
}
