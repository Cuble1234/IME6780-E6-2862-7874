package geometries;

import primitives.*;

public abstract class Geometry implements Intersectable {
	Color emmission;
	public abstract Vector getNormal(Point3D point);
	public Geometry(Color emmission) {
		this.emmission = emmission;
	}
	/**
	 * @return the emmission
	 */
	public Color getEmmission() {
		return emmission;
	}
	
}
