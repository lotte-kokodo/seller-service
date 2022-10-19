package shop.kokodo.sellerservice.factory;

import shop.kokodo.sellerservice.entity.CommissionPolicy;
import shop.kokodo.sellerservice.entity.Seller;

/**
 * packageName    : shop.kokodo.sellerservice.factory
 * fileName       : CommissionPolicyFactory
 * author         : namhyeop
 * date           : 2022/10/17
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/10/17        namhyeop       최초 생성
 */
public class CommissionPolicyFactory {

    public static CommissionPolicy createCommissionPolicy(Long id, Seller seller){
        return new CommissionPolicy(id, seller, 0.5, 0.5, 0.5, 0.5, 0.5, 0.5, 0.0);
    }
}
