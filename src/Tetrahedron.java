import java.awt.*;

/************************************************************************
 * 
 * class Tetrahedron
 * 
 ************************************************************************/
public class Tetrahedron {
	
	//------------------------------------------------------------
	// OBJECT ATTRIBUTES
	//------------------------------------------------------------
	
	/** first corner point of this tetrahedron			*/
	public Point p1;
	
	/** second corner point of this tetrahedron			*/
	public Point p2;
	
	/** third corner point of this tetrahedron			*/
	public Point p3;
	
	/** fourth corner point of this tetrahedron			*/
	public Point p4;

	/** persistent unique identifier					*/
	String id;
	

	//------------------------------------------------------------
	// CONSTRUCTOR METHODS
	//------------------------------------------------------------
	
	/******************************************************************
	 * @param p1 first corner point of this tetrahedron
	 * @param p2 second corner point of this tetrahedron
	 * @param p3 third corner point of this tetrahedron
	 * @param p4 fourth corner point of this tetrahedron 
	 ******************************************************************/
	
	public Tetrahedron(Point p1, Point p2, Point p3, Point p4)	{
		
		this.p1 = p1;		
		this.p2 = p2;
		this.p3 = p3;
		this.p4 = p4;
		
	}	//eom

	
	//------------------------------------------------------------
	// OBJECT METHODS
	//------------------------------------------------------------
	
	/*************************************************************
	 * method prints the objects properties (= attributes)
	 * print to the console
	 *************************************************************/
	
	public void print()	{							// properties of this project
		
		System.out.println();
		System.out.println("\n------------- objects id : "+this.id+" ------------------");
		this.p1.Print();
		this.p2.Print();
		this.p3.Print();
		this.p4.Print();
		System.out.println();
		
	}	//eom
	
	/**************************************************************************
	 * @return area vector of this tetrahedron
	 **************************************************************************/
	
	public double [] areaVector ()	{
		
		double ax = p2.x - p1.x;					double bx = p3.x - p1.x;
		double ay = p2.y - p1.y;					double by = p3.y - p1.y;
		double az = p2.z - p1.z;					double bz = p3.z - p1.z;
		
		double [] c = new double [3];
		
		c[0] = ay*bz - az*by;
		c[1] = az*bx - bz*ay;
		c[2] = ax*by - bx*ay;
		
		return c;
		
	}	//eom
	
	/*************************************************************
	 * @return volume of this tetrahedron
	 *************************************************************/
	
	public double volume()	{											// volume of the tetrahedron
		
		double volume;
		
		double dx = p4.x-p1.x;
		double dy = p4.y-p1.y;
		double dz = p4.z-p1.z;
		
		double [] av = areaVector();
		
		volume = Math.abs((dx*av[0])+(dy*av[1])+(dz*av[2])/6.); 
		
		return volume;
		
	}	//eom
	
	/*************************************************************
	 * @return center coordinates of this tetrahedron
	 *************************************************************/

	public Point center(){

		Point sum;
		Point center;

		sum = p1.add(p2).add(p3).add(p4);
		center = sum.multiply(0.25);

		return center;
	}
}
