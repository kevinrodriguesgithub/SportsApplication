package com.kevin.esd.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.kevin.esd.configuration.UtilClass;
import com.kevin.esd.model.Match;
import com.kevin.esd.model.Player;

public class MatchIPLDAO {

	public void saveMatch(Match match, Set<Integer> playerIds) {
        Transaction transaction = null;
        Session session = null;
        try {
        	session = UtilClass.getSF().openSession();
            transaction = session.beginTransaction();
            
            match.setPlayers(new HashSet<>());
            for (Integer playerId : playerIds) {
                Player player = session.get(Player.class, playerId);
                if (player != null) {
                    match.getPlayers().add(player);
                }
            }
            session.persist(match);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        }finally {
            if (session != null) {
                session.close();
            }
        }
    }
	
	//Method to get all matches
    public List<Match> findAllMatchesWithDetails() {
        try (Session session = UtilClass.getSF().openSession()) {
            String hql = "SELECT m FROM Match m JOIN FETCH m.teamA JOIN FETCH m.teamB";
            Query<Match> query = session.createQuery(hql, Match.class);
            return query.getResultList();
        }
    }
    
    public Match getMatchByID(int id) {
        Match match = null;
        Transaction transaction = null;
        try (Session session = UtilClass.getSF().openSession()) {
            transaction = session.beginTransaction();
            
            String hql = "SELECT m FROM Match m " +
                         "LEFT JOIN FETCH m.teamA " +
                         "LEFT JOIN FETCH m.teamB " +
                         "WHERE m.id = :id";
            Query<Match> query = session.createQuery(hql, Match.class);
            query.setParameter("id", id);
            match = query.uniqueResult();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return match;
    }
    
    // Delete a match
    public void deleteMatch(int id) {
        Transaction transaction = null;
        try (Session session = UtilClass.getSF().openSession()) {
            transaction = session.beginTransaction();
            Match match = session.get(Match.class, id);
            if (match != null) {
                session.remove(match);
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
