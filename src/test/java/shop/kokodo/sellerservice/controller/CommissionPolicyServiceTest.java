package shop.kokodo.sellerservice.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import shop.kokodo.sellerservice.TestContext;
import shop.kokodo.sellerservice.dto.CommissionPolicyDto;
import shop.kokodo.sellerservice.repository.CommissionPolicyRepository;
import shop.kokodo.sellerservice.repository.SellerRepository;
import shop.kokodo.sellerservice.service.CommissionPolicyService;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

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
class CommissionPolicyServiceTest extends TestContext {

    @Autowired
    CommissionPolicyService commissionPolicyService;
    @Autowired
    CommissionPolicyRepository commissionPolicyRepository;
    @Autowired
    SellerRepository sellerRepository;
    @Autowired
    EntityManager em;

    @Test
    public void getCommissionPolicyTest() throws Exception{
        //given
        //when
        List<Long> sellerIdList = commissionPolicyRepository.findAll().stream().map(s -> s.getId()).collect(Collectors.toList());
        List<CommissionPolicyDto> commissionBySellerId = commissionPolicyRepository.findCommissionPolicyBySellerId(sellerIdList);
        //then
        Assertions.assertThat(commissionBySellerId.get(0).getSellerId()).isEqualTo(sellerIdList.get(0));
        Assertions.assertThat(commissionBySellerId.get(1).getSellerId()).isEqualTo(sellerIdList.get(1));
        Assertions.assertThat(commissionBySellerId.get(2).getSellerId()).isEqualTo(sellerIdList.get(2));
    }
}