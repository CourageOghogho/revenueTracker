package me.courage.RevenueTracker.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class RevenueType {
	@Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String name;
	private String description;
	private float chargeable;
	
	
	
	
	public RevenueType() {
	}
	public RevenueType(Integer id, String name, String description, float chargeable) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.chargeable = chargeable;
	}
	public RevenueType(String name, String description, float chargeable) {
		this.name = name;
		this.description = description;
		this.chargeable = chargeable;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getChargeable() {
		return chargeable;
	}
	public void setChargeable(float chargeable) {
		this.chargeable = chargeable;
	}
	@Override
	public String toString() {
		return "RevenueTpe [id=" + id + ", name=" + name + ", description=" + description + ", chargeable=" + chargeable
				+ "]";
	}
	
	
	
	

}
