package shop.kokodo.sellerservice.dto;


import lombok.*;
import org.springframework.stereotype.Service;
import shop.kokodo.sellerservice.dto.product.request.RequestProduct;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class KafkaProductTemplate {

    long categoryId;
    private String name;
    private int price;
    private String displayName;
    private int stock;
    private LocalDateTime deadline;
    private String thumbnail;
    private long sellerId;
    private int deliveryFee;
    private TemplateDto templateDto;

    @Builder
    public KafkaProductTemplate(long categoryId, String name, int price, String displayName, int stock,
                                LocalDateTime deadline, String thumbnail, long sellerId, int deliveryFee, TemplateDto templateDto) {
        this.categoryId = categoryId;
        this.name = name;
        this.price = price;
        this.displayName = displayName;
        this.stock = stock;
        this.deadline = deadline;
        this.thumbnail = thumbnail;
        this.sellerId = sellerId;
        this.deliveryFee = deliveryFee;
        this.templateDto = templateDto;
    }

    public static KafkaProductTemplate createKafkaProductTemplate(RequestProduct requestProduct, TemplateDto templateDto,String thumbnailStr){
        return KafkaProductTemplate.builder()
                .categoryId(requestProduct.getCategoryId())
                .name(requestProduct.getName())
                .price(requestProduct.getPrice())
                .displayName(requestProduct.getDisplayName())
                .stock(requestProduct.getStock())
                .deadline(requestProduct.getDeadline())
                .thumbnail(thumbnailStr)
                .sellerId(requestProduct.getSellerId())
                .deliveryFee(requestProduct.getDeliveryFee())
                .templateDto(templateDto)
                .build();
    }
}
