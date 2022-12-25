/*
 * Name: Daniel He
 * Solar ID: 114457594
 * Homework #2
 * Email: daniel.he@stonybrook.edu
 * Course: CSE214
 * Recitation #: R01 TA:Ulfeen Ayevan & Wesley Mui  
 */

/*
* ProductLoad which contains the product name (String), its weight in tons (double), its value in dollars (double), 
* and whether the product is dangerous or not (boolean). Provides accessor and mutator methods for each variable. 
* The mutator methods for weight and value throws exceptions for illegal arguments (i.e. negative values) and includes a constructor.
* 
* @author Daniel He
* email: daniel.he@stonybrook.edu
* 114457594
*/
public class ProductLoad {
	private String name;
	private double weight;
	private double value;
	private boolean isDangerous;
	
	/*
	 * Constructs an ProductLoad objects with null or 0 fields.
	 * 
	 * <dt> Postconditions:
	 * 	<dd> The ProductLoad has been initialized with empty fields.
	 * 
	 */
	public ProductLoad() {
	}
	
	/*
	 * Does the same thing as the ProductLoad() method but uses user inputted fields to set the fields.
	 * 
	 * @param name
	 * 		New name for the ProductLoad
	 * @param weight 
	 * 		New weight for the ProductLoad
	 * @param value
	 * 		New value for the ProductLoad
	 * @param isDangerous 
	 * 		New isDangerous for the ProductLoad
	 */
	public ProductLoad(String name, double weight, double value, boolean isDangerous) {
		if (weight < 0)
			throw new IllegalArgumentException("Weight can not be negative!");
		if (value < 0)
			throw new IllegalArgumentException("value can not be negative!");
		this.name = name;
		this.weight = weight;
		this.value = value;
		this.isDangerous = isDangerous;
	}
	
	/*
	 * returns the string name
	 * 
	 * <dt> Preconditions:
	 * 	<dd> This ProductLoad object has been instantiated.
	 * 
	 * @return
	 * 	The ProductLoad name
	 * 
	 */
	public String getName() {
		return name;
	}
	
	/*
	 * returns the double weight
	 * 
	 * <dt> Preconditions:
	 * 	<dd> This ProductLoad object has been instantiated.
	 * 
	 * @return
	 * 	The ProductLoad weight
	 * 
	 */
	public double getWeight() {
		return weight;
	}
	
	/*
	 * returns the double value
	 * 
	 * <dt> Preconditions:
	 * 	<dd> This ProductLoad object has been instantiated.
	 * 
	 * @return
	 * 	The ProductLoad value
	 * 
	 */
	public double getvalue() {
		return value;
	}
	
	/*
	 * returns the boolean isDangerous
	 * 
	 * <dt> Preconditions:
	 * 	<dd> This ProductLoad object has been instantiated.
	 * 
	 * @return
	 * 	The ProductLoad isDangerous
	 * 
	 */
	public boolean getIsDangerous() {
		return isDangerous;
	}
	
	/*
	 * Replaces the string name with the parameter string
	 * 
	 * @param name
	 * 		New name for the ProductLoad
	 * 
	 * <dt> Preconditions:
	 * 	<dd>This ProductLoad object has been instantiated.
	 * 
	 * <dt> Postconditions:
	 * 	<dd>The new ProductLoad now has a new name field with the parameter string.
	 * 
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/*
	 * Replaces the double weight with the parameter double
	 * 
	 * @param weight
	 * 		New weight for the ProductLoad
	 * 
	 * <dt> Preconditions:
	 * 	<dd>This ProductLoad object has been instantiated.
	 * 
	 * <dt> Postconditions:
	 * 	<dd>The new ProductLoad now has a new weight field with the parameter double.
	 * 
	 * @throws IllegalArgumentException
	 * 		Indicates that the inputted field is incorrect
	 * 
	 */
	public void setWeight(double weight) {
		if (weight < 0)
			throw new IllegalArgumentException("Weight can not be negative!");
		this.weight = weight;
	}
	
	/*
	 * Replaces the double value with the parameter double
	 * 
	 * @param value
	 * 		New value for the ProductLoad
	 * 
	 * <dt> Preconditions:
	 * 	<dd>This ProductLoad object has been instantiated.
	 * 
	 * <dt> Postconditions:
	 * 	<dd>The new ProductLoad now has a new value field with the parameter double.
	 * 
	 * @throws IllegalArgumentException
	 * 		Indicates that the inputted field is incorrect
	 * 
	 */
	public void setvalue(double value) {
		if (value < 0)
			throw new IllegalArgumentException("value can not be negative!");
		this.value = value;
	}
	
	/*
	 * Replaces the boolean isDangerous with the parameter boolean
	 * 
	 * @param isDangerous
	 * 		New isDangerous for the ProductLoad
	 * 
	 * <dt> Preconditions:
	 * 	<dd>This ProductLoad object has been instantiated.
	 * 
	 * <dt> Postconditions:
	 * 	<dd>The new ProductLoad now has a new isDangerous field with the parameter boolean.
	 * 
	 */
	public void setDangerous(boolean isDangerous) {
		this.isDangerous = isDangerous;
	}
}
