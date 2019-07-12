package com.tpf.command;


public class CloseAccountCommand extends AbstractAccountCommand<String>{

    CloseAccountCommand(String id) {
        super(id);
    }

    @Override
    public String toString() {
        return "CloseAccountCommand{" +
                "id='" + super.identifier() + '\'' +
                '}';
    }
}
