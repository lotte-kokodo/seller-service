package shop.kokodo.sellerservice.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class TemplateDto {

    private String imageOne;
    private String imageTwo;
    private String imageThree;
    private String imageFour;
    private String imageFive;

    private String writingTitle;
    private String writingTitleDetail;
    private String writingHighlightOne;
    private String writingHighlightTwo;
    private String writingName;
    private String writingDescription;

    @Builder
    public TemplateDto(String imageOne, String imageTwo, String imageThree, String imageFour, String imageFive,
                       String writingTitle, String writingTitleDetail, String writingHighlightOne, String writingHighlightTwo, String writingName, String writingDescription) {
        this.imageOne = imageOne;
        this.imageTwo = imageTwo;
        this.imageThree = imageThree;
        this.imageFour = imageFour;
        this.imageFive = imageFive;
        this.writingTitle = writingTitle;
        this.writingTitleDetail = writingTitleDetail;
        this.writingHighlightOne = writingHighlightOne;
        this.writingHighlightTwo = writingHighlightTwo;
        this.writingName = writingName;
        this.writingDescription = writingDescription;
    }

    public static TemplateDto createTemplateDto(List<String> templateImg, TemplateArticle templateArticle ){
        return TemplateDto.builder()
                .imageOne(templateImg.get(0))
                .imageTwo(templateImg.get(1))
                .imageThree(templateImg.get(2))
                .imageFour(templateImg.get(3))
                .imageFive(templateImg.get(4))
                .writingTitle(templateArticle.getSellerTitle())
                .writingTitleDetail(templateArticle.getSellerTitleDetail())
                .writingHighlightOne(templateArticle.getSellerTitleHighlight1())
                .writingHighlightTwo(templateArticle.getSellerTitleHighlight2())
                .writingName(templateArticle.getSellerProductName())
                .writingDescription(templateArticle.getSellerProductDetail())
                .build();
    }
}
