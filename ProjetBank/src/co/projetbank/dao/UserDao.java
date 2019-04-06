package co.projetbank.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.projetbank.entities.Customer;
import co.projetbank.entities.User;

public class UserDao extends Dao<User> {
	@Override
	public User find(int id) {
		String str = "select * from T_User where Pwd=?";
		PreparedStatement ps;
		User client = null;
		try {
			ps = connection.prepareStatement(str);
			ps.setInt(1, id);
			ResultSet resultSet = ps.executeQuery();
			if (resultSet.next()) {
				client = new User(resultSet.getString(1), resultSet.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return client;
	}

	@Override
	public boolean create(User obj) {
		String str = "INSERT INTO T_User (Login,Pwd) VALUES (?, ? );";
		PreparedStatement ps;
		boolean ok = false;
		try {
			ps = connection.prepareStatement(str);
			ps.setString(1, obj.getLogin());
			ps.setString(2, obj.getPwd());

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
		String str = "delete from T_User where Login=?;";
		PreparedStatement ps;
		boolean ok = false;
		try {
			ps = connection.prepareStatement(str);
			ps.setString(1, obj.getLogin());
			int row = ps.executeUpdate();
			if (row > 0)
				ok = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ok;
	}
}
