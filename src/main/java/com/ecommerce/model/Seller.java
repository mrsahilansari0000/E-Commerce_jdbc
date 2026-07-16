package com.ecommerce.model;

import java.sql.Timestamp;

public class Seller {

	private int sellerId;
	private String name;
	private String email;
	private String password;
	private String phone;
	private String shopName;
	private String address;

	public Seller(int sellerId, String name, String email, String password, String phone, String shopName,
			String address) {

		this.sellerId = sellerId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.shopName = shopName;
		this.address = address;
	}

	public int getSellerId() {
		return sellerId;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getPhone() {
		return phone;
	}

	public String getShopName() {
		return shopName;
	}

	public String getAddress() {
		return address;
	}
	
	

}
