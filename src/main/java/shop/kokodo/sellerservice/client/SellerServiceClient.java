package shop.kokodo.sellerservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import shop.kokodo.sellerservice.dto.CategoryDto;
import shop.kokodo.sellerservice.dto.PagingProductDto;
import shop.kokodo.sellerservice.dto.product.response.ResponseProduct;

import java.util.List;
import java.util.Map;

@FeignClient(name="product-service")
public interface SellerServiceClient {

    @GetMapping("/product")
    PagingProductDto findByProductNameAndStatusAndDate(@SpringQueryMap Map<String, Object> params);

    @GetMapping("/product/seller/stock/{sellerId}/{page}")
    PagingProductDto findByProductStockLack(@PathVariable long sellerId, @PathVariable int page);

    @GetMapping("/category/all")
    List<CategoryDto> categoryAll();
}
