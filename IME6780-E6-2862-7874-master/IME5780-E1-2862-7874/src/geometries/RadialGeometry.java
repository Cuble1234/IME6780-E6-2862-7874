package geometries;

import primitives.Color;
import primitives.Material;

public abstract class RadialGeometry extends Geometry {
	protected double radius;

	// ***************** Constructors ********************** //
	/**
	 * Regular constructor
	 * 
	 * @param radius
	 */
	public RadialGeometry(Material material,Color emmission,double radius) {
		super(material,emmission);
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
