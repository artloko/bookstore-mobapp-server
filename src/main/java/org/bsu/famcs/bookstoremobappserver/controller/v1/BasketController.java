package org.bsu.famcs.bookstoremobappserver.controller.v1;

import org.bsu.famcs.bookstoremobappserver.controller.entity.OrderCreateRq;
import org.bsu.famcs.bookstoremobappserver.controller.entity.OrdersRs;
import org.bsu.famcs.bookstoremobappserver.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BasketController {

    private final OrderService orderService;

    @Autowired
    public BasketController(OrderService orderService) {
        this.orderService = orderService;
    }


    @PostMapping("order/add")
    public void createOrder(@RequestBody OrderCreateRq rq) {
        orderService.createOrder(rq);
    }

    @GetMapping("orders")
    @ResponseBody
    public OrdersRs getOrders(@RequestParam String userId) {
        return orderService.getOrders(userId);
    }
}
