package com.kevin.esd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kevin.esd.dao.TeamIPLDAO;
import com.kevin.esd.model.Team;
import java.util.List;

@Service
public class TeamIPLService {
 
    private TeamIPLDAO teamDAO = new TeamIPLDAO();

    public void createTeam(Team team) {
        teamDAO.saveTeam(team);
    }

    public List<Team> getAllTeams() {
        return teamDAO.listAllTeams();
    }

    public Team getTeamDetailsById(int id) {
        return teamDAO.getTeamById(id);
    }

    public void deleteTeam(int id) {
        teamDAO.deleteTeam(id);
    }
}
