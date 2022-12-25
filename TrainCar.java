/*
 * Name: Daniel He
 * Solar ID: 114457594
 * Homework #2
 * Email: daniel.he@stonybrook.edu
 * Course: CSE214
 * Recitation #: R01 TA:Ulfeen Ayevan & Wesley Mui  
 */

/*
*  TrainCar which contains a length in meters (double), a weight in tons (double), and a load reference (ProductLoad). 
*  The load variable of the train may be null, which indicates that the train car is empty and contains no product. 
*  The train car has accessor methods for the length, weight, and load variables; however, it only provides a mutator 
*  method for the load variable (the car weight and length are constant once set). In addition, the class
*  specifies a constructor method (with whatever parameters are necessary), and a method determining whether the car is empty or not.
* 
* @author Daniel He
* email: daniel.he@stonybrook.edu
* 114457594
*/
public class TrainCar {
	
	private double carLength;
	private double carWeight;
	private ProductLoad load;
	
	/*
	 * returns the double carLength
	 * 
	 * <dt> Preconditions:
	 * 	<dd> This TrainCar object has been instantiated.
	 * 
	 * @return
	 * 	The TrainCar carLength
	 * 
	 */
	public double getcarLength() {
		return carLength;
	}
	
	/*
	 * returns the double carWeight
	 * 
	 * <dt> Preconditions:
	 * 	<dd> This TrainCar object has been instantiated.
	 * 
	 * @return
	 * 	The TrainCar carWeight
	 * 
	 */
	public double getCarWeight() {
		return carWeight;
	}
	
	/*
	 * returns the ProductLoad load
	 * 
	 * <dt> Preconditions:
	 * 	<dd> This TrainCar object has been instantiated with a ProductLoad.
	 * 
	 * @return
	 * 	The ProductLoad load
	 * 
	 */
	public ProductLoad getProductLoad() {
		return load;
	}
	
	/*
	 * Replaces the ProductLoad load with the parameter load
	 * 
	 * @param load
	 * 		New load for the TrainCar
	 * 
	 * <dt> Preconditions:
	 * 	<dd>This TrainCar object has been instantiated.
	 * 
	 * <dt> Postconditions:
	 * 	<dd>The new TrainCar now has a new ProductLoad field with the parameter load.
	 * 
	 */
	public void setProductLoad(ProductLoad load) {
		this.load = load;
	}
	
	/*
	 * Constructs an TrainCar objects with null or 0 fields.
	 * 
	 * <dt> Postconditions:
	 * 	<dd> The TrainCar has been initialized with empty fields.
	 * 
	 */
	public TrainCar() {
	}
	
	/*
	 * Does the same thing as the TrainCar() method but uses user inputted fields to set the fields.
	 * 
	 * @param carLength
	 * 		New carLength for the TrainCar
	 * @param carWeight 
	 * 		New carWeight for the TrainCar
	 * 
	 * @throws IllegalArgumentException
	 * 		Indicates that the inputted fields are invalid.
	 */
	public TrainCar(double carLength, double carWeight) {
		if (carLength < 0)
			throw new IllegalArgumentException("Car carLength can not be negative!");
		if (carWeight < 0)
			throw new IllegalArgumentException("Weight can not be negative!");
		this.carWeight =carWeight;
		this.carLength = carLength;
	}

	/*
	 * Does the same thing as the TrainCar() method but uses user inputted fields to set the fields.
	 * 
	 * @param carLength
	 * 		New carLength for the TrainCar
	 * @param carWeight 
	 * 		New carWeight for the TrainCar
	 * @param load
	 * 		New load for the ProductLoad in the TrainCar
	 * 
	 * 	 * @throws IllegalArgumentException
	 * 		Indicates that the inputted fields are invalid.
	 */
	public TrainCar(double carLength, double carWeight, ProductLoad load) {
		if (carLength < 0)
			throw new IllegalArgumentException("Car carLength can not be negative!");
		if (carWeight < 0)
			throw new IllegalArgumentException("Weight can not be negative!");
		this.carWeight =carWeight;
		this.carLength = carLength;
		this.load = load;
	}
	
	/*
	 * Returns a boolean true if the TrainCar's load is empty and vice versa.
	 * 
	 * <dt> Postconditions:
	 * 	<dd> The TrainCar has been initialized.
	 * 
	 * @returns
	 * 		True if the ProductLoad within the TrainCar is not empty and vice versa.
	 * 
	 */
	public boolean isEmpty() {
		if(this.load == null)
			return true;
		return false;
	}
}
