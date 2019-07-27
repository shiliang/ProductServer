package com.product.server.domain.impl;

import com.product.common.DecreaseStockInput;
import com.product.server.domain.OrderDomainEvent;
import com.product.server.entity.OrderMaster;
import lombok.Data;

import java.io.Serializable;
import java.util.List;


@Data
public class OrderCreated implements OrderDomainEvent, Serializable{
    private static final long serialVersionUID = 1L;
    private OrderMaster orderMaster;
    private List<DecreaseStockInput> decreaseStockInputs;

    public OrderCreated(){}

    public OrderCreated(OrderMaster orderMaster, List<DecreaseStockInput> decreaseStockInputs) {
        this.orderMaster = orderMaster;
        this.decreaseStockInputs = decreaseStockInputs;
    }
}
