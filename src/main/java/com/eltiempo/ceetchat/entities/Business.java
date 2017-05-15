package com.eltiempo.ceetchat.entities;

import org.springframework.data.annotation.Id;

public class Business {
	
	@Id
	private Long id;
	
	private String businessName;
	
	private String  url;
	
	private String logo;
	
	private String description;
	
	private String callCenterPhone;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCallCenterPhone() {
		return callCenterPhone;
	}

	public void setCallCenterPhone(String callCenterPhone) {
		this.callCenterPhone = callCenterPhone;
	}
	
	
	

}
