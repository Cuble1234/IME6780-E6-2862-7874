package primitives;

public class Vector {
	private Point3D head;

	// ***************** Constructors ********************** //
	/**
	 * Constructs a Vector by its head
	 * 
	 * @param head of the vector
	 */
	public Vector(Point3D head) {
		if (head.equals(Point3D.ZERO)) {
			throw new IllegalArgumentException("Vector zero is illegal");
		}
		this.head = head;
	}

	/**
	 * Constructs a Vector by coordinates of its head
	 * 
	 * @param x coordinate value
	 * @param y coordinate value
	 * @param z coordinate value
	 */
	public Vector(double x, double y, double z) {
		this.head = new Point3D(new Coordinate(x), new Coordinate(y), new Coordinate(z));
		if (head.equals(Point3D.ZERO)) {
			throw new IllegalArgumentException("Vector zero is illegal");
		}
	}

	/**
	 * Copy constructor
	 * 
	 * @param vector
	 */
	public Vector(Vector vector) {
		this.head = vector.head;
	}

	// ***************** Getters/Setters ********************** //
	/**
	 * Vector head point getter
	 * 
	 * @return the head point
	 */
	public Point3D getHead() {
		return head;
	}

	// ***************** Administration ******************** //
	@Override
	public String toString() {
		return head.toString();

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Vector))
			return false;

		Vector other = (Vector) obj;
		return head.equals(other.head);
	}

	// ***************** Operations ******************** //
	/**
	 * Adding the vector with other vector
	 * 
	 * @param other vector
	 * @return Vector
	 */
	public Vector add(Vector other) {
		double x1 = this.head.getX().get();
		double y1 = this.head.getY().get();
		double z1 = this.head.getZ().get();

		double x2 = other.head.getX().get();
		double y2 = other.head.getY().get();
		double z2 = other.head.getZ().get();

		return new Vector(x1 + x2, y1 + y2, z1 + z2);
	}

	/**
	 * Subtraction the vector with other vector
	 * 
	 * @param other vector
	 * @return Vector
	 */
	public Vector subtract(Vector other) {
		double x1 = this.head.getX().get();
		double y1 = this.head.getY().get();
		double z1 = this.head.getZ().get();

		double x2 = other.head.getX().get();
		double y2 = other.head.getY().get();
		double z2 = other.head.getZ().get();

		return new Vector(x1 - x2, y1 - y2, z1 - z2);
	}

	/**
	 * Scalar multiplication
	 * 
	 *scale the vector with other number
	 * @param num
	 * @return Vector
	 */
	public Vector scale(double num) {
		double x = this.head.getX().get();
		double y = this.head.getY().get();
		double z = this.head.getZ().get();
		return new Vector(x * num, y * num, z * num);
	}

	/**
	 * Calculate dot product between the vector and other vector
	 * 
	 * @param other 2nd vector
	 * @return dot product result
	 */

	public double dotProduct(Vector other) {
		double x1 = this.head.getX().get();
		double y1 = this.head.getY().get();
		double z1 = this.head.getZ().get();

		double x2 = other.head.getX().get();
		double y2 = other.head.getY().get();
		double z2 = other.head.getZ().get();

		return x1 * x2 + y1 * y2 + z1 * z2;
	}

	/**
	 * Calculate cross product between the vector and other vector
	 * 
	 * @param other
	 * @return Vector
	 */

	public Vector crossProduct(Vector other) {
		double x1 = this.head.getX().get();
		double y1 = this.head.getY().get();
		double z1 = this.head.getZ().get();

		double x2 = other.head.getX().get();
		double y2 = other.head.getY().get();
		double z2 = other.head.getZ().get();
//s1=y1 * z2 - y2 * z1 s2=z1 * x2 - z2 * x1 s3=x1 * y2 - x2 * y1
		return new Vector(y1 * z2 - y2 * z1, z1 * x2 - z2 * x1, x1 * y2 - x2 * y1);
	}

	/**
	 * Calculate length of the vector
	 * 
	 * @return double
	 */

	public double length2() {
		double x = this.head.getX().get();
		double y = this.head.getY().get();
		double z = this.head.getZ().get();
//(X^2+Y^2+Z^2)
		return x * x + y * y + z * z;
	}

	/**
	 * Calculate root of the length of the vector
	 * 
	 * @return double
	 */
	public double length() {
		//root of(X^2+Y^2+Z^2)
		return Math.sqrt(length2());
	}

	/**
	 * Normal the vector vector / length Change the vector
	 */

	public Vector normal() {
		double l = length();
		double x = this.head.getX().get();
		double y = this.head.getY().get();
		double z = this.head.getZ().get();
		this.head = new Point3D(x / l, y / l, z / l);
		return this;
	}

	/**
	 * Normal the vector vector / length return new vector
	 * 
	 * @return Vector
	 */
	public Vector normalization() {
		return new Vector(this).normal();
	}

}
