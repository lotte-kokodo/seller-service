package shop.kokodo.sellerservice.dto;

import lombok.*;
import shop.kokodo.sellerservice.dto.product.request.RequestProduct;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class KafkaProduct {

    long id;
    long categoryId;
    private String name;
    private int price;
    private String displayName;
    private int stock;
    private LocalDateTime deadline;
    private String thumbnail;
    private long sellerId;
    private int deliveryFee;
    private List<String> details;

    @Builder
    public KafkaProduct(long id, long categoryId, String name, int price, String displayName, int stock,
                        LocalDateTime deadline, String thumbnail, long sellerId, int deliveryFee, List<String> details) {
        this.id = id;
        this.categoryId = categoryId;
        this.name = name;
        this.price = price;
        this.displayName = displayName;
        this.stock = stock;
        this.deadline = deadline;
        this.thumbnail = thumbnail;
        this.sellerId = sellerId;
        this.deliveryFee = deliveryFee;
        this.details = details;
    }

    public static KafkaProduct createKafkaProduct(RequestProduct requestProduct, List<String> detailList, String thumbnail){
        return KafkaProduct.builder()
                .id(requestProduct.getId())
                .categoryId(requestProduct.getCategoryId())
                .name(requestProduct.getName())
                .price(requestProduct.getPrice())
                .displayName(requestProduct.getDisplayName())
                .deadline(requestProduct.getDeadline())
                .thumbnail(thumbnail)
                .sellerId(requestProduct.getSellerId())
                .deliveryFee(requestProduct.getDeliveryFee())
                .details(detailList)
                .build();
    }
}
