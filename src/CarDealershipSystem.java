import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;


public class CarDealershipSystem {
	
	
	private String login;
	private String line;
	private String make,model,vin,color,engine,bodyStyle;	
	private String tmp;
	private int year;	
	private double msrp;
	private int firstIndex;
	private int endIndex;
	private int index=0;    //Used to find index of new car
	private int index2 = 0;    //Used to index transactions
	private int index3 = 0;		// Used to index employees
	
	//Transaction variables
	private String salesDate;
	private double salePrice;
	
	//Variables for employees methods
	
	private String employeeName;
	private String employeeID;
	private String employeePass;
	private String totalCars;
	private String address;
    
	
	
	
	//customer variables
	private String customerName, customerID;
	
	
	//sales associate variables
	private String salesAssociateName, associateID;
	
	//car variables
	private String purchasedMake, purchasedModel, purchasedVin;
	
	String message;
	
	Car[] cars = new Car[100];
	Transaction[] transactions = new Transaction[100];
	SalesAssociate[] employees = new SalesAssociate[100];
	 
    SimpleDateFormat ft = new SimpleDateFormat ("E mm.dd.yyyy");
	
	
	
	//Create the cars from the txt file
	
	public void createCarArray(String line){
		firstIndex = line.indexOf(":");
		firstIndex+=1;
		endIndex = line.indexOf(",");
		make = line.substring(firstIndex, endIndex);
		//Get model from string
		firstIndex = line.indexOf(":",endIndex);
		firstIndex +=1;
		endIndex = line.indexOf(",",firstIndex);
		model = line.substring(firstIndex, endIndex);
		//Get vin number from string
		firstIndex = line.indexOf(":",endIndex);
		firstIndex +=1;
		endIndex = line.indexOf(",",firstIndex);
		vin = line.substring(firstIndex, endIndex);
		//Get year from string
		firstIndex = line.indexOf(":",endIndex);
		firstIndex +=1;
		endIndex = line.indexOf(",",firstIndex);
		tmp = line.substring(firstIndex, endIndex);
		year = Integer.parseInt(tmp);
		//Get color from string
		firstIndex = line.indexOf(":",endIndex);
		firstIndex +=1;
		endIndex = line.indexOf(",",firstIndex);
		color = line.substring(firstIndex, endIndex);
		//Get engine from String
		firstIndex = line.indexOf(":",endIndex);
		firstIndex +=1;
		endIndex = line.indexOf(",",firstIndex);
		engine = line.substring(firstIndex, endIndex);
		//Get bodyStyle from String
		firstIndex = line.indexOf(":",endIndex);
		firstIndex +=1;
		endIndex = line.indexOf(",",firstIndex);
		bodyStyle = line.substring(firstIndex, endIndex);
		//Get msrp from string
		firstIndex = line.indexOf(":",endIndex);
		firstIndex +=1;
		endIndex = line.indexOf("}",firstIndex);
		tmp = line.substring(firstIndex, endIndex);
		msrp = Double.parseDouble(tmp);
		cars[index] = new Car(make,model,vin,year,color,engine,bodyStyle,msrp);
		index = index+1;
	}
	
