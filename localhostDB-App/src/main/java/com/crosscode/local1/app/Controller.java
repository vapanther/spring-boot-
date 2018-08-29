package com.crosscode.local1.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@Autowired
	private Repository r;
	@RequestMapping("/search")
	public List<AppMain> getAllTopics()
	{
		return r.findAll();
		
	}

}
