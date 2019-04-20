

public class SalesAssociate extends Person {
	private String associateID;
	private String associatePass;
	private String totalCarsSold;
	
	// Default constructor
	public SalesAssociate(){
		associateID = "";
		associatePass = "";
	}
	
	public SalesAssociate(String name, String address, String totalCarsSold, String associateID, String associatePass){
		setName(name);
		setAddress(address);
		this.totalCarsSold = totalCarsSold;
		this.associateID = associateID;
		this.associatePass = associatePass;
	}
	
	public String getID(){
		return associateID;
	}
	
	public String getAssociatePass(){
		return associatePass;
	}
	
	
}
