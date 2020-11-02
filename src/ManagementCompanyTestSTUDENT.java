import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ManagementCompanyTestSTUDENT {
	Property p1 ,p2,p3,p4,p5,p6;
	ManagementCompany m ;
	@Before
	public void setUp() throws Exception {
		p1 = new Property ("Tesla", "Rockville", 3212.00, "Jack Box",2,1,2,2);
		p2 = new Property ("Hospital", "Takoma", 5213, "Surafiel Tesfahun",4,1,2,2);
		p3 = new Property ("Gym", "BVille", 1231, "John Smith",6,1,2,2);
		m= new ManagementCompany("Railey", "555555555",6);
		m.addProperty(p1);
		m.addProperty(p2);
		m.addProperty(p3);
		
	}

	@After
	public void tearDown() {
		p1=p2=p3=p4=p5=p6=null;
		m=null; 
	}

	@Test
	public void testAddPropertyDefaultPlot() {
		p4 = new Property ("Inpserational", "Silver Spring", 25213, "John Willson",2,5,2,2);
		p5 = new Property ("Cavern", "Springbreak", 1231, "Turner Hills",4,5,2,2);
		p6 = new Property ("Caverns", "Plaza", 5213, "Desmona Hart",6,5,2,2);
		 
		assertEquals(m.addProperty(p4),3,0);
		assertEquals(m.addProperty(p5),4,0);
		assertEquals(m.addProperty(p6),-1,0);	
	}
 
	@Test
	public void testMaxRentProp() {
		String maxRentString = m.maxRentProp().split("\n")[3];
		assertTrue(maxRentString.contains("5213"));
		
	}

	@Test
	public void testTotalRent() {
		assertEquals(m.totalRent(),9656.0,0);
	}

 }