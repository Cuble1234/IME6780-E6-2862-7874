package geometries;

import java.util.List;
import static primitives.Util.*;

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
	 * 
	 * @param color
	 * @param radius
	 * @param center
	 */
	public Sphere(Material material, Color emmission, double radius, Point3D center) {
		super(material, emmission, radius);
		this.center = center;
	}

	/**
	 * @return center
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
		Point3D p0 = ray.getP0();
		Vector v = ray.getDirection();

		Vector u = null;
		try {
			u = this.center.subtract(p0);
		} catch (Exception e) {
			return List.of(new GeoPoint(this, this.center.add(v.scale(this.radius))));
		}

		double tm = v.dotProduct(u);
		double d2 = u.length2() - tm * tm;
		double th2 = this.radius * this.radius - d2;
		if (th2 < 0) return null;
		double th = alignZero(Math.sqrt(th2));
		if (th == 0) return null;
		
		double t1 = alignZero(tm + th);
		double t2 = alignZero(tm - th);
		if (t1 <= 0 && t2 <= 0) return null;

		if (t1 > 0 && t2 > 0)
			return List.of(new GeoPoint(this, p0.add(v.scale(t1))), new GeoPoint(this, p0.add(v.scale(t2))));
		if (t1 > 0)
			return List.of(new GeoPoint(this, p0.add(v.scale(t1))));
		else // t2 > 0
			return List.of(new GeoPoint(this, p0.add(v.scale(t2))));
	}
}
