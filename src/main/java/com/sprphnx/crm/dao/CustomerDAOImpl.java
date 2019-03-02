package com.sprphnx.crm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sprhpnx.crm.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public Customer getCustomerById(long id) {
		Session session = sessionFactory.getCurrentSession();
		Customer customer = session.get(Customer.class, id);
		
		return customer;
	}

	@Override
	@Transactional
	public List<Customer> getAllCustomer() {
		Session session = sessionFactory.getCurrentSession();
		List<Customer> customers = session.createQuery("from Customer").getResultList();
		
		return customers;
	}

	
	
}
