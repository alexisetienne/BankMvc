package co.simplon.metier;

import java.util.ArrayList;
import java.util.Date;

import co.simplon.dao.AccountDao;
import co.simplon.dao.OperationDao;
import co.simplon.entities.Account;
import co.simplon.entities.CurrentAccount;
import co.simplon.entities.Operation;
import co.simplon.entities.Payment;
import co.simplon.entities.Withdrawal;

public class BankMetierIMPL implements IBanqueMetier {

    private AccountDao accountDao;
    private OperationDao operationDao ;
    private ArrayList<Operation> operation;
    
    
    public BankMetierIMPL() {
    	operation=new ArrayList<Operation>();
    	accountDao = new AccountDao();
    	operationDao = new OperationDao();
    }
	
	
	@Override
	public Account showAccount(int IdCust) {
		Account account= accountDao.find(IdCust);
		if(account==null) throw new RuntimeException("Account introuvable");
		return account; 
	}

	@Override
	public void verser(int IdCust, double Amount) {
		Account account= showAccount(IdCust);
		
		account.setBalance( account.getBalance() + Amount );
		accountDao.update(account);
		
		Operation opv= new Payment(IdCust, new Date(),Amount,"Payment");
		operationDao.update(opv);
		
	}

	@Override
	public void retirer(int IdCust, double Amount) {
		Account account=  showAccount (IdCust);
		Operation opr=new Withdrawal(IdCust ,new Date(),Amount,"withdrawal");
		double cashfacility=0;
		if(account instanceof CurrentAccount)
			cashfacility= ((CurrentAccount) account).getOverdraft();
		if(account.getBalance()+cashfacility<Amount)
			throw new RuntimeException("Solde Insuffisant!");
		operationDao.update(opr);
		account.setBalance (account.getBalance()- Amount);
		accountDao.update(account);
		
	}

	@Override
	public void virement(int IdCust1, int IdCust2, double Amount) {
		if(IdCust1==IdCust2)
			throw new RuntimeException("impossible de virer sur le même compte!");
		retirer(IdCust1,Amount);
		verser(IdCust2,Amount);
		
	}

	@Override
	public ArrayList<Operation> listOperations(int IdCust) {
		   return operationDao.listOperations(IdCust);

	}

	public OperationDao getOperationDao() {
		return operationDao;
	}

	public void setOperationDao(OperationDao operationDao) {
		this.operationDao = operationDao;
	}


	public ArrayList<Operation> getOperation() {
		return operation;
	}


	public void setOperation(ArrayList<Operation> operation) {
		this.operation = operation;
	}
	

}
