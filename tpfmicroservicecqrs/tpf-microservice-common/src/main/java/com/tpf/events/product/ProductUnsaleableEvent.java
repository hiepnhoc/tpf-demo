package com.tpf.events.product;

import com.tpf.events.AbstractEvent;

public class ProductUnsaleableEvent extends AbstractEvent {
    public ProductUnsaleableEvent(String id) {
        super(id);
    }
}
