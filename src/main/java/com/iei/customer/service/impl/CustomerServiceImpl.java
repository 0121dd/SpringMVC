package com.iei.customer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iei.customer.domain.CustomerVO;
import com.iei.customer.service.CustomerService;
import com.iei.customer.store.CustomerStore;

//bean 대체 가능(context:component사용하기 spring-context.xml)
//spring-context.xml 하단에 namespaces에서 context 추가하기
//<context:component-scan base-package="com.iei.customer"></context:component-scan> �Է�
@Component("customerService")
public class CustomerServiceImpl implements CustomerService {
	
	//spring-context.xml ref 객체
	@Autowired
	CustomerStore cStore;
//	CustomerStore cStore = new CustomerStoreLogic();
	
	// 1. setter() 메소드로 의존성 주입
	public void setStore(CustomerStore cStore) {
		this.cStore = cStore;
	}
	// 2. 생성자로 의존성 주입
	public CustomerServiceImpl() {}
	
	public CustomerServiceImpl(CustomerStore cStore) {
		this.cStore = cStore;
	}
	
	@Override
	public int registerCustomer(CustomerVO customer) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyCustomer(CustomerVO customer) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeCustomer(String customerId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<CustomerVO> findAllCustomers() {
		List<CustomerVO> cList = cStore.selectAllCustomers();
		return cList;
	}

	@Override
	public CustomerVO findOneById(String customerId) {
		// TODO Auto-generated method stub
		return null;
	}

}
