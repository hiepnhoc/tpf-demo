package com.tpf.command;

public class CreateAccountCommand extends AbstractAccountCommand<String> {
    private final String creator;
    private final String username;
    private final String password;

    public CreateAccountCommand(String id, String creator, String username, String password) {
        super(id);
        this.creator = creator;
        this.username = username;
        this.password = password;
    }

    public String getCreator() {
        return creator;
    }

    public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	@Override
    public String toString() {
        return "CreateAccountCommand{" +
                "id='" + super.identifier()+ '\'' +
                ", creator='" + creator + '\'' +
                '}';
    }
}
