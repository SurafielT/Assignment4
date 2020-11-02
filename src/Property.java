/**
 * Represents a Property object
 * implement setCity method
 * implement setPropertyName method
 * implement rentAmount method
 * implement Plot method
 * @author Surafiel
 *
 */
public class Property {
	private String propertyName;
	private String city;
	private double rentAmount;
	private String owner;
	private Plot plot;
	
	/**
	 * No-arg Constructor, creates a new object with default values of empty
	 * String, 0 fore rent amount, and default 
	 * Plot(sets the x, y values to zero, depth and width to 1)
	 */
	public Property()
	{
		this.propertyName = "";
		this.city = "";
		this.owner = "";
		this.rentAmount = 0;
		this.plot = new Plot();
	}
	/**
	 * Copy Constructor, creates a new object using the information of the object passed to it.
	 * @param p - copies the constructor
	 */
	public Property(Property p)
	{
		this.propertyName = p.propertyName;
		this.city = p.city;
		this.rentAmount = p.rentAmount;
		this.owner = p.owner;
	}
	/**
	 * Parameterized Constructor, no Plot information provided
	 * @param propertyName - sets the property name
	 * @param city - sets the location of the property
	 * @param rentAmount - sets the rent amount
	 * @param owner - sets the owner of the property
	 */
	public Property(String propertyName, String city, double rentAmount, String owner)
	{
		this.propertyName= propertyName;
		this.city= city;
		this.rentAmount= rentAmount;
		this.owner= owner;
	}
	/**
	 * Constructor, Parameterized constructor
	 * @param propertyName - sets the property name
	 * @param city - sets location of city
	 * @param rentAmount - sets rent amount
	 * @param owner - sets the owner of the property
	 * @param x - sets x
	 * @param y - sets y
	 * @param width - sets width
	 * @param depth - sets depth
	 */
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth)
	{
		this.plot= new Plot(x, y, width, depth);
		this.city= city;
		this.propertyName= propertyName;
		this.rentAmount= rentAmount;
		this.owner= owner;
	}
	/**
	 * Set the city
	 * @param city - set city
	 */
	public void setCity(String city)
	{
		this.city = city;
	}
	/**
	 * Set the owner name
	 * @param owner - set owner
	 */
	public void setOwner(String owner)
	{
		this.owner = owner;
	}
	/**
	 * Set the property name
	 * @param propertyName - set property name
	 */
	public void setPropertyName(String propertyName)
	{
		this.propertyName = propertyName;
	}
	/**
	 * Set the rent amount
	 * @param rentAmount - sets Rent amount
	 */
	public void setRentAmount(double rentAmount)
	{
		this.rentAmount = rentAmount;
	}
	/**
	 * Return city
	 * @return String, get city
	 */
	public String getCity()
	{
		return city;
	}
	/**
	 * Return owner
	 * @return String, get owner
	 */
	public String getOwner()
	{
		return owner;
	}
	/**
	 * Return property name
	 * @return String, property name
	 */
	public String getPropertyName()
	{
		return propertyName;
	}
	/**
	 * Return rent amount
	 * @return double, get rent amount
	 */
	public double getRentAmount()
	{
		return rentAmount;
	}
	/**
	 * Set plot values and return the Plot instance
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 * @return the plot instance
	 */
	public Plot setPlot(int x, int y, int width, int depth)
	{
		return new Plot(x, y, width, depth);
		
	}
	/**
	 * Retrun Plot
	 * @return plot instance
	 */
	public Plot getPlot()
	{
		return plot;
	}
	/**
	 * Prints out the name, city, owner, and amount for a property.
	 */
	public String toString() 
	{
		String message = "Property Name: " + this.propertyName
				+ "\nLocated in " + this.city
				+ "\nBelonging to: " + this.owner
				+ "\nRent Amount: " + this.rentAmount;
		return message;
	}
}
