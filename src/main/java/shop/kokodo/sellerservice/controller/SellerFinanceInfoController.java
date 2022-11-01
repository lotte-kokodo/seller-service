package shop.kokodo.sellerservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import shop.kokodo.sellerservice.dto.FinanceInfoDto;
import shop.kokodo.sellerservice.service.SellerFinanceInfoService;


@Slf4j
@RestController
@RequestMapping("/sellerFinanceInfo")
@RequiredArgsConstructor
public class SellerFinanceInfoController {

    private final SellerFinanceInfoService sellerFinanceInfoService;

    @GetMapping("/finance")
    FinanceInfoDto getSellerFinanceInfo(@RequestParam Long sellerId){
        return sellerFinanceInfoService.getUniqueSellerFinanceById(sellerId);
    }
}
