
package co.simplon.metier;
import java.util.ArrayList;

import co.simplon.entities.*;

public interface IBanqueMetier {

	public Account showAccount(int IdCust);

	public void verser(int IdCust,double Amount);

	public void retirer(int IdCust, double Amount);

	public void virement(int IdCust1,int IdCust2, double Amount);

	public ArrayList<Operation> listOperations(int IdCust);

}