package com.iei.customer.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// bean쓰려면 필요
@Component("customer")
public class CustomerVO {
	// property말고 constructor-arg에서 사용 
	@Value("1")
	private String customerId;
	@Value("일용자")
	private String customerName;
	@Value("서울시 문방구")
	private String address;
	@Value("khuser01@kh.com")
	private String email;
	
	public CustomerVO() {}

	public CustomerVO(String customerId, String customerName, String address, String email) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.address = address;
		this.email = email;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "회원[아이디=" + customerId + ", 이름=" + customerName + ", 주소=" + address
				+ ", 이메일=" + email + "]";
	}
	
	
}
