
package co.simplon.entities;

import java.util.Date;

public  class Account {
	private int IdCust ; 
	private double Balance;
	private Date DateCreation;
	 
	
	public Account(int IdCust ,double balance, Date dateCreation) {
		this.DateCreation = dateCreation;
		this.Balance = balance ; 
		this.IdCust =IdCust;
				
	}
	@Override
	public String toString() {
		return " Creation Date = " + DateCreation + ",Balance=" + Balance+",Customer number = "+IdCust;
	}
	public Date getDateCreation() {
		return DateCreation;
	}

	public void setDateCreation(Date DateCreation) {
		this.DateCreation = DateCreation;
	}
	public double getBalance() {
		return Balance;
	}

	public void setBalance(double Balance) {
		this.Balance =Balance;
	}
	public int getIdCust() {
		return IdCust;
	}

	public void setIdCust(int IdCust) {
		this.IdCust = IdCust;
	}

		
}