package co.simplon.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.simplon.entities.Account;
import co.simplon.entities.Operation;
import co.simplon.entities.User;
import co.simplon.metier.BankMetierIMPL;
import co.simplon.metier.IBanqueMetier;

/**
 * Servlet implementation class ViewAccount
 */
@WebServlet("/viewAccount")
public class ViewAccount extends HttpServlet {
	private BankMetierIMPL bankMetier = null;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAccount() {
    	bankMetier = new BankMetierIMPL();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User connectedUser = (User)request.getSession().getAttribute("connectedUser");
		String codeCompte = request.getParameter("IdCust");
		Account Account = null ; 
		ArrayList<Operation> listOperations = null;
		if(codeCompte.equalsIgnoreCase("")) {
		
		}
		else {
			int cdeCompte = Integer.parseInt(codeCompte);
			Account = bankMetier.showAccount(cdeCompte);
			listOperations = bankMetier.listOperations(cdeCompte);
		}
		if(Account != null) {
			HttpSession session = request.getSession();
			session.setAttribute("connectedUser", connectedUser);
			session.setAttribute("IdCust", codeCompte);
			session.setAttribute("Account", Account);
			session.setAttribute("listOperations", listOperations);
			request.setAttribute("error", "");
			request.getRequestDispatcher("/vue.jsp").forward(request, response);;
			
		}
	}

}
