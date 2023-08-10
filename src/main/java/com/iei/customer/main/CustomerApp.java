package com.iei.customer.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.iei.customer.domain.CustomerVO;
import com.iei.customer.service.CustomerService;
import com.iei.customer.service.impl.CustomerServiceImpl;

public class CustomerApp {

	public static void main(String[] args) {
		String resource = "spring-context.xml";
		ApplicationContext ctx = new GenericXmlApplicationContext(resource);
		// bean에서 id로 new CustomerSerivce() 객체생성 대신해줌.
		// object라서 customerServiceImpl 다운캐스팅
//		CustomerService cService = new CustomerSeriviceImple();
		CustomerService cService = (CustomerServiceImpl)ctx.getBean("customerService");
		List<CustomerVO> cList = cService.findAllCustomers();
		if(!cList.isEmpty()) {
			for(CustomerVO customer : cList) {				
				System.out.println(customer.toString());
			}
		}
		System.out.println();
		CustomerVO cOne = (CustomerVO)ctx.getBean("customer");
		System.out.println(cOne.toString());
	}

}
