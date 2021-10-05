package com.almin.fudbalskitim;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {
	
	@Autowired
	private TeamRepository teamRepository;
	
	//findAll
	public List<Team> getAllTim(){
		return teamRepository.findAll();
	}
	//Save
	public Team saveTim(Team tim) {
		return teamRepository.save(tim);
	}
	//Delete
	public void deleteTim(Long id) {
		teamRepository.deleteById(id);
	}
	
	//Get one Tim
	public Team getTime(Long id) {
		return teamRepository.findById(id).get();
	}

	

}
