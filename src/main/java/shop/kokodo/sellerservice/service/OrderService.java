package shop.kokodo.sellerservice.service;

import shop.kokodo.sellerservice.dto.order.MonthlyOrderCountDto;

public interface OrderService {

    Long getTodayOrderCount(Long sellerId);

    Long[] getMonthlyOrderCount(Long sellerId);
}
