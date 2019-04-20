import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class DealershipProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = null;
		String line;	
		CarDealershipSystem entry = new CarDealershipSystem();
		int choice;
		String value;
		String value1;
		
		
		// Transaction variables
		String saleDate;
		double salePrice;
		String customerName;
		String customerID;
		String associateID;
		String associate;
		
		// car variables
		String make, model, vin, engine, bodyStyle, color;
		int year;
		double msrp;
		
		String username;
		String password;
		
		try {
			input = new Scanner(new File("cars.txt"));
			line = input.nextLine();
			// Loop to read in all lines of car text file and make into car objects.
			do{
				entry.createCarArray(line);
				line = input.nextLine();
			}while(input.hasNextLine());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			input = new Scanner(new File("transactions.txt"));
			line = input.nextLine();
			// Loop to read in all lines of transaction text file and make into transactions objects.
			do {
				entry.createTransactionsArray(line);
				line = input.nextLine();
			}while(input.hasNextLine());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// Creates the employee objects
		try{
			input = new Scanner(new File("employees.txt"));
			line = input.nextLine();
			
			do {
				entry.createEmployeeInfo(line);
				line = input.nextLine();
			}while(input.hasNextLine());
		}catch (FileNotFoundException e){
			
			JOptionPane.showMessageDialog(null, "File could not be found or read!", 
												"File IO message", JOptionPane.ERROR_MESSAGE);	
		}
		Boolean login = false;
		
		while (!login){
			username = JOptionPane.showInputDialog("Enter your username");
			password = JOptionPane.showInputDialog("Enter your password");
			login = entry.loginConfirmation(username, password);
		}
		
				
		
		
		//Message for options output to user.
		do{
			value = JOptionPane.showInputDialog(null,"1. Enter a new car into inventory.\n" + "2. Modify an existing car in stock.\n" + "3. Record the sale of a car.\n" + "4. Search car inventory.\n" + "5. Display inventory.\n" + "6. Exit program.","Car Dealership Program",JOptionPane.INFORMATION_MESSAGE);
			choice = Integer.parseInt(value);
			switch(choice){
				case 1:
				{
					
					value = JOptionPane.showInputDialog(null,"Enter the make of the car.","New Car Entry",JOptionPane.INFORMATION_MESSAGE);	
					make = value;
					value = JOptionPane.showInputDialog(null,"Enter the model of the car.","New Car Entry",JOptionPane.INFORMATION_MESSAGE);
					model = value;
					value = JOptionPane.showInputDialog(null,"Enter the VIN number of the car.","New Car Entry",JOptionPane.INFORMATION_MESSAGE);
					vin = value;
					value = JOptionPane.showInputDialog(null,"Enter the year of the car.","New Car Entry",JOptionPane.INFORMATION_MESSAGE);
					year = Integer.parseInt(value);
					value = JOptionPane.showInputDialog(null,"Enter the color of the car.","New Car Entry",JOptionPane.INFORMATION_MESSAGE);
					color = value;
					value = JOptionPane.showInputDialog(null,"Enter the type of engine in the car.","New Car Entry",JOptionPane.INFORMATION_MESSAGE);
					engine= value;
					value = JOptionPane.showInputDialog(null,"Enter the body style of the car.","New Car Entry",JOptionPane.INFORMATION_MESSAGE);
					bodyStyle = value;
					value = JOptionPane.showInputDialog(null,"Enter the MSRP of the car.","New Car Entry",JOptionPane.INFORMATION_MESSAGE);
					msrp = Double.parseDouble(value);
					entry.addNewCar(make,model,vin,year,color,engine,bodyStyle,msrp);
					continue;
				}
				case 2:
				{
					
					// They cannot change parts of the car that aren't modifiable such as the make, model, VIN, and year
					
					value1 = JOptionPane.showInputDialog("1. Change color" + "2. Change Engine" + 
							"3. Change body style" + "4. Change MSRP");
					
					value = JOptionPane.showInputDialog("Enter the VIN of the car");
					vin = value;
					switch (value1){
						case "1":{
							value = JOptionPane.showInputDialog(null,"Enter the new color of the car","Color change",JOptionPane.QUESTION_MESSAGE);
							color = value;
							entry.getColorInfo(vin,color);
							break;
						}
						case "2":{
							value = JOptionPane.showInputDialog(null,"Enter the new Engine type.","Engine change.",JOptionPane.QUESTION_MESSAGE);
							engine = value;
							entry.getEngineInfo(vin, engine);
							break;
						}
						case "3":{
							value = JOptionPane.showInputDialog(null,"Enter the new Body Style.","Body Style change.",JOptionPane.QUESTION_MESSAGE);
							bodyStyle = value;
							entry.getBodyStyleInfo(vin,bodyStyle);
							break;
						}
						case "4":{
							value = JOptionPane.showInputDialog(null,"Enter the new MSRP","MSRP change.",JOptionPane.QUESTION_MESSAGE);
							msrp = Double.parseDouble(value);
							entry.getMSRPInfo(vin,msrp);
							break;
						}					
					}
					continue;
				}
				case 3:
				{
					
					value = JOptionPane.showInputDialog("Enter the Sale Date");
					saleDate = value;
					value = JOptionPane.showInputDialog("Enter the Sale Price");
					salePrice = Double.parseDouble(value);
					value = JOptionPane.showInputDialog("Enter the Customer Name.");
					customerName = value;
					value = JOptionPane.showInputDialog("Enter the Customer ID.");
					customerID = value;
					value = JOptionPane.showInputDialog("Enter the Sales Associate name.");
					associate = value;
					value = JOptionPane.showInputDialog("Enter the Sales Associate ID.");
					associateID = value;
					value = JOptionPane.showInputDialog("Enter the make of the car.");
					make = value;
					value = JOptionPane.showInputDialog("Enter the model of the car.");
					model = value;
					
					
					entry.recordTransaction(saleDate,salePrice,customerName,customerID,associate,associateID,make,model);
					continue;
				}
				case 4:
				{
					value = JOptionPane.showInputDialog(null,"Enter make of car you want to search for","Search window",JOptionPane.INFORMATION_MESSAGE);
					make = value;
					value = JOptionPane.showInputDialog(null,"Enter model of the car you want to search for.","Search window.",JOptionPane.INFORMATION_MESSAGE);
					model = value;
					entry.searchInventory(make, model);
					continue;
				}
				case 5:
				{
					
					entry.displayList();
					continue;
				}
				case 6:
				{
					//System.exit(0);
					break;
				}
			}
		}while(choice!= 6);
		
		JOptionPane.showMessageDialog(null,"Program over.");	
	}

	
}
