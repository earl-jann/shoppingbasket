package com.tormes.shoppingbasket.repository;

import org.springframework.data.repository.CrudRepository;

import com.tormes.shoppingbasket.models.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{

}
