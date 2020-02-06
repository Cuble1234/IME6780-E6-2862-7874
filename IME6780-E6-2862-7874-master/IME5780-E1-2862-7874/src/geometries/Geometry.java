package geometries;

import primitives.*;

public abstract class Geometry implements Intersectable {
	protected Color emmission;
	protected Material material;
	public abstract Vector getNormal(Point3D point);
	public Geometry(Material material,Color emmission) {
		this.material = material;
		this.emmission = emmission;
	}
	/**
	 * @return the emmission
	 */
	public Color getEmmission() {
		return emmission;
	}
	/**
	 * @return the material
	 */
	public Material getMaterial() {
		return material;
	}
	
}
