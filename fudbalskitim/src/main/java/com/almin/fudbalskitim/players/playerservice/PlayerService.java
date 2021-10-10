package com.almin.fudbalskitim.players.playerservice;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	public void deletePlayer(Long id) {
		playerRepositroy.deleteById(id);
	}
	
	public Player getPlayerById(Long id) {
		return playerRepositroy.findById(id).get();
	}

	public List<Player>getPlayerByTeam(Long id){
		System.out.println("TeamdID : " + id);
		return getAllPlayer().stream()
							.filter(player->player.getTeam().getId().equals(id))
							.collect(Collectors.toList());
	}
	
	public void deletePlayer(Player player) {
		playerRepositroy.delete(player);
	}
	
}
