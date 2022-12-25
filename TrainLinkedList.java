/*
 * Name: Daniel He
 * Solar ID: 114457594
 * Homework #2
 * Email: daniel.he@stonybrook.edu
 * Course: CSE214
 * Recitation #: R01 TA:Ulfeen Ayevan & Wesley Mui  
 */

/*
* ProductLoad contains the product name (String), its weight in tons (double), its value in dollars (double), 
* and whether the product is dangerous or not (boolean). Provides accessor and mutator methods for each variable. 
* The mutator methods for weight and value throws exceptions for illegal arguments (i.e. negative values) and
* includes a constructor.
*
* @author Daniel He
* email: daniel.he@stonybrook.edu
* 114457594
*/
public class TrainLinkedList {
	private TrainCarNode head;
	private TrainCarNode tail;
	private TrainCarNode cursor;
	private int size;
	private double length;
	private double value;
	private double weight;
	private boolean dangerous;
	private int dangerousCounter;
	
	/*
	 * Constructs an instance of the TrainLinkedList with no TrainCar objects in it.
	 * 
	 * <dt> Postconditions:
	 * 	<dd> This TrainLinkedList has been initialized to an empty linked list.
	 * 	<dd> head, tail, and cursor are all set to null.
	 * 
	 */
	public TrainLinkedList() {
	}
	
	/*
	 * Returns a reference to the TrainCar at the node currently referenced by the cursor.
	 * 
	 * @param NAME
	 * 		New name for the course
	 * 
	 * <dt> Preconditions:
	 * 	<dd>The list is not empty (cursor is not null).
	 * 
	 * @return
	 * 	The reference to the TrainCar at the node currently referenced by the cursor.
	 * 
	 */
	public TrainCar getCursorData() {
		if (cursor == null)
			throw new NullPointerException("The list is empty!");
		return cursor.getCar();
	}
	
	/*
	 * Places car in the node currently referenced by the cursor.
	 * 
	 * <dt> Preconditions:
	 * 	<dd>The list is not empty (cursor is not null).
	 * 
	 * <dt> Postconditions:
	 * 	<dd>The cursor node now contains a reference to car as its data.
	 * 
	 */
	public void setCursorData(TrainCar car) {
		if (cursor == null)
			throw new NullPointerException("The list is empty!");
		cursor.setCar(car);
	}
	
	/*
	 * Moves the cursor to point at the next TrainCarNode.
	 * 
	 * <dt> Preconditions:
	 * 	<dd>The list is not empty (cursor is not null) and cursor does not currently reference the tail of the list.
	 * 
	 * <dt> Postconditions:
	 * 	<dd>The cursor has been advanced to the next TrainCarNode, or has remained at the tail of the list.
	 * 
	 */
	public void cursorForward() {
		try {
			if(cursor != tail)  {
				cursor = cursor.getNext();
				System.out.println("Cursor moved foward");
			} else {
				System.out.println("No next car, cannot move cursor forward.");
			}
		} catch(Exception e) {
			System.out.println("No next car, cannot move cursor forward.");
		}
	}
	
	/*
	 * Moves the cursor to point at the previous TrainCarNode.
	 * 
	 * <dt> Preconditions:
	 * 	<dd>The list is not empty (cursor is not null) and cursor does not currently reference the head of the list.
	 * 
	 * <dt> Postconditions:
	 * 	<dd>The cursor has been moved back to the previous TrainCarNode, or has remained at the head of the list.
	 * 
	 */
	public void cursorBackward() {
		try {
			if(cursor != head) {
				cursor = cursor.getPrevious();
				System.out.println("Cursor moved backward");
			} else {
				System.out.println("No previous car, cannot move cursor backward.");
			}
		}catch(Exception e) {
			System.out.println("No previous car, cannot move cursor backward.");
		}
	}
	
