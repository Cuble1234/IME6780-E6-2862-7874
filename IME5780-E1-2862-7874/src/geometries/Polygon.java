package geometries;

import java.util.ArrayList;
import java.util.List;

import primitives.*;
import static primitives.Util.*;
/**
 * 
 * @author elhanan and yahav
 *represent a typical poligonn at the space
 */
public class Polygon extends Geometry {
	protected List<Point3D> points;// a rgenised list of the polygon points
	protected Plane plane;// plane for th polygon

	// ***************** Constructors ********************** //

	/**
	 * Regular constructor for polygon
	 * 
	 * @param points
	 * create a new polygon and painter the color to black and set the matirel to (0,0,0)
	 */
	public Polygon(Point3D... points) {
		this(new Material(0,0,0), Color.BLACK, points);
	}

	/**
	 * Regular constructor
	 * 
	 * @param color
	 * @param points
	 */
	public Polygon(Color emmission, Point3D... points) {
		this(new Material(0,0,0), emmission, points);
	}

	/**
	 * Regular constructor
	 * 
	 * @param color
	 * @param points
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
	 * @return the points
	 */
	public List<Point3D> getPoints() {
		return points;
	}

	/**
	 * @return the plane
	 */
	public Plane getPlane() {
		return plane;
	}

	/**
	 * get ray and return list of the intersections between the ray and the polygon
	 **/
	public List<GeoPoint> findIntersections(Ray ray) {
	/*	List<GeoPoint> intersectionsList = this.plane.findIntersections(ray);
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
			}
			else
				vec0 = vec2;
			vec1 = vec2;
		}
		double vn = Util.alignZero(v.dotProduct(vec1.crossProduct(vec0)));
		if (vn == 0 || positive != (vn > 0))
			return null;
		intersectionsList.get(0).geometry = this;
		return intersectionsList;
	}*/
		  List<GeoPoint> intersections = this.plane.findIntersections(ray);
	        if (intersections == null) // if there are no intersections with the plane, or the ray's
	            // base is on the triangle return null
	            return null;
	        Point3D p0 = ray.getP0();
	        int size = this.points.size();
	        Vector[] v = new Vector[size];
	        Vector[] n = new Vector[size];
	        double[] un = new double[size];
	        // vi = pi - p0
	        for (int i = 0; i < size; ++i)
	            v[i] = points.get(i).subtract(p0);
	        // Ni = Vi x Vi+1
	        for (int i = 0; i < size; ++i)
	            n[i] = v[i].crossProduct(v[(i < size - 1) ? i + 1 : 0]).normal();
	        Vector u = intersections.get(0).point.subtract(p0);
	        // uni = u*Ni
	        for (int i = 0; i < size; ++i)
	            if ((un[i] = alignZero(u.dotProduct(n[i]))) == 0)
	                return null;
	        double sign = un[0];
	        for (int i = 1; i < size; ++i)
	            // if the N1...Nn do not have the same sign, return null
	            if ((sign < 0 && un[i] > 0) || (sign > 0 && un[i] < 0))
	                return null;
	        Point3D intersection = intersections.get(0).point;
	        intersections.get(0).geometry = this;
	        return intersections;
	    }

	/**
	 * get normal function
	 * 
	 * @param Point3D
	 * @return normal
	 */
	@Override
	public Vector getNormal(Point3D point) {
		// Plane's normal does not depend on the point - we can save passing the
		// parameter
		// thus calling plane's regular getter of normal
		return this.plane.getNormal();
	}

}
