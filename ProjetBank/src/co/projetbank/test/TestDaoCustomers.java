package co.projetbank.test;

import co.projetbank.dao.CustomerDao;
import co.projetbank.entities.*;
public class TestDaoCustomers {
	public static void runTests() {
		
		CustomerDao cd = new CustomerDao();		
		
		Customer c1 = new Customer(13,"Hanakin");
		
		if(cd.create(c1))	System.out.println("insertion ok de " + c1);
		else System.out.println("insertion impossible, client avec cet id existe déjà ");
				
		Customer c2 = cd.find(c1.getIdCust()); 		
		if(c2 == null)	System.out.println("ce client n'est pas contenu en base ");
		else System.out.println("client trouvé en base : " + c2);
		
		c1.setName("Vador");
		if(cd.update(c1)) System.out.println("ok mise à jour " + c1);
		else System.out.println("mise à jour impossible ");
		
		if(cd.delete(c1))	System.out.println("delete ok " + c1);
		else System.out.println("delete impossible ");				
	}
		
	
}
