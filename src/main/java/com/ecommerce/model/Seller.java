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
	
	public Seller() {
		
	}

	public Seller(int sellerId, String name, String email, String password) {

		this.sellerId = sellerId;
		this.name = name;
		this.email = email;
		this.password = password;
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

	@Override
	public String toString() {
		return "Seller [sellerId=" + sellerId + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", phone=" + phone + ", shopName=" + shopName + ", address=" + address + "]";
	}
	
	

}
