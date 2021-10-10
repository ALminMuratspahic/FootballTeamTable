package com.almin.fudbalskitim.players.playerrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.almin.fudbalskitim.Team;
import com.almin.fudbalskitim.players.Player;

public interface PlayerRepositroy extends JpaRepository<Player,Long> {

	
	List<Player> findByTeam(Team team);
}
