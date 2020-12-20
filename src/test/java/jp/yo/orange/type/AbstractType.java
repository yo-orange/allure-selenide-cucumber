package jp.yo.orange.type;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import jp.yo.orange.page.ItemModel;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;

@lombok.extern.slf4j.Slf4j
public abstract class AbstractType {

    protected ItemModel itemModel;

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
        log.info("attr:{}, value:{}", attribute, value);
        switch (attribute) {
            case "text":
                getElement().shouldHave(Condition.exactText(value));
                break;
            case "value":
                getElement().shouldHave(Condition.value(value));
                break;
            case "appear":
                if (BooleanUtils.toBoolean(value)){
                    getElement().shouldBe(Condition.appear);
                } else {
                    getElement().shouldBe(Condition.disappear);
                }
                break;
            case "enabled":
                if (BooleanUtils.toBoolean(value)){
                    getElement().shouldBe(Condition.enabled);
                } else {
                    getElement().shouldBe(Condition.disabled);
                }
                break;
            default:
                log.warn("Not supported: attr:{}, value:{}", attribute, value);
                getElement().shouldHave(Condition.attribute(attribute, value));
                break;
        }
    }
}
