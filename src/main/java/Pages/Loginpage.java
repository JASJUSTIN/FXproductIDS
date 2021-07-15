package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.PropertyFileReader;
import utils.TestApp2;

public class Loginpage {



    WebDriver driver= TestApp2.getInstance().getDriver();

    PropertyFileReader prop=new PropertyFileReader();

    String uemailelement=prop.getProperty("loginpage","useremail");
    String passwordelement=prop.getProperty("loginpage","password");
    String loginbuyyonelement=prop.getProperty("loginpage","Loginbutton");

    public Loginpage setuseremail(String uemail)
    {
        TestApp2.getInstance().waitForElement(By.xpath(uemailelement),80);
        driver.findElement(By.xpath(uemailelement)).sendKeys(uemail);
        return this;


    }


    public Loginpage setpassword(String password)
    {
        driver.findElement(By.xpath(passwordelement)).sendKeys(password);
        return this;
    }

    public HomePage clickLogin()
    {
        driver.findElement(By.xpath(loginbuyyonelement)).click();
        return new HomePage();
    }

}
