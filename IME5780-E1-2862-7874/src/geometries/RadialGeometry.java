package geometries;

import primitives.Color;

public abstract class RadialGeometry extends Geometry {
	protected double radius;

	// ***************** Constructors ********************** //
	/**
	 * Regular constructor
	 * 
	 * @param radius
	 */
	public RadialGeometry(Color emmission,double radius) {
		super(emmission);
		this.radius = radius;
	}

	/**
	 * get radius function
	 * 
	 * @return radius
	 */
	public double getRadius() {
		return radius;
	}
}
