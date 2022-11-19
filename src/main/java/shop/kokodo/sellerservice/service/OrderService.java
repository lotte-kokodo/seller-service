package shop.kokodo.sellerservice.service;

import shop.kokodo.sellerservice.dto.order.DashboardOrderCountDto;

public interface OrderService {

    DashboardOrderCountDto getOrderCount(Long sellerId);

    Long[] getMonthlyOrderCount(Long sellerId);
}
