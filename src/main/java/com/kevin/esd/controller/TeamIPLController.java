package com.kevin.esd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.kevin.esd.model.Team;
import com.kevin.esd.model.User;
import com.kevin.esd.service.TeamIPLService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/teams")
public class TeamIPLController {

    @Autowired
    private TeamIPLService teamService;
    
    private boolean isAdmin(HttpSession session) {
        User user = (User) session.getAttribute("user");
        return user != null && user.isAdmin();
    }

    @GetMapping("/new")
    public String showCreateTeamForm(Model model, HttpSession session) {
    	if (!isAdmin(session)) {
            return "redirect:/loginPage";
        }
        model.addAttribute("team", new Team());
        return "createTeam";
    }

    @PostMapping("newTeam")
    public String createTeam(@ModelAttribute Team team, RedirectAttributes redirectAttributes, HttpSession session) {
    	User user = (User) session.getAttribute("user");
		if (user == null || !user.isAdmin()) {
            redirectAttributes.addFlashAttribute("error", "Access denied");
            return "redirect:/teams/allTeams";
        }
    	teamService.createTeam(team);
        redirectAttributes.addFlashAttribute("message", "Team created successfully");
        return "redirect:/teams/allTeams";
    }

    @GetMapping("/allTeams")
    public String getAllTeams(Model model) {
        model.addAttribute("teams", teamService.getAllTeams());
        return "teamsList";
    }

    @GetMapping("/{id}")
    public String getTeamById(@PathVariable int id, Model model) {
        model.addAttribute("team", teamService.getTeamDetailsById(id));
        return "teamDetail";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTeam(@PathVariable int id, RedirectAttributes redirectAttributes, HttpSession session) {
    	User user = (User) session.getAttribute("user");
		if (user == null || !user.isAdmin()) {
            redirectAttributes.addFlashAttribute("error", "Access denied");
            return "redirect:/teams/allTeams";
        }
        teamService.deleteTeam(id);
        redirectAttributes.addFlashAttribute("message", "Team deleted successfully");
        return "redirect:/teams/allTeams";
    }
}
