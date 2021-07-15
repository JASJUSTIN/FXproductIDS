package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.PropertyFileReader;
import utils.TestApp2;

public class CreateTravelAgent {
    WebDriver driver= TestApp2.getInstance().getDriver();
    PropertyFileReader prop=new PropertyFileReader();

    String nameelement=prop.getProperty("CreateTravelAgent","name.element");
    String contactnameelement=prop.getProperty("CreateTravelAgent","contactname.element");
    String mobile1element=prop.getProperty("CreateTravelAgent","mobilet.element");





    public CreateTravelAgent setname(String travelagent)
    {
       TestApp2.getInstance().waitForElement(By.xpath(nameelement),20);

        Actions actions = new Actions(driver);
        WebElement menu = driver.findElement(By.xpath(nameelement));
        actions.moveToElement(menu);

        WebElement subMenu = driver.findElement(By.xpath(nameelement));
        actions.moveToElement(subMenu);
        actions.click().build().perform();
        driver.findElement(By.xpath(nameelement)).sendKeys(travelagent);
        return this;
    }

    //input[@placeholder='Contact Name']

    public  CreateTravelAgent setContactname(String contactname)
    {
        driver.findElement(By.xpath(contactnameelement)).sendKeys(contactname);
        return this;
    }



    public  CreateTravelAgent setmobile(String mobile)
    {
        driver.findElement(By.xpath(mobile1element)).sendKeys(mobile);
        return this;
    }

    public FXReservationPage clickSave()
    {
        driver.findElement(By.xpath("//button[@class='button ng-star-inserted']")).click();
        return new FXReservationPage();
    }


}
