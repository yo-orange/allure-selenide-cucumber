package jp.yo.orange.step;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jp.yo.orange.page.PagesFactory;
import jp.yo.orange.type.AbstractType;
import jp.yo.orange.util.StepUtils;

import java.util.List;
import java.util.Map;

public class CommonStep {

    /**
     * open browser.
     *
     * @param url
     */
    @Given("open {string}")
    public void open(String url) {
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
        Map<String, Map<String, AbstractType>> pageTypes = PagesFactory.getInstance().getPagesType();
        Map<String, AbstractType> items = pageTypes.get(pageName);
        for (Map.Entry<String, String> value : data.entrySet()) {
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
        Map<String, Map<String, AbstractType>> pageTypes = PagesFactory.getInstance().getPagesType();
        Map<String, AbstractType> items = pageTypes.get(pageName);
        for (Map.Entry<String, List<String>> value : data.entrySet()) {
            items.get(value.getKey()).assertElement(value.getValue().get(0), StepUtils.convert(value.getValue().get(1)));
        }
    }
}
