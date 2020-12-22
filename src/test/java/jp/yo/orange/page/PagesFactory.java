package jp.yo.orange.page;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.google.common.collect.Maps;
import jp.yo.orange.type.AbstractType;
import org.reflections.Reflections;

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

        var reflections = new Reflections("jp.yo.orange.type");
        var abstractTypes = reflections.getSubTypesOf(AbstractType.class);

        var mapper = new ObjectMapper(new YAMLFactory());
        var pagesModel = mapper.readValue(Thread.currentThread().getContextClassLoader().getResourceAsStream("./pages.yml"), PagesModel.class);
        for (var pageModel : pagesModel.getPages()) {
            Map<String, AbstractType> types = Maps.newHashMap();
            pagesType.put(pageModel.getName(), types);
            for (var itemModel : pageModel.getItems()) {
                var type = itemModel.getType();
                var typeName = type.substring(0, 1).toUpperCase() + type.substring(1) + "Type";

                var target = abstractTypes.stream()
                        .filter(clazz -> clazz.getSimpleName().equals(typeName))
                        .findFirst();
                if (!target.isPresent()) {
                    continue;
                }
                types.put(itemModel.getName(), target.get().getDeclaredConstructor(ItemModel.class).newInstance(itemModel));
            }
        }
        return pagesType;
    }
}