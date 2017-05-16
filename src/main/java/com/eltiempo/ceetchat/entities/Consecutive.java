package com.eltiempo.ceetchat.entities;

import org.springframework.data.annotation.Id;

import com.eltiempo.ceetchat.enumeration.ConsecutiveEnum;

public class Consecutive {

	@Id
	private Long id;
	
	private ConsecutiveEnum entity;
	
	private Long count;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public Consecutive(Long id, ConsecutiveEnum entity, Long count) {
		super();
		this.id = id;
		this.entity = entity;
		this.count = count;
	}

	public ConsecutiveEnum getEntity() {
		return entity;
	}

	public void setEntity(ConsecutiveEnum entity) {
		this.entity = entity;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}
	
	
	
}
