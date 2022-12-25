/*
 * Name: Daniel He
 * Solar ID: 114457594
 * Homework #2
 * Email: daniel.he@stonybrook.edu
 * Course: CSE214
 * Recitation #: R01 TA:Ulfeen Ayevan & Wesley Mui  
 */

/*
* TrainCarNode acts as a node wrapper around a TrainCar object. The class contains two TrainCarNode references 
* (one for the next node in the chain, one for the previous node in the chain), and one TrainCar reference variable 
* containing the data. Include mutator/accessor methods for each member variable, and a constructor method. 
* 
* @author Daniel He
* email: daniel.he@stonybrook.edu
* 114457594
*/
public class TrainCarNode {
	private TrainCarNode previous;
	private TrainCarNode next;
	private TrainCar car;
	
	/*
	 * Constructs an TrainCarNode objects with null or 0 fields.
	 * 
	 * <dt> Postconditions:
	 * 	<dd> The TrainCarNode has been initialized with empty fields.
	 * 
	 */
	public TrainCarNode() {
	}
	
	/*
	 * Does the same thing as the TrainCarNode() method but uses user inputted fields to set the fields.
	 * 
	 * @param car
	 * 		New TrainCar car for the TrainCarNode
	 */
	public TrainCarNode(TrainCar car) {
		this.car = car;
	}
	
	/*
	 * returns the TrainCarNode previous
	 * 
	 * <dt> Preconditions:
	 * 	<dd> This TrainCarNode previous has been instantiated.
	 * 
	 * @return
	 * 	The TrainCarNode previous
	 * 
	 */
	public TrainCarNode getPrevious() {
		return previous;
	}
	
	/*
	 * returns the TrainCarNode next
	 * 
	 * <dt> Preconditions:
	 * 	<dd> This TrainCarNode next has been instantiated.
	 * 
	 * @return
	 * 	The TrainCarNode next
	 * 
	 */
	public TrainCarNode getNext() {
		return next;
	}
	
	/*
	 * returns the TrainCar car
	 * 
	 * <dt> Preconditions:
	 * 	<dd> This TrainCarNode object has been instantiated.
	 * 
	 * @return
	 * 	The TrainCar car
	 * 
	 */
	public TrainCar getCar() {
		return car;
	}
	
	/*
	 * Replaces the TrainCarNode previous with the parameter previous
	 * 
	 * @param previous
	 * 		New previous for the TrainCarNode
	 * 
	 * <dt> Preconditions:
	 * 	<dd>This TrainCarNode object has been instantiated.
	 * 
	 * <dt> Postconditions:
	 * 	<dd>The new TrainCarNode now has a new previous field with the parameter previous.
	 * 
	 */
	public void setPrevious(TrainCarNode previous) {
		this.previous = previous;
	}
	
	/*
	 * Replaces the TrainCarNode next with the parameter next
	 * 
	 * @param next
	 * 		New next for the TrainCarNode
	 * 
	 * <dt> Preconditions:
	 * 	<dd>This TrainCarNode object has been instantiated.
	 * 
	 * <dt> Postconditions:
	 * 	<dd>The new TrainCarNode now has a new next field with the parameter next.
	 * 
	 */
	public void setNext(TrainCarNode next) {
		this.next = next;
	}
	
	/*
	 * Replaces the TrainCar car with the parameter car
	 * 
	 * @param car
	 * 		New car for the TrainCarNode 
	 * 
	 * <dt> Preconditions:
	 * 	<dd>This TrainCarNode object has been instantiated.
	 * 
	 * <dt> Postconditions:
	 * 	<dd>The new TrainCarNode now has a new car field with the parameter car.
	 * 
	 */
	public void setCar(TrainCar car) {
		this.car = car;
	}
	
	/*
	 * Returns a neatly formatted String representation of the TrainCarNode.
	 * 
	 * @returns
	 * 		A neatly formatted string containing information about the TrainCarNode, including its size 
	 * 		previous car, next car, load name, length, weight, value, and dangerous or not.
	 */
	public String toString() {
		return(String.format("Previous Car: %s Next Car: %s, Load Name: %s, Length(meters): %f, Weight(tons): %f, Value: %f, Dangerous?: %s", 
			this.getPrevious(), this.getPrevious(), this.getCar().getProductLoad().getName(), this.getCar().getcarLength(),
			this.getCar().getCarWeight(), this.getCar().getProductLoad().getvalue(), (this.getCar().getProductLoad().getIsDangerous()) ? "YES" : "NO"));
	}
}
