package com.product.server.domain.impl;

import com.product.common.DecreaseStockInput;
import com.product.server.domain.OrderDomainEvent;
import lombok.Data;

import java.util.List;


@Data
public class OrderCreated implements OrderDomainEvent {
    private List<DecreaseStockInput> decreaseStockInputs;

    public OrderCreated(List<DecreaseStockInput> decreaseStockInputs) {
        this.decreaseStockInputs = decreaseStockInputs;
    }
}
