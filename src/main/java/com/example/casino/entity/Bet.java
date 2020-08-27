package com.example.casino.entity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonInclude;
@Entity
@Table (name="bet")
public class Bet  implements Serializable{	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long betId;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@Column(name="number")
	private Integer number;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@Column(name="colour")
	private String colour;
	@Column(name="amount")
	private double amount;
	@Column(name="user")
	private Long user;
	@Column(name="wheelId")
	private Long wheelId;
public Bet() {
	}
	public Long getBetId() {
		return betId;
	}
	public void setBetId(Long betId) {
		this.betId = betId;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Long getUser() {
		return user;
	}
	public void setUser(Long user) {
		this.user = user;
	}
	public Long getWheelIdl() {
		return wheelId;
	}
	public void setWheelId(Long wheelId) {
		this.wheelId = wheelId;
	}
	private static final long serialVersionUID = 1L;
}
