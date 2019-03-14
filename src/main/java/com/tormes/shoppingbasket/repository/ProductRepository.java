package com.tormes.shoppingbasket.repository;
package com.tormes.shoppingbasket.repository;

import org.springframework.data.repository.CrudRepository;

import com.tormes.shoppingbasket.models.Customer;

public interface ProductRepository extends CrudRepository<Customer, Long>{

}
