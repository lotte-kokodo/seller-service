package shop.kokodo.sellerservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import shop.kokodo.sellerservice.dto.order.OrderCountResponseDto;

@FeignClient(name="order-service", path = "/orders/feign")
public interface OrderServiceClient {

    @GetMapping("/seller/{sellerId}/dashboard/count")
    OrderCountResponseDto getOrderCount(@PathVariable Long sellerId);

    @GetMapping("/seller/{sellerId}/productId")
    Long[] getMonthlyOrderCount(@PathVariable Long sellerId);

}
