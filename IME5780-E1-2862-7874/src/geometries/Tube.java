package geometries;

import primitives.*;
import static primitives.Util.*;

import java.util.List;

/**
 * 
 * @author elhanan and yahav represent unlimited tube at the space extands from
 *         radial geomtry
 */
public class Tube extends RadialGeometry {
	protected Ray axisRay;

	// ***************** Constructors ********************** //
	/**
	 * Regular constructor
	 * 
	 * @param color    of the tube
	 * @param material of the tube
	 * @param radius   of the tube
	 * @param axisRay  - enter ray of the tube use hus father and creat new tube
	 */
	public Tube(Material material, Color emmission, double radius, Ray axisRay) {
		super(material, emmission, radius);
		this.axisRay = new Ray(axisRay);
	}

	/************************************
	 * Getters
	 *******************************************/
	/**
	 * ray getter
	 * 
	 * @return the axisRay of the tube
	 */
	public Ray getAxisRay() {
		return axisRay;
	}

	/**
	 * get normal function
	 * 
	 * @param POINT3D
	 * @return normal to the tube
	 */
	public Vector getNormal(Point3D point) {
		Vector v = this.axisRay.getDirection();
		Point3D p0 = this.axisRay.getP0();
		Vector u = point.subtract(p0);
		double t = v.dotProduct(u);
		Point3D o = p0;
		if (!isZero(t))
			o = o.add(v.scale(t));
		return point.subtract(o).normal();
	}

	/**
	 * find intersuction function
	 * 
	 * @return null
	 */
	@Override
	public List<GeoPoint> findIntersections(Ray ray) {
		return null;
	}
}
