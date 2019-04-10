package co.projetbank.entities;

import java.util.Date;

public class Withdrawal extends Operation {
	

	public Withdrawal(int NumOp, Date DateOp, double Amount, String Type) {
		super(NumOp, DateOp, Amount,Type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Withdrawal ["+super.toString()+"]";
	}

}
