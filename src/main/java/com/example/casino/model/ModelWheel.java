package com.example.casino.model;
import com.example.casino.entity.Wheel;
public class ModelWheel {
	private Long id;
	private Boolean status;	
	public ModelWheel() {
	}
public ModelWheel(Long id, Boolean status) {
		this.id = id;
		this.status=status;
	}
	public ModelWheel(Long id) {	
		this.id = id;
	}
	public ModelWheel(Wheel wheel) {
		this.id=wheel.getId();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}	
}
