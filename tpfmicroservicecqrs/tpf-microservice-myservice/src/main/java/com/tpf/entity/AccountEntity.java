package com.tpf.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "accounts")
public class AccountEntity {
    @Id
    private String id;
    
    @Column(columnDefinition = "balance")
    private double balance;
    
    @NotBlank
    @Column(columnDefinition = "owner")
    private String owner;
    
    @NotBlank
    @Column(columnDefinition = "username", unique = true)
    private String username;
    
    @NotBlank
    @Column(columnDefinition = "password")
    private String password;

    public AccountEntity() {
    }

    public AccountEntity(String id, double balance, String owner, String username, String password) {
        this.id = id;
        this.balance = balance;
        this.owner = owner;
        this.username = username;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public String getOwner() {
        return owner;
    }
    
    public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountEntity that = (AccountEntity) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "AccountEntity{" +
                "id='" + id + '\'' +
                ", balance=" + balance +
                ", owner='" + owner + '\'' +
                '}';
    }
}
