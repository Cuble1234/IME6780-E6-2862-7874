package geometries;

import static primitives.Util.isZero;

import primitives.*;

/**
 * 
 * @author elhanan and yahav represent the radial geometry cylinder by center
 *         ray ,radius and height legateefrom tube the the ray and the radius
 */
public class Cylinder extends Tube {
	private double height;

	/**
	 * Regular constructor get the params:
	 * 
	 * @param radius
	 * @param axisRay
	 * @param height  and make a new cylinder wuth them
	 */
	public Cylinder(Material material, Color emmission, double radius, Ray axisRay, double height) {
		super(material, emmission, radius, axisRay);
		this.height = height;
	}

	/**
	 * getHiget function
	 * 
	 * @return the height of the cylinder
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * get normal function
	 * 
	 * @param Point3D
	 * @return normal to cylinder
	 */
	@Override
	public Vector getNormal(Point3D p) {
		Point3D p0 = axisRay.getP0();
		Vector v = axisRay.getDirection();
		Vector u = p.subtract(p0); // vector from p0 to p
		double t = v.dotProduct(u); // size of projection of vector u on the ray
		// point on the ray and plane crossing P and orthogonal to the ray
		if (isZero(t) || isZero(t - this.height))
			return v;
		return p.subtract(p0.add(v.scale(t))).normal();
	}
}