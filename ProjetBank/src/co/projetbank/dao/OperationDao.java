package co.projetbank.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.projetbank.entities.Account;
import co.projetbank.entities.Operation;

public class OperationDao extends Dao<Operation>{
	@Override
	public Operation find(int id) {
		String str = "select * from T_Operation where NumOp=?";
		PreparedStatement ps;
		Operation compte = null;
		try {
			ps = connection.prepareStatement(str);
			ps.setInt(1,id);
			ResultSet resultSet = ps.executeQuery();
			if(resultSet.next()){
				compte = new Operation(resultSet.getInt(1),resultSet.getDate(2),resultSet.getDouble(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return compte;
	}

	@Override
	public boolean create(Operation obj) {
		String str = "INSERT INTO T_Operation (NumOp,DateOp,Amount) VALUES (?, ? ,? );";
		PreparedStatement ps;
		boolean ok = false;
		try {
			ps = connection.prepareStatement(str);
			ps.setInt(1, obj.getNumOp());
			ps.setDate(2,(Date) obj.getDateOp());
			ps.setDouble(3,obj.getAmount());
			
			ps.executeQuery();
			ok = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ok;
	}

	@Override
	public boolean update(Operation obj) {		
		String str = " update T_Operation set Amount=? where NumOp=?;";		
		PreparedStatement ps;
		boolean ok = false;
		try {
			ps = connection.prepareStatement(str);
			ps.setDouble(1,obj.getAmount());
			ps.setInt(2,obj.getNumOp());
			int row = ps.executeUpdate();
			if(row > 0)	ok = true;			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return ok;
	}

	@Override
	public boolean delete(Operation obj) {
		String str = "delete from T_Operation where NumOp=?;";	
		PreparedStatement ps;
		boolean ok = false;
		try {
			ps = connection.prepareStatement(str);
			ps.setInt(1,obj.getNumOp());
			int row = ps.executeUpdate();
			if(row > 0)	ok = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ok;
	}
}
