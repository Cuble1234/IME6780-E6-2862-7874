package geometries;

import primitives.*;

public class Triangle extends Polygon {
	// ***************** Constructors ********************** //
	/**
	 * Regular constructor
	 * 
	 * @param points
	 * @param plane
	 */
	public Triangle(Material material,Color emmission,Point3D a, Point3D b, Point3D c) {
		super(material,emmission,a, b, c);
	}
}
