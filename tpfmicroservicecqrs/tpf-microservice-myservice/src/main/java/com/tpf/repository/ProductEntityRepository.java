package com.tpf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tpf.entity.ProductEntity;

@Repository
public interface ProductEntityRepository extends JpaRepository<ProductEntity, Long> {

}
