package com.hcl.utility;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Utility {

	public static final SessionFactory sessionFactory;

	static {
		try {

			Configuration config = new Configuration().configure("hibernate.cfg.xml");
			sessionFactory = config.buildSessionFactory();
		} catch (Throwable ex) {

			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static final ThreadLocal<Session> session = new ThreadLocal<Session>();

	public static Session getSession() throws HibernateException {
		Session s = (Session) session.get();

		if (s == null) {
			s = sessionFactory.openSession();

			session.set(s);
		}
		return s;
	}

	public static void closeSession() throws HibernateException {
		Session s = (Session) session.get();
		if (s != null)
			s.close();
		session.set(null);
	}
}