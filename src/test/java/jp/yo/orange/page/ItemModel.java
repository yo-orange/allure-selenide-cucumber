package jp.yo.orange.page;

@lombok.ToString
@lombok.Builder
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.Data
public class ItemModel {

    private String name;

    private String type;

    private String css;

    private String xpath;

}
