package shop.kokodo.sellerservice.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseProduct {
    long id;
    long categoryId;
    String categoryName;
    private String name;
    private int price;
    private String displayName;
    private int stock;
    private LocalDateTime deadline;
    private String thumbnail;
    private long sellerId;
    private int deliveryFee;
}