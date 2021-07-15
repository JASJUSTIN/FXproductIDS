package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public class TestApp2 {
    private WebDriver driver;
    private static TestApp2 myObj;
    // public static WebDriver driver;
    utils.PropertyFileReader property = new PropertyFileReader();

    public static TestApp2 getInstance() {
        if (myObj == null) {
            myObj = new TestApp2();
            return myObj;
        } else {
            return myObj;
        }
    }

    //get the selenium driver
    public WebDriver getDriver() {
        return driver;
    }

    //when selenium opens the browsers it will automatically set the web driver
    private void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public static void setMyObj(TestApp2 myObj) {
        TestApp2.myObj = myObj;
    }

    public void openBrowser() {

        //ExcelReader reader=new ExcelReader("")



        String browserversion12 = property.getProperty("config", "browserversion");

        if (browserversion12.contains("Chrome")) {
            // System.setProperty("webdriver.chrome.driver", "chromedriver");
            System.setProperty("webdriver.chrome.driver", getChromeDriverFilePath());
            ChromeOptions options = new ChromeOptions();

            DesiredCapabilities capabilities = DesiredCapabilities.chrome();

          //  options.addArguments("incognito");
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);


            options.addArguments("--disable-notifications");
            options.addArguments("disable-infobars");
            //  options.setBinary("/usr/bin/google-chrome");

            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (browserversion12.contains("firefox"))
        {
            System.setProperty("webdriver.gecko.driver",getfirefoxDriverFilePath());
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }
        //String chromeDriverPath = property.getProperty("config", "chrome.driver.path");
        //String chromeDriverPath = property.getProperty("config", getChromeDriverFilePath());


        if (browserversion12.contains("Edge"))
        {
            System.setProperty("webdriver.edge.driver",getedgeDriverFilePath());
            //driver = new InternetExplorerDriver();
            driver = new EdgeDriver();
            driver.manage().window().maximize();

        }

        if (browserversion12.contains("InternetExplorer"))
        {
            System.setProperty("webdriver.ie.driver",getIEDriverFilePath());
            //  WebDriver driver = new InternetExplorerDriver();
            driver = new InternetExplorerDriver();
            driver.manage().window().maximize();

        }
        if (browserversion12.contains("Opera"))
        {
            System.setProperty("webdriver.opera.driver",getOperaDriverFilePath());
            //  WebDriver driver = new InternetExplorerDriver();
            driver = new OperaDriver();
            driver.manage().window().maximize();

        }

    }



    public void navigateToURL() {

        String url = property.getProperty("config", "url");
        // String browserversion=property.getProperty("confiq","browserversion");
        driver.get(url);
    }

    public void closeBrowser() {
        driver.quit();
    }

    public WebElement waitForElement(By locator, int timeout) {
        WebElement element = new WebDriverWait(TestApp2.getInstance().getDriver(), timeout).until
                (ExpectedConditions.presenceOfElementLocated(locator));
        return element;
    }

    private String getChromeDriverFilePath() {
        // checking resources file for chrome driver in side main resources
        URL res = getClass().getClassLoader().getResource("chromedriver.exe");
        File file = null;
        try {
            file = Paths.get(res.toURI()).toFile();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return file.getAbsolutePath();
    }

    private String getfirefoxDriverFilePath() {
        // checking resources file for chrome driver in side main resources
        URL res = getClass().getClassLoader().getResource("geckodriver.exe");
        File file = null;
        try {
            file = Paths.get(res.toURI()).toFile();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return file.getAbsolutePath();
    }

    private String getedgeDriverFilePath() {
        // checking resources file for chrome driver in side main resources
        URL res = getClass().getClassLoader().getResource("msedgedriver.exe");
        File file = null;
        try {
            file = Paths.get(res.toURI()).toFile();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return file.getAbsolutePath();
    }


    private String getIEDriverFilePath() {
        // checking resources file for chrome driver in side main resources
        URL res = getClass().getClassLoader().getResource("IEDriverServer.exe");
        File file = null;
        try {
            file = Paths.get(res.toURI()).toFile();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return file.getAbsolutePath();
    }


    private String getOperaDriverFilePath() {
        // checking resources file for chrome driver in side main resources
        URL res = getClass().getClassLoader().getResource("operadriver.exe");
        File file = null;
        try {
            file = Paths.get(res.toURI()).toFile();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return file.getAbsolutePath();
    }




    public String getname()
    {
        String NAMEBROWSER=property.getProperty("config","browserversion");
        return NAMEBROWSER;
    }



}
