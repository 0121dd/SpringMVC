package com.iei.customer.store;

import java.util.List;

import com.iei.customer.domain.CustomerVO;

public interface CustomerStore {
	/**
	 * 
	 * @param customer
	 * @return
	 */
	public int insertCustomer(CustomerVO customer);
	
	/**
	 * 
	 * @param customer
	 * @return
	 */
	public int updateCustomer(CustomerVO customer);
	
	/**
	 * 
	 * @param customerId
	 * @return
	 */
	public int deleteCustomer(String customerId);
	
	/**
	 * 
	 * @return
	 */
	public List<CustomerVO> selectAllCustomers();
	
	/**
	 * 
	 * @param customerId
	 * @return
	 */
	public CustomerVO selectOneById(String customerId);
	
}
