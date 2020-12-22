package jp.yo.orange.util;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Keys;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;

public class SelenideUtils {

    private static String OS = System.getProperty("os.name").toLowerCase();

    private SelenideUtils() {
    }

    /**
     * clear input field.
     *
     * @param element
     */
    public static void clear(SelenideElement element) {
        if (isMac()) {
            element.sendKeys(Keys.chord(Keys.COMMAND, "a"));
        } else {
            element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        }
        element.sendKeys(Keys.DELETE);
    }

    /**
     * screenshot.
     *
     * @return
     * @throws Exception
     */
    public static byte[] screenshot() throws Exception {
        var screenshot = new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(1000))
                .takeScreenshot(WebDriverRunner.getWebDriver());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(screenshot.getImage(), "png", baos);
        return baos.toByteArray();
    }

    public static boolean isWindows() {
        return (OS.indexOf("win") >= 0);
    }

    public static boolean isMac() {
        return (OS.indexOf("mac") >= 0);
    }

    public static boolean isUnix() {
        return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0);
    }

    public static boolean isSolaris() {
        return (OS.indexOf("sunos") >= 0);
    }
}
