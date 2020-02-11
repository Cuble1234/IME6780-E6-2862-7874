package geometries;

import java.util.List;

import primitives.*;

/**
 * 
 * @author elhanan and yahav represent a plane at the space
 */
public class Plane extends Geometry {
	private Point3D p;// start point
	private Vector normal;// normal for the whole plane

	// ***************** Constructors ********************** //
	/**
	 * plane constructor
	 * 
	 * @param p       start point
	 * @param normal  for the plane
	 * @param matirel of the plane
	 * @param color   of the plane create a new plane
	 */
	public Plane(Material material, Color emmission, Point3D p, Vector normal) {
		super(material, emmission);
		this.p = new Point3D(p);
		this.normal = new Vector(normal.normalization());
	}

	/**
	 * plane constructor
	 * 
	 * @param p1,p2,p3 3 point
	 * @param matirel  of the plane
	 * @param color    of the plane create a new plane from the points
	 */
	public Plane(Material material, Color emmission, Point3D p1, Point3D p2, Point3D p3) {
		super(material, emmission);
		this.p = new Point3D(p1);
		this.normal = p1.subtract(p2).crossProduct(p1.subtract(p3)).normal();
	}

	/**
	 * get p function
	 * 
	 * @return the p start point of the plane
	 */
	public Point3D getP() {
		return p;
	}

	/**
	 * get normal function
	 * 
	 * @return the normal for the whole plane
	 */
	public Vector getNormal() {
		return normal;
	}

	/**
	 * get normal function
	 * 
	 * @param Point3D
	 * @return the normal for the whole plane
	 */

	public Vector getNormal(Point3D point) {
		return normal;
	}

	/**
	 * get ray and return list of the intersections between the ray and the plane
	 */
	@Override
	public List<GeoPoint> findIntersections(Ray ray) {
		Vector v = ray.getDirection();
		double vn = Util.alignZero(v.dotProduct(this.normal));
		if (vn == 0)
			return null;

		Point3D p0 = ray.getP0();
		Vector u = null;
		try {
			u = this.p.subtract(p0);
		} catch (Exception e) {
			return null;
		}

		double t = Util.alignZero(u.dotProduct(this.normal) / vn);
		if (t <= 0)
			return null;

		return List.of(new GeoPoint(this, p0.add(v.scale(t))));
	}
}
