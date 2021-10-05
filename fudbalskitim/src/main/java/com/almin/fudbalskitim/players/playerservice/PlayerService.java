package com.almin.fudbalskitim.players.playerservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.almin.fudbalskitim.players.Player;
import com.almin.fudbalskitim.players.playerrepository.PlayerRepositroy;



@Service
public class PlayerService {
	
	@Autowired
	private PlayerRepositroy playerRepositroy;
	
	public List<Player>getAllPlayer(){
		return playerRepositroy.findAll();
	}
	
	public Player savePlayer(Player player) {
		return playerRepositroy.save(player);
	}
	
	

}
