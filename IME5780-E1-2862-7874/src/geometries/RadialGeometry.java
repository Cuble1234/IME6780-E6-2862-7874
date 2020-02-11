package geometries;

import primitives.Color;
import primitives.Material;

/**
 * 
 * @author elhanan and yahav represnt a typical geomtry for shapes who needs
 *         radius
 *
 */
public abstract class RadialGeometry extends Geometry {
	protected double radius;

	// ***************** Constructors ********************** //
	/**
	 * Regular constructor
	 * 
	 * @param color   represent the color of the shape
	 * @param matirel represent the matirial of the shape
	 * @param radius  creat new help us to create new radial geomtries
	 */
	public RadialGeometry(Material material, Color emmission, double radius) {
		super(material, emmission);
		this.radius = radius;
	}

	/**
	 * get radius function
	 * 
	 * @return radius of the shape
	 */
	public double getRadius() {
		return radius;
	}
}
