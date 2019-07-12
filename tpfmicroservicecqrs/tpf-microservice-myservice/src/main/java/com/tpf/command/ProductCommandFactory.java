package com.tpf.command;

public enum ProductCommandFactory {
    INSTANCE;

    public AddProductCommand newAddProductCommand(String id, String name) {
        return new AddProductCommand(id, name);
    }
}
