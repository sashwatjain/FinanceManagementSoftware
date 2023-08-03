package com.fms;

public class User {
    private int id;
    private String name;
    private String phone;
    private String email;
    private String username;
    private String password;
    private String address;
    private String cardType;
    private String bank;
    private String accountNumber;
    private String ifscCode;
    private double balance;
    private boolean isactivated; 
    

    // Default constructor
    public User() {
    }

    // Parameterized constructor
    public User(int id, String name, String phone, String email, String username,
                String password, String address, String cardType, String bank,
                String accountNumber, String ifscCode) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.username = username;
        this.password = password;
        this.address = address;
        this.cardType = cardType;
        this.bank = bank;
        this.accountNumber = accountNumber;
        this.ifscCode = ifscCode;
        if(this.cardType == "Gold") {this.balance = 50000;}
        else {this.balance = 100000;}
    }

    // Getter and Setter methods for each attribute
    public int getId() {
        return id;
    }
    
    public double getBalance() {
        return balance;
    }
    

    public void setId(int id) {
        this.id = id;
    }
    
    public void setBalance(double d) {
        this.balance = d;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

	public boolean isActivated() {
		// TODO Auto-generated method stub
		return this.isactivated;
	}
	
	public void setActivated( boolean b) {
		this.isactivated = b;
	}
}
