import java.util.Date;
import java.util.Arrays;
import java.util.*;
import java.text.*;




public class Transaction {
	//Transaction variables
	private String salesDate;
	private double salePrice;
	
	
	
	//customer variables
	private String customerName, customerID;
	
	//sales associate variables
	private String salesAssociateName, associateID;
	
	//car variables
	private String purchasedMake, purchasedModel, purchasedVin;
	
	int index = 0;
	
	
	public Transaction (String salesDate, double value, String customerName, String customerID, String salesAssociateName, String associateID, String make, String model){
		this.salesDate = salesDate;
		salePrice = value;
		this.customerName = customerName;
		this.customerID = customerID;
		this.salesAssociateName = salesAssociateName;
		this.associateID = associateID;
		purchasedMake = make;
		purchasedModel = model;
				
	}
	
	public String getSalesDate(){
		return salesDate;
	}
	
	public void setSalesDate(String value){
		salesDate = value;
	}
	
		
	public String getPurchasedMake(){
		return purchasedMake;
	}
	
	public void setPurchasedMake(String value){
		purchasedMake = value;
	}
	
	public String getPurchasedModel(){
		return purchasedModel;
	}
	
	public void setPurchasedModel(String value){
		purchasedModel = value;
	}
	
	public String getSalesAssociateName(){
		return salesAssociateName;
	}
	
	public void setSalesAssociateName(String value){
		salesAssociateName = value;
	}
	
	public String getSalesAssociateID(){
		return associateID;
	}
	
	public void getSalesAssociateID(String value){
		associateID = value;
	}
	
	public String getCustomerName(){
		return customerName;
	}
	
	public void setCustomerName(String value){
		customerName = value;
	}
	
	public double getSalePrice(){
		return salePrice;
	}
	
	public void setSalePrice(double value){
		salePrice = value;
	}
	
	public String getCustomerID(){
		return customerID;
	}
	
	public void setCustomerID(String value){
		customerID = value;
	}
	
	public String toMessage(){
		return "{Sales Date:" + salesDate + ",Sale Price:" + salePrice + ",Customer Name:" + customerName + ",Customer ID:" + customerID + ",Sales Associate Name:" + salesAssociateName + ",Sales Associate ID:" + associateID + ",Vehicle make:" + purchasedMake + ",Vehicle model:" + purchasedModel + "}\n";
	}
	
}