package shop.kokodo.sellerservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.kokodo.sellerservice.dto.response.Response;
import shop.kokodo.sellerservice.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/todayCount")
    public Response getTodayOrderCount(@RequestHeader Long sellerId) {
        Long todayOrderCount = orderService.getTodayOrderCount(sellerId);
        return Response.success(todayOrderCount);
    }

}
