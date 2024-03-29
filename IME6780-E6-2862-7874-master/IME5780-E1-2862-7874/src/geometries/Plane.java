package geometries;

import java.util.ArrayList;
import java.util.List;

import primitives.*;

//@param
public class Plane extends Geometry {
	private Point3D p;
	private Vector normal;

	// ***************** Constructors ********************** //
	/**
	 * Regular constructor
	 * 
	 * @param p
	 * @param normal
	 */
	public Plane(Material material,Color emmission,Point3D p, Vector normal) {
		super(material,emmission);
		this.p = new Point3D(p);
		this.normal = new Vector(normal.normalization());
	}

	public Plane(Material material,Color emmission,Point3D p1, Point3D p2, Point3D p3) {
		super(material,emmission);
		this.p = new Point3D(p1);
		this.normal = p1.subtract(p2).crossProduct(p1.subtract(p3)).normal();
	}

	/**
	 * @return the p
	 */
	public Point3D getP() {
		return p;
	}

	/**
	 * @return the normal
	 */
	public Vector getNormal() {
		return normal;
	}

	/**
	 * get normal function
	 * 
	 * @param Point3D
	 * @return null
	 */

	public Vector getNormal(Point3D point) {
		return normal;
	}
/**
 * get ray and return list of the intersections between the ray and the plane
 */
	@Override
	public List<GeoPoint> findIntersections(Ray ray) {
		if (ray.getDirection().dotProduct(normal) == 0) {
			return null;
		}
		if (this.p.equals(ray.getP0())){
			return null;
		}
		double t = this.normal.dotProduct(this.p.subtract(ray.getP0())) / (this.normal.dotProduct(ray.getDirection()));
		if (t <= 0) {
			return null;
		}
		GeoPoint P = new GeoPoint(this,ray.getP0().add(ray.getDirection().scale(t)));
		List<GeoPoint> list = new ArrayList<GeoPoint>();
		list.add(P);
		return list;
	}
}
