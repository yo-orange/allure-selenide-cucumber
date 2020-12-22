package jp.yo.orange.type;

import jp.yo.orange.page.ItemModel;
import jp.yo.orange.util.SelenideUtils;

public class InputType extends AbstractType {

    public InputType(final ItemModel itemModel) {
        super(itemModel);
    }

    @Override
    public void input(String value) {
        var element = getElement();
        SelenideUtils.clear(element);
        element.setValue(value);
    }
}
