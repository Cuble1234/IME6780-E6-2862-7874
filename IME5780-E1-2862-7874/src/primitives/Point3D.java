package primitives;

/**
 * 
 * @author elhanan and yahav represent a 3 d point at the space
 */
public class Point3D {
	private Coordinate x;
	private Coordinate y;
	private Coordinate z;

	public static Point3D ZERO = new Point3D(0, 0, 0);

	// ***************** Constructors ********************** //

	/**
	 * Point3D parameters constructor.<br>
	 * 
	 * @param x represent coordinate x at the point
	 * @param y represent coordinate y at the point
	 * @param z represent coordinate z at the point
	 */

	public Point3D(double x, double y, double z) {
		this.x = new Coordinate(x);
		this.y = new Coordinate(y);
		this.z = new Coordinate(z);
	}

	/**
	 * Point3D copy constructor constructor copy the point to new other point
	 * 
	 * @param the real point
	 */
	public Point3D(Point3D point) {
		this.x = point.x;
		this.y = point.y;
		this.z = point.z;
	}

	// ***************** Getters/Setters ********************** //
	/**
	 * getter for x coordinate
	 * 
	 * @return the x
	 */

	public Coordinate getX() {
		return x;
	}

	/**
	 * getter for y coordinate
	 * 
	 * @return the y
	 */
	public Coordinate getY() {
		return y;
	}

	/**
	 * getter for z coordinate
	 * 
	 * @return the z
	 */
	public Coordinate getZ() {
		return z;
	}

	// ***************** Administration ******************** //
	/**
	 * to string function
	 * 
	 * @return the coordinates of the point
	 */
	@Override
	public String toString() {
		return "(" + x + "," + y + "," + z + ")";
	}

	/**
	 * equals function compare between 2 point and
	 * 
	 * @return true or false
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Point3D))
			return false;

		Point3D other = (Point3D) obj;
		return x.equals(other.x) && y.equals(other.y) && z.equals(other.z);
	}
	// ***************** Operations ******************** //

	/**
	 * Subtract function calculate the subtract between the vector and other vector
	 * 
	 * @param other
	 * @return Vector between both of the point
	 */
	public Vector subtract(Point3D other) {
		double x1 = this.x.get();
		double y1 = this.y.get();
		double z1 = this.z.get();
		double x2 = other.x.get();
		double y2 = other.y.get();
		double z2 = other.z.get();
		return new Vector(x1 - x2, y1 - y2, z1 - z2);
	}

	/**
	 * Adding function adding point to other point
	 * 
	 * @param a
	 * @return Point3D
	 */
	public Point3D add(Vector other) {
		double x1 = this.x.get();
		double y1 = this.y.get();
		double z1 = this.z.get();
		double x2 = other.getHead().getX().get();
		double y2 = other.getHead().getY().get();
		double z2 = other.getHead().getZ().get();
		return new Point3D(x1 + x2, y1 + y2, z1 + z2);
	}

	/**
	 * Calculate the distance between 2 points at square
	 * 
	 * @param a Point3D parameter
	 * @return double
	 */

	public double distance2(Point3D other) {
		double x1 = this.x.get();
		double y1 = this.y.get();
		double z1 = this.z.get();
		double x2 = other.x.get();
		double y2 = other.y.get();
		double z2 = other.z.get();
//((x2-x1)^2+(y2-y1)^2+(z2-z1)^2)
		return (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1) + (z2 - z1) * (z2 - z1);
	}

	/**
	 * Calculate the distance between 2 points
	 * 
	 * @param other point
	 * @return double a distance between both of the points
	 */

	public double distance(Point3D other) {
		// root of ((x2-x1)^2+(y2-y1)^2+(z2-z1)^2)
		return Math.sqrt(this.distance2(other));
	}

}
