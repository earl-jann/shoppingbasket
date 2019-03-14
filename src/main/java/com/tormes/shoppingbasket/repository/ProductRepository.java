package com.tormes.shoppingbasket.repository;

import org.springframework.data.repository.CrudRepository;

import com.tormes.shoppingbasket.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{

}
