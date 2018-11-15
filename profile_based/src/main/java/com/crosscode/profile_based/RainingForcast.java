package com.crosscode.profile_based;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"rain"})
public class RainingForcast implements WetherForcast {
	public String forcast()
	{
		return "This is raining ";
	}

}
