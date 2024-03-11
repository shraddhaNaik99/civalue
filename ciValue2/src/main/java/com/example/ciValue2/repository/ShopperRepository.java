package com.example.ciValue2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ciValue2.entity.Shopper;

@Repository
public interface ShopperRepository extends JpaRepository<Shopper,Long>{
}
