package co.projetbank.metier;
import java.util.ArrayList;

import co.projetbank.entities.*;

public interface IBanqueMetier {

	public Account ShowAccount(String IdCust);

	public void verser(String IdCust,double Amount);

	public void retirer(String IdCust, double Amount);

	public void virement(String IdCust1,String IdCust2, double Amount);

	public ArrayList<Operation> listOperation(String IdCust);

}

