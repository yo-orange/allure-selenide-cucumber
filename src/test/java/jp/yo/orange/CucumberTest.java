package jp.yo.orange;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.platform.engine.Cucumber;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

@lombok.extern.slf4j.Slf4j
@Cucumber
@CucumberOptions(plugin = {"io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"})
public class CucumberTest {

    @BeforeAll
    public static void setup() {
        log.info("headless : {}", Configuration.headless);
        log.info("browser : {}", Configuration.browser);
        // Configuration
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
    }

    @AfterAll
    public static void afterClass() {
    }
}
