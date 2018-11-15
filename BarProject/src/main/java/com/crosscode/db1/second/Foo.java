package com.crosscode.db1.second;

import javax.persistence.*;

@Entity
@Table(name = "foo")
public class Foo {
  
  @Id
  @GeneratedValue
  @Column(name = "ID")
  private Long id;
  
  @Column(name = "FOO")
  private String foo;
  
  public Foo() {
	super();
}

public Foo(Long id, String foo) {
	super();
	this.id = id;
	this.foo = foo;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getFoo() {
	return foo;
}

public void setFoo(String foo) {
	this.foo = foo;
}

Foo(String foo) {
    this.foo = foo;
  }
  
  
}