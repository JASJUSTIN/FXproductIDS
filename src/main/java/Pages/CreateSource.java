package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.PropertyFileReader;
import utils.TestApp2;

public class CreateSource {

    WebDriver driver= TestApp2.getInstance().getDriver();

    PropertyFileReader prop=new PropertyFileReader();


    String namesourceelement=prop.getProperty("CreateSource","name.source.element");
    String sourcecontactnameelement=prop.getProperty("CreateSource","contactname.source.element");
    String sourcemobile=prop.getProperty("CreateSource","mobile.source.elemet");
    String savesource=prop.getProperty("CreateSource","savesource.element");

    String sql=prop.getProperty("sql","sql1");



    public CreateSource setSourcename(String sourcename)
    {
        TestApp2.getInstance().waitForElement(By.xpath(namesourceelement),600);
        // driver.findElement(By.xpath(firstnameelement)).click();
        //  driver.findElement(By.xpath(firstnameelement)).sendKeys(fname);


  // mousehover to firstname element and click
        Actions actions = new Actions(driver);
        WebElement menu = driver.findElement(By.xpath(namesourceelement));
        actions.moveToElement(menu);

        WebElement subMenu = driver.findElement(By.xpath(namesourceelement));
        actions.moveToElement(subMenu);
        actions.click().build().perform();
        driver.findElement(By.xpath(namesourceelement)).sendKeys(sourcename);
        return this;
    }

    public CreateSource setsourcecontactname(String sourcecontactname)
    {
        driver.findElement(By.xpath(sourcecontactnameelement)).sendKeys(sourcecontactname);
        return this;
    }
    public CreateSource setsourcemobile(String sourcecontactmobilr)
    {
        driver.findElement(By.xpath(sourcemobile)).sendKeys(sourcecontactmobilr);
        return this;
    }

    public FXReservationPage ClicksaveSource()
    {
        System.out.println(sql);

        driver.findElement(By.xpath(savesource)).click();
        return new FXReservationPage();
    }





}
