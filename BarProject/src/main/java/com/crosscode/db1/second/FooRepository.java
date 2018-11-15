package com.crosscode.db1.second;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FooRepository extends JpaRepository<Foo, Long> {
  
  Foo findById(Long id); 
  
}