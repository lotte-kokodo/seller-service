package shop.kokodo.sellerservice.dummy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ActiveProfiles;
import shop.kokodo.sellerservice.entity.CommissionPolicy;
import shop.kokodo.sellerservice.entity.Seller;
import shop.kokodo.sellerservice.entity.SellerFinanceInfo;
import shop.kokodo.sellerservice.repository.CommissionPolicyRepository;
import shop.kokodo.sellerservice.repository.SellerFinanceInfoRepository;
import shop.kokodo.sellerservice.repository.SellerRepository;

import java.util.List;

import static shop.kokodo.sellerservice.factory.CommissionPolicyFactory.createCommissionPolicy;
import static shop.kokodo.sellerservice.factory.SellerFactory.createSeller;
import static shop.kokodo.sellerservice.factory.SellerFinanceFactory.createSellerFinanceInfo;


/**
 * packageName    : shop.kokodo.calculateservice.dummy
 * fileName       : calculateDummy
 * author         : namhyeop
 * date           : 2022/10/26
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/10/26        namhyeop       최초 생성
 */
@Component
@ActiveProfiles("test")
public class DummyData implements CommandLineRunner {

    @Autowired
    SellerRepository sellerRepository;
    @Autowired
    SellerFinanceInfoRepository sellerFinanceInfoRepository;
    @Autowired
    CommissionPolicyRepository commissionPolicyRepository;

    public static Seller SELLER1;
    public static Seller SELLER2;
    public static Seller SELLER3;

    public static CommissionPolicy COMMISSIONPOLICY1;
    public static CommissionPolicy COMMISSIONPOLICY2;
    public static CommissionPolicy COMMISSIONPOLICY3;
    public static SellerFinanceInfo SELLERFINANCEINFO1;
    public static SellerFinanceInfo SELLERFINANCEINFO2;
    public static SellerFinanceInfo SELLERFINANCEINFO3;
    public static SellerFinanceInfo SELLERFINANCEINFO4;
    public static SellerFinanceInfo SELLERFINANCEINFO5;
    public static SellerFinanceInfo SELLERFINANCEINFO6;
    public static SellerFinanceInfo SELLERFINANCEINFO7;
    public static SellerFinanceInfo SELLERFINANCEINFO8;
    public static SellerFinanceInfo SELLERFINANCEINFO9;


    @Override
    public void run(String... args) throws Exception {
        SELLERFINANCEINFO1 = createSellerFinanceInfo("신한은행", "110-501-3234-3422", "김남협", true);
        SELLERFINANCEINFO2 = createSellerFinanceInfo("카카오뱅크", "110-213-5674-2312", "김남협", false);
        SELLERFINANCEINFO3 = createSellerFinanceInfo("농협은행", "110-234-4363-5654", "김남협", false);
        SELLERFINANCEINFO4 = createSellerFinanceInfo("신한은행", "110-502-3234-3422", "도수호", true);
        SELLERFINANCEINFO5 = createSellerFinanceInfo("카카오은행", "110-214-5674-2312", "도수호", false);
        SELLERFINANCEINFO6 = createSellerFinanceInfo("농협은행", "110-235-4363-5654", "도수호", false);
        SELLERFINANCEINFO7 = createSellerFinanceInfo("신한은행", "110-525-3234-3422", "권나연", true);
        SELLERFINANCEINFO8 = createSellerFinanceInfo("카카오은행", "110-432-5674-2312", "권나연", false);
        SELLERFINANCEINFO9 = createSellerFinanceInfo("농협은행", "110-213-4363-5654", "권나연", false);

        SELLER1 = createSeller(List.of(SELLERFINANCEINFO1, SELLERFINANCEINFO2, SELLERFINANCEINFO3));
        SELLER2 = createSeller(List.of(SELLERFINANCEINFO4, SELLERFINANCEINFO5, SELLERFINANCEINFO6));
        SELLER3 = createSeller(List.of(SELLERFINANCEINFO7, SELLERFINANCEINFO8, SELLERFINANCEINFO9));

        COMMISSIONPOLICY1 =  commissionPolicyRepository.save(createCommissionPolicy(1L, SELLER1));
        COMMISSIONPOLICY2 =  commissionPolicyRepository.save(createCommissionPolicy(2L, SELLER2));
        COMMISSIONPOLICY3 =  commissionPolicyRepository.save(createCommissionPolicy(3L, SELLER3));
    }
}
