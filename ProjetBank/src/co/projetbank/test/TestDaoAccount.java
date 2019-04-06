package co.projetbank.test;

import co.projetbank.dao.AccountDao;
import co.projetbank.dao.OperationDao;
import co.projetbank.entities.*;
public class TestDaoAccount {
	public static void runTests() {
		java.util.Date utilDate = new java.util.Date();
	    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
	    Customer c2 = new Customer(11,"peter");
	    
		AccountDao ad = new AccountDao();		
		
		Account a1 = new CurrentAccount(13,2000,sqlDate,10000,c2);
		
		if(ad.create(a1))	System.out.println("insertion ok de " + a1);
		else System.out.println("insertion impossible, client avec cet id existe déjà ");
				
		Account a2 = ad.find(a1.getIdCust()); 		
		if(a2 == null)	System.out.println("ce client n'est pas contenu en base ");
		else System.out.println("client trouvé en base : " + a2);
		
		a1.setBalance(2500);
		if(ad.update(a1)) System.out.println("ok mise à jour " + a1);
		else System.out.println("mise à jour impossible ");
		
		if(ad.delete(a1))	System.out.println("delete ok " + a1);
		else System.out.println("delete impossible ");				
	}
		
	
}

