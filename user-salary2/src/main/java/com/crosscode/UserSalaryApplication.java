package com.crosscode;
import org.jfree.util.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @author ankit.tripathi
 * 
 * UserSalaryApplication
 *
 */
@SpringBootApplication

public class UserSalaryApplication extends SpringBootServletInitializer {

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(UserSalaryApplication.class);
        
    }
	public static void main(String[] args) {
		 
         Log.info("hi this is main");
		SpringApplication.run(UserSalaryApplication.class, args);
		Log.info("hi this is main & after running ");
	}
	
	


	

}
