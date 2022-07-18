package com.sample.sample_prj.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.sample_prj.entity.Purchase;

public interface PurchaseRepo extends JpaRepository<Purchase, Integer>{

}
