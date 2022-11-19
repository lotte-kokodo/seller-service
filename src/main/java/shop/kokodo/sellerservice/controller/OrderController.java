package shop.kokodo.sellerservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.kokodo.sellerservice.dto.order.DashboardOrderCountDto;
import shop.kokodo.sellerservice.dto.order.MonthlyOrderCountDto;
import shop.kokodo.sellerservice.dto.order.OrderCountResponseDto;
import shop.kokodo.sellerservice.dto.response.Response;
import shop.kokodo.sellerservice.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/count")
    public Response getOrderCount(@RequestHeader Long sellerId) {
        DashboardOrderCountDto orderCountDto = orderService.getOrderCount(sellerId);
        return Response.success(orderCountDto);
    }

    @GetMapping("/monthlyCount")
    public Response getMonthlyOrderCount(@RequestHeader Long sellerId) {
        Long[] monthlyOrderCount = orderService.getMonthlyOrderCount(sellerId);
        return Response.success(monthlyOrderCount);
    }
}
