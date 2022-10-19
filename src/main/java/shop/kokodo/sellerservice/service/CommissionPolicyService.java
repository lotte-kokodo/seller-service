package shop.kokodo.sellerservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import shop.kokodo.sellerservice.dto.CommissionPolicyDto;
import shop.kokodo.sellerservice.repository.CommissionPolicyRepository;

import java.util.List;

/**
 * packageName    : shop.kokodo.sellerservice.controller
 * fileName       : CommissionPolicyService
 * author         : namhyeop
 * date           : 2022/10/17
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/10/17        namhyeop       최초 생성
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class CommissionPolicyService {

    private final CommissionPolicyRepository commissionRepository;

    public List<CommissionPolicyDto> getCommissionPolicy(List<Long> sellerId){
        List<CommissionPolicyDto> commissionBySellerId = commissionRepository.findCommissionPolicyBySellerId(sellerId);
        log.info("commissionBySellerId = {}", commissionBySellerId);
        return commissionBySellerId;
    }
}
