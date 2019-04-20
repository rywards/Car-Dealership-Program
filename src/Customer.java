

public class Customer extends Person {
	private int customerID;
	private int totalCarsPurchased;
	
	public Customer(){
		customerID = 0;
		totalCarsPurchased = 0;
	}
	
	public Customer(String name, int age, String address, int customerID, int totalCarsPurchased){
		setName(name);
		setAge(age);
		setAddress(address);
		this.customerID = customerID;
		this.totalCarsPurchased = totalCarsPurchased;
	}
	public int getCustomerID(){
		return customerID;
	}
}
