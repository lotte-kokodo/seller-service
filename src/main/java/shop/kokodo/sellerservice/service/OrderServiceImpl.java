package shop.kokodo.sellerservice.service;

import org.springframework.stereotype.Service;
import shop.kokodo.sellerservice.client.OrderServiceClient;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderServiceClient orderServiceClient;

    public OrderServiceImpl(OrderServiceClient orderServiceClient) {
        this.orderServiceClient = orderServiceClient;
    }

    @Override
    public Long getTodayOrderCount(Long sellerId) {
        return orderServiceClient.getTodayOrderCount(sellerId);
    }

    @Override
    public Long[] getMonthlyOrderCount(Long sellerId) {
        return orderServiceClient.getMonthlyOrderCount(sellerId);
    }
}