	/*
	 * Brief:

	 * 
	 * @param newCar 
	 * 		the new TrainCar to be inserted into the train.
	 * 
	 * <dt> Preconditions:
	 * 	<dd>This TrainCar object has been instantiated
	 * 
	 * <dt> Postconditions:
	 * 	 <dd>The new TrainCar has been inserted into the train after the position of the cursor.
	 *	 <dd>All TrainCar objects previously on the train are still on the train, and their order has been preserved.
	 *	 <dd>The cursor now points to the inserted car.
	 *
	 * @throws IllegalArgumentException 
	 * 		Indicates that newCar is null.
	 * 
	 */
	public void insertAfterCursor(TrainCar newCar) {
		TrainCarNode newNode = new TrainCarNode(newCar);
		try {
			if(newCar == null)
				throw new IllegalArgumentException();
		if(cursor == null) {
			head = newNode;
			tail = newNode;
			cursor = newNode;
		}else if(cursor == tail) {
			newNode.setNext(null);
			newNode.setPrevious(cursor);
			cursor.setNext(newNode);
			tail = newNode;
			cursor = tail;
		}else{
			newNode.setNext(cursor.getNext());
			newNode.setPrevious(cursor);
			cursor.getNext().setPrevious(newNode);
			cursor.setNext(newNode);
			cursor = cursor.getNext();
		}
		}catch(IllegalArgumentException e) {
			System.out.println("The newCar is null!");
		}
		size++;
		length += newCar.getcarLength();
		weight += newCar.getCarWeight();
	}
	
	/*
	 * Removes the TrainCarNode referenced by the cursor and returns the TrainCar contained within the node.
	 * 
	 * <dt> Preconditions:
	 * 	<dd>The cursor is not null.
	 * 
	 * <dt> Postconditions:
	 * 	 <dd>The TrainCarNode referenced by the cursor has been removed from the train.
	 *	 <dd>The cursor now references the next node, or the previous node if no next node exists.
	 * 
	 */
	public TrainCar removeCursor() {
		TrainCar removedNode = null;
		if (cursor.getCar().getProductLoad() != null) {
			removedNode = cursor.getCar();
			if(cursor.getCar().getProductLoad() != null) {
				size--;
				value -= removedNode.getProductLoad().getvalue();
				length -= removedNode.getcarLength();
				weight -= removedNode.getCarWeight();
				if(removedNode.getProductLoad().getIsDangerous() == true)
					dangerousCounter--;
			}
		}
		if(cursor == tail) {
			tail = cursor.getPrevious();
			cursor = cursor.getPrevious();
			cursor.getNext().setPrevious(null);
			cursor.setNext(null);
		}else if(cursor == head) {
			cursor = cursor.getNext();
			head = cursor;
			cursor.getPrevious().setNext(null);
			cursor.setPrevious(null);
		}else{
			cursor = cursor.getNext();
			cursor.getPrevious().getPrevious().setNext(cursor);
			cursor.setPrevious(cursor.getPrevious().getPrevious());
		}
		return removedNode;
	}
	
	/*
	 * Determines the number of TrainCar objects currently on the train.
	 * 
	 * @return
	 * 	The number of TrainCar objects on this train.
	 * 
	 * @note
	 * 	This function should complete in O(1) time.
	 */
	public int size() {
		return size;
	}
	
	/*
	 * Returns the total length of the train in meters.
	 * 
	 * @return
	 * 	The sum of the lengths of each TrainCar in the train.
	 * 
	 * @note
	 * 	This function should complete in O(1) time.
	 */
	public double getLength() {
		return length;
	}
	
	/*
	 * Returns the total value of product carried by the train.
	 * 
	 * @return
	 * 	The sum of the values of each TrainCar in the train.
	 * 
	 * @note
	 * 	This function should complete in O(1) time.
	 */
	public double getValue() {
		return value;
	}
	
