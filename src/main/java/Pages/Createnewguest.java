package Pages;


import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import utils.PropertyFileReader;
import utils.TakeFullScreenShots;
import utils.TakeScreenShot;
import utils.TestApp2;

import java.io.IOException;
import java.security.Key;
import java.util.List;

public class Createnewguest {

    WebDriver driver= TestApp2.getInstance().getDriver();
    PropertyFileReader prop=new PropertyFileReader();

    String firstnameelement=prop.getProperty("Createnewguest","firstname.element");
    String middlenameelement=prop.getProperty("Createnewguest","middle.element");
    String lastnameelement=prop.getProperty("Createnewguest","lastname.element");
    String emailelement=prop.getProperty("Createnewguest","email.element");
    String mobileelement=prop.getProperty("Createnewguest","mobile.element");
    String savebuttonelement=prop.getProperty("Createnewguest","savebutton.element");
    String save2buttonelement=prop.getProperty("Createnewguest","save2");

    String isdelement=prop.getProperty("Createnewguest","isd.element");

    String closeelement=prop.getProperty("Createnewguest","closewindow.element");






    //Guest Details...........


    public Createnewguest uploadPic()
    {
        TestApp2.getInstance().waitForElement(By.xpath("//*[@id=\"modeldata\"]/div[1]/div/label/div"),70);
       // driver.findElement(By.xpath("//*[@id=\"modeldata\"]/div[1]/div/label/div")).click();
        Actions actions = new Actions(driver);
        WebElement subMenu = driver.findElement(By.cssSelector(".hover-text"));
        actions.moveToElement(subMenu).click();
        driver.findElement(By.cssSelector(".hover-text")).click();



        return this;
    }


    public Createnewguest SetTitle(String title1) {
        TestApp2.getInstance().waitForElement(By.xpath("//*[@id=\"mat-select-28\"]/div/div[2]/div"), 80);

        Actions actions = new Actions(driver);
        WebElement menu = driver.findElement(By.xpath("//*[@id=\"mat-select-28\"]/div/div[2]/div"));
        actions.moveToElement(menu);

        WebElement subMenu = driver.findElement(By.xpath("//*[@id=\"mat-select-28\"]/div/div[2]/div"));
        actions.moveToElement(subMenu);
        actions.click().build().perform();

        TestApp2.getInstance().waitForElement(By.xpath("//*[@id=\"cdk-overlay-0\"]//div"), 40);
        List<WebElement> titles = driver.findElements(By.xpath("//mat-option[@role='option']//span"));

        for(int i = 0; i<=titles.size()-1; i++)
        {
            if(titles.get(i).getText().contains(title1)) {
                titles.get(i).click();
                break;

            }
        }

        return this;
    }

    public Createnewguest setfirstname(String fname) throws InterruptedException {
       //TestApp2.getInstance().waitForElement(By.xpath(firstnameelement),60);
        Thread.sleep(3000);
       driver.findElement(By.xpath(firstnameelement)).click();
       driver.findElement(By.xpath(firstnameelement)).sendKeys(fname);
       return this;
    }

    public Createnewguest setmiddlename(String Mname)
    {
        TestApp2.getInstance().waitForElement(By.xpath(middlenameelement),30);
        driver.findElement(By.xpath(middlenameelement)).sendKeys(Mname);
        return this;
    }

    public Createnewguest setLastname(String Lname)
    {
        TestApp2.getInstance().waitForElement(By.xpath(lastnameelement),30);
        driver.findElement(By.xpath(lastnameelement)).sendKeys(Lname);
        return this;
    }



    public Createnewguest setGendder(String gender)
    {

        WebElement elementmale=driver.findElement(By.xpath("//*[contains(text(),\"Male\")]"));
        WebElement elementfemale=driver.findElement(By.xpath("//*[contains(text(),\"Female\")]"));
        if (elementmale.getText().contains(gender))
        {
            elementmale.click();
        } else {
            elementfemale.click();
        }



      //  driver.findElement(By.xpath("//*[contains(text(),\"Female\")]")).click();
        return this;
    }

    public Createnewguest setemail(String email)
    {
        TestApp2.getInstance().waitForElement(By.xpath(emailelement),30);
        driver.findElement(By.xpath(emailelement)).sendKeys(email);
        return this;
    }

    public Createnewguest setmobile(String mobile,String NATIONALITY)
    {
        TestApp2.getInstance().waitForElement(By.xpath(mobileelement),30);
        driver.findElement(By.xpath(mobileelement)).sendKeys(mobile);
        driver.findElement(By.xpath("//*[@placeholder='Nationality']")).clear();
        driver.findElement(By.xpath("//*[@placeholder='Nationality']")).sendKeys(NATIONALITY);
      //  JavascriptExecutor js = (JavascriptExecutor) driver;
     //   js.executeScript("window.scrollBy(0,500)");

        return this;
    }

