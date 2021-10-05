package com.almin.fudbalskitim.players.playerrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.almin.fudbalskitim.players.Player;

public interface PlayerRepositroy extends JpaRepository<Player,Long> {

}