	/*
	 * Returns the total weight in tons of the train. Note that the weight of the 
	 * train is the sum of the weights of each empty TrainCar, plus the weight of the ProductLoad carried by that car.
	 * 
	 * @return
	 * 	The sum of the weight of each TrainCar plus the sum of the ProductLoad carried by that car.
	 * 
	 * @note
	 * 	This function should complete in O(1) time.
	 */
	public double getWeight(){
		return weight;
	}
	
	/*
	 * Whether or not there is a dangerous product on one of the TrainCar objects on the train.
	 * 
	 * @return
	 * 	Returns true if the train contains at least one TrainCar carrying a dangerous ProductLoad, false otherwise.
	 * 
	 * @note
	 * 	This function should complete in O(1) time.
	 */
	public boolean isDangerous() {
		if(dangerousCounter>0)
			dangerous = true;
		else {dangerous = false;}
		return dangerous;
	}
	
	/*
	 * Searches the list for all ProductLoad objects with the indicated name and sums together their weight 
	 * and value (Also keeps track of whether the product is dangerous or not), then prints a single 
	 * ProductLoad record to the console.
	 * 
	 * @param name 
	 * 		the name of the ProductLoad to find on the train.
	 * 
	 * @notes
	 * 		This method should search the entire train for the indicated ProductLoad, and should not stop 
	 * 		after the first match. For example, if there are three different TrainCar objects each carrying 
	 * 		a ProductLoad with the name "corn", then this method should print a single record with the sum of 
	 * 		the weight and value for the corn on each car. If nothing was found, indicate that there are no 
	 * 		ProductLoad objects of the indicated name on board the train.
	 * 
	 * @notes
	 * 		For the purposes of this assignment, you may assume that the dangerousness of loads with equal names 
	 * 		are equal. Simply use the boolean value of isDangerous for the first match found.
	 * 
	 */
	public void findProduct(String name) {
		System.out.println();
		TrainCarNode tempCursor = head;
		int record = 0;
		int tempDangerousCounter = 0;
		double tempValue = 0;
		double tempWeight = 0;
		while(tempCursor != null) {
			if(tempCursor.getCar().getProductLoad() == null)
				tempCursor = tempCursor.getNext();
			if(name.equals(tempCursor.getCar().getProductLoad().getName())) {
				tempWeight += tempCursor.getCar().getCarWeight();
				tempValue += tempCursor.getCar().getProductLoad().getvalue();
				if(tempCursor.getCar().getProductLoad().getIsDangerous() == true)
					tempDangerousCounter++;
				record++;
			}
			tempCursor = tempCursor.getNext();
		}
		if(record==0) {
			System.out.println();
			System.out.println("No record of "+name+" on board train.");
		}else if(record != 0) {
			System.out.printf("The following products were found on %d cars:%n%n", record);
			System.out.println("        Name      Weight (t)     Value ($)   Dangerous");
			System.out.println("    ===================================================");
			String stringCurrency = "";
			stringCurrency = String.format("%,.2f", tempValue);
			System.out.printf("%14s%14.1f%14s%12s%n", name, tempWeight, stringCurrency, ((tempDangerousCounter>0) ? "YES" : "NO"));
		}
	}
	
