package TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import utils.ScreenshotFailure;

public class TestFailure

{
    @Test
    public void testName()

    {


    }

    @AfterMethod
    public void afterClass()
    {
        //ScreenshotFailure.CaptureScreenshot();
    }
}