    public Createnewguest setGSTNumber(String gstnumer) throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"mat-slide-toggle-4\"]/label/div"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500);

        TestApp2.getInstance().waitForElement(By.xpath("//*[@id=\"mat-slide-toggle-4\"]/label/div"),90);
        Actions actions = new Actions(driver);
        WebElement menu = driver.findElement(By.xpath("//*[@id=\"mat-slide-toggle-4\"]/label/div"));
        actions.moveToElement(menu);
        actions.click().build().perform();


        driver.findElement(By.xpath("//input[@placeholder=\"GST Registration Number\"]")).click();
        driver.findElement(By.xpath("//input[@placeholder=\"GST Registration Number\"]")).sendKeys(gstnumer);

        return this;
    }

    public  Createnewguest setISD(String isd, Keys keys)
    {
        TestApp2.getInstance().waitForElement(By.xpath(isdelement),60);
        driver.findElement(By.xpath(isdelement)).click();
       // driver.findElement(By.xpath(isdelement)).clear();
        driver.findElement(By.xpath(isdelement)).sendKeys(isd,Keys.TAB);
        return this;
    }

    public Createnewguest setLinkProfile()
    {
       // driver.findElement(By.xpath("//*[@id=\"mat-slide-toggle-45\"]/label/div/div/div[1]")).click();
        return this;
    }


    //Other Details

    public Createnewguest setCompanyDetails(String data,Keys tab,String designation,String saluation)
    {
        driver.findElement(By.xpath("//input[@placeholder=\"Company\"]")).click();
        List<WebElement> listelements=driver.findElements(By.xpath("//div[@id='mat-autocomplete-2']//div"));
     //   for (int i=0;i<listelements.size();i ++)
        System.out.println(listelements.size());
        driver.findElement(By.xpath("//input[@placeholder=\"Company\"]")).sendKeys(data,Keys.TAB);
        driver.findElement(By.xpath("//input[@placeholder=\"Designation\"]")).clear();
        driver.findElement(By.xpath("//input[@placeholder=\"Designation\"]")).sendKeys(designation);
        driver.findElement(By.xpath("//input[@placeholder='Salutation']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Salutation']")).sendKeys(saluation);

        return this;

        //String companyname,String Desingation,String saluation
    }

    public Createnewguest setCompany_Status_classfication(String status,String classfication)
    {
        driver.findElement(By.xpath("//*[@id=\"mat-select-29\"]/div/div[2]")).click();
        TestApp2.getInstance().waitForElement(By.xpath("//*[@id=\"cdk-overlay-4\"]/div/div//div"),70);
        List <WebElement> STATUSES=driver.findElements(By.xpath("//span[@class='mat-option-text']"));

        for(int i =0;i<STATUSES.size();i++)

        {
            if(STATUSES.get(i).getText().contains(status))
            {
                STATUSES.get(i).click();
                break;
            }
        }




        // classcification
        driver.findElement(By.xpath("//*[@id=\"mat-select-30\"]/div/div[2]")).click();
        TestApp2.getInstance().waitForElement(By.xpath("//*[@id=\"cdk-overlay-5\"]/div/div"),80);
        List <WebElement> CLASSIFICATION=driver.findElements(By.xpath("//*[@id=\"cdk-overlay-5\"]/div/div//span"));
        for(int i =0;i<CLASSIFICATION.size();i++)

        {
            if(CLASSIFICATION.get(i).getText().contains(classfication))
            {
                CLASSIFICATION.get(i).click();
                break;
            }
        }


        return this;
    }

