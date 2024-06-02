package com.kevin.esd.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.kevin.esd.model.Player;
import java.util.List;
import com.kevin.esd.configuration.UtilClass;

public class PlayerIPLDAO {
	
    public void savePlayer(Player player) {
        Transaction transaction = null;
        try (Session session = UtilClass.getSF().openSession()) {
            transaction = session.beginTransaction();
            session.persist(player);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Player getPlayerById(int id) {
        try (Session session = UtilClass.getSF().openSession()) {
            return session.get(Player.class, id);
        }
    }

    public List<Player> listAllPlayers() {
        try (Session session = UtilClass.getSF().openSession()) {
            return session.createQuery("from Player", Player.class).list();
        }
    }

    public void deletePlayer(int id) {
        Transaction transaction = null;
        try (Session session = UtilClass.getSF().openSession()) {
            transaction = session.beginTransaction();
            Player player = session.get(Player.class, id);
            if (player != null) {
                session.remove(player);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
