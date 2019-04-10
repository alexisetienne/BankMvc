package co.projetbank.dao;

import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.projetbank.entities.Account;
import co.projetbank.entities.Operation;
import co.projetbank.entities.Payment;
import co.projetbank.entities.Withdrawal;

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
			while(resultSet.next()){
				if(resultSet.getString("Type")=="Payment")
				compte = new Payment(resultSet.getInt(1),resultSet.getDate(2),resultSet.getDouble(3),resultSet.getString(4));
				else
					compte = new Withdrawal(resultSet.getInt(1),resultSet.getDate(2),resultSet.getDouble(3),resultSet.getString(4));
					
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return compte;
	}

	@Override
	public boolean create(Operation obj) {
		String str = "INSERT INTO T_Operation (NumOp,Amount,Type) VALUES (?,?,?);";
		PreparedStatement ps;
		boolean ok = false;
		try {
			ps = connection.prepareStatement(str);
			ps.setInt(1, obj.getNumOp());
			//ps.setDate(2,(Date) obj.getDateOp());
			ps.setDouble(2,obj.getAmount());
			ps.setString(3,obj.getType());
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

	public ArrayList<Operation> listOperations(int idCust) {
	
		ArrayList<Operation> list = new ArrayList<Operation>();
		String str = "select * from T_Operation;";
		PreparedStatement ps;
		
		try {
			ps = connection.prepareStatement(str);
			ResultSet resultSet = ps.executeQuery();
		
			 while(resultSet.next()) {
			    	
			    	list.add(new Operation(resultSet.getInt(1),resultSet.getDate(2),resultSet.getDouble(3),resultSet.getString(4)));
			    }
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		
		//requetes de recuperation des operations
		//boucle qui permet de recuperer toutes les occurences de ma tables des operations
		
		return list;
	}
}
