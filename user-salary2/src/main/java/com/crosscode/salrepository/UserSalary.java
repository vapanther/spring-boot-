package com.crosscode.salrepository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author ankit.tripathi
 *
 */
@Entity
@Table(name="user_salary")
public class UserSalary {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long identifier;
	@Column(name="userid")
	private long userid;
	@Column(name="salary")
	private long salary;
	@Transient
	private String username;
	
	


	public UserSalary(){
		
	}
	
	
	public long getIdentifier() {
		return identifier;
	}


	public void setIdentifier(long identifier) {
		this.identifier = identifier;
	}


	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}

}
