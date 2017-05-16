package com.eltiempo.ceetchat.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eltiempo.ceetchat.entities.Business;
import com.eltiempo.ceetchat.repository.BusinessRepository;

@RestController
public class BusinessController {

	@Autowired
	BusinessRepository businessRepository;

	@GetMapping("/business/list")
	public List<Business> getBusiness() {
		return businessRepository.findAll();
	}

	@PostMapping("/business/save")
	public String saveBusiness(Long id, String businessName, String callCenterPhone, String description, String logo,
			String url) {
		Business business = new Business();
		business.setId(id);
		business.setBusinessName(businessName);
		business.setCallCenterPhone(callCenterPhone);
		business.setDescription(description);
		business.setLogo(logo);
		business.setUrl(url);
		businessRepository.save(business);
		return "saved";
	}

}
