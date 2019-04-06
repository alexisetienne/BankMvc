package co.projetbank.entities;

import java.util.Date;

public class SavingsAccount extends Account {
	
	private double InterestRate ;
	private Customer Custo ; 
		
	
	public SavingsAccount(int idCust, double balance, Date dateCreation, double InterestRate, Customer Custo  ) {
		super(idCust, balance, dateCreation);
		this.InterestRate = InterestRate ;
		this.Custo = Custo;
		
}
	@Override
	public String toString() {
		return "SavingsAccount ["+super.toString()+"  "+"interest rate :" + InterestRate +" "+"  "+Custo+ "]";
	}

	public double getInterestRate() {
		return InterestRate ;
	}
	public void setInterestRate(double InterestRate) {
		this.InterestRate = InterestRate ;	
				
}
}
