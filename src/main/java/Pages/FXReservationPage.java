package Pages;

import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.TestException;
import utils.DBconnectionUtils;
import utils.PropertyFileReader;
import utils.TakeScreenShot;
import utils.TestApp2;

import javax.swing.*;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

public class FXReservationPage {


    DBconnectionUtils dBconnectionUtils = new DBconnectionUtils();
    PropertyFileReader prop = new PropertyFileReader();
    String Companylimit = prop.getProperty("sql", "Creditlimitofcompany");


    WebDriver driver = TestApp2.getInstance().getDriver();
    // String parent=driver.getWindowHandle();


    String createnewelement = prop.getProperty("FXReservationPage", "createnew");
    String nightelement = prop.getProperty("FXReservationPage", "night.element");
    String Continueelement = prop.getProperty("FXReservationPage", "Continue.element");

    String companyplaceholder = prop.getProperty("FXReservationPage", "company.search.element");


    String Companynamewithcreditlimit = prop.getProperty("sql", "Companynamewithcredit");


    public Createnewguest clicknewGuestcreate() throws InterruptedException {

        Thread.sleep(9000);
        List<WebElement> listOfElements = driver.findElements(By.xpath(createnewelement));
        listOfElements.get(0).click();

        String TEXT = driver.findElement(By.xpath(" //*[contains(text(),\"Create Guest\")] ")).getText();


        return new Createnewguest();
    }

    public CreateCompany ClickNewCompany() {

        TestApp2.getInstance().waitForElement(By.xpath(createnewelement), 80);
        List<WebElement> listOfElements = driver.findElements(By.xpath(createnewelement));
        listOfElements.get(3).click();

        return new CreateCompany();

    }


    public FXReservationPage SETGUESTNAME(String FIRSTNAME) {
        // waitForPageLoaded();

        TestApp2.getInstance().waitForElement(By.xpath("//input[@type='text']"), 70);

        List<WebElement> ELEMENT = driver.findElements(By.xpath("//input[@type='text']"));
        WebElement element = ELEMENT.get(0);
        element.click();
        element.sendKeys(FIRSTNAME);
        driver.findElement(By.xpath("//mat-tab-body[@id='mat-tab-content-0-0']/div/form/ol/li/div/span/app-guest-detail/div/div/div[2]/button/i")).click();
        driver.findElement(By.xpath("//input[@type='text']")).click();
        TestApp2.getInstance().waitForElement(By.xpath("//*[@id=\"auto-list\"]/div"), 80);
        driver.findElement(By.xpath("//*[@id=\"auto-list\"]/div/table/tbody/tr[2]")).click();
        //*[@id="auto-list"]/div/table/tbody/tr[2]
        return this;
    }


