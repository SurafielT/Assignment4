/**
 * Displays the information of all the properties in the "properties" array.
 * implement setX method
 * implement getX method
 * implement setY method
 * implement getY method
 * implement setWidth method
 * implement getWidth method
 * implement setDepth method
 * implement getDepth method
 * implement overlap method
 * implement encompasses method
 * @author Surafiel
 */
public class Plot {
	
	private int x;
	private int y;
	private int width;
	private int depth;
	/**
	 * No-arg Constructor, creates a default Plot with
	 * args x=0, y=0, width=1, depth=1
	 */
	public Plot()
	{
		this.x = 0;
		this.y = 0;
		this.width = 1;
		this.depth = 1;
	}
	/**
	 * Copy Constructor, creates a new object using the 
	 * information of the object passed to it.
	 * @param p
	 */
	public Plot(Plot p)
	{
		this.x = p.x;
		
		this.y = p.y;
		
		this.width = p.width;
		
		this.depth = p.depth;
	}
	/**
	 * Parameterized constructor
	 * @param x - set to x field
	 * @param y - set to y in field
	 * @param width - set to width in field
	 * @param depth - set to depth in field
	 */
	public Plot(int x, int y, int width, int depth)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	/**
	 * Sets the x value
	 * @param x - Sets the x value for the x field
	 */
	public void setX(int x)
	{
		this.x = x;
	}
	/**
	 * Sets the y value
	 * @param y - Sets the y value for the y field
	 */
	public void setY(int y)
	{
		this.y = y;
	}
	/**
	 * Sets the width value
	 * @param width - Sets the width value for the width field
	 */
	public void setWidth(int width)
	{
		this.width = width;
	}
	/**
	 * Sets the depth value
	 * @param depth - Sets the depth value for the depth field
	 */
	public void setDepth(int depth)
	{
		this.depth = depth;
	}
	/**
	 * Returns the x value
	 * @return int, x is returned
	 */
	public int getX()
	{
		return x;
	}
	/**
	 * Returns the y value
	 * @return int, y is returned
	 */
	public int getY()
	{
		return y;
	}
	/**
	 * Returns the width value
	 * @return int, width is returned
	 */
	public int getWidth()
	{
		return width;
	}
	/**
	 * Returns the depth value
	 * @return int, depth is returned
	 */
	public int getDepth()
	{
		return depth;
	}
	/**
	 * Prints the X,Y of the upper left corner, the width and depth.
	 */
	public String toString()
	{
		String display = "Upper left: (" + this.x + ","+ this.y +"); Width: " + this.width + " Depth: " + this.depth;
		return display;
	}
	/**
	 * Determines if this plot overlaps the parameter, returns true if 
	 * the two plots overlap, false otherwise
	 * @param p - creates an instance
	 * @return overlapping
	 */
	public boolean overlaps(Plot p)
	{
		boolean overlapping = true;
		if(p.x >= (x + width) || (p.x + p.width) <=x)
		{
			overlapping = false;
		}
		if(p.y >= (y + depth) || (p.y + p.depth)<= y)
		{
			overlapping = false;
		}
			return overlapping;
	}
	/**
	 * Takes a Plot instance and determines if the current plot contains it.
	 * @param p - creates an instance
	 * @return encompasses
	 */
	public boolean encompasses(Plot p)
	{
		boolean X = false;
		boolean Y = false;
		boolean Width = false;
		boolean Depth = false;
		
		if(p.x >= x)
		{
		 X = true;
		}
		if(p.y >= y)
		{
			Y = true;
		}
		if(p.x + p.width <= x + width)
		{
			Width = true;
		}
		if(p.y + p.depth <= y + depth)
		{
			Depth = true;
		}
		return X && Y && Width && Depth;
	}

}
