package co.projetbank.entities;

import java.util.Date;

public class Withdrawal extends Operation {
	

	public Withdrawal(int NumOp, Date DateOp, double Amount) {
		super(NumOp, DateOp, Amount);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Withdrawal ["+super.toString()+"]";
	}

}
