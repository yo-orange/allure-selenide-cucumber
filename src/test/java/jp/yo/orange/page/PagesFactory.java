package jp.yo.orange.page;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.google.common.collect.Maps;
import jp.yo.orange.type.*;

import java.util.Map;

public class PagesFactory {

    private Map<String, Map<String, AbstractType>> pagesType = Maps.newHashMap();

    private static PagesFactory instance = new PagesFactory();

    private PagesFactory() {
    }

    public static PagesFactory getInstance() {
        return instance;
    }

    public Map<String, Map<String, AbstractType>> getPagesType() throws Exception {
        if (!pagesType.isEmpty()) {
            return pagesType;
        }

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        PagesModel pagesModel = mapper.readValue(Thread.currentThread().getContextClassLoader().getResourceAsStream("./pages.yml"), PagesModel.class);
        for (PageModel pageModel : pagesModel.getPages()) {
            Map<String, AbstractType> types = Maps.newHashMap();
            pagesType.put(pageModel.getName(), types);
            for (ItemModel itemModel : pageModel.getItems()) {
                switch (itemModel.getType()) {
                    case "input":
                        types.put(itemModel.getName(), new InputTextType(itemModel));
                        break;
                    case "text":
                        types.put(itemModel.getName(), new TextType(itemModel));
                        break;
                    case "select":
                        types.put(itemModel.getName(), new SelectType(itemModel));
                        break;
                    case "button":
                        types.put(itemModel.getName(), new ButtonType(itemModel));
                        break;
                    default:
                        throw new RuntimeException(itemModel.toString());
                }

            }
        }
        return pagesType;
    }
}