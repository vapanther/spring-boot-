package com.crosscode.db1.third;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarRepository extends JpaRepository<Bar, Long> {
  
  Bar findById(Long id); 
  
}