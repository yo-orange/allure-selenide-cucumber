package jp.yo.orange.type;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import jp.yo.orange.page.ItemModel;
import org.apache.commons.lang3.StringUtils;

public abstract class AbstractType {

    private ItemModel itemModel;

    public AbstractType(ItemModel itemModel) {
        this.itemModel = itemModel;
    }

    public SelenideElement getElement() {
        return StringUtils.isEmpty(itemModel.getCss())
                ? Selenide.$x(itemModel.getXpath())
                : Selenide.$(itemModel.getCss());
    }

    public abstract void input(String value);

    public void assertElement(String attribute, String value) {
        switch (attribute) {
            case "text":
                getElement().shouldHave(Condition.exactText(value));
                break;
            case "value":
                getElement().shouldHave(Condition.exactValue(value));
                break;
        }
    }
}
