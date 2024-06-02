package com.kevin.esd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kevin.esd.dao.PlayerIPLDAO;
import com.kevin.esd.model.Player;
import java.util.List;

@Service
public class PlayerIPLService {
	
    private PlayerIPLDAO playerDAO = new PlayerIPLDAO();

    public void createPlayer(Player player) {
        playerDAO.savePlayer(player);
    }

    public List<Player> getAllPlayers() {
        return playerDAO.listAllPlayers();
    }

    public Player getPlayerDetailsById(int id) {
        return playerDAO.getPlayerById(id);
    }

    public void deletePlayer(int id) {
        playerDAO.deletePlayer(id);
    }
}
