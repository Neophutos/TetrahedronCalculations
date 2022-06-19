
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Vector;

/******************************************************************************
 *
 * class TetMesh represents a Tetrahedral mesh of an arbitrary geometric
 * object stored in an ascii file format.
 *
 * @author mru 05/2022
 *
 ******************************************************************************/

public class TetMesh {


	//-------------------------------------------------------------------------
	// object attributes (define object properties)
	//-------------------------------------------------------------------------

	/** dynamic data-structure - stores all triangles of the mesh             */
	Vector<Tetrahedron> mesh = new Vector<Tetrahedron>();



	//-------------------------------------------------------------------------
	// constructor method(s)
	//-------------------------------------------------------------------------

	/**************************************************************************
	 * constructor method calls methods to compute the total volume and center
	 * of gravity coordinates
	 **************************************************************************/
	public TetMesh() {

		// Lesen der Modell-Daten.............................................
		readModelData("src/model.txt");

		// Aufruf der Volumenberechnung und Ausgabe des Berechnungsergebnisses
		System.out.println("das Gesamtvolumen beträgt: "+volume());

		// Aufruf der Schwerpunktsberechnung und Ausgabe des Ergebnisses......
		Point mp = centerOfGravity();
		System.out.println("x =  "+mp.x);
		System.out.println("y =  "+mp.y);
		System.out.println("z =  "+mp.z);

	} //eom





	//-------------------------------------------------------------------------
	// object methods (define object functionality)
	//-------------------------------------------------------------------------


	/**************************************************************************
	 * method parses an ascii-file format (brute force, poor approach, but running)
	 * @param file filename of the input file
	 **************************************************************************/
	public void readModelData( String file ) {
	
		try {
			FileInputStream   fis = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader    br  = new BufferedReader(isr);
			StreamTokenizer   st  = new StreamTokenizer(br);

			st.slashSlashComments(true);
			st.slashStarComments(true);

			Point[] points;
			st.nextToken();
			int size = (int)st.nval;

			double x,y,z;
			for( int n=0; n<size; n++ ) {
				points = new Point[4];
				for( int j=0; j<4; j++ ) {

					st.nextToken();
					x = st.nval;
					st.nextToken();
					y = st.nval;
					st.nextToken();
					z = st.nval;

					points[j] = new Point(x,y,z);
				}
				mesh.add(new Tetrahedron(points[0],points[1],points[2],points[3]));
			}
		}
		catch( IOException e ) { e.printStackTrace(); }
	} //eom

	/**************************************************************************
	 * @return the total volume of this geometry
	 **************************************************************************/
	public double volume() {

		double fullvolume = 0;

		for(int i = 0; i<mesh.size();i++) {
			fullvolume = fullvolume + mesh.get(i).volume();
		}

		return fullvolume;
	} //eom

	/**************************************************************************
	 * @return center of gravity point
	 **************************************************************************/
	public Point centerOfGravity() {

		double kx = 0;
		double ky = 0;
		double kz = 0;

		for(int i = 0; i<mesh.size();i++) {
			Point center = mesh.get(i).center();
			double volume = mesh.get(i).volume();

			kx = kx + (center.x * volume);
			ky = ky + (center.y * volume);
			kz = kz + (center.z * volume);
		}

		double sx = kx / this.volume();
		double sy = ky / this.volume();
		double sz = kz / this.volume();

		Point centerOfGravity = new Point(sx, sy, sz);

		return centerOfGravity;
	} //eom


	//-------------------------------------------------------------------------
	// main method (for testing purposes)
	//-------------------------------------------------------------------------

	/**************************************************************************
	 * main-method
	 * @param args
	 **************************************************************************/
	public static void main( String[] args ) {

		new TetMesh();

	} //eom

} //eoc
