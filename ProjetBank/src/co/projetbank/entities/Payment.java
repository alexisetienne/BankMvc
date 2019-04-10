package co.projetbank.entities;

import java.util.Date;

public class Payment extends Operation {
	
	public Payment(int NumOp, Date DateOp, double Amount,String Type) {
		super(NumOp, DateOp, Amount,Type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Payment : "+super.toString();
	}
	


}
