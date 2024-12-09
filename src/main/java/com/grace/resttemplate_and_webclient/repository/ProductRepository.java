package com.grace.resttemplate_and_webclient.repository;

import com.grace.resttemplate_and_webclient.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
