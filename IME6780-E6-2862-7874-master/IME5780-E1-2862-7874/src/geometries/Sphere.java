package geometries;

import java.util.ArrayList;
import java.util.List;

import primitives.*;

/**
 * params
 * 
 * @author elhanan and yahav
 *
 */
public class Sphere extends RadialGeometry {
	private Point3D center;

	// ***************** Constructors ********************** //
	/**
	 * Regular constructor
	 * @param color
	 * @param radius
	 * @param center
	 */
	public Sphere(Material material,Color emmission, double radius, Point3D center) {
		super(material,emmission,radius);
		this.center = center;
	}

	/**
	 *@return center
	 */
	public Point3D getCenter() {
		return center;
	}

	/**
	 * get normal function
	 * 
	 * @param vector
	 * @return normal to the sphere
	 */
	public Vector getNormal(Point3D point) {
		return point.subtract(this.center).normal();
	}

	@Override

	public List<GeoPoint> findIntersections(Ray ray) {
		Point3D p0 = new Point3D(ray.getP0());
		List<GeoPoint> list = new ArrayList<GeoPoint>();

		if (p0.equals(this.getCenter())) {
			list.add(new GeoPoint(this,Point3D.ZERO.add(ray.getDirection().scale(this.radius))));
			return list;
		}
		Vector u = new Vector(this.center.subtract(p0));
		Vector v = new Vector(ray.getDirection());
		double tm = v.dotProduct(u);
		Vector subtrction = new Vector(p0.subtract(center));
		/**
		 * if (subtrction.length2() - (this.getRadius() * this.getRadius()) == 0) {
		 * return null; }
		 **/
		double d = Math.sqrt(u.length2() - tm * tm);
		double th = Math.sqrt((this.getRadius() * this.getRadius()) - d * d);
		double t1 = tm + th;
		double t2 = tm - th;
		if (t1 > 0 || t2 > 0) {
			if (t1==t2) {
				list.add(new GeoPoint(this,p0.add(ray.getDirection().scale(t1))));
				return list;
			}
			if (t1 > 0) {
				list.add(new GeoPoint(this,p0.add(ray.getDirection().scale(t1))));
			}
			if (t2 > 0) {
					list.add(new GeoPoint(this,p0.add(ray.getDirection().scale(t2))));
			}
			return list;
		} else
			return null;
	}
}
