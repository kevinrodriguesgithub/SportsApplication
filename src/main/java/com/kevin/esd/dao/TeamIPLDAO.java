package com.kevin.esd.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.kevin.esd.model.Team;
import java.util.List;
import com.kevin.esd.configuration.UtilClass;

public class TeamIPLDAO {
	
    public void saveTeam(Team team) {
        Transaction transaction = null;
        try (Session session = UtilClass.getSF().openSession()) {
            transaction = session.beginTransaction();
            session.persist(team);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Team getTeamById(int id) {
        try (Session session = UtilClass.getSF().openSession()) {
            return session.get(Team.class, id);
        }
    }

    public List<Team> listAllTeams() {
        try (Session session = UtilClass.getSF().openSession()) {
            return session.createQuery("from Team", Team.class).list();
        }
    }

    public void deleteTeam(int id) {
        Transaction transaction = null;
        try (Session session = UtilClass.getSF().openSession()) {
            transaction = session.beginTransaction();
            Team team = session.get(Team.class, id);
            if (team != null) {
                session.remove(team);
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
