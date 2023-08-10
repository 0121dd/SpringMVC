package com.iei.customer.service;

import java.util.List;

import com.iei.customer.domain.CustomerVO;

public interface CustomerService {
	/**
	 * 
	 * @param customer
	 * @return
	 */
	public int registerCustomer(CustomerVO customer);
	
	/**
	 * 
	 * @param customer
	 * @return
	 */
	public int modifyCustomer(CustomerVO customer);
	
	/**
	 * 
	 * @param customerId
	 * @return
	 */
	public int removeCustomer(String customerId);
	
	/**
	 * 
	 * @return
	 */
	public List<CustomerVO> findAllCustomers();
	
	/**
	 * 
	 * @param customerId
	 * @return
	 */
	public CustomerVO findOneById(String customerId);

}
