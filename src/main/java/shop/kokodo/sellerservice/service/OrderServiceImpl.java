package shop.kokodo.sellerservice.service;

import org.springframework.stereotype.Service;
import shop.kokodo.sellerservice.client.OrderServiceClient;
import shop.kokodo.sellerservice.dto.order.DashboardOrderCountDto;
import shop.kokodo.sellerservice.dto.order.OrderCountResponseDto;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderServiceClient orderServiceClient;

    public OrderServiceImpl(OrderServiceClient orderServiceClient) {
        this.orderServiceClient = orderServiceClient;
    }

    @Override
    public DashboardOrderCountDto getOrderCount(Long sellerId) {
        OrderCountResponseDto orderCountResponseDto = orderServiceClient.getOrderCount(sellerId);
        return new DashboardOrderCountDto(orderCountResponseDto.getTodayOrderCount(), orderCountResponseDto.getYesterdayOrderCount());
    }

    @Override
    public Long[] getMonthlyOrderCount(Long sellerId) {
        return orderServiceClient.getMonthlyOrderCount(sellerId);
    }
}
