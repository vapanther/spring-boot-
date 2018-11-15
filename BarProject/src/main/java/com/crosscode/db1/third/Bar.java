package com.crosscode.db1.third;

import javax.persistence.*;

@Entity
@Table(name ="bar")
public class Bar {
  
  @Id
  @GeneratedValue
  @Column(name = "ID")
  private Long id;
  
  @Column(name = "BAR")
  private String bar;
  
  Bar(String bar) {
    this.bar = bar;
  }
  
  public Bar() {
	super();
}

public Bar(Long id, String bar) {
	super();
	this.id = id;
	this.bar = bar;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getBar() {
	return bar;
}

public void setBar(String bar) {
	this.bar = bar;
}

}