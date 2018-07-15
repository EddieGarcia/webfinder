package com.eddgarcia.webfinder.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.eddgarcia.webfinder.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{
	List<Customer> findByLastName(String lastName);
}