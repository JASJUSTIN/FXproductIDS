package TestCases;

import Pages.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.*;

import java.io.IOException;

public class CreateGuestDiffrentDifferentScenarios {

    Loginpage loginpage;
    HomePage homePage;
    FXReservationPage fxReservationPage;
    Createnewguest createnewguest;
    CreateSource createSource;
    Dbutils2 dbutils2;
    DBconnectionUtils dBconnectionUtils = new DBconnectionUtils();
    private String NewCreatedGuestID;


    ExcelReader reader = new ExcelReader("src/test/resources/FXReservationMasterDataFile.xlsx");

    //data-1
    String Title=reader.getCellData("Createguest","Data_2\n",11);
    String lastname=reader.getCellData("Createguest","Data_2\n",14);
    String sex=reader.getCellData("Createguest","Data_2\n",15);
    String email=reader.getCellData("Createguest","Data_2\n",16);
    String mobile=reader.getCellData("Createguest","Data_2\n",18);
    String Nationality=reader.getCellData("Createguest","Data_2\n",19);


    //data_3

    String Title3=reader.getCellData("Createguest","Date_3\n",11);
    String firstname3=reader.getCellData("Createguest","Date_3\n",12);
    String middlename3=reader.getCellData("Createguest","Date_3\n",13);
    String lastname3=reader.getCellData("Createguest","Date_3\n",14);
    String sex3=reader.getCellData("Createguest","Date_3\n",15);
    String email3=reader.getCellData("Createguest","Date_3\n",16);
    String mobile3=reader.getCellData("Createguest","Date_3\n",18);
    String Nationality3=reader.getCellData("Createguest","Date_3\n",19);
    String gstnumber=reader.getCellData("Createguest","Date_3\n",34);

    //data_4
    String Title4=reader.getCellData("Createguest","Date_4\n",11);
    String firstname4=reader.getCellData("Createguest","Date_4\n",12);
    String middlename4=reader.getCellData("Createguest","Date_4\n",13);
    String lastname4=reader.getCellData("Createguest","Date_4\n",14);
    String sex4=reader.getCellData("Createguest","Date_4\n",15);
    String email4=reader.getCellData("Createguest","Date_4\n",16);
    String mobile4=reader.getCellData("Createguest","Date_4\n",18);
    String Nationality4=reader.getCellData("Createguest","Date_4\n",19);
    String Address4=reader.getCellData("Createguest","Date_4\n",42);
    String country4=reader.getCellData("Createguest","Date_4\n",43);
    String state4=reader.getCellData("Createguest","Date_4\n",44);
    String city4=reader.getCellData("Createguest","Date_4\n",45);
    String zip4=reader.getCellData("Createguest","Date_4\n",46);

  //data 5
  String Title5=reader.getCellData("Createguest","Data_5\n",11);
    String firstname5=reader.getCellData("Createguest","Data_5\n",12);
    String middlename5=reader.getCellData("Createguest","Data_5\n",13);
    String lastname5=reader.getCellData("Createguest","Data_5\n",14);
    String sex5=reader.getCellData("Createguest","Data_5\n",15);
    String email5=reader.getCellData("Createguest","Data_5\n",16);
    String mobile5=reader.getCellData("Createguest","Data_5\n",18);
    String Nationality5=reader.getCellData("Createguest","Data_5\n",19);

    //Login User Details
    String useremail = reader.getCellData("UserloginDetails", "Useremail\n", 2);
    String password = reader.getCellData("UserloginDetails", "Password\n", 2);




    PropertyFileReader prop = new PropertyFileReader();
    String Firstname = prop.getProperty("sql", "Existingguestname");





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


    @Test(priority = 0)
    public void testCreateGuestWithMandatoryField() throws InterruptedException, IOException {
        loginpage = new Loginpage();
        homePage = new HomePage();
        fxReservationPage = new FXReservationPage();
        createnewguest = new Createnewguest();
        createSource = new CreateSource();


        fxReservationPage.clicknewGuestcreate()


                        .SetTitle(Title)
                         .setLastname(lastname)
                         .setGendder(sex)
                         .setemail(email)
                         .setmobile(mobile,Nationality)
                         .clickSave()
                         .checktitleofguest();
           createnewguest.closewindow();










    }

    @Test(priority = 1)
    public void testCreatnewGuestWithGSTNumber() throws InterruptedException, IOException {

        TestApp2.getInstance().getDriver().getCurrentUrl();
        TestApp2.getInstance().getDriver().navigate().refresh();

        loginpage = new Loginpage();
        homePage = new HomePage();
        fxReservationPage = new FXReservationPage();
        createnewguest = new Createnewguest();
        createSource = new CreateSource();

//data_3
        fxReservationPage.clicknewGuestcreate()
                .SetTitle(Title3)
                .setfirstname(firstname3)
                .setmiddlename(middlename3)
                .setLastname(lastname3)
                .setGendder(sex3)
                .setemail(email3)
                .setmobile(mobile3,Nationality3)
                .setGSTNumber(gstnumber)
                .clickSave()
                .checktitleofguest();
        createnewguest.closewindow();
        
    }

    @Test(priority = 2)
    public void testCreateGuestWithAddress() throws InterruptedException, IOException {
        TestApp2.getInstance().getDriver().getCurrentUrl();
        TestApp2.getInstance().getDriver().navigate().refresh();

        loginpage = new Loginpage();
        homePage = new HomePage();
        fxReservationPage = new FXReservationPage();
        createnewguest = new Createnewguest();
        createSource = new CreateSource();

//data_4
        fxReservationPage.clicknewGuestcreate()
                         .SetTitle(Title4)
                         .setfirstname(firstname4)
                         .setmiddlename(middlename4)
                         .setLastname(lastname4)
                         .setGendder(sex4)
                         .setemail(email4)
                         .setmobile(mobile4,Nationality4)
                         .setAddress(Address4)
                         .setCountry(country4)
                         .setState(state4)
                         .setCity(city4)
                         .setZip(zip4)
                        .clickSave()
                .checktitleofguest();
        createnewguest.closewindow();

    }

//data 05
    @Test(priority = 3)
    public void testCreateGuestWithPancardNumber() throws InterruptedException {


        TestApp2.getInstance().getDriver().getCurrentUrl();
        TestApp2.getInstance().getDriver().navigate().refresh();

        loginpage = new Loginpage();
        homePage = new HomePage();
        fxReservationPage = new FXReservationPage();
        createnewguest = new Createnewguest();
        createSource = new CreateSource();

        fxReservationPage.clicknewGuestcreate()
                .SetTitle(Title5)
                .setfirstname(firstname5)
                .setmiddlename(middlename5)
                .setLastname(lastname5)
                .setGendder(sex5)
                .setemail(email5)
                .setmobile(mobile5,Nationality5)
                .setPANCardNumber("");


    }

    //data 8
    @Test(priority = 4 )
    public void testCreateGuestWithFirstnameAndLastname() throws InterruptedException {
        TestApp2.getInstance().getDriver().getCurrentUrl();
        TestApp2.getInstance().getDriver().navigate().refresh();


        loginpage = new Loginpage();
        homePage = new HomePage();
        fxReservationPage = new FXReservationPage();
        createnewguest = new Createnewguest();
        createSource = new CreateSource();

        fxReservationPage.clicknewGuestcreate()
                .SetTitle("")
                .setfirstname("")
                .setmiddlename("")
                .setLastname("")
                .setGendder("")
                .setemail("")
                .setmobile("","")
                .setPANCardNumber("");

    }
}
