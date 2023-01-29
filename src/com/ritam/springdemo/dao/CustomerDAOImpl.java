package com.ritam.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ritam.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
		
		//get a session
		Session session = sessionFactory.getCurrentSession();
		
		//query to list customers
		Query<Customer> query = session.createQuery("from Customer order by firstName", Customer.class);
		
		//execute query and retrive customers
		List<Customer> customers = query.getResultList();
		
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		
		//get the current hiberante session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//save the customer
		currentSession.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomer(int theId) {
		
		//get the current hiberante session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//get the customer with id
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		
		//get the current hiberbate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//delete customer with primary key
		Query<Customer> query = 
				currentSession.createQuery("delete from Customer where id=:customerId", Customer.class);
		query.setParameter("customerId", theId);
		query.executeUpdate();
	}

}
