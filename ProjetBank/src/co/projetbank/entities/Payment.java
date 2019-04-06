package co.projetbank.entities;

import java.util.Date;

public class Payment extends Operation {
	
	public Payment(int NumOp, Date DateOp, double Amount) {
		super(NumOp, DateOp, Amount);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Payment : "+super.toString();
	}
	


}
