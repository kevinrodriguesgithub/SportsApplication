package com.kevin.esd.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevin.esd.dao.MatchIPLDAO;
import com.kevin.esd.model.Match;

import jakarta.transaction.Transactional;

@Service
public class MatchIPLService {

	private MatchIPLDAO matchDAO = new MatchIPLDAO();

    public void createMatchDAO(Match match, Set<Integer> playerIds) {
        matchDAO.saveMatch(match, playerIds);
    }

    public List<Match> getAllMatchesWithDetails() {
        return matchDAO.findAllMatchesWithDetails();
    }
    
//	public List<Match> listAllMatchesDAO() {
//        return matchDAO.listAllMatches();
//    }

	@Transactional			//To keep the session open as we need to fetch 
    public Match getMatchDetailsByIdDAO(int id) {
        return matchDAO.getMatchByID(id);
    }

    public void deleteMatchDAO(int id) {
    	matchDAO.deleteMatch(id);
    }
    
}
