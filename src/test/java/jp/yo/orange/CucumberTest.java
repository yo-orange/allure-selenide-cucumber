package jp.yo.orange;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@lombok.extern.slf4j.Slf4j
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", plugin = {"pretty", "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"}, monochrome = true)
public class CucumberTest {

    @BeforeClass
    public static void setup() {
        log.info("headless : {}", Configuration.headless);
        log.info("browser : {}", Configuration.browser);
        // Configuration
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
    }

    @AfterClass
    public static void afterClass() {
    }
}
