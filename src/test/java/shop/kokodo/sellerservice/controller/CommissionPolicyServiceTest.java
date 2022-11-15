package shop.kokodo.sellerservice.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import shop.kokodo.sellerservice.dto.CommissionPolicyDto;
import shop.kokodo.sellerservice.entity.CommissionPolicy;
import shop.kokodo.sellerservice.entity.Seller;
import shop.kokodo.sellerservice.repository.CommissionPolicyRepository;
import shop.kokodo.sellerservice.repository.SellerRepository;
import shop.kokodo.sellerservice.service.CommissionPolicyService;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

import static shop.kokodo.sellerservice.factory.CommissionPolicyFactory.createCommissionPolicy;
import static shop.kokodo.sellerservice.factory.SellerFactory.createSeller;

/**
 * packageName    : shop.kokodo.sellerservice.controller
 * fileName       : CommissionPolicyServiceTest
 * author         : namhyeop
 * date           : 2022/10/17
 * description    :
 * CommissionPolicy Service Test
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/10/17        namhyeop       최초 생성
 */
@SpringBootTest
class CommissionPolicyServiceTest {

    @Autowired
    CommissionPolicyService commissionPolicyService;
    @Autowired
    CommissionPolicyRepository commissionPolicyRepository;
    @Autowired
    SellerRepository sellerRepository;

    @BeforeEach
    public void beforeEach(){
        commissionPolicyRepository.deleteAll();;
        sellerRepository.deleteAll();
    }

    @Test
    public void getCommissionPolicyTest() throws Exception{

        //given
        Seller seller1 = createSeller(1L);
        Seller seller2 = createSeller(2L);
        Seller seller3 = createSeller(3L);
        Seller seller4 = createSeller(4L);
        CommissionPolicy commissionPolicy1 = createCommissionPolicy(1L, seller1);
        CommissionPolicy commissionPolicy2 = createCommissionPolicy(2L, seller2);
        CommissionPolicy commissionPolicy3 = createCommissionPolicy(3L, seller3);
        CommissionPolicy commissionPolicy4 = createCommissionPolicy(4L, seller4);

        sellerRepository.save(seller1);
        sellerRepository.save(seller2);
        sellerRepository.save(seller3);
        sellerRepository.save(seller4);

        commissionPolicyRepository.save(commissionPolicy1);
        commissionPolicyRepository.save(commissionPolicy2);
        commissionPolicyRepository.save(commissionPolicy3);
        commissionPolicyRepository.save(commissionPolicy4);

        //when
        List<Long> sellerIdList = new ArrayList<>();
        sellerIdList.add(1L);
        sellerIdList.add(2L);
        sellerIdList.add(3L);
        sellerIdList.add(4L);
        List<CommissionPolicyDto> commissionBySellerId = commissionPolicyRepository.findCommissionPolicyBySellerId(sellerIdList);
        //then
        Assertions.assertThat(commissionBySellerId.get(0).getSellerId()).isEqualTo(1L);
        Assertions.assertThat(commissionBySellerId.get(1).getSellerId()).isEqualTo(2L);
        Assertions.assertThat(commissionBySellerId.get(2).getSellerId()).isEqualTo(3L);
        Assertions.assertThat(commissionBySellerId.get(3).getSellerId()).isEqualTo(4L);
    }
}