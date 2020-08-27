package com.example.casino.entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table (name="wheel")
public class Wheel implements Serializable{	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="status")
	private boolean status;
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name= "wheelId", referencedColumnName= "id")
	private List <Bet> bet= new ArrayList<>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public boolean isStatus() {
		return status;
	}
	public void setState(boolean state) {
		this.status = state;
	}
	public Wheel() {
		this.status=false;
	}
	public void setStatus(boolean status){
        this.status = status;
    }
	public List<Bet> getBet() {
		return bet;
	}
	public void setBet(List<Bet> bet) {
		this.bet = bet;
	}
	private static final long serialVersionUID = 1L;
}