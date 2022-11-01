package shop.kokodo.sellerservice.controller;

import feign.Param;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import shop.kokodo.sellerservice.service.SellerService;

@RestController
@RequestMapping("/seller")
@Slf4j
public class SellerController {

    private final SellerService sellerService;

    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @GetMapping
    public ResponseEntity getSeller(@RequestParam(value = "id") long id){
        boolean flag = sellerService.findBySellerId(id).isEmpty()? false : true ;

        return ResponseEntity.status(HttpStatus.OK).body(flag);
    }
}
