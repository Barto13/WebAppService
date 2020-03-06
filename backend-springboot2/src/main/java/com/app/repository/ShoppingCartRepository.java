//package net.guides.springboot2.springboot2jpacrudexample.repository;
//
//import java.sql.Date;
//import java.util.List;
//
//import org.springframework.data.repository.CrudRepository;
//
//import net.guides.springboot2.springboot2jpacrudexample.model.Product;
//
//public interface ProductRepository extends CrudRepository<Product, Long> {
//    List<Product> findByExpiration(Date expiration);
//}

package com.app.repository;

import com.app.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends JpaRepository<Product, Long>{

}