	//Add new car method
	// Written by: Kelly Gedling
	public void addNewCar(String make, String model, String vin, int year, String color, String engine, String bodyStyle, double msrp){
		this.make = make;
		this.model = model;
		this.vin = vin;
		this.year = year;
		this.color = color;
		this.engine= engine;
		this.bodyStyle = bodyStyle;
		this.msrp = msrp;
		cars[index] = new Car(this.make,this.model,this.vin,this.year,this.color,this.engine,this.bodyStyle,this.msrp);	
		
		try {
			PrintWriter out;
			try {
				out = new PrintWriter(new FileWriter("cars.txt", true));
				message = cars[index].getMessage();
				out.println(message);
				//out.println(" ");
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		index = index+1;
	}

	
	//Display list of cars
	//Written by:Kelly Gedling
	//Used to display the car inventory
	public void displayList(){		
		String message = "";
		for(int i = 0;i<index ; i++){
			message = message + cars[i].getMessage();
		}
		JOptionPane.showMessageDialog(null,message,"Inventory",JOptionPane.INFORMATION_MESSAGE);
	}
	
	
	
	public void searchInventory(String make, String model){
		message = "";
		for(int i = 0; i< index; i++){
			this.make = cars[i].getMake();
			this.model = cars[i].getModel();
			if(this.make.compareToIgnoreCase(make)== 0 && this.model.compareToIgnoreCase(model)== 0){
				message = message + cars[i].getMessage();				
			}			
		}
		if(message == "")
			JOptionPane.showMessageDialog(null, "There are no matches.","Make another selection",JOptionPane.INFORMATION_MESSAGE);
		else
			JOptionPane.showMessageDialog(null, message,"Search results",JOptionPane.INFORMATION_MESSAGE);
	}
	
	//Create transactions array from text file
	
	public void createTransactionsArray(String line){
		firstIndex = line.indexOf(":");
		firstIndex+=1;
		endIndex = line.indexOf(",");
		salesDate = line.substring(firstIndex, endIndex);		
		//Get Sale Price from string
		firstIndex = line.indexOf(":",endIndex);
		firstIndex +=1;
		endIndex = line.indexOf(",",firstIndex);
		tmp = line.substring(firstIndex, endIndex);
		salePrice = Double.parseDouble(tmp);
		//Get Customer Name from string
		firstIndex = line.indexOf(":",endIndex);
		firstIndex +=1;
		endIndex = line.indexOf(",",firstIndex);
		customerName = line.substring(firstIndex, endIndex);
		//Get CustomerID from string
		firstIndex = line.indexOf(":",endIndex);
		firstIndex +=1;
		endIndex = line.indexOf(",",firstIndex);
		customerID = line.substring(firstIndex, endIndex);
		//Get Sales Associate Name from string
		firstIndex = line.indexOf(":",endIndex);
		firstIndex +=1;
		endIndex = line.indexOf(",",firstIndex);
		salesAssociateName = line.substring(firstIndex, endIndex);
		//Get Sales Associate ID from String
		firstIndex = line.indexOf(":",endIndex);
		firstIndex +=1;
		endIndex = line.indexOf(",",firstIndex);
		associateID = line.substring(firstIndex, endIndex);
		//Get Vehicle Make from String
		firstIndex = line.indexOf(":",endIndex);
		firstIndex +=1;
		endIndex = line.indexOf(",",firstIndex);
		purchasedMake = line.substring(firstIndex, endIndex);
		//Get Vehicle model from string
		firstIndex = line.indexOf(":",endIndex);
		firstIndex +=1;
		endIndex = line.indexOf("}",firstIndex);
		purchasedModel = line.substring(firstIndex, endIndex);
		
		transactions[index2] = new Transaction(salesDate,salePrice,customerName,customerID,salesAssociateName,associateID,purchasedMake,purchasedModel);
		index2 = index2+1;
	}
	
	
		
		
	public void createEmployeeInfo(String line){	
			
			// Each block gets the separate part of each string
			firstIndex = line.indexOf(":");
			firstIndex+=1;
			endIndex = line.indexOf(",");
			employeeName = line.substring(firstIndex, endIndex);
			
			firstIndex = line.indexOf(":",endIndex);
			firstIndex +=1;
			endIndex = line.indexOf(",",firstIndex);
			address = line.substring(firstIndex, endIndex);
			
			firstIndex = line.indexOf(":",endIndex);
			firstIndex +=1;
			endIndex = line.indexOf(",",firstIndex);
			totalCars = line.substring(firstIndex, endIndex);
			
			firstIndex = line.indexOf(":",endIndex);
			firstIndex +=1;
			endIndex = line.indexOf(",",firstIndex);
			employeeID = line.substring(firstIndex, endIndex);
			
			firstIndex = line.indexOf(":",endIndex);
			firstIndex +=1;
			endIndex = line.indexOf("}",firstIndex);
			employeePass = line.substring(firstIndex, endIndex);
			
			employees[index3] = new SalesAssociate(employeeName, address, totalCars, employeeID, employeePass);
			index3 = index3 + 1;
	
  } // End of checkEmployeeInfo method
	

public  Boolean loginConfirmation(String username, String password){
	
	message = "";
	Boolean login = false;
	for (int i = 0; i < index3; i++ ){
		this.employeeID = employees[i].getID();
		this.employeePass = employees[i].getAssociatePass();
		
		if (this.employeeID.compareToIgnoreCase(username) == 0 && this.employeePass.compareToIgnoreCase(password) == 0){
			login = true;				
		}				
			
	}if(login)
		JOptionPane.showMessageDialog(null,"Welcome to the system.","Entry confirmation",JOptionPane.INFORMATION_MESSAGE);
	else
		JOptionPane.showMessageDialog(null,"Login Failure.","",JOptionPane.ERROR_MESSAGE);
	return login;
}		
	

public void getColorInfo(String vin, String color){								
		
		// Searching the inventory to find the car to modify
		message = "";
		for (int i = 0; i < index; i++){
			this.vin = cars[i].getVin();			
			if (this.vin.compareToIgnoreCase(vin) == 0){
				cars[i].setColor(color);
				message = "This is the updated car: " + cars[i].getMessage();
				JOptionPane.showMessageDialog(null,message,"New Info",JOptionPane.INFORMATION_MESSAGE);	
				
			}				
		}
		if (message == "")
			JOptionPane.showMessageDialog(null, "Invalid Car. Please Try again.","Error Message",JOptionPane.ERROR_MESSAGE);
	
}// End of getColorInfoMethod
	
public void getEngineInfo(String vin, String engine){								
		
	// Searching the inventory to find the car to modify
			message = "";
			for (int i = 0; i < index; i++){
				this.vin = cars[i].getVin();			
				if (this.vin.compareToIgnoreCase(vin) == 0){
					cars[i].setEngine(engine);
					message = "This is the updated car: " + cars[i].getMessage();
					JOptionPane.showMessageDialog(null,message,"New Info",JOptionPane.INFORMATION_MESSAGE);	
					
				}				
			}
			if (message == "")
				JOptionPane.showMessageDialog(null, "Invalid Car. Please Try again.","Error Message",JOptionPane.ERROR_MESSAGE);
		
			
	
}// End of getEngineInfoMethod
		

public void getBodyStyleInfo(String vin, String bodyStyle){								
		
	// Searching the inventory to find the car to modify
			message = "";
			for (int i = 0; i < index; i++){
				this.vin = cars[i].getVin();			
				if (this.vin.compareToIgnoreCase(vin) == 0){
					cars[i].setBodyStyle(bodyStyle);
					message = "This is the updated car: " + cars[i].getMessage();
					JOptionPane.showMessageDialog(null,message,"New Info",JOptionPane.INFORMATION_MESSAGE);	
					
				}				
			}
			if (message == "")
				JOptionPane.showMessageDialog(null, "Invalid Car. Please Try again.","Error Message",JOptionPane.ERROR_MESSAGE);
			
	
}// End of getBodyStyleInfoMethod


public void getMSRPInfo(String vin, double msrp){				
	// Searching the inventory to find the car to modify
			message = "";
			for (int i = 0; i < index; i++){
				this.vin = cars[i].getVin();			
				if (this.vin.compareToIgnoreCase(vin) == 0){
					cars[i].setMsrp(msrp);
					message = "This is the updated car: " + cars[i].getMessage();
					JOptionPane.showMessageDialog(null,message,"New Info",JOptionPane.INFORMATION_MESSAGE);	
					
				}				
			}
			if (message == "")
				JOptionPane.showMessageDialog(null, "Invalid Car. Please Try again.","Error Message",JOptionPane.ERROR_MESSAGE);
}		
// End of getCarInfoMethod


	public void recordTransaction(String salesDate, double salePrice, String customerName, String customerID, String associate, String associateID,String make,String model){
		message = "";
		this.salesDate = salesDate;
		this.salePrice = salePrice;
		this.customerName = customerName;
		this.customerID = customerID;
		salesAssociateName = associate;
		this.associateID = associateID;
		this.make = make;
		this.model = model;
		
		transactions[index2] = new Transaction(this.salesDate,this.salePrice,this.customerName,this.customerID,salesAssociateName,this.associateID,this.make,this.model);
		try{			
			PrintWriter record = new PrintWriter(new FileWriter("transactions.txt", true));
			message = transactions[index2].toMessage();
			
			record.println(message);
			record.close();
			
		}catch (Exception e){
			JOptionPane.showMessageDialog(null, "File reading issue", 
												"Error message", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
}
	

