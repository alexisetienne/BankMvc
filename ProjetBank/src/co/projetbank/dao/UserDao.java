package co.projetbank.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.projetbank.entities.Customer;
import co.projetbank.entities.User;
import sun.rmi.runtime.Log;

public class UserDao extends Dao<User> {
	
	

	@Override
	public User find(int id) {
		String str = "select * from T_User where IdU=?";
		PreparedStatement ps;
		User client = null;
		try {
			ps = connection.prepareStatement(str);
			ps.setInt(1, id);
			ResultSet resultSet = ps.executeQuery();
			if (resultSet.next()) {
				client = new User(resultSet.getString(1), resultSet.getString(2),resultSet.getInt(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return client;
	}

	@Override
	public boolean create(User obj) {
		String str = "INSERT INTO T_User (Login,Pwd,IdU) VALUES (?, ? ,?);";
		PreparedStatement ps;
		boolean ok = false;
		try {
			ps = connection.prepareStatement(str);
			ps.setString(1, obj.getLogin());
			ps.setString(2, obj.getPwd());
			ps.setInt(3,obj.getIdU());

			ps.executeQuery();
			ok = true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ok;
	}

	@Override
	public boolean update(User obj) {
		String str = " update T_User set Pwd=? where Login=?;";
		PreparedStatement ps;
		boolean ok = false;
		try {
			ps = connection.prepareStatement(str);
			ps.setString(1, obj.getPwd());

			ps.setString(2, obj.getLogin());
			int row = ps.executeUpdate();
			if (row > 0)
				ok = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ok;
	}

	@Override
	public boolean delete(User obj) {
		String str = "delete from T_User where IdU=?;";
		PreparedStatement ps;
		boolean ok = false;
		try {
			ps = connection.prepareStatement(str);
			ps.setInt(1, obj.getIdU());
			int row = ps.executeUpdate();
			if (row > 0)
				ok = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ok;
	}
	public User isValidLogin(String login, String password) {
		// TODO Auto-generated method stub
		String str = "select * from T_User";
		PreparedStatement ps;
		User client = null;
		try {
			ps = connection.prepareStatement(str);
			
			ResultSet resultSet = ps.executeQuery();
			if (resultSet.next()) {
				client = new User(resultSet.getString(1), resultSet.getString(2),resultSet.getInt(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return client;
	}
	
}

