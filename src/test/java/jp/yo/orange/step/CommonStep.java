package jp.yo.orange.step;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import jp.yo.orange.page.PagesFactory;
import jp.yo.orange.util.SelenideUtils;
import jp.yo.orange.util.StepUtils;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Map;

public class CommonStep {

    /**
     * open browser.
     *
     * @param url
     */
    @Given("open {string}")
    public void open(String url) throws Exception {
        Selenide.open(url);
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
        var pageTypes = PagesFactory.getInstance().getPagesType();
        var items = pageTypes.get(pageName);
        for (var value : data.entrySet()) {
            items.get(value.getKey()).input(StepUtils.convert(value.getValue()));
        }
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
        var pageTypes = PagesFactory.getInstance().getPagesType();
        var items = pageTypes.get(pageName);
        for (var value : data.entrySet()) {
            items.get(value.getKey()).assertElement(value.getValue().get(0), StepUtils.convert(value.getValue().get(1)));
        }
    }

    /**
     * screenshot.
     *
     * @param imageName
     */
    @And("screenshot {string}")
    public void screenshotStep(String imageName) throws Exception {
        screenshot(imageName);
    }

    /**
     * screenshot.
     *
     * @param imageName
     * @throws Exception
     */
    public void screenshot(String imageName) throws Exception {
        var image = SelenideUtils.screenshot();
        Allure.addAttachment(imageName, new ByteArrayInputStream(image));
    }
}
