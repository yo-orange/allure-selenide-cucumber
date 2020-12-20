package jp.yo.orange.type;

import com.codeborne.selenide.SelenideElement;
import jp.yo.orange.page.ItemModel;

import java.util.Optional;

public class SelectType extends AbstractType {

    public SelectType(final ItemModel itemModel) {
        super(itemModel);
    }

    @Override
    public void input(String value) {
        SelenideElement element = getElement();
        Optional<SelenideElement> target = element.findAll("option")
                .stream()
                .filter(option -> option.getText().trim().equals(value))
                .findFirst();
        target.ifPresent(option -> option.click());
    }

}
