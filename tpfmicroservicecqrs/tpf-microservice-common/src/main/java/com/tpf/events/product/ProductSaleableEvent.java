package com.tpf.events.product;

import com.tpf.events.AbstractEvent;

public class ProductSaleableEvent extends AbstractEvent {
    public ProductSaleableEvent(String id) {
        super(id);
    }
}
