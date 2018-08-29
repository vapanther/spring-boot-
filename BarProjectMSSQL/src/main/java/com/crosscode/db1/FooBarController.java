package com.crosscode.db1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crosscode.db1.second.Foo;
import com.crosscode.db1.second.FooRepository;
import com.crosscode.db1.third.Bar;
import com.crosscode.db1.third.BarRepository;

@RestController
public class FooBarController {
  
  private final FooRepository fooRepo;
  private final BarRepository barRepo;
  
  @Autowired
  FooBarController(FooRepository fooRepo, BarRepository barRepo) {
    this.fooRepo = fooRepo;
    this.barRepo = barRepo;
  }
  
  @RequestMapping("/{id}")
  public String fooBar(@PathVariable("id") Long id) {
    Foo foo = fooRepo.findById(id);
    Bar bar = barRepo.findById(id);
    
    return foo.getId() + " " + foo.getFoo() + " " + bar.getBar(); 
  }
}
