package com.almin.fudbalskitim;

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
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;

import com.almin.fudbalskitim.players.Player;


@Entity
@Table
public class Team {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@Column
	private String teamName;
	
	@Column
	private String country;
	
	@Column
	private String coach;
	
	@Column
	private int numberOfPlayer;
	
	@Column
	private int numberOfThrophey;
	
	@OneToMany(targetEntity = Player.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "team_id",referencedColumnName = "id")
	List<Player>players;
	
	public Team() {
	
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCoach() {
		return coach;
	}

	public void setCoach(String coach) {
		this.coach = coach;
	}

	public int getNumberOfPlayer() {
		return numberOfPlayer;
	}

	public void setNumberOfPlayer(int numberOfPlayer) {
		this.numberOfPlayer = numberOfPlayer;
	}

	public int getNumberOfThrophey() {
		return numberOfThrophey;
	}

	public void setNumberOfThrophey(int numberOfThrophey) {
		this.numberOfThrophey = numberOfThrophey;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	
	
	

}
