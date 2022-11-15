package shop.kokodo.sellerservice.dto.product.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RequestProduct {
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



}
