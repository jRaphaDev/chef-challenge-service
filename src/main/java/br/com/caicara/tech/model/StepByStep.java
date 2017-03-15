package br.com.caicara.tech.model;

import java.io.Serializable;

public class StepByStep implements Serializable {
	
	private static final long serialVersionUID = -8149611728695891455L;
	private long id;
	private String description;
	
	public StepByStep(long id, String description) {
		this.id = id;
		this.description = description;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

}
