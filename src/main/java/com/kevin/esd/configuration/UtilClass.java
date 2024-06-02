package com.kevin.esd.configuration;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UtilClass {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("SessionFactory failed to create" + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSF() {
		return sessionFactory;
	}

	public static void closeSF() {
		getSF().close();
	}
}
