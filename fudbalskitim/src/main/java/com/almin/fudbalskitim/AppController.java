package com.almin.fudbalskitim;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {
	
	@Autowired
	private TeamService teamService;
	
	@RequestMapping("/")
	public String getAllTime(Model model){
		List<Team> listOfTim= teamService.getAllTim();
		model.addAttribute("listOfTim", listOfTim);
		return "timHomePage";
	}
	
	@RequestMapping("/newTeam")
	public String createNewTeam(Model model) {
		Team team = new Team();
		model.addAttribute("team", team);
		
		return "create_team";
	}
	
	@RequestMapping(value = "/saveTeam", method = RequestMethod.POST)
	public String saveTema(@ModelAttribute("team") Team tim) {
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
	@RequestMapping("/vjezba")
	public String vievVjezba(Model model) {
		Team tim = new Team();
		model.addAttribute("teamm",tim);
		return "vjezba";
	}

}
