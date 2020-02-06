package geometries;

import java.util.List;

import primitives.*;

public class Triangle extends Polygon {
	// ***************** Constructors ********************** //
	/**
	 * Regular constructor
	 * 
	 * @param points
	 * @param plane
	 */
	public Triangle(Material material,Color emmission,Point3D a, Point3D b, Point3D c) {
		super(material,emmission,a, b, c);
	}

	/**
	 * get normal function
	 * 
	 * @param Point3D
	 * @return normal
	 */

	public Vector getNormal(Point3D point) {
		// Plane's normal does not depend on the point - we can save passing the
		// parameter
		// thus calling plane's regular getter of normal
		return this.plane.getNormal();
	}
/**
 *get ray and return list of the intersections between the ray and the triangle
 */
	@Override
	public List<GeoPoint> findIntersections(Ray ray) {
		List<GeoPoint> list = this.plane.findIntersections(ray);
		if (list==null)
			return null;
		Point3D p0 = new Point3D(ray.getP0());
		Vector v1 = new Vector(this.points.get(0).subtract(p0));
		Vector v2 = new Vector(this.points.get(1).subtract(p0));
		Vector v3 = new Vector(this.points.get(2).subtract(p0));
		Vector n1 = new Vector(v1.crossProduct(v2).normal());
		Vector n2 = new Vector(v2.crossProduct(v3).normal());
		Vector n3 = new Vector(v3.crossProduct(v1).normal());
		double test1 =  list.get(0).point.subtract(p0).dotProduct(n1);
		double test2 =  list.get(0).point.subtract(p0).dotProduct(n2);
		double test3 =  list.get(0).point.subtract(p0).dotProduct(n3);
		if(Util.isZero(test1)||Util.isZero(test2)||Util.isZero(test3))
			return null;
		if(test1>0&&test2>0&&test3>0||test1<0&&test2<0&&test3<0) {
			list.get(0).geometry = this;
			return list;
		}
			
		else
			return null;
	}
}
