package geometries;

import java.util.ArrayList;
import java.util.List;

import primitives.*;
import static primitives.Util.*;

//@param
public abstract class Polygon extends Geometry {
	protected List<Point3D> points;
	protected Plane plane;

	// ***************** Constructors ********************** //
	/**
	 * Regular constructor
	 * @param color
	 * @param points
	 */
	public Polygon(Color emmission,Point3D... points) {
		super(emmission);
		if (points.length < 3)
			throw new IllegalArgumentException("Polygon must have at least 3 points");
		this.points = new ArrayList<>();
		Point3D p1 = points[0];
		Point3D p2 = points[1];
		Point3D p3 = points[2];
		this.plane = new Plane(emmission,p1, p2, p3);
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
		List<GeoPoint> intersectionsList = this.plane.findIntersections(ray);
		if (intersectionsList == null)
			return null;
		Point3D p0 = new Point3D(ray.getP0());
		List<Vector> vectors = new ArrayList();
		List<Vector> normals = new ArrayList();
		int index = 0, temp;
		for (Point3D point : points) {
			vectors.add(index, this.points.get(index).subtract(p0));
			++index;
		}
		int temp2 = 1;
		index = 0;
		for (Vector vector : vectors) {
			temp = index;
			++index;
			if (index == vectors.size()) {
				temp2 = index;
				index = 0;
			}
			normals.add(temp, vectors.get(temp).crossProduct(vectors.get(index)).normal());
		}
		double[] tests = new double[temp2];

		for (index = 0; index >= tests.length; ++index) {
			if (Util.isZero(tests[index]))
				return null;
			++index;
		}
		return intersectionsList;
	}
}