	/*
	 * Prints a neatly formatted table of the car number, car length, car weight, load name, 
	 * load weight, load value, and load dangerousness for all of the car on the train.
	 * 
	 * @notes
	 * 		There should be a record for each TrainCar printed to the console, numbered from 1 to n. For each car, print the data of the 
	 * 		car, followed by the ProductLoad data if the car is not empty. If the car is empty, print "Empty" for name, 0 for weight and 
	 * 		value, and "NO" for dangerousness (see sample I/O for example).
	 * 
	 */
	public void printManifest() {
		System.out.println("    CAR:                               LOAD:");
		System.out.println("      Num   Length (m)    Weight (t)  |    Name      Weight (t)     Value ($)   Dangerous");
		System.out.println("    ==================================+===================================================");
		TrainCarNode temp = head;
		String stringCurrency = "";
		int num = 1;
		while(temp != null) {
			if(temp.getCar().getProductLoad() != null)
				stringCurrency = String.format("%,.2f", temp.getCar().getProductLoad().getvalue());
			if(temp == cursor) {
				if(temp.getCar().getProductLoad() == null)
					System.out.printf(" ->   %2d%14.1f%14.1f  |%10s%14.1f%14.2f%12s", num, temp.getCar().getcarLength(), temp.getCar().getCarWeight(),
						"Empty", 0.0, 0.00, "NO");
				else if(temp.getCar().getProductLoad() != null) {
					System.out.printf(" ->   %2d%14.1f%14.1f  |%10s%14.1f%14s%12s", num, temp.getCar().getcarLength(), temp.getCar().getCarWeight(),
							temp.getCar().getProductLoad().getName(), temp.getCar().getProductLoad().getWeight(), stringCurrency,
							(temp.getCar().getProductLoad().getIsDangerous())? "YES" : "NO");
				}
			} else if(temp != cursor) {
				if(temp.getCar().getProductLoad() == null)
					System.out.printf("      %2d%14.1f%14.1f  |%10s%14.1f%14.2f%12s", num, temp.getCar().getcarLength(), temp.getCar().getCarWeight(),
						"Empty", 0.0, 0.00, "NO");
				else if(temp.getCar().getProductLoad() != null) {
					System.out.printf("      %2d%14.1f%14.1f  |%10s%14.1f%14s%12s", num, temp.getCar().getcarLength(), temp.getCar().getCarWeight(),
							temp.getCar().getProductLoad().getName(), temp.getCar().getProductLoad().getWeight(), stringCurrency,
							(temp.getCar().getProductLoad().getIsDangerous())? "YES" : "NO");
				}
			}
			num++;
			temp=temp.getNext();
			System.out.println();
		}
	}
	
	/*
	 * Removes all dangerous cars from the train, maintaining the order of the cars in the train.
	 * 
	 * <dt> Postconditions:
	 * 	<dd>All dangerous cars have been removed from this train.
	 * 	<dd>The order of all non-dangerous cars must be maintained upon the completion of this method.
	 * 
	 * @notes
	 * 		All the dangerous cars may be discarded after calling this method.
	 */
	public void removeDangerousCars() {
		TrainCarNode tempCursor = head;
		TrainCarNode cursorHolder = cursor;
		while(tempCursor != null) {
			if(tempCursor.getCar().getProductLoad().getIsDangerous() == false) {
				tempCursor = tempCursor.getNext();
			}else if(tempCursor.getCar().getProductLoad().getIsDangerous() == true) {
				cursor = tempCursor;
				this.removeCursor();
				cursor = cursorHolder.getNext();
				tempCursor = tempCursor.getNext();
			}
		}
		System.out.printf("Dangerous cars successfully removed from the train.%n");
	}
	
	/*
	 * Returns a neatly formatted String representation of the train.
	 * 
	 * @returns
	 * 		A neatly formatted string containing information about the train, including its size 
	 * 		(number of cars), length in meters, weight in tons, value in dollars, and whether 
	 * 		it is dangerous or not.
	 */
	public String toString() {
		TrainCarNode tempCursor = head;
		double tempWeight = weight;
		double tempValue = value;
		int dangerousCounter = 0;
		
		while(tempCursor != null) {
			tempWeight += tempCursor.getCar().getProductLoad().getWeight();
			tempValue += tempCursor.getCar().getProductLoad().getvalue();
			dangerousCounter += ((tempCursor.getCar().getProductLoad().getIsDangerous()) ? 1 : 0);
			tempCursor = tempCursor.getNext();
		}
		String carCount = "car";
		if(size > 1)
			carCount = "cars";
		return (String.format("Train: %d %s, %.1f meters, %,.1f tons, $%,.2f value, %s.",
				size, carCount, this.getLength(), tempWeight, tempValue, (dangerousCounter>0) ? "DANGEROUS" : "not dangerous"));
	}
}
