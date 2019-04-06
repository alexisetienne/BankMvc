package co.projetbank.test;

import co.projetbank.entities.Account;
import co.projetbank.entities.CurrentAccount;
import co.projetbank.entities.Customer;
import co.projetbank.entities.SavingsAccount;

public class SuperTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.Date date_util = new java.util.Date();
		java.sql.Date date_sql = new java.sql.Date(date_util.getTime());
		Customer c1 = new Customer(1,"dupont");

		Customer c2 = new Customer(1,"durand");	

		Account cp1 = new CurrentAccount(12,900, date_sql , 60 , c1);  // code compte + date de creation + solde + client + découvert autorisé

		Account cp2 = new SavingsAccount(23,400,date_sql , 5.5,c2); // code compte + date de creation + solde + client + taux

		System.out.println(cp1) ;

		System.out.println(cp2) ;
	}

}
