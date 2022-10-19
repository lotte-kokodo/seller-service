package shop.kokodo.sellerservice.controller;

import feign.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.kokodo.sellerservice.client.SellerServiceClient;
import shop.kokodo.sellerservice.dto.response.ResponseProduct;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final SellerServiceClient sellerServiceClient;

    @Autowired
    public ProductController(SellerServiceClient sellerServiceClient) {
        this.sellerServiceClient = sellerServiceClient;
    }

    @GetMapping
    public ResponseEntity findByProductNameAndStatusAndDate(@Param String productName, @Param Integer status
            , @Param String startDate, @Param String endDate, @Param Long sellerId){
        Map<String, Object> params = new HashMap<>();
        params.put("productName",productName);
        params.put("status",status);
        params.put("startDate",startDate);
        params.put("endDate",endDate);
        params.put("sellerId",sellerId);

        List<ResponseProduct> list = sellerServiceClient.findByProductNameAndStatusAndDate(params);

        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
}
