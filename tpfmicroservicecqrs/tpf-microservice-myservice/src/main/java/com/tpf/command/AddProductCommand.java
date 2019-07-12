package com.tpf.command;

public class AddProductCommand {
    private final String id;
    private final String name;

    AddProductCommand(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "AddProductCommand{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
