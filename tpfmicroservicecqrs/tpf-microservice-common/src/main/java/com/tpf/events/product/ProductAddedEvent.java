package com.tpf.events.product;

import com.tpf.events.AbstractEvent;

public class ProductAddedEvent extends AbstractEvent {
    private final String name;

    public ProductAddedEvent(String id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
}
