package com.almin.fudbalskitim.players;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.almin.fudbalskitim.Team;

@Entity
@Table
public class Player {
	
	public Player() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column
	private int dressNumber; //
	
	@Column
	@Enumerated(EnumType.STRING)
	private PositionPlay positionPlay;
	
//	@ManyToOne(targetEntity = Team.class,cascade = CascadeType.ALL)
//	@JoinColumn(name = "team_id",referencedColumnName = "id")
	
	@ManyToOne
	private Team team; //
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getDressNumber() {
		return dressNumber;
	}
	public void setDressNumber(int dressNumber) {
		this.dressNumber = dressNumber;
	}
	public PositionPlay getPositionPlay() {
		return positionPlay;
	}
	public void setPositionPlay(PositionPlay positionPlay) {
		this.positionPlay = positionPlay;
	}
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	
	
	
	
	

}
