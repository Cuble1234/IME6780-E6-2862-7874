package geometries;

import java.util.ArrayList;
import java.util.List;

import primitives.*;
import static primitives.Util.*;

/**
 * 
 * @author elhanan and yahav represent a typical poligonn at the space
 */
public class Polygon extends Geometry {
	protected List<Point3D> points;// a rgenised list of the polygon points
	protected Plane plane;// plane for th polygon

	// ***************** Constructors ********************** //

	/**
	 * Regular constructor for polygon
	 * 
	 * @param points create a new polygon and painter the color to black and set the
	 *               matirel to (0,0,0)
	 */
	public Polygon(Point3D... points) {
		this(new Material(0, 0, 0), Color.BLACK, points);
	}

	/**
	 * Regular constructor
	 * 
	 * @param matirel represent the matirel of th polygon
	 * @param color   of th polygon
	 * @param points- orgnized list of the polygon points create new polygon with
	 *                that parmas
	 */
	public Polygon(Material material, Color emmission, Point3D... points) {
		super(material, emmission);
		if (points.length < 3)
			throw new IllegalArgumentException("Polygon must have at least 3 points");
		this.points = new ArrayList<>();
		Point3D p1 = points[0];
		Point3D p2 = points[1];
		Point3D p3 = points[2];
		this.plane = new Plane(material, emmission, p1, p2, p3);
		this.points.add(p1);
		this.points.add(p2);
		this.points.add(p3);
		Vector n = plane.getNormal();
		for (int i = 3; i < points.length; ++i) {
			Point3D p = points[i];
			if (!isZero(p1.subtract(p).dotProduct(n)))
				throw new IllegalArgumentException("Polygon points must be in the same plane");
			this.points.add(p);
		}
	}

	/**
	 ************************** Getters****************************************
	 */
	/**
	 * getPoints function
	 * 
	 * @return the list of th polygon's points
	 */
	public List<Point3D> getPoints() {
		return points;
	}

	/**
	 * get plane function
	 * 
	 * @return the plane of th polyagon
	 */
	public Plane getPlane() {
		return plane;
	}

	/**
	 * find inersections
	 * 
	 * @param ray
	 * @return list of the intersections between the ray and the polygon
	 **/
	public List<GeoPoint> findIntersections(Ray ray) {
		List<GeoPoint> intersectionsList = this.plane.findIntersections(ray);
		if (intersectionsList == null)
			return null;
		Point3D p0 = ray.getP0();
		Vector v = ray.getDirection();
		boolean positive = true, first = false;
		Vector vec1 = null, vec2, vec0 = null;
		for (Point3D point : points) {
			vec2 = point.subtract(p0);
			if (vec1 != null) {
				double vn = Util.alignZero(v.dotProduct(vec1.crossProduct(vec2)));
				if (vn == 0)
					return null;
				boolean test = vn > 0;
				if (first)
					positive = test;
				else if (positive != test)
					return null;
			} else
				vec0 = vec2;
			vec1 = vec2;
		}
		double vn = Util.alignZero(v.dotProduct(vec1.crossProduct(vec0)));
		if (vn == 0 || positive != (vn > 0))
			return null;
		intersectionsList.get(0).geometry = this;
		return intersectionsList;
	}

	/**
	 * get normal function
	 * 
	 * @param Point3D and we dosen use it
	 * @return normal to the polygon
	 */
	@Override
	public Vector getNormal(Point3D point) {
		// Plane's normal does not depend on the point - we can save passing the
		// parameter
		// thus calling plane's regular getter of normal
		return this.plane.getNormal();
	}

}
