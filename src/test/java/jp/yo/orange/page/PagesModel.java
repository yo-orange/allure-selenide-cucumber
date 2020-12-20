package jp.yo.orange.page;

import java.util.List;

@lombok.ToString
@lombok.Builder
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.Data
public class PagesModel {

    private List<PageModel> pages;

}
