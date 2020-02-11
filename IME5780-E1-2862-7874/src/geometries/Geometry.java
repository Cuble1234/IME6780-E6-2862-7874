package geometries;

import primitives.*;

/**
 * 
 * @author yahav and elhanan abstruct class organizer all the properties that
 *         all the geometry use them
 */
public abstract class Geometry implements Intersectable {
	protected Color emission; // represent the color of the shape
	protected Material material;// represent the Type of material of the shape

	public abstract Vector getNormal(Point3D point);

	/**
	 * constrctor for geomtery put the matirel at (0,0,00 and painter the color to
	 * black
	 */
	public Geometry() {
		this.material = new Material(0, 0, 0);
		this.emission = Color.BLACK;
	}

	/**
	 * constrctor for geomtery
	 * 
	 * @param matireal
	 * @param color    put the matirel at that he get and painter the color to whice
	 *                 color he get
	 */
	public Geometry(Material material, Color emmission) {
		this.material = material;
		this.emission = emmission;
	}

	/**
	 * get emission function
	 * 
	 * @return the emmission color of the geometry.
	 */
	public Color getEmmission() {
		return emission;
	}

	/**
	 * get matirel function
	 * 
	 * @return the material of the shape
	 */
	public Material getMaterial() {
		return material;
	}

}
