/**
 * 
 */
package unittests;

import static org.junit.Assert.*;

import org.junit.Test;

import geometries.Cylinder;
import primitives.Color;
import primitives.Material;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

/**
 * @author elhan
 *
 */
public class CylinderTests {

	/**
	 * Test method for {@link geometries.Cylinder#getNormal(primitives.Point3D)}.
	 */
	@Test
	public void testGetNormal() {
		Material material = new Material(0, 0, 0);
		Point3D point1 = new Point3D(0, 0, 0);
		Point3D point2 = new Point3D(0, 10, 4);
		Vector vector1 = new Vector(0, 0, 1);
		Ray ray = new Ray(point1, vector1);
		Cylinder cylinder = new Cylinder(material,new Color(0,0,0),10, ray, 10);
		Vector vector2 = new Vector(0, 1, 0);
		assertEquals("Didn't get normal correct", vector2, cylinder.getNormal(point2));
	}
	
	/**
	 * Test method for 
	 */
	@Test
	public void testFindIntersections() {
		Material material = new Material(0, 0, 0);
		Point3D point1 = new Point3D(0, 0, 0);
		Vector vector1 = new Vector(0, 0, 1);
		Ray ray = new Ray(point1, vector1);
		Cylinder cylinder = new Cylinder(material,new Color(0,0,0),10, ray, 10);
		assertEquals(null, cylinder.findIntersections(ray));
	}

}
