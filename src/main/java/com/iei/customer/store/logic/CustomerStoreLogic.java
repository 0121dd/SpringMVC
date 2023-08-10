package com.iei.customer.store.logic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.iei.customer.domain.CustomerVO;
import com.iei.customer.store.CustomerStore;

// bean 대체 가능(context:component사용하기 spring-context.xml)
// spring-context.xml 하단에 namespaces에서 context 추가하기
// <context:component-scan base-package="com.iei.customer"></context:component-scan> �Է�
@Component("customerStore")
public class CustomerStoreLogic implements CustomerStore {

	@Override
	public int insertCustomer(CustomerVO customer) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateCustomer(CustomerVO customer) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteCustomer(String customerId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<CustomerVO> selectAllCustomers() {
		List<CustomerVO> cList = new ArrayList<CustomerVO>();
		// DB연결 안돼있어서 더미데이터 넣음
		for(int i = 0; i < 10; i++) {
			CustomerVO customer = new CustomerVO(i+"", i+"", i+"", i+"");
			cList.add(customer);
		}
		return cList;
	}

	@Override
	public CustomerVO selectOneById(String customerId) {
		// TODO Auto-generated method stub
		return null;
	}

}
