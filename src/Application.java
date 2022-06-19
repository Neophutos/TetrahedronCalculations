import java.awt.*;
import java.util.Vector;

/******************************************************************************
 * 
 * class Application: test class for mesh objects
 * 
 ******************************************************************************/

public class Application {
	
	/**************************************************************************
	 * 
	 **************************************************************************/
	public Application() {}

	/**************************************************************************
	 * main method = entry point for the program 'mesh'
	 * @param args
	 **************************************************************************/
	public static void main( String[] args ) {
		
		
		//---------------------------------------------------------------------
		// example: construction of 40 point objects, storage in an array
		//---------------------------------------------------------------------
		
		// definition of an array for 40 Point objects.........................		
		Vector<Point> points = new Vector<Point>();

		
		// construction of 40 Point objects with random coordinates and id.....
		for( int i=0; i<40; i++ ) {
			
			String id = "point_"+i;       // create id "point_0", "point_1",...
			double x  = Math.random()*30.;      // create a random value for x.
			double y  = (1.-2*Math.random())*20.;// create a random value for y
			double z  = Math.random()*10.;      // create a random value for z.
			
			points.add(new Point(id,x,y,z));    // use values to create a point
                                                // object .....................												
		}
		
		
//		for( int i=0; i<10; i++ ) {
//			points.remove(i);
//		}
//		System.out.println("(3) Anzahl Objekte = "+points.size());

		
//		//---------------------------------------------------------------------
//		// example: construction of 4 point objects, storage in different 
//		//          variables
//		//---------------------------------------------------------------------
//		
//		Point a = new Point("point A",3.5, 4.1, -9.3);
//		Point b = new Point("point B",33.5, 4.3, -2.3);
//		Point c = new Point(34.3, 8.4, -0.3,"otto");
//		Point d = new Point(64.3, 8.4, -0.3);
//		
//		
//		//---------------------------------------------------------------------
//		// example: construction of triangle objects, defined using any three
//		//          point objects
//		//---------------------------------------------------------------------
//		
//		Triangle tri1 = new Triangle("my test triangle",b, a, d);
//		double cf = tri1.circumference();
//		System.out.println(	"Umfang des Dreiecks 1 = "+cf);
//		System.out.println(	"Fl�che des Dreiecks 1 = "+tri1.area()+"\n");
//		
//		Triangle tri2 = new Triangle("my test triangle",b, c, d);
//		System.out.println(	"Umfang des Dreiecks 2 = "+tri2.circumference());
//		System.out.println(	"Fl�che des Dreiecks 2 = "+tri2.area()+"\n");
//		
		
		//---------------------------------------------------------------------
		// implement here a loop over the 40 point object which sums up the 
		// polygonal length defined by the points.
		// I   define & initialize a variable 'totalPolyLength' which is used
		//     to sum up the distances between the polygon points
		// II  define a for()-loop over all point objects. Add in each loop
		//     step the length between point i and point (i+1) 
		// III print the total length of the polygon to the console.
		//---------------------------------------------------------------------
//		double totalPolyLength = 0.;
//		for( int i=0; i<(points.length-1); i++ ) {
//			
//			totalPolyLength = totalPolyLength + points[i].distance(points[i+1]);
//		}
//		System.out.println("Gesamtl�nge Polygon = "+totalPolyLength);
		
		Application app = new Application();
		double tpl = app.polyLength(points);
		System.out.println("Gesamtl�nge Polygon = "+tpl);
//		
	
	} //eom
	
	
	
	/**************************************************************************
	 * @param p array of point objects
	 * @return total polygon length for this point set
	 **************************************************************************/
	public double polyLength( Vector<Point> p ) {
		
		double totalPolyLength = 0.;
		for( int i=0; i<(p.size()-1); i++ ) {
						
			totalPolyLength = totalPolyLength + (p.elementAt(i)).distance(p.elementAt(i+1));
		}
		return totalPolyLength;
	} //eom
	
	/**************************************************************************
	 * @param p array of point objects
	 * @return total polygon length for this point set
	 **************************************************************************/
	public double polyLength( Point[] p ) {
		
		double totalPolyLength = 0.;
		for( int i=0; i<(p.length-1); i++ ) {
			
			totalPolyLength = totalPolyLength + p[i].distance(p[i+1]);
		}
		return totalPolyLength;
	} //eom
	
	//---------------------------------------------------------------------
	// example: construction of triangle objects, defined using any three
	//          point objects
	//---------------------------------------------------------------------
	
	Point a = new Point(3.5, 4.1, -9.3);
	Point b = new Point(33.5, 4.3, -2.3);
	Point c = new Point(34.3, 8.4, -0.3);
	Point d = new Point(64.3, 8.4, -0.3);
	
	
	Tetrahedron ter1 = new Tetrahedron(b, d, a, c);
	double vl = ter1.volume();

	
//	Triangle tri2 = new Triangle("my test triangle",b, c, d);
//	System.out.println(	"Umfang des Dreiecks 2 = "+tri2.circumference());
//	System.out.println(	"Fl�che des Dreiecks 2 = "+tri2.area()+"\n");
	
	
} //eoc
