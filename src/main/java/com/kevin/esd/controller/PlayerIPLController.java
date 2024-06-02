package com.kevin.esd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.kevin.esd.model.Player;
import com.kevin.esd.model.Team;
import com.kevin.esd.model.User;
import com.kevin.esd.service.PlayerIPLService;
import com.kevin.esd.service.TeamIPLService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/players")
public class PlayerIPLController {
	
    @Autowired
    private PlayerIPLService playerService;
    
    @Autowired
    private TeamIPLService teamService;
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Team.class, new TeamEditor(teamService));
    }
    
    private boolean isAdmin(HttpSession session) {
        User user = (User) session.getAttribute("user");
        return user != null && user.isAdmin();
    }

    @GetMapping("/new/p")
    public String showCreatePlayerForm(Model model, HttpSession session) {
    	 if (!isAdmin(session)) {
             return "redirect:/loginPage";
         }
        model.addAttribute("player", new Player());
        model.addAttribute("teams", teamService.getAllTeams());
        return "createPlayer";
    }

    @PostMapping("/p")
    public String createPlayer(@ModelAttribute Player player, RedirectAttributes redirectAttributes, HttpSession session) {
    	
    	User user = (User) session.getAttribute("user");
		if (user == null || !user.isAdmin()) {
            redirectAttributes.addFlashAttribute("error", "Access denied");
            return "redirect:/players/all";
        }
    	
        playerService.createPlayer(player);
        redirectAttributes.addFlashAttribute("message", "Successfully created new player");
        return "redirect:/players/all";
    }

    @GetMapping("/all")
    public String getAllPlayers(Model model) {
        model.addAttribute("players", playerService.getAllPlayers());
        return "playersList";
    }

    @GetMapping("/{id}")
    public String getPlayerById(@PathVariable int id, Model model) {
        model.addAttribute("player", playerService.getPlayerDetailsById(id));
        return "playerDetail";
    }

    @DeleteMapping("/delete/{id}")
    public String deletePlayer(@PathVariable int id, RedirectAttributes redirectAttributes, HttpSession session) {
    	User user = (User) session.getAttribute("user");
		if (user == null || !user.isAdmin()) {
            redirectAttributes.addFlashAttribute("error", "Access denied");
            return "redirect:/players/all";
        }
        playerService.deletePlayer(id);
        redirectAttributes.addFlashAttribute("message", "Successfully deleted the player");
        return "redirect:/players/all";
    }
}
