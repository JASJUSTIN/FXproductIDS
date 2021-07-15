package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.PropertyFileReader;
import utils.TestApp2;

public class HomePage {

    WebDriver driver= TestApp2.getInstance().getDriver();
    PropertyFileReader prop=new PropertyFileReader();

    String Fereservationelement=prop.getProperty("HomePage","FXReservation");

    public FXReservationPage clickFXReservation() throws InterruptedException
    {



       // Thread.sleep(50000);
        TestApp2.getInstance().waitForElement(By.xpath(Fereservationelement),4000);
        driver.findElement(By.xpath(Fereservationelement)).click();
        return new FXReservationPage();
    }



    }
