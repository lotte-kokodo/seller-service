package shop.kokodo.sellerservice.entity;

import lombok.*;

import javax.persistence.*;

/**
 * packageName    : shop.kokodo.sellerservice.entity
 * fileName       : CommissionPolicy
 * author         : namhyeop
 * date           : 2022/10/17
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/10/17        namhyeop       최초 생성
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class CommissionPolicy extends BaseEntity{

    @Id @GeneratedValue
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "seller_id")
    private Seller seller;

    private Double basic;

    private Double salesPromotion;

    private Double firstPaymentDelivery;

    private Double deliverySupport;

    private Double discountSupport;

    private Double mediumCompanyCostRefund;

    private Double etc;

    public void setSeller(Seller seller){
        this.seller = seller;
    }

    public CommissionPolicy createCommissionPolicy(Seller seller){
        CommissionPolicy commissionPolicy = new CommissionPolicy();
        commissionPolicy.setSeller(seller);
        return commissionPolicy;
    }

    public CommissionPolicy(Seller seller, Double basic, Double salesPromotion, Double firstPaymentDelivery, Double deliverySupport, Double discountSupport, Double mediumCompanyCostRefund, Double etc) {
        this.seller = seller;
        this.basic = basic;
        this.salesPromotion = salesPromotion;
        this.firstPaymentDelivery = firstPaymentDelivery;
        this.deliverySupport = deliverySupport;
        this.discountSupport = discountSupport;
        this.mediumCompanyCostRefund = mediumCompanyCostRefund;
        this.etc = etc;
    }
}
