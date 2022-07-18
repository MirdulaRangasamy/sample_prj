package com.sample.sample_prj.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.sample_prj.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{

}
