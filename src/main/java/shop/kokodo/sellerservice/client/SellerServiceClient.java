package shop.kokodo.sellerservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import shop.kokodo.sellerservice.dto.response.ResponseProduct;

import java.util.List;
import java.util.Map;

@FeignClient(name="product-service", url = "http://localhost:8001")
public interface SellerServiceClient {

    @GetMapping("/product-service/product")
    List<ResponseProduct> findByProductNameAndStatusAndDate(@SpringQueryMap Map<String, Object> params);
}
