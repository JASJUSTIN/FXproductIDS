package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.PropertyFileReader;
import utils.TakeScreenShot;
import utils.TestApp2;

import java.io.IOException;

public class CreateCompany {

    WebDriver driver= TestApp2.getInstance().getDriver();


    PropertyFileReader prop=new PropertyFileReader();
    String nameelement=prop.getProperty("CreateCompany","companyname.element");
    String classficationelement=prop.getProperty("CreateCompany","classificaion.element");
    String insideclassification=prop.getProperty("CreateCompany","insideelement.element");
    String contactnameelement=prop.getProperty("CreateCompany","contactname.comapny.element");
    String emailcompanyelement=prop.getProperty("CreateCompany","email.company.element");
    String isdelement=prop.getProperty("CreateCompany","isd.company.element");
    String insideisdelement=prop.getProperty("CreateCompany","inside.isd.element");
    String companymobileelement=prop.getProperty("CreateCompany","mobile.company.element");
    String addresselement=prop.getProperty("CreateCompany","Address.company.element");


    String SAVECOMPANYelement=prop.getProperty("CreateCompany","Save.company.button");
  //  String nameelement=prop.getProperty("CreateCompany","companyname.element");
//    String nameelement=prop.getProperty("CreateCompany","companyname.element");
//    String nameelement=prop.getProperty("CreateCompany","companyname.element");





    public CreateCompany setCompanyNmae(String Companyname) throws InterruptedException {
        Thread.sleep(2000);
        TestApp2.getInstance().waitForElement(By.xpath(nameelement),30);
        driver.findElement(By.xpath(nameelement)).sendKeys(Companyname);
        return this;
    }

    public CreateCompany setCompanycontactname(String comcontactname)
    {
        driver.findElement(By.xpath(contactnameelement)).sendKeys(comcontactname);
        return this;
    }

    public CreateCompany setMobilenumber(String companyMobile)
    {
        driver.findElement(By.xpath(companymobileelement)).sendKeys(companyMobile);
        return this;
    }

    public FXReservationPage ClickSaaveButton() throws InterruptedException, IOException {
        TestApp2.getInstance().waitForElement(By.xpath(SAVECOMPANYelement),30);
        driver.findElement(By.xpath(SAVECOMPANYelement)).click();
        Thread.sleep(2000);
        TakeScreenShot.TakeScreenshot("Company is created new");
        return new FXReservationPage();

    }

}
