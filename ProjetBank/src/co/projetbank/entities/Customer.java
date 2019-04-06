package co.projetbank.entities;

public  class Customer {
	
	private int IdCust;
	private String Name;
	
	public Customer(int idCust, String name) {
		this.IdCust = idCust;
		this.Name = name;
		
	}
	@Override
	public String toString() {
		return "[Customer number=" + IdCust + ",Customer Name=" + Name +"]";
	}
	public int getIdCust() {
		return IdCust;
	}

	public void setIdCust(int IdCust) {
		this.IdCust = IdCust;
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	
}