    public void Waitforelement() {
        try {
            WebDriverWait wait = new WebDriverWait(TestApp2.getInstance().getDriver(), 4000);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\" MDM \"]")));


        } catch (NoSuchElementException e) {

        }
    }

    public FXReservationPage setCompanyname(String comapnyname) {
        TestApp2.getInstance().waitForElement(By.xpath(companyplaceholder), 50);


        List<WebElement> ELEMENT = driver.findElements(By.xpath(companyplaceholder));
        WebElement element1 = ELEMENT.get(3);
        element1.click();
        element1.sendKeys(comapnyname);
        TestApp2.getInstance().waitForElement(By.xpath("//*[@id=\"auto-list\"]/div/table/tbody"), 90);
        driver.findElement(By.xpath("//*[@id=\"auto-list\"]/div/table/tbody/tr[2]")).click();

        return this;
    }


    public static void waitForPageLoaded() {

        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) TestApp2.getInstance().getDriver()).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(TestApp2.getInstance().getDriver(), 50);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }

    }

    public CreateTravelAgent click3dotofTAGENT() {
        TestApp2.getInstance().waitForElement(By.xpath(createnewelement), 600);
        List<WebElement> listOfElements = driver.findElements(By.xpath(createnewelement));
        listOfElements.get(1).click();
        return new CreateTravelAgent();
    }

    public CreateSource clickcreatesource() throws InterruptedException {

        Thread.sleep(4000);
        TestApp2.getInstance().waitForElement(By.xpath(createnewelement), 600);
        List<WebElement> listOfElements = driver.findElements(By.xpath(createnewelement));
        listOfElements.get(2).click();
        return new CreateSource();
    }

    public FXReservationPage setNight_GO(String nights) throws InterruptedException, IOException {
        Thread.sleep(3000);
        TestApp2.getInstance().waitForElement(By.xpath("//*[contains(text(),'Room Details')]"), 90);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");
        TestApp2.getInstance().waitForElement(By.xpath(nightelement), 700);
        driver.findElement(By.xpath(nightelement)).sendKeys(Keys.BACK_SPACE);
        driver.findElement(By.xpath(nightelement)).sendKeys(nights);
        List<WebElement> ARRIVALANDdEPATURE = driver.findElements(By.xpath("//*[@id=\"roomDetailId\"]//div[@class=\"col-xs-12 col-sm-6 col-md-4 col-lg-4\"]"));
        System.out.println(ARRIVALANDdEPATURE.get(0).getText());
        System.out.println(ARRIVALANDdEPATURE.get(1).getText());
        TakeScreenShot.TakeScreenshot("VerifyDatesAfter_NightsCounts");
        String PASS = ARRIVALANDdEPATURE.get(0).getText();


        Actions act = new Actions(driver);
        act.moveToElement(driver.findElement(By.xpath(nightelement))).click().perform();
        Thread.sleep(1000);

        // List<WebElement> ARRIVALANDdEPATURE=driver.findElements(By.xpath("//*[@id=\"roomDetailId\"]//div[@class=\"col-xs-12 col-sm-6 col-md-4 col-lg-4\"]"));
        //System.out.println(ARRIVALANDdEPATURE.get(0).getText());
        //System.out.println(ARRIVALANDdEPATURE.get(1).getText());


        Actions act1 = new Actions(driver);
        act1.moveToElement(driver.findElement(By.xpath(Continueelement))).click().perform();
        return this;


    }


    public FXReservationPage setNight_GO2(String nights) throws InterruptedException {
        TestApp2.getInstance().waitForElement(By.xpath("//*[@id=\"mat-tab-label-0-0\"]/div/span"), 20);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");
        TestApp2.getInstance().waitForElement(By.xpath(nightelement), 70);
        Actions act1 = new Actions(driver);
        act1.moveToElement(driver.findElement(By.xpath(Continueelement))).click().perform();
        return this;


        //  TestApp2.getInstance().waitForElement(By.xpath("//*[contains(text(),'Room Details')]"),90);
        //  JavascriptExecutor js = (JavascriptExecutor) driver;
        //  js.executeScript("window.scrollBy(0,400)");
        ///  TestApp2.getInstance().waitForElement(By.xpath(nightelement),700);

        // Actions act1 =  new Actions(driver);
        // act1.moveToElement(driver.findElement(By.xpath(goelement))).click().perform();
        //  return this;


    }


    public FXReservationPage uploadGuestdetails() {

        return this;
    }


    public FXReservationPage ClickRate_set(String rates,String ratecode) throws InterruptedException, IOException {
        Thread.sleep(3000);
        TestApp2.getInstance().waitForElement(By.xpath("//*[contains(text(),\"Step 3- Rate *\")]"), 80);
        driver.findElement(By.xpath("//*[contains(text(),\"Step 3- Rate *\")]")).click();
        Thread.sleep(2000);


        TestApp2.getInstance().waitForElement(By.xpath("//div[@class='col-sm-2']"), 30);



        //click Rate category
        WebElement XPATH = driver.findElement(By.xpath("//div[@class='mat-select-arrow-wrapper']"));
        List<WebElement> dropdowns = driver.findElements(By.xpath("//div[@class='mat-select-arrow-wrapper']"));
        WebElement RATECATEGORY = dropdowns.get(3);
        RATECATEGORY.click();


        TestApp2.getInstance().waitForElement(By.xpath("//mat-option[@role='option']"), 90);
        List<WebElement> rates1 = driver.findElements(By.xpath("//mat-option[@role='option']"));
        for (int i = 0; i < rates1.size(); i++) {
            if (rates1.get(i).getText().contains(rates)) {
                rates1.get(i).click();
                break;
            }
        }
        Thread.sleep(4000);
        WebElement RATECODECATEGORY = dropdowns.get(5);
        RATECODECATEGORY.click();

        TestApp2.getInstance().waitForElement(By.xpath("//mat-option[@role='option']"), 100);
      //  List<WebElement> ratesCODES = driver.findElements(By.xpath("//mat-option[@role='option']"));
        Thread.sleep(3000);


        List<WebElement> RATECODESS=driver.findElements(By.xpath("//mat-option[@role='option']//span[@class='mat-option-text']"));

        int Ratecodessize=RATECODESS.size();
        System.out.println(Ratecodessize);

        try {

            for (WebElement selectLi : RATECODESS) {
                if (selectLi.getText().equals(ratecode)) {
                    selectLi.click();
                    break;
                }


            }
        }
        catch (StaleElementReferenceException e)
        {
            for (WebElement selectLi : RATECODESS) {
                if (selectLi.getText().equals(ratecode)) {
                    selectLi.click();
                    break;
                }


            }
        }

        return new FXReservationPage();
    }
    public FXReservationPage clickFetchRate() throws InterruptedException {

        Thread.sleep(2000);
        TestApp2.getInstance().waitForElement(By.xpath("//button[@class='primary-button']"), 90);
        List<WebElement> LOADS = driver.findElements(By.xpath("//button[@class='primary-button']"));
        WebElement GO = LOADS.get(0);
        WebElement LOAD = LOADS.get(1);
        Thread.sleep(2000);
        //  LOAD.click();


        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", LOAD);


        Thread.sleep(1000);

        return this;
    }


    public FXReservationPage setChargeLimit() {
        //   String Companylimitamout = dBconnectionUtils.Dbconnect(Companylimit);

        //  String creditlimit = Companylimitamout;
        //  float creditlimitfloat = Float.parseFloat(creditlimit);
        int CreditAmoutInt;
        //   CreditAmoutInt= Math.round(creditlimitfloat);

        //int reducedamount=CreditAmoutInt-2000;
        //  String VALUE=Integer.toString(reducedamount);
        TestApp2.getInstance().waitForElement(By.xpath("//input[@placeholder=\"Charge Rate\"]"), 90);
        List<WebElement> ChargeRates = driver.findElements(By.xpath("//input[@placeholder=\"Charge Rate\"]"));
        ChargeRates.get(0).click();
        ChargeRates.get(0).clear();
        // ChargeRates.get(0).sendKeys(VALUE);

        return this;
    }

    public FXReservationPage setPurposeofcustomertype(String pct) throws InterruptedException {
        //TestApp2.getInstance().waitForElement(By.xpath("//span[@class='mat-select-placeholder ng-tns-c14-53 ng-star-inserted']"),80);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[@class='mat-select-placeholder ng-tns-c14-53 ng-star-inserted']")).click();
        List<WebElement> Purposes = driver.findElements(By.xpath("//div[@class='cdk-overlay-pane']//span"));
        for (int i = 0; i < Purposes.size(); i++) {
            if (Purposes.get(i).getText().contains(pct)) {
                Purposes.get(i).click();
                break;
            }
        }
        return this;
    }

    public FXReservationPage setCustomertype(String CTYPE) throws InterruptedException {

        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"mat-select-20\"]/div/div[1]/span")).click();
        TestApp2.getInstance().waitForElement(By.xpath("//div[@class='ng-tns-c14-55 ng-trigger ng-trigger-transformPanel mat-select-panel mat-primary']//span"), 30);
        List<WebElement> classification = driver.findElements(By.xpath("//div[contains(@class,\"ng-tns-c14-53 ng-trigger ng-trigger-transformPanel mat-select-panel mat-primary\")]//span"));
        List<WebElement> TYPES = driver.findElements(By.xpath("//div[@class='cdk-overlay-pane']//span"));
        for (int i = 0; i < TYPES.size(); i++) {
            if (TYPES.get(i).getText().contains(CTYPE)) {
                TYPES.get(i).click();
                break;
            }
        }
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");

        return this;
    }


    public FXReservationPage setvaluesforRate(String rates) {

        List<WebElement> rateselements = driver.findElements(By.xpath("//span[@class='mat-option-text']"));
        for (int i = 0; i < rateselements.size(); i++) {
            if (rateselements.get(i).getText().contains(rates))
                rateselements.get(i).click();

            else {
                System.out.println("Checking");
            }

        }


        return this;
    }




  /*  public void setOriginAirport(String airportName)
    {
        driver.findElement(By.cssSelector("#departsfrom-div .location_icon")).click();
        By locator = By.xpath("//div[@id='departsfrom-div']//span[contains(.,'" + airportName + "')]");
        WebElement e = new WebDriverWait(driver, 5).Until(ExpectedConditions.elementToBeClickable(locator));
        Thread.sleep(500); // may need this even after wait
        e.click();
    }
*/


    public FXReservationPage ClickLoad() throws InterruptedException {

        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//*[text()='Load']"));
        boolean Buttonenabled = element.isEnabled();
        System.out.println("lOAD BUTTON IS " + Buttonenabled);

        if (driver.findElement(By.xpath("//*[@id=\"mat-tab-content-6-2\"]/div/app-rate-v2/div[1]/div[5]/button")).isDisplayed()) {

            List<WebElement> LOADS = driver.findElements(By.xpath("//button[@class='primary-button']"));
            WebElement GO = LOADS.get(0);
            WebElement LOAD = LOADS.get(1);
            LOAD.click();

        } else {
            while (driver.findElement(By.xpath("//*[@id=\"mat-tab-content-6-2\"]/div/app-rate-v2/div[1]/div[5]/button")).isDisplayed())
                ;

        }
        return this;
    }


    public FXReservationPage clickConfirmRate() throws InterruptedException {

        Thread.sleep(2000);
        TestApp2.getInstance().waitForElement(By.xpath("//button[@title='Confirm Rate']"), 60);
        String TEXT = driver.findElement(By.xpath("//button[@title='Confirm Rate']")).getText();
        //   System.out.println("jesus"+TEXT);

        Thread.sleep(2000);
        TestApp2.getInstance().waitForElement(By.xpath("//button[@class='ng-tns-c4-2 button-background']"), 90);
        WebElement ELEMENT = driver.findElement(By.xpath("//button[@title='Confirm Rate']"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", ELEMENT);
        Thread.sleep(1000);


        return this;
    }

    public FXReservationPage clickSaveReservation() throws InterruptedException, IOException {
        Thread.sleep(2000);

        //TestApp2.getInstance().waitForElement(By.xpath("//*[@id=\"roomDetailId\"]/div/span[2]/div/div[1]/div[2]/button[1]"),80);
        // driver.findElement(By.xpath("//*[@id=\"roomDetailId\"]/div/span[2]/div/div[1]/div[2]/button[1]")).click();
        // TestApp2.getInstance().waitForElement(By.xpath("//button[@name='save-reservation']"),80);
        // Thread.sleep(4000);
        TestApp2.getInstance().waitForElement(By.xpath("//button[@name='save-reservation']"), 140);
        driver.findElement(By.xpath("//button[@name='save-reservation']")).click();
        TestApp2.getInstance().waitForElement(By.xpath("//*[@id=\"myModal\"]/div"), 100);
        // TakeScreenShot.TakeScreenshot("Reservation_save_done");
        return this;
    }


    public int ValidateRateAndTotal() {
        String rate = "";
        TestApp2.getInstance().waitForElement(By.xpath("//span[@class='rate_color']"), 90);
        List<WebElement> ChargeRates = driver.findElements(By.xpath("//span[@class='rate_color']"));
        ChargeRates.get(0).click();
        String rateamountforonenight = ChargeRates.get(0).getText();

        String[] parts = rateamountforonenight.split(" ");
        String part1 = parts[0]; //CURRENCY
        String part2 = parts[1]; // 2000
        int rateamout = Integer.parseInt(part2);



        return rateamout;
    }

    public  String RATE()
    {
        String rate = "";
        TestApp2.getInstance().waitForElement(By.xpath("//div[starts-with(@class,\"rate-summary\")]//div"),80);
        List <WebElement> ratesummary=driver.findElements(By.xpath("//div[starts-with(@class,\"rate-summary\")]//span"));
        WebElement Ratelement=ratesummary.get(1);
        String RATEAMOUNT=Ratelement.getText();
       // System.out.println("rate amount text"+RATEAMOUNT);
        //String[] parts = RATEAMOUNT.split(" ");
    //    String part1 = parts[0]; //CURRENCY
       // String part2 = parts[1]; // 2000
       // int rateamout = Integer.parseInt(RATEAMOUNT);
        rate=RATEAMOUNT;
        return rate;
    }

    public String Mealplan()
    {
        String mealplan = "";
        List <WebElement> ratesummary=driver.findElements(By.xpath("//div[starts-with(@class,\"rate-summary\")]//span"));
        WebElement Ratelement=ratesummary.get(3);
        String mealplane=Ratelement.getText();
        System.out.println("mealplan text"+mealplane);
      //  String[] parts = mealplane.split(" ");
      //  String part1 = parts[0]; //CURRENCY
      //  String part2 = parts[1]; // 2000
    //    int mealplan1 = Integer.parseInt(mealplane);
        mealplan=mealplane;
        return mealplan;
    }

    public String  Addon()
    {
        String Addon = "";
        List <WebElement> ratesummary=driver.findElements(By.xpath("//div[starts-with(@class,\"rate-summary\")]//span"));
        WebElement Addonelement=ratesummary.get(5);
        String Addonelemen=Addonelement.getText();
        System.out.println("Addon text"+Addonelemen);
       // String[] parts = Addonelemen.split(" ");
     //   String part1 = parts[0]; //CURRENCY
     //   String part2 = parts[1]; // 2000
      //  int Addonplane = Integer.parseInt(Addonelemen);
        Addon=Addonelemen;
        return Addon;
    }

    public String  Tax()
    {
        String tax = "";
        List <WebElement> ratesummary=driver.findElements(By.xpath("//div[starts-with(@class,\"rate-summary\")]//span"));
        WebElement Addonelement=ratesummary.get(7);
        String Taxelement=Addonelement.getText();
        System.out.println("Tax text"+Taxelement);
      //  String[] parts = Taxelement.split(" ");
       // String part1 = parts[0]; //CURRENCY
       // String part2 = parts[1]; // 2000
      //  int Tax = Integer.parseInt(Taxelement);
        tax=Taxelement;
        return tax;
    }

    public String  Total()
    {
        String total = "";
        List <WebElement> ratesummary=driver.findElements(By.xpath("//div[starts-with(@class,\"rate-summary\")]//span"));
        WebElement Addonelement=ratesummary.get(9);
        String Totalelement=Addonelement.getText();
        System.out.println("Total text"+Totalelement);
    //    String[] parts = Totalelement.split(" ");
      //  String part1 = parts[0]; //CURRENCY
      //  String part2 = parts[1]; // 2000
    //    int Total= Integer.parseInt(Totalelement);
        total=total;
        return total;
    }


}



//input[@type='text']