/**
 * Represents management company object
 * This class displays four constructors
 * getMax_Property method implemented
 * implement three addproperty methods
 * implement totalRent method
 * implement maxRentProp method
 * implement maxRentPropIndex method
 * implement displayPropertyIndex method
 * implement toString method
 * @author Surafiel
 */
public class ManagementCompany {
	
	private final int MAX_PROPERTY = 5;
	private double mgmFeePer;
	private String name;
	private Property[] properties;
	private String taxID;
	private final int MGMT_WIDTH = 10;
	private final int MGMT_DEPTH = 10;
	private Plot plot;
	private int round ;
	
	/**
	 * No-Arg Constructor that creates a ManagementCompany object using empty 
	 * strings and a default Plot. "properties" array is initialized here as well
	 */
	public ManagementCompany()
	{
		this.properties = new Property[MAX_PROPERTY];
		this.mgmFeePer = 0;
		this.name = "";
		this.taxID = "";
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		this.round = 0;
	}
	/**
	 * Constructor Creates a ManagementCompany object using the passed information.
	 * Mgmt Co plot is initialized to a default Plot. "properties" array is initialized
	 * here as well.
	 * @param name - management company name
	 * @param taxID - tax id
	 * @param mgmFee - manegemnt fee
	 */
	public ManagementCompany(String name, String taxID, double mgmFee)
	{
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		this.properties = new Property[MAX_PROPERTY];
		
	}
	/**
	 * Constructor Creates a ManagementCompany object using the passed information
	 * "properties" array is initialized here as well.
	 * @param name - manegment company name
	 * @param taxID
	 * @param mgmFee
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 */
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth)
	{
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		this.plot = new Plot (x, y, width, depth);
	}
	/**
	 * Copy Constructors creates a ManagementCompany object using another 
	 * ManagementCompany object. "properties" array is initialized here as well.
	 * @param otherCompany - another management company
	 */
	public ManagementCompany(ManagementCompany otherCompany)
	{
		this.name = otherCompany.name;
		this.taxID = otherCompany.taxID;
		this.mgmFeePer = otherCompany.mgmFeePer;
		this.properties = new Property[MAX_PROPERTY];
	}
	/**
	 * Return the MAX_PROPERTY constant that represent the size of the
	 * "properties" array.
	 * @return the MAX_PROPERTY constant attribute for this class
	 */
	public int getMAX_PROPERTY()
	{
		return MAX_PROPERTY;
	}
	/**
	 * Adds the property object to the "properties" array
	 * @param property - a property object
	 * @return -1 if array is full, 
	 * @return -2 if property is null
	 * @return -3 if the plot is not contained by the MgmtCo plot
	 * @return -4 if the plot overlaps any other property
	 */
	public int addProperty(Property property)
	{
		if(property == null)
			return -2;
		
		if(round >= MAX_PROPERTY)
			return -1;
		
		if(!this.plot.encompasses(property.getPlot()))
			return -3;
		
		if(round > 0 && properties[round] != null)
		{
			for(int n = 0; n < properties.length; n++)
			{
				if(property.getPlot().overlaps(properties[n].getPlot()))
				{
					return -4;
				}
			}
		}
	
	
		
		properties[round] = property;
		round ++;
		return round -1;
	}
	/**
	 * Adds the property object to the "properties" array
	 * @param name - property name 
	 * @param city - location of property
	 * @param rent - monthly rent
	 * @param owner - owner of the property
	 * @return -1 if array is full, 
	 * @return -2 if property is null
	 * @return -3 if the plot is not contained by the MgmtCo plot
	 * @return -4 if the plot overlaps any other property
	 */
	public int addProperty(String name, String city, double rent, String owner)
	{
		int n;
		Property prop;
		prop = new Property(name, city, rent, owner);
		
		
		for(n = 0; n < properties.length; n++)
		{
			if(prop.getPlot().overlaps(properties[n].getPlot()))
				return -4;
		}
			if(round >= MAX_PROPERTY)
				return -1;
			
			if(this.plot.encompasses(prop.getPlot()))
				return -3;
			
			
		
				properties[round] = prop;
				round++;
				return round -1;
	}
	/**
	 * Adds the property object to the "properties" array
	 * @param name - property name 
	 * @param city - location of property
	 * @param rent - monthly rent
	 * @param owner - owner of the property
	 * @param x - x location of upper left corner of property's plot
	 * @param y - y location of upper left corner of property's plot
	 * @param width - width of property's plot
	 * @param depth - depth of the property's plot
	 * @return -1 if array is full, 
	 * @return -2 if property is null
	 * @return -3 if the plot is not contained by the MgmtCo plot
	 * @return -4 if the plot overlaps any other property
	 */
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth)
	{
		int n;
		Property prop;
		prop = new Property(name, city, rent, owner, x, y, width, depth);
		if(round >= 5)
		{
			return -1;
		}
		if(!plot.encompasses(prop.getPlot()))
		{
			return -3;
		}
		for(n = 0; n < round; n++)
		{
			if(prop.getPlot().overlaps(properties[n].getPlot()))
			{
				return -4;
			}
		}
		properties[round] = prop;
		round++;
		return round -1;
	} 
	/**
	 * This method find the property with the maximum rent amount
	 * and returns its toString result. NOTE: For simplicity assume
	 * that each "Property" object's rent amount is different.
	 * @return total rent amount
	 */
	public double totalRent()
	{
		int n;
		double rent = 0.0;
		
		for (n = 0; n < round; n++)
		{
			if(properties[n] != null)
			{
				rent = rent + properties[n].getRentAmount();
			}
		}
		return rent;
	}
	/**
	 * This method finds the property with the maximum rent amount and 
	 * returns its toString result. NOTE: For simplicity assume that each
	 * "Property" object's rent amount is different
	 * @return double, the maximum rent amount
	 */
	public String maxRentProp()
	{
		return properties[maxRentPropertyIndex()].toString();
	}
	/**
	 * This method finds the index of property with the maximum rent amount.
	 * NOTE: For simplicity assume that each "Property" object's rent amount
	 * is different.
	 * @return int, the index of property with the maximum rent amount
	 */
	public  int maxRentPropertyIndex()
	{
		int n;
		int increment = 0;
		for(n = 0; n < round; n++)
		{
			if(properties[n] != null)
			{
				if(properties[increment].getRentAmount() < properties[n].getRentAmount())
				{
					increment = n;
				}
			}
		}
		return increment;
	}
	/**
	 * Displays the information of the property at index i
	 * @param i - The index of the property within the array "properties"
	 * @return infomration of the property at index i
	 */
	public String displayPropertyAtIndex(int i)
	{
		return properties[i].toString();
	}
	/**
	 * Displays the information of all the properties in 
	 * the "properties" array.
	 * @return information of ALL properties within this management 
	 * company by accessing the "Properties" array.
	 */
	public String toString()
	{
		int n;
		String display="";
		for (n = 0; n < round; n++)
		{
			if(properties[n] != null)
			{
				display += ("\nProperty Name: " + properties[n].getPropertyName() + "\n  Located in: " 
						+ properties[n].getCity() + "\n  Belongings to: " + properties[n].getOwner()
						+ "\n  Rent Amount: " + properties[n].getRentAmount());
			}
		}
		
		
		return "List of properties for Alliance, taxID: " + taxID  +"\n______________________________________" + display + "\n______________________________________\n" + "total management Fee: " + mgmFeePer;
	}
	public Plot getPlot() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
