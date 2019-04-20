import java.util.ArrayList;

import javax.swing.JOptionPane;


public class Car {
	private String make;
	private String model;
	private String vin;
	private int year;
	private String color;
	private int numberOfDoors;
	private String engine;
	private String bodyStyle;
	private double msrp;
	


// Constructor using all parameters from text file.
	public Car(String make, String model, String vin, int year, String color, String engine, String bodyStyle, double msrp){
		this.make = make;
		this.model = model;
		this.vin = vin;
		this.year = year;
		this.color = color;
		this.engine = engine;
		this.bodyStyle = bodyStyle;
		this.msrp = msrp;
	}
	
//Standard Constructor with no inputs
	public Car(){
		make = "";
		model = "";
		vin = "";
		year = 0;
		color = "";
		engine = "";
		bodyStyle = "";
		msrp = 0.0;
	}
	//Get make of car
	public String getMake(){
		return make;
	}
	
	//Set make of car
	public void setMake(String value){
		make = value;
	}
	
	//Get model of car
	public String getModel(){
		return model;
	}
	
	//Set model of car
	public void setModel(String value){
		model = value;
	}
	
	//Get VIN number of car
	public String getVin(){
		return vin;
	}
	
	//Set VIN number of car
	public void setVin(String value){
		vin = value;
	}
	
	//Get year of car
	public int getYear(){
		return year;
	}
	
	// Set year of car
	public void setYear(int value){
		if(value<1920 || value > 2018)
			JOptionPane.showMessageDialog(null,"The year you have entered is invalid. Please enter a valid year.","Error Message",JOptionPane.INFORMATION_MESSAGE);
		else
			year = value;
	}
	//Get color of car
	public String getColor(){
		return color;
	}
	
	//Set color of car
	public void setColor(String value){
		color = value;
	}
	
	//Get number of door of car
	public int getNumberOfDoors(){
		return numberOfDoors;
	}
	
	//Set number of doors on car
	public void setNumberOfDoors(int value){
		numberOfDoors = value;
	}
	
	//Get engine type
	public String getEngine(){
		return engine;
	}
	
	//Set type of engine
	
	public void setEngine(String value){
		engine = value;
	}
	
	//Get body style
	
	public String  getBodyStyle() {
		return bodyStyle;
	}
	
	//Set body style of car
	public void setBodyStyle(String value){
		
		bodyStyle = value;
	}
	
	// Get msrp of car
	public double getMsrp(){
		return msrp;
	}
	
	// Set msrp of car
	public void setMsrp(double value){
		msrp = value;
	}
	
	//ToString 
	
	public String getMessage(){
		return "{make:" + make + ",model:" + model + ",vin:" + vin + ",year:" + year + ",color:" + color + ",engine:" + engine + ",bodyStyle:" + bodyStyle + ",msrp:" + msrp + "}\n";
	}
	
	public String getString(){
		return "{make:" + make + ",model:" + model + ",vin:" + vin + ",year:" + year + ",color:" + color + ",engine:" + engine + ",bodyStyle:" + bodyStyle + ",msrp:" + msrp + "}";
	}
}
