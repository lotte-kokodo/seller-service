package shop.kokodo.sellerservice.dto.order;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class MonthlyOrderCountDto {
    private Long janCount;
    private Long febCount;
    private Long marCount;
    private Long aprCount;
    private Long mayCount;
    private Long junCount;
    private Long julCount;
    private Long augCount;
    private Long septCount;
    private Long octCount;
    private Long novCount;
    private Long decCount;
}
