package co.projetbank.test;


import co.projetbank.dao.CustomerDao;
import co.projetbank.dao.OperationDao;
import co.projetbank.entities.*;
public class TestDaoOperation {
	public static void runTests() {
		java.util.Date utilDate = new java.util.Date();
	    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		OperationDao od = new OperationDao();		
		
		Operation o1 = new Payment(13,sqlDate,10000,"Payment");
		
		if(od.create(o1))	System.out.println("insertion ok de " + o1);
		else System.out.println("insertion impossible, client avec cet id existe déjà ");
				
		Operation c2 = od.find(o1.getNumOp()); 		
		if(c2 == null)	System.out.println("ce client n'est pas contenu en base ");
		else System.out.println("client trouvé en base : " + c2);
		
		o1.setAmount(2500);
		if(od.update(o1)) System.out.println("ok mise à jour " + o1);
		else System.out.println("mise à jour impossible ");
		
		if(od.delete(o1))	System.out.println("delete ok " + o1);
		else System.out.println("delete impossible ");				
	}
		
	
}
