package co.projetbank.entities;

import java.util.Date;

public class CurrentAccount extends Account {
private double Overdraft ;
private Customer Custo ; 
	
	public CurrentAccount(int idCust, double balance, Date dateCreation , double Overdraft,Customer Custo ) {
		super(idCust, balance, dateCreation);
		this.Overdraft = Overdraft ;
		this.Custo = Custo;
		
}

	@Override
	public String toString() {
		return "CurrentAccount [CurrentAccount=" +super.toString()+"  "+"Overdraft = "+ Overdraft+"  " +Custo+ "]";
	}

	public double getOverdraft() {
		return Overdraft ;
	}
	public void setOverdraft(double Overdraft) {
		this.Overdraft = Overdraft ;	
				
}

	public Customer getCusto() {
		return Custo;
	}

	public void setCusto(Customer custo) {
		Custo = custo;
	}
}


