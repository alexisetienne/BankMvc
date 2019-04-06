package co.projetbank.entities;

import java.util.Date;

public  class Operation {
	
	private int NumOp;
	private Date DateOp ;
	private double Amount;
	
	public Operation(int NumOp,Date DateOp, double Amount ) {
		this.NumOp = NumOp;
		this.DateOp = DateOp;
		this.Amount = Amount;
		
}
	@Override
	public String toString() {
		return "[numero d'operation = " + NumOp + " ,Creation Date = " + DateOp + ", Amount =" + Amount + "]";
	}
	public int getNumOp() {
		return NumOp;
	}

	public void setNumOp(int NumOp) {
		this.NumOp = NumOp;
	}
	public Date getDateOp() {
		return DateOp;
	}

	public void setDateCreation(Date DateOp) {
		this.DateOp = DateOp;
}
	public double getAmount() {
		return Amount;
	}

	public void setAmount(double Amount) {
		this.Amount = Amount;
	}
}