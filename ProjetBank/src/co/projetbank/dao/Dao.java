package co.projetbank.dao;

import java.sql.Connection;

public abstract class Dao<T> {
	
public Connection connection = ProjetbankConnection.getConnection();


public abstract T find(int id);


public abstract boolean create(T obj);


public abstract boolean update(T obj);


public abstract boolean delete(T obj);

}












