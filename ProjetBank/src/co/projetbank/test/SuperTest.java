package co.projetbank.test;

import java.util.ArrayList;
import java.util.Date;

import co.projetbank.dao.OperationDao;
import co.projetbank.entities.Account;
import co.projetbank.entities.CurrentAccount;
import co.projetbank.entities.Customer;
import co.projetbank.entities.Operation;
import co.projetbank.entities.Payment;
import co.projetbank.entities.SavingsAccount;
import co.projetbank.entities.Withdrawal;
import co.projetbank.metier.BankMetierIMPL;

public class SuperTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.Date date_util = new java.util.Date();
		
		
		Customer c1 = new Customer(1,"dupont");

		Customer c2 = new Customer(1,"durand");	

		Account cp1 = new CurrentAccount(12,900, new Date() , 60 , c1);  // code compte + date de creation + solde + client + découvert autorisé

		Account cp2 = new SavingsAccount(23,400,new Date() , 5.5,c2); // code compte + date de creation + solde + client + taux
        
		Operation op1 = new Withdrawal(1, new Date(), 200, "withdrawal");
		
		System.out.println(cp1) ;

		System.out.println(cp2) ;
		
		BankMetierIMPL bank = new BankMetierIMPL();
		
		bank.verser(1,100);
		bank.verser(1, 1000);
		bank.retirer(1,200);
		bank.retirer(1,100);
		bank.virement(1, 2, 20);
		
		OperationDao opo = new OperationDao();
		opo.create(new Payment(1900, new Date(),1300,"Payment"));
		opo.create(new Withdrawal(2230,new Date() , 1200,"Withdrawal"));
		opo.create(new Withdrawal(3330,new Date() , 200,"Withdrawal"));
		ArrayList<Operation> list = bank.listOperations(1); 
		
	for(Operation op : list ) 	
		System.out.println(op);
	}

}
