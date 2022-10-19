package shop.kokodo.sellerservice.dto;

import lombok.*;
import shop.kokodo.sellerservice.entity.Seller;

/**
 * packageName    : shop.kokodo.calculateservice.entity
 * fileName       : commission
 * author         : namhyeop
 * date           : 2022/09/26
 * description    :
 * 수수로 정책 생성을 위해 필요한 Dto
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/09/26        namhyeop       최초 생성
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class CommissionPolicyDto {

    private Long sellerId;

    private Double basic;

    private Double salesPromotion;

    private Double firstPaymentDelivery;

    private Double deliverySupport;

    private Double discountSupport;

    private Double mediumCompanyCostRefund;

    private Double etc;

}
