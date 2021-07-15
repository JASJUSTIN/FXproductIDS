package TestCases;

import Pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.DBconnectionUtils;
import utils.Dbutils2;
import utils.ExcelReader;
import utils.TestApp2;

public class login {


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

    @BeforeMethod
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

    @Test
    public void testTravelAgentCreationData1()
    {

    }
}
