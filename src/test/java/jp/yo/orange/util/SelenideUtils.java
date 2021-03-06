package jp.yo.orange.util;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

public class SelenideUtils {

    private static String OS = System.getProperty("os.name").toLowerCase();

    private SelenideUtils() {
    }

    public static void clear(SelenideElement element) {
        if (isMac()) {
            element.sendKeys(Keys.chord(Keys.COMMAND, "a"));
        } else {
            element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        }
        element.sendKeys(Keys.DELETE);
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