//*[@id="mat-select-30"]/div/div[2]

    public Createnewguest  setDob_Anndate(String year) {

        List<WebElement> CALENDER = driver.findElements(By.xpath("//*[@class=\"mat-datepicker-toggle-default-icon ng-star-inserted\"]"));
        CALENDER.get(0).click();
        TestApp2.getInstance().waitForElement(By.xpath("//button[@aria-label=\"Previous month\"]"), 80);
        driver.findElement(By.xpath("//*[@id=\"mat-datepicker-2\"]/mat-calendar-header/div/div/button[1]/span")).click();
        String CURRENT = driver.findElement(By.xpath("//button[@aria-label='Choose date']")).getText();

        List<WebElement> years=driver.findElements(By.xpath("//*[@id=\"mat-datepicker-2\"]/div//div"));

        for (int i=0;i<years.size();i++)
        {
            if (years.get(i).getText().contains(year))
            {
                years.get(i).click();
                break;
            }
            
            else
            {
                driver.findElement(By.xpath("//button[@aria-label='Previous 20 years']"));
            }
        }









     /*   String[] parts = CURRENT.split("(?<=\\d)(?=\\D)");
        System.out.println(parts[0] + parts[1]);




















        while (true) {
            String CURRENT1 = driver.findElement(By.xpath("//button[@aria-label='Choose date']")).getText();
            String[] parts1 = CURRENT1.split("(?<=\\d)(?=\\D)");
            System.out.println(parts[0] + parts[1]);
            //  String EARLIERDAYTE=parts[0];
            String LATEDAYTE = parts[1];
            String EARLIERDAYTE1 = parts[0];
            System.out.println("EARLYYEAR" + EARLIERDAYTE1);
            if (EARLIERDAYTE1.contains(year))
            {
                break;
            }else {
                driver.findElement(By.xpath("//button[@aria-label='Previous 20 years']")).click();

            }

        }

            WebElement previoubuttonforyear = driver.findElement(By.xpath("//button[@aria-label='Previous 20 years']"));

            // driver.findElement(By.xpath("")),80'*/
            return this;
        }



    public Createnewguest clickSave() throws InterruptedException, IOException {

        TestApp2.getInstance().waitForElement(By.xpath("//button[@class='button primary-button']"),80);
        WebElement save=driver.findElement(By.xpath("//button[@class='button primary-button']"));
        WebElement saveBUTTON=  driver.findElement(By.xpath("//*[text()='Save']"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", saveBUTTON);
        Thread.sleep(2000);
       // TestApp2.getInstance().waitForElement(By.xpath("//*[contains(text(),'Guest Profile Created')]"),300);

        TakeScreenShot.TakeScreenshot("Guest is created");
        return this;
    }
    public CreateReservationPage closewindow() throws InterruptedException {

        Thread.sleep(5000);
        TestApp2.getInstance().waitForElement(By.xpath(closeelement),2000);
        driver.findElement(By.xpath(closeelement)).click();
        WebElement CLOSEPOPUP=driver.findElement(By.xpath(closeelement));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", CLOSEPOPUP);

        return new CreateReservationPage();
    }


    public String checktitleofguest()
    {

        TestApp2.getInstance().waitForElement(By.xpath("//*[@id=\"body\"]/app-root/div[2]/app-reservation/div/div[2]/div[2]/div[2]/app-multiple-guest/div[1]/div/div[1]/div/ul/li"),100);

      String name=driver.findElement(By.xpath("//*[@id=\"body\"]/app-root/div[2]/app-reservation/div/div[2]/div[2]/div[2]/app-multiple-guest/div[1]/div/div[1]/div/ul/li")).getText();
      return name;
    }



//*[@id="body"]/app-root/div[2]/app-reservation/div/div[2]/div[2]/div[2]/app-multiple-guest/p/button[1]/i


public Createnewguest setAddress(String address)
{
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollTo(0, document.body.scrollHeight)");


   // WebElement element = driver.findElement(By.xpath("//input[@placeholder='Address']"));
    //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    TestApp2.getInstance().waitForElement(By.xpath("//input[@placeholder='Address']"),90);
    driver.findElement(By.xpath("//input[@placeholder='Address']")).sendKeys(address);
    return this;
}

public Createnewguest setCountry(String country)
{
    driver.findElement(By.xpath("//input[@placeholder='Country']")).click();
    //div[@role='listbox']//div
    TestApp2.getInstance().waitForElement(By.xpath("//div[@role='listbox']//span"),90);
    List<WebElement> countrieslist=driver.findElements(By.xpath("//div[@role='listbox']//span"));
    int countriescount=countrieslist.size();

    for (int i=0;i<countriescount;i++)
    {
        if (countrieslist.get(i).getText().contains(country))
        {
            System.out.println(countrieslist.get(i).getText());
            countrieslist.get(i).click();
            break;
        }
    }

    return this;
}

public Createnewguest setState(String state) throws InterruptedException {
    Thread.sleep(2000);
    TestApp2.getInstance().waitForElement(By.xpath("//input[@placeholder='State']"),90);
    driver.findElement(By.xpath("//input[@placeholder='State']")).click();
    TestApp2.getInstance().waitForElement(By.xpath("//div[@id='mat-autocomplete-4']//span"),90);
    List<WebElement> Stateelements=driver.findElements(By.xpath("//div[@id='mat-autocomplete-4']//span"));
    int statelementscount=Stateelements.size();
    for (int i=0;i<statelementscount;i++)
    {
        if(Stateelements.get(i).getText().contains(state))
        {
            Stateelements.get(i).click();
            break;
        }
    }

    return this;
}

public Createnewguest setCity(String city)
{
    driver.findElement(By.xpath("//input[@placeholder='City']")).click();
    driver.findElement(By.xpath("//input[@placeholder='City']")).sendKeys(city);
    return this;
}

public Createnewguest setZip(String zipcode)
{
    driver.findElement(By.xpath("//input[@placeholder='Zip / Postal Code']")).click();
    driver.findElement(By.xpath("//input[@placeholder='Zip / Postal Code']")).sendKeys(zipcode);
    return this;
}
public Createnewguest setPANCardNumber(String panCardNumber)
{
    TestApp2.getInstance().waitForElement(By.xpath("//input[@placeholder='PAN Card Number']"),90);
    driver.findElement(By.xpath("//input[@placeholder='PAN Card Number']")).click();
    driver.findElement(By.xpath("//input[@placeholder='PAN Card Number']")).sendKeys(panCardNumber);

    return this;
}

}
