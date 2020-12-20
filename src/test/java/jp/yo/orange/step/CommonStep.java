package jp.yo.orange.step;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import jp.yo.orange.page.PagesFactory;
import jp.yo.orange.type.AbstractType;
import jp.yo.orange.util.SelenideUtils;
import jp.yo.orange.util.StepUtils;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Map;

public class CommonStep {

//    private boolean isScreenshot = false;
//
//    @AfterStep
//    public void afterStep(Scenario scenario) throws Exception {
//        if (isScreenshot) {
//            byte[] image = SelenideUtils.screenshot();
//            scenario.attach(image, "image/png", scenario.getName() + ":afterStep");
//            Allure.addAttachment(scenario.getName() + ":afterStep", new ByteArrayInputStream(image));
//        }
//    }

    /**
     * open browser.
     *
     * @param url
     */
    @Given("open {string}")
    public void open(String url) throws Exception {
        Selenide.open(url);
        screenshot("open");
    }

    /**
     * input value.
     *
     * @param pageName
     * @param data
     * @throws Exception
     */
    @When("{string}:input")
    public void input(String pageName, Map<String, String> data) throws Exception {
        Map<String, Map<String, AbstractType>> pageTypes = PagesFactory.getInstance().getPagesType();
        Map<String, AbstractType> items = pageTypes.get(pageName);
        for (Map.Entry<String, String> value : data.entrySet()) {
            items.get(value.getKey()).input(StepUtils.convert(value.getValue()));
        }
        screenshot(pageName + ":input");
    }

    /**
     * assert element.
     *
     * @param pageName
     * @param data
     * @throws Exception
     */
    @Then("{string}:assert")
    public void assertElement(String pageName, Map<String, List<String>> data) throws Exception {
        screenshot(pageName + ":assert");
        Map<String, Map<String, AbstractType>> pageTypes = PagesFactory.getInstance().getPagesType();
        Map<String, AbstractType> items = pageTypes.get(pageName);
        for (Map.Entry<String, List<String>> value : data.entrySet()) {
            items.get(value.getKey()).assertElement(value.getValue().get(0), StepUtils.convert(value.getValue().get(1)));
        }
    }

    /**
     * screen shot.
     *
     * @param imageName
     */
    @And("screenshot {string}")
    public void screenshotStep(String imageName) throws Exception {
        screenshot(imageName);
    }

    /**
     * @param imageName
     * @throws Exception
     */
    public void screenshot(String imageName) throws Exception {
        byte[] image = SelenideUtils.screenshot();
        Allure.addAttachment(imageName, new ByteArrayInputStream(image));
    }
}
