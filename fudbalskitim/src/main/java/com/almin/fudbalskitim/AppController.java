package com.almin.fudbalskitim;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.almin.fudbalskitim.players.Player;
import com.almin.fudbalskitim.players.playerservice.PlayerService;

@Controller
public class AppController {
	
	@Autowired
	private TeamService teamService;
	@Autowired
	private  PlayerService playerService;
	
	@RequestMapping("/")
	public String getAllTime(Model model){
		List<Team> listOfTim= teamService.getAllTim();
		model.addAttribute("teams", listOfTim);		
		return "timHomePage";
	}
	
	@RequestMapping("/newTeam")
	public String createNewTeam(Model model) {
		Team team = new Team();
		model.addAttribute("team", team);
		
		return "create_team";
	}
	
	@RequestMapping(value = "/saveTeam", method = RequestMethod.POST)
	public String saveTema(@ModelAttribute("team")Team tim) {
		teamService.saveTim(tim);	
		return "redirect:/";
		
	}
	@RequestMapping("/deleteTeam/{id}")
	public String deleteTeam(@PathVariable(name="id") Long id) {
		teamService.deleteTim(id);
		return "redirect:/";
	}
	
	@RequestMapping("/editTeam/{id}")
	public ModelAndView editTeam(@PathVariable(name = "id") Long id) {
		ModelAndView mv= new ModelAndView("edit_team");
		Team team=teamService.getTime(id);
		mv.addObject("team", team);
		return mv;
	}
	
	
	
	//PLAYER
	@RequestMapping("/allPlayer")
	public String getAllPlayer(Model model){
		List<Player>listOfPlayer= playerService.getAllPlayer();
		model.addAttribute("listOfPlayer", listOfPlayer);
		return "playerHomePage";
	}
	
	@PostMapping("/savePlayer")
	public String savePlayer(@ModelAttribute("player")Player player) {
		playerService.savePlayer(player);
		return "redirect:/allPlayer";
	}
	
	@RequestMapping("/newPlayer")
	public String createNewPlayer(Model model) {
		Player player= new Player();
		model.addAttribute("player", player);
		model.addAttribute("teams", teamService.getAllTim());
		return "create_player";
	}
	
	

}
