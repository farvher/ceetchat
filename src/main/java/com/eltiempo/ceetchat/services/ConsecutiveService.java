package com.eltiempo.ceetchat.services;

import com.eltiempo.ceetchat.enumeration.ConsecutiveEnum;

public interface ConsecutiveService {
	
	Long getConsecutive(ConsecutiveEnum consecutiveEnum);
	
	void saveCosecutivive(ConsecutiveEnum consecutiveEnum);

}
