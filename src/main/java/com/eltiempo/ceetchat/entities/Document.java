package com.eltiempo.ceetchat.entities;


import org.springframework.data.annotation.Id;

public class Document {

	@Id
	private Long id;

	private String content;

	private String documentName;

	
	 

	public Document(Long id, String content, String documentName) {
		super();
		this.id = id;
		this.content = content;
		this.documentName = documentName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}


}
