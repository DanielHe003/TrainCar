/*
 * Name: Daniel He
 * Solar ID: 114457594
 * Homework #2
 * Email: daniel.he@stonybrook.edu
 * Course: CSE214
 * Recitation #: R01 TA:Ulfeen Ayevan & Wesley Mui  
 */

import java.util.Scanner;

public class TrainManager {
	/*
	* The main class is a switch case which prints out a menu of different options 
	* and then the user has the option of choosing a selection which then will implement
	* the appropriate selection.
	* 
	* @author Daniel He
	* email: daniel.he@stonybrook.edu
	* 114457594
	*/
	public static void main(String[] args) {
		double length;
		double weight;
		double value;
		String name;
		String temp;
		
		TrainLinkedList train = new TrainLinkedList();
		Scanner scanner = new Scanner(System.in);
		String scan = "";
	
		while(scan != "Q") {
			mainMenu();
			System.out.printf("%nEnter a selection: ");
			scan = scanner.nextLine().toUpperCase();
			System.out.println();
			
			switch(scan) {
			
			//Moves the cursor forward one car (if a next car exists).
			case "F": 
				train.cursorForward();
				break;
				
			//Moves the cursor backward one car (if a previous car exists).
			case "B": 
				train.cursorBackward();
				break;
				
			//Inserts a new empty car after the cursor. If the cursor is null (i.e. the train is empty), the car is set as the head of the train. After insertion, the cursor is set to the newly inserted car.
			case "I": 
				System.out.print("Enter car length in meters: ");
				String carLength = scanner.nextLine();
				length = Double.parseDouble(carLength);
				
				System.out.print("Enter car weight in tons: ");
				String carWeight = scanner.nextLine();
				weight = Double.parseDouble(carWeight);
				
				System.out.printf("%nNew train car %s meters %s tons inserted into train.%n", length, weight);
				
				TrainCar tempCar = new TrainCar(length, weight);
				
				train.insertAfterCursor(tempCar);
				break;
			
			//Removes the car at current position of the cursor. After deletion, the cursor is set to the next car in the list if one exists, otherwise the previous car. If there is no previous car, the list is empty and the cursor is set to null.
			case "R": 
				TrainCar removedCar = train.removeCursor();
				System.out.printf("Car successfully unlinked. The following load has been removed from the train:%n%n");
				System.out.println("        Name      Weight (t)     Value ($)   Dangerous");
				System.out.println("    ===================================================");
				if(removedCar.getProductLoad() == null) {
					System.out.printf("%12s%12.1f%14.2f%18s%n", "Empty",
							0.0, 0.0, "NOT DANGEROUS");
				} else { 
					String stringCurrency = "";
					stringCurrency = String.format("%,.2f", removedCar.getProductLoad().getvalue());
					System.out.printf("%14s%14.1f%14s%12s%n", removedCar.getProductLoad().getName(),
						removedCar.getCarWeight(), stringCurrency, (removedCar.getProductLoad().getIsDangerous() ? "YES" : "NO"));
				}
				break;
			
			//Sets the product load at the current position in the list.
			case "L":
				System.out.print("Enter produce name: ");
				name = scanner.nextLine();
				
				System.out.print("Enter product weight in tons: ");
				temp = scanner.nextLine();
				weight = Double.parseDouble(temp);
				
				System.out.print("Enter product value in dollars: ");
				temp = scanner.nextLine();
				value = Double.parseDouble(temp);
				
				System.out.print("Enter is product dangerous? (y/n): ");
				temp = scanner.nextLine().toLowerCase();
				String Danger = temp;
				if (Danger.equals("n")) {
					ProductLoad tempLoad = new ProductLoad(name, weight, value, false);
					train.getCursorData().setProductLoad(tempLoad);
				} else if (Danger.equals("y")) {
					ProductLoad tempLoad = new ProductLoad(name, weight, value, true);
					train.getCursorData().setProductLoad(tempLoad);
				}
				System.out.printf("%n%.1f tons of %s added to the current car.%n", weight, name);
				break;
			
			/*Searches the train for all the loads with the indicated name and prints out the total weight and value, 
		   	 *and whether the load is dangerous or not. If the product could not be found, indicate to the user that 
			 *the train does not contain the indicated product.
			*/
			case "S": 
				System.out.print("Enter product name: ");
				name = scanner.nextLine();
				train.findProduct(name);
				break;
				
			//Prints the String value of the train to the console.
			case "T": 
				System.out.println(train.toString());
				break;
				
			//Prints the train manifest - the loads carried by each car.
			case "M": 
				train.printManifest();
				break;
				
			//Removes all the dangerous cars from the train.
			case "D": 
				train.removeDangerousCars();
				break;
			
			//Terminates the program.
			case "Q":
				System.out.println("Program terminating successfully...");
				return;
				
			//Returns to menu in case of wrong input
			default:
				System.out.printf("Please enter a choice on the list!\n");
				break;
			}
		}
		scanner.close();
	}

	//Prints out the list of all options available for the user to choose from and implements it.
	public static void mainMenu(){
		System.out.println();
		System.out.println("(F) Cursor Forward");
		System.out.println("(B) Cursor Backward");
		System.out.println("(I) Insert Car After Cursor");
		System.out.println("(R) Remove Car At Cursor");
		System.out.println("(L) Set Product Load");
		System.out.println("(S) Search For Product");
		System.out.println("(T) Display Train");
		System.out.println("(M) Display Manifest");
		System.out.println("(D) Remove Dangerous Cars");
		System.out.println("(Q) Quit");
	}
}
