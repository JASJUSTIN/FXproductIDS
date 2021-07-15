package utils;


//import jdk.javadoc.internal.doclets.toolkit.util.DocFile;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.internal.Utils;

import java.io.File;
import java.io.IOException;

public class TakeScreenShot
{

    //  private static Utils FileUtils;

    public static void TakeScreenshot(String filename) throws IOException
    {

        File file= ((TakesScreenshot)TestApp2.getInstance().getDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("src/main/java/ScreenShots/" + filename + ".jpg"));
    }



}
