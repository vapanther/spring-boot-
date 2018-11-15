package com.crosscode.profile_based;


import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"sunny", "default"})
public class SunnyDayService implements WetherForcast  {

	public String forcast()
	{
		 return "Today is sunny day!";
	}

}
