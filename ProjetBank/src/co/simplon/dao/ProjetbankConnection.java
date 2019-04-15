package co.simplon.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;



public class ProjetbankConnection {
private static Connection connection = null;	
	
	private ProjetbankConnection() {		
		/*
		 * Properties props = new Properties(); try (FileInputStream fis = new
		 * FileInputStream("../config.properties")){ props.load(fis); } catch
		 * (FileNotFoundException e1) { e1.printStackTrace(); } catch (IOException e1) {
		 * e1.printStackTrace(); }
		 */
		String url = "jdbc:mariadb://localhost:3306/Projetbank";
		String log = "root";
		String pwd = "root";
		
		try {
			//System.out.println(props.getProperty("jdbc.driver.class"));
			
			Class.forName("org.mariadb.jdbc.Driver");
			connection = DriverManager.getConnection(url, log, pwd);
			Statement statement = connection.createStatement();
			statement.executeQuery("create database if not exists Projetbank;");
			statement.executeQuery("use Projetbank;");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 				
		catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	public static Connection getConnection() {
		if(connection == null) {
			new ProjetbankConnection();
		}
		return connection;
	}
}
