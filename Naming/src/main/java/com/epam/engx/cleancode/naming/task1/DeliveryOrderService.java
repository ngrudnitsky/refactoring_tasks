package com.epam.engx.cleancode.naming.task1;

import com.epam.engx.cleancode.naming.task1.thirdpartyjar.*;

public class DeliveryOrderService implements OrderService{
    private DeliveryService deliveryService;
    private OrderFulfilmentService orderFulfilmentService;

    public void submitOrder(Order order) {
        if (deliveryService.isDeliverable()) {
            orderFulfilmentService.fulfilProducts(order.getProducts());
        } else {
            throw new NotDeliverableOrderException();
        }
    }

    public void setDeliveryService(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    public void setOrderFulfilmentService(OrderFulfilmentService orderFulfilmentService) {
        this.orderFulfilmentService = orderFulfilmentService;
    }
}
