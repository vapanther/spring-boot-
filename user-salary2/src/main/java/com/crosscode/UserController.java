package com.crosscode;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.crosscode.repository.User;
import com.crosscode.salrepository.UserSalary;

/**
 * @author ankit.tripathi
 *
 */
@Controller
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	SalaryService salaryService;

	@ModelAttribute("users")
	public List<User> getUsers() {

		return (List<User>) userService.getUser();
	}

	@RequestMapping("/")
	public String getUsers(Model model) {

		model.addAttribute("usersalary", new UserSalary());
		return "home";
	}

	@RequestMapping(value = "/salSave", method = RequestMethod.POST)
	public String saveUserSalary(@ModelAttribute("usersalary") UserSalary usersalary, Model model) {

		salaryService.saveSalary(usersalary);

		return "home";
	}
}
