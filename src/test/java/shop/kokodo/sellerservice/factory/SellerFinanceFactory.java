package shop.kokodo.sellerservice.factory;

import shop.kokodo.sellerservice.entity.SellerFinanceInfo;

/**
 * packageName    : shop.kokodo.sellerservice.factory
 * fileName       : SellerFinanceFactory
 * author         : namhyeop
 * date           : 2022/11/03
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/11/03        namhyeop       최초 생성
 */
public class SellerFinanceFactory {

    public static SellerFinanceInfo createSellerFinanceInfo(String bankName, String accountNumber, String accountHolder, Boolean delegateAccount){
        return new SellerFinanceInfo(bankName, accountNumber, accountHolder, delegateAccount);
    }
}
