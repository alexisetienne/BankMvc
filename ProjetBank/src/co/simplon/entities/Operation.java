package co.simplon.entities;

import java.util.Date;

public  class Operation {
	
	private int NumOp;
	private Date DateOp ;
	private double Amount;
	private String Type ; 
	
	public Operation(int NumOp,Date DateOp, double Amount ,String Type ) {
		this.NumOp = NumOp;
		this.DateOp = DateOp;
		this.Amount = Amount;
		this.Type = Type ; 
		
}
	@Override
	public String toString() {
		return "Operation Type "+Type+"[numero d'operation = " + NumOp + " ,Creation Date = " + DateOp + ", Amount =" + Amount + "]";
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
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
}