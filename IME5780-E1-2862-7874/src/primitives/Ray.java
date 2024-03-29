package primitives;

/**
 * 
 * @author elhanan and yahav represent ar at the space had a start point and
 *         direction vector
 */
public class Ray {
	private Point3D p0;
	private Vector direction;

	// ***************** Constructors ********************** //
	/**
	 * ray Constructor
	 * 
	 * @param Point3D p0 - start point
	 * @param Vector  direction
	 */
	public Ray(Point3D p0, Vector direction) {
		this.p0 = p0;
		this.direction = direction.normalization();
	}

	/**
	 * Ray Copy Constructor get ray and and put it in another new ray
	 * 
	 * @param ray
	 */
	public Ray(Ray ray) {
		this.p0 = ray.p0;
		this.direction = ray.direction;
	}

	// ***************** Getters/Setters ********************** //
	/**
	 * getter for direction
	 * 
	 * @return Vector of the direction of the ray
	 */
	public Vector getDirection() {
		return direction;
	}

	/**
	 * getter for p0
	 * 
	 * @return Point3D p0 - the start point of the ray
	 */
	public Point3D getP0() {
		return p0;
	}

	// ***************** Administration ******************** //
	/**
	 * to string function
	 * 
	 * @return the start point of the ray and her direction
	 */
	@Override
	public String toString() {
		return this.p0 + "" + this.direction;
	}

	/**
	 * equals function compare between 2 rays
	 * 
	 * @return true or false
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Ray))
			return false;

		Ray other = (Ray) obj;
		return p0.equals(other.p0) && direction.equals(other.direction);
	}

}
