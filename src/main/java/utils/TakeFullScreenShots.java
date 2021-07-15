package utils;

import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class TakeFullScreenShots {
    // public static WebDriver driver;

    public static void fullScren(String filename) throws IOException
    {

        Screenshot myScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(TestApp2.getInstance().getDriver());
        ImageIO.write(myScreenshot.getImage(),"PNG",new File("src/main/java/ScreenShots/" + filename + ".jpg"));
    }
}

