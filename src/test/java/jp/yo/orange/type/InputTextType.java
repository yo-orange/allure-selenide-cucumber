package jp.yo.orange.type;

import com.codeborne.selenide.SelenideElement;
import jp.yo.orange.page.ItemModel;
import jp.yo.orange.util.SelenideUtils;

public class InputTextType extends AbstractType {

    public InputTextType(final ItemModel itemModel) {
        super(itemModel);
    }

    @Override
    public void input(String value) {
        SelenideElement element = getElement();
        SelenideUtils.clear(element);
        element.setValue(value);
    }
}
