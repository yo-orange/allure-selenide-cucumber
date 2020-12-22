package jp.yo.orange.type;

import jp.yo.orange.page.ItemModel;

public class SelectType extends AbstractType {

    public SelectType(final ItemModel itemModel) {
        super(itemModel);
    }

    @Override
    public void input(String value) {
        var element = getElement();
        var target = element.findAll("option")
                .stream()
                .filter(option -> option.getText().trim().equals(value))
                .findFirst();
        target.ifPresent(option -> option.click());
    }

}
