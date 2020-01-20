package geometries;

import static primitives.Util.isZero;

import primitives.*;

public class Cylinder extends Tube {
	private double height;

/**
 * @param
 * **/
	/**
	 *Regular constructor
 * @param radius
 * @param axisRay
 * @param height
 */
	public Cylinder(Color emmission,double radius, Ray axisRay, double height) {
		super(emmission,radius, axisRay);
		this.height = height;
	}

/**
 * copy constructor
 * @param cylinder
 */
	public Cylinder(Cylinder cylinder) {
		super(cylinder.emmission,cylinder.radius, cylinder.axisRay);
		this.height = cylinder.height;
	}

	/**
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}

/**
 * get normal function
 * @param Point3D
 *  @return null
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