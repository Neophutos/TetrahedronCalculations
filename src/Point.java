/*
 * 
 * class Point: object class for point object
 * 
 */

public class Point {
	
	//------------------------------------------------------------
	// OBJECT ATTRIBUTES
	//------------------------------------------------------------
	/** persistent unique identifier							*/
	String id;
	
	/** x - coordinate of this point 							*/ 		// fuer Java - Dokumentation; jede Koordinate einzeln definiert, da Weltkoordinaten, double, weil Fiesskkommazahlen
	double x;						
	
	/** y - coordinate of this point							*/
	double y;
	
	/** z - coordinate of this point							*/
	double z;
	
	
	
	//------------------------------------------------------------
	// CONSTRUCTOR METHODS
	//------------------------------------------------------------

	
	/***********************************************************
	 * constructor method
	 * @param x global x - coordinate
	 * @param y global y - coordinate
	 * @param z global z - coordinate
	 **********************************************************/
	
	public Point ( double x, double y, double z)	{				// nimm diese Werte und speicher sie in der Variablen darueber -> Zuweisung erstellen
		
		this.x = x;													// this x = oberes x soll Wert fuer unteres x der Methode haben
		this.y = y;
		this.z = z;
						
	}	// eom
	
	/***********************************************************
	 * constructor method
	 * @param id persistent object identifier
	 * @param x global x - coordinate
	 * @param y global y - coordinate
	 * @param z global z - coordinate
	 **********************************************************/
	
	public Point (String id, double x, double y, double z)	{				// nimm diese Werte und speicher sie in der Variablen darueber -> Zuweisung erstellen
		
		this.id = id;
		this.x = x;													// this x = oberes x soll Wert fuer unteres x der Methode haben
		this.y = y;
		this.z = z;
						
	}	// eom
	
	/***********************************************************
	 * constructor method
	 * @param x global x - coordinate
	 * @param y global y - coordinate
	 * @param z global z - coordinate
	 * @param id persistent object identifier
	 **********************************************************/
	
	public Point ( double x, double y, double z, String id)	{				// nimm diese Werte und speicher sie in der Variablen darueber -> Zuweisung erstellen
		
		this.id = "P_"+id;
		this.x = x;													// this x = oberes x soll Wert fuer unteres x der Methode haben
		this.y = y;
		this.z = z;
						
	}	// eom
	
	
	
	//------------------------------------------------------------
	// OBJECT METHODS
	//------------------------------------------------------------
	
	/*************************************************************
	 * method prints all object properties  (=attributes)
	 ************************************************************/
	
	public void Print ()	{										// void, weil nichts berechnet wird, keine �bergabeparameter, da schon davor alles definiert und nichts neues dazu kommt
		
		System.out.println();
		System.out.println("object id : "+this.id);
		System.out.println("x-coordinate = " + this.x);
		System.out.println("y-coordinate = " + this.y);
		System.out.println("z-coordinate = " + this.z);
		System.out.println();
		
	}	// eom
	
	/***********************************************************
	 * method computes the Euclidian distance to a neighboring p
	 * @param p neighboring point
	 * @return distance to point p
	 **********************************************************/

	
	public double distance (Point p)	{
		
		double dx = p.x-this.x;
		double dy = p.y-this.y;
		double dz = p.z-this.z;
		
		return Math.sqrt(dx*dx+dy*dy+dz*dz);		
		
	}	//eom

	public Point add (Point p){
		double ax = p.x+this.x;
		double ay = p.y+this.y;
		double az = p.z+this.z;

		Point point = new Point(ax, ay, az);
		return point;
	}

	public Point multiply(double d){
		double mx = d * this.x;
		double my = d * this.y;
		double mz = d * this.z;

		Point point = new Point(mx, my, mz);
		return point;
	}
	
}	//eoc


