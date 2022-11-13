package shop.kokodo.sellerservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="order-service", path = "/orders/feign")
public interface OrderServiceClient {

    @GetMapping("/seller/{sellerId}/dashboard/todayCount")
    Long getTodayOrderCount(@PathVariable Long sellerId);

}
