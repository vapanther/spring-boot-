package com.crosscode;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crosscode.repository.UserRepository;
import com.crosscode.salrepository.SalaryRepository;
import com.crosscode.salrepository.UserSalary;

/**
 * @author ankit.tripathi
 *
 */
@Service
public class SalaryService {
	@Autowired
	SalaryRepository salaryRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public void saveSalary(UserSalary salary){
		
		salaryRepository.save(salary);
	}
	
	public List<UserSalary> getUserSalary(){
		
		return (List<UserSalary>) salaryRepository.findAll();
		
				
	}
	
public List<UserSalary> getSalaryWithUserName(){
		
		List<UserSalary> userSalaryList = new ArrayList<UserSalary>();
		
		for(UserSalary userSalary:(List<UserSalary>) salaryRepository.findAll()){
			userSalary.setUsername(userRepository.findOne(userSalary.getUserid()).getUsername());
			userSalaryList.add(userSalary);
		}
		return userSalaryList;
		
		
	}

}
