package com.kevin.esd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kevin.esd.dao.UserDAO;
import com.kevin.esd.model.User;
import jakarta.servlet.http.HttpSession;


@Controller
public class LoginController {

	@GetMapping("/loginPage")
	public String loginPage() {
		return "login";
	}
	
	
	@PostMapping("/loginPage")
	public String handleLogin(@RequestParam String username, @RequestParam String password, HttpSession session, RedirectAttributes redirectAttributes) {
		System.out.print("Sent to Post loginPage");
	    UserDAO userDao = new UserDAO();
	    User user = userDao.findByUsername(username);
	    if (user != null && user.getPassword().equals(password)) {
	        session.setAttribute("user", user); 
	        if (user.isAdmin()) {
	            return "adminDashboard"; 
	        } else {
	            return "userDashboard";
	        }
	    }
	    else {
	        redirectAttributes.addFlashAttribute("error", "Incorrect username and password");
	        return "redirect:/loginPage";  // Redirect to the login page if authentication fails
	    }
	}

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/loginPage";
    }
}
