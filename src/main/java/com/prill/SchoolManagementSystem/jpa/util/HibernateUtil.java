package com.prill.SchoolManagementSystem.jpa.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * This Class defines and creates connections to the database
 * 
 * @author Jonathan Prill
 *
 */
public class HibernateUtil {

	public static Session getConnection() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		return session;

	}

	/**
	 * the password may need to be changed based on you MySQL credentials.
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection setConnection() throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/smsdb";
		String user = "root";
		String password = "root";

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection connection = DriverManager.getConnection(url, user, password);

		return connection;
	}

}