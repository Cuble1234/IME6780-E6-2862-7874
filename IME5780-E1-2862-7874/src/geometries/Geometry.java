package geometries;

import primitives.*;

/**
 * 
 * @author yahav
 *
 */
public abstract class Geometry implements Intersectable {
	protected Color emission;
	protected Material material;
	public abstract Vector getNormal(Point3D point);
	
	public Geometry() {
		this.material = new Material(0,0,0);
		this.emission = Color.BLACK;
	}
	
	public Geometry(Material material,Color emmission) {
		this.material = material;
		this.emission = emmission;
	}
	/**
	 * @return the emmission
	 */
	public Color getEmmission() {
		return emission;
	}
	/**
	 * @return the material
	 */
	public Material getMaterial() {
		return material;
	}
	
}
