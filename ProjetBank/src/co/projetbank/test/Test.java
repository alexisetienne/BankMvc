package co.projetbank.test;

public class Test {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestDaoCustomers.runTests();
		System.out.println("\n\n");
		/*
		TestDaoAccount.runTests();
		System.out.println("\n\n");
		 */

		TestDaoAccount.runTests();
		System.out.println("\n\n");
		
		/*TestDaoSavingOperation.runTests();
		System.out.println("\n\n");
		 */
		
		TestDaoOperation.runTests();
		System.out.println("\n\n");
		
		
	}

}


