package jp.yo.orange.type;

import jp.yo.orange.page.ItemModel;

public class ButtonType extends AbstractType {

    public ButtonType(final ItemModel itemModel) {
        super(itemModel);
    }

    @Override
    public void input(String value) {
        getElement().click();
    }

}
