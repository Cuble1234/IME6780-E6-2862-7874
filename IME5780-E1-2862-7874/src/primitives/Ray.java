package primitives;

/**
 * Ray Class
 */
public class Ray {
	private Point3D p0;
	private Vector direction;

	// ***************** Constructors ********************** //
	/**
	 * Constructor with
	 * 
	 * @param p0
	 * @param direction
	 */
	public Ray(Point3D p0, Vector direction) {
		this.p0 = p0;
		this.direction = direction.normalization();
	}

	/**
	 * Copy Constructor
	 * 
	 * @param ray
	 */
	public Ray(Ray ray) {
		this.p0 = ray.p0;
		this.direction = ray.direction;
	}

	// ***************** Getters/Setters ********************** //
	/**
	 * @return the direction
	 */
	public Vector getDirection() {
		return direction;
	}

	/**
	 * @return the p0
	 */
	public Point3D getP0() {
		return p0;
	}

	// ***************** Administration ******************** //
	@Override
	public String toString() {
		return (this.p0.toString() + " direct to:" + this.direction.toString());
	}

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
