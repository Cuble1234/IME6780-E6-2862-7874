package geometries;

import primitives.*;
import static primitives.Util.*;

import java.util.List;

public class Tube extends RadialGeometry {
	protected Ray axisRay;

	// ***************** Constructors ********************** //
	/**
	 * Regular constructor
	 * 
	 * @param radius
	 * @param axisRay
	 */
	public Tube(Material material,Color emmission,double radius, Ray axisRay) {
		super(material,emmission,radius);
		this.axisRay = new Ray(axisRay);
	}

	/************************************Getters*******************************************/
	/**
	 * @return the axisRay
	 */
	public Ray getAxisRay() {
		return axisRay;
	}

	/**
	 * get normal function
	 * 
	 * @param POINT3D
	 * @return null
	 */
	public Vector getNormal(Point3D point) {
		Vector v = this.axisRay.getDirection();
		Point3D p0 = this.axisRay.getP0();
		Vector u = point.subtract(p0);
		double t = v.dotProduct(u);
		Point3D o;
		if (isZero(t))
			o = p0;
		else
			o = p0.add(v.scale(t));
		return point.subtract(o).normal();
	}
/**
 * ма ооеощ
 */
	@Override
	public List<GeoPoint> findIntersections(Ray ray) {
		return null;
	}
}
