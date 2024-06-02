package com.kevin.esd.controller;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kevin.esd.model.Match;
import com.kevin.esd.model.Team;
import com.kevin.esd.model.User;
import com.kevin.esd.service.MatchIPLService;
import com.kevin.esd.service.PlayerIPLService;
import com.kevin.esd.service.TeamIPLService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/sportsApp")
public class MatchIPLController {

	@Autowired
	private MatchIPLService matchServ;
	
	@Autowired
    private TeamIPLService teamService;
	
    @Autowired
    private PlayerIPLService playerService;
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Team.class, new TeamEditor(teamService));
    }
    
    private boolean isAdmin(HttpSession session) {
        User user = (User) session.getAttribute("user");
        return user != null && user.isAdmin();
    }
	
	@GetMapping("/match/new")
	public String showCreateMatchForm(Model model, HttpSession session) {
		if (!isAdmin(session)) {
            return "redirect:/loginPage"; // Redirect to login if not admin
        }
	    model.addAttribute("match", new Match()); 
	    model.addAttribute("teams", teamService.getAllTeams());
        model.addAttribute("players", playerService.getAllPlayers());
	    if(model.getAttribute("match") == null) {
	        System.out.println("Error - Match attribute not found in model");
	    }
	    return "createMatch"; 
	}
	
	@PostMapping("/match")
	public String createMatchDAO(@ModelAttribute Match match, @RequestParam Set<Integer> playerIds, RedirectAttributes redirectAttributes, HttpSession session) {
		
		User user = (User) session.getAttribute("user");
		if (user == null || !user.isAdmin()) {
            redirectAttributes.addFlashAttribute("error", "Access denied");
            return "redirect:/sportsApp/allMatches";
        }
		Set<Integer> playerIdsInt = playerIds.stream().map(Integer::valueOf).collect(Collectors.toSet());
	    System.out.println("Received player IDs: " + playerIdsInt);
	    
		matchServ.createMatchDAO(match, playerIds);
		redirectAttributes.addFlashAttribute("message", "New Match got created");
		return "redirect:/sportsApp/allMatches"; // Redirect to show all matches after creating a match
	}
	
	@GetMapping("/allMatches")
	public String getAllMatchesWithDetails(Model model) {
	    List<Match> matches = matchServ.getAllMatchesWithDetails();
	    model.addAttribute("matches", matches);
	    return "matches";
	}

	@GetMapping("/match/{id}")
	public String getMatchByIdDAO(@PathVariable int id, Model model) {
		Match match = matchServ.getMatchDetailsByIdDAO(id);
		model.addAttribute("match", match);
		return "matchDetail";
	}

	@DeleteMapping("/deleteMatch/{id}")
	public String deleteMatchDAO(@PathVariable int id, RedirectAttributes redirectAttributes, HttpSession session) {
		
		User user = (User) session.getAttribute("user");
	    if (user == null || !user.isAdmin()) {
	        redirectAttributes.addFlashAttribute("error", "Access denied");
	        return "redirect:/sportsApp/allMatches";
	    }
		matchServ.deleteMatchDAO(id);
        redirectAttributes.addFlashAttribute("message", "Match got deleted !");
        return "redirect:/sportsApp/allMatches"; // Redirect after deleting a match
	}	
}
