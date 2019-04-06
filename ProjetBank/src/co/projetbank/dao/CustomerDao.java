package co.projetbank.dao;
import co.projetbank.entities.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class CustomerDao extends Dao<Customer> {
	
	@Override
	public Customer find(int id) {
		String str = "select * from T_Customers where IdCust=?";
		PreparedStatement ps;
		Customer client = null;
		try {
			ps = connection.prepareStatement(str);
			ps.setInt(1,id);
			ResultSet resultSet = ps.executeQuery();
			if(resultSet.next()){				
				client = new Customer(resultSet.getInt(1),resultSet.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return client;
	}

	@Override
	public boolean create(Customer obj) {
		String str = "INSERT INTO T_Customers (IdCust,Name) VALUES (?, ? );";
		PreparedStatement ps;
		boolean ok = false;
		try {
			ps = connection.prepareStatement(str);
			ps.setInt(1, obj.getIdCust());
			ps.setString(2,obj.getName());
			
			ps.executeQuery();
			ok = true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ok;
	}

	@Override
	public boolean update(Customer obj) {		
		String str = " update T_Customers set Name=? where IdCust=?;";		
		PreparedStatement ps;
		boolean ok = false;
		try {
			ps = connection.prepareStatement(str);
			ps.setString(1,obj.getName());
			
			ps.setInt(2,obj.getIdCust());
			int row = ps.executeUpdate();
			if(row > 0)	ok = true;			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return ok;
	}

	@Override
	public boolean delete(Customer obj) {
		String str = "delete from T_Customers where IdCust=?;";	
		PreparedStatement ps;
		boolean ok = false;
		try {
			ps = connection.prepareStatement(str);
			ps.setInt(1,obj.getIdCust());
			int row = ps.executeUpdate();
			if(row > 0)	ok = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ok;
}
}
