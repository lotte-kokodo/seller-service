package shop.kokodo.sellerservice.factory;

import shop.kokodo.sellerservice.entity.Seller;
import shop.kokodo.sellerservice.entity.SellerFinanceInfo;

import java.util.List;

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
public class SellerFactory {
    public static Seller createSeller(Long id, List<SellerFinanceInfo> sellerFinanceInfo){
        return new Seller(id, sellerFinanceInfo,"namhyeop1", "!namhyeop1234", "010-3333-3333",
                "namhyeop@gmail.com", true, true, "1996-12-12",
                "KIMNAMHYEOP", 100000L, "서울특별시 강남구", "서울특별시 강동구",
                "롯데택배", "롯데택배", true, true,
                "VIP");
    }

    public static Seller createSeller(List<SellerFinanceInfo> sellerFinanceInfo){
        return new Seller(sellerFinanceInfo,"namhyeop1", "!namhyeop1234", "010-3333-3333",
                "namhyeop@gmail.com", true, true, "1996-12-12",
                "KIMNAMHYEOP", 100000L, "서울특별시 강남구", "서울특별시 강동구",
                "롯데택배", "롯데택배", true, true,
                "VIP");
    }
}
