package shop.kokodo.sellerservice.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class TemplateArticle {

    private String sellerTitle;
    private String sellerTitleDetail;
    private String sellerTitleHighlight1;
    private String sellerTitleHighlight2;
    private String sellerProductName;
    private String sellerProductDetail;

    @Builder
    public TemplateArticle(String sellerTitle, String sellerTitleDetail, String sellerTitleHighlight1,
                           String sellerTitleHighlight2, String sellerProductName, String sellerProductDetail) {
        this.sellerTitle = sellerTitle;
        this.sellerTitleDetail = sellerTitleDetail;
        this.sellerTitleHighlight1 = sellerTitleHighlight1;
        this.sellerTitleHighlight2 = sellerTitleHighlight2;
        this.sellerProductName = sellerProductName;
        this.sellerProductDetail = sellerProductDetail;
    }
}

