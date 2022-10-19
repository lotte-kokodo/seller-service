package shop.kokodo.sellerservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import shop.kokodo.sellerservice.dto.CommissionPolicyDto;
import shop.kokodo.sellerservice.service.CommissionPolicyService;

import java.util.List;



/**
 * packageName    : shop.kokodo.sellerservice.controller
 * fileName       : CommissionPolicyController
 * author         : namhyeop
 * date           : 2022/10/17
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/10/17        namhyeop       최초 생성
 */

@Slf4j
@RestController
@RequestMapping("/seller")
@RequiredArgsConstructor
public class CommissionPolicyController {

    private final CommissionPolicyService commissionPolicyService;

    @GetMapping("/commissionPolicy")
    public List<CommissionPolicyDto> searchCommissionPolicy(@RequestParam List<Long> sellerId){
        List<CommissionPolicyDto> commissionPolicyList = commissionPolicyService.getCommissionPolicy(sellerId);
        return commissionPolicyList;
    }
}
