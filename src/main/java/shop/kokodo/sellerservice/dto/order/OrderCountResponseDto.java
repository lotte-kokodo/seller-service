package shop.kokodo.sellerservice.dto.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderCountResponseDto {

    private Integer todayOrderCount;
    private Integer yesterdayOrderCount;

}
