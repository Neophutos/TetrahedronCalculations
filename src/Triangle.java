import java.awt.*;

/********************************************************************************
 * 
 * class Triangle: object class for triangle objects
 * 
 * @author Not your average Ben
 *
 ********************************************************************************/
public class Triangle {
	
	//------------------------------------------------------------
	// OBJECT ATTRIBUTES
	//------------------------------------------------------------
	
	/** first corner point of this triangle				*/
	public Point p1;
	
	/** second corner point of this triangle			*/
	public Point p2;
	
	/** third corner point of this triangle				*/
	public Point p3;
	
	/** persistent unique identifier					*/
	String id;											// String = grossgeschrieben = refferenzierter Datentyp, String = persistent (anhaltend/ dauernd - ueber einen langen Zeitraum speichern)
	
	
	
	//------------------------------------------------------------
	// CONSTRUCTOR METHODS
	//------------------------------------------------------------
	
	/***********************************************************
	 * constructor method
	 * @param p1 first corner point of this triangle
	 * @param p2 second corner point of this triangle
	 * @param p3 third corner point of this triangle
	 **********************************************************/
	
	public Triangle( Point p1, Point p2, Point p3 )	{
	
		this.p1 = p1;		
		this.p2 = p2;
		this.p3 = p3;
						
	}	//eom
		
	/***********************************************************
	 * constructor method
	 * @param id persistent unique identifier
	 * @param p1 first corner point of this triangle
	 * @param p2 second corner point of this triangle
	 * @param p3 third corner point of this triangle
	 **********************************************************/
	
	public Triangle( String id, Point p1, Point p2, Point p3 )	{
		
		System.out.println("x-coordinate of p1 = "+p1.x);
		this.id = id;
		this.p1 = p1;		
		this.p2 = p2;
		this.p3 = p3;
						
	}	//eom
	
	
	
	//------------------------------------------------------------
	// OBJECT METHODS
	//------------------------------------------------------------

	/*************************************************************
	 * @return area of this straight-sided triangle
	 *************************************************************/
	
	public double area ()	{
		
		double[] c = areaVector();
		
		return Math.sqrt(c[0]*c[0]+c[1]*c[1]+c[2]*c[2])/2.;
		
		
	//	double ax = p2.x - p1.x;					double bx = p3.x - p1.x;
	//	double ay = p2.y - p1.y;					double by = p3.y - p1.y;
	//	double az = p2.z - p1.z;					double bz = p3.z - p1.z;
		
	//	double cx = ay*bz - az*by;
	//	double cy = az*bx - bz*ay;
	//	double cz = ax*by - bx*ay;
		
		
		
	//	return 0.5*Math.sqrt((ay*bz-az*by)*(ay*bz-az*by)+(az*bx-ax*bz)*(az*bx-ax*bz)+(ax*by-ay*bx)*(ax*by-ay*bx));
		
			
	//	return (Math.sqrt (cx*cx+cy*cy+cz*cz)/2.);
		
		
	}	// eom
	
	/*************************************************************
	 * @return circumference of this straight-sided triangle
	*************************************************************/
	
	public double circumference() {
		
		return p1.distance(p2)+p2.distance(p3)+p3.distance(p1);
		
	}	//eom
	
	/***********************************************************
	 * method prints the object properties (=attributes)
	 **********************************************************/
	
	public void Print ()	{

		System.out.println();
		System.out.println("\n------------- objects id : "+this.id+" ------------------");
		System.out.println(p1.toString());
		this.p2.Print();
		this.p3.Print();
		System.out.println();

	}	// eom

	/**************************************************************************
	 * @return area vector of this triangle
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
	
	/*
	
	public double getFlaecheninhalt() {
		double flaeche = (p1.distance(p2)*p1.distance(p3))/2;
	
		return flaeche;
		
	}	//eom
	
	public void printProperties()	{
		
		System.out.println("ID: " + id);
		System.out.println("----------------------------------------");
		System.out.println("Punkt p1: ");
		p1.Print();
		System.out.println();
		System.out.println("Punkt p2: ");
		p2.Print();
		System.out.println();
		System.out.println("Punkt p3: ");
		p3.Print();
		System.out.println();
		System.out.println("----------------------------------------");
		System.out.println("Laenge der Seite a: " + p1.distance(p2));
		System.out.println("Laenge der Seite b: " + p1.distance(p3));
		System.out.println("Laenge der Seite c: " + p2.distance(p3));
		System.out.println("----------------------------------------");
		System.out.println("Umfang: " + circumference());
		System.out.println("Flaecheninhalt: " + getFlaecheninhalt());
		
	}	//eom
	
	*/

}	//eoc
