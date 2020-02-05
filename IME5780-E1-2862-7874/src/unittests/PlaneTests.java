/**
 * 
 */
package unittests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import geometries.Plane;
import primitives.Color;
import primitives.Material;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;
import static geometries.Intersectable.GeoPoint;

/**
 * @author elhan
 *
 */
public class PlaneTests {

	/**
	 * Test method for {@link geometries.Plane#getNormal(primitives.Point3D)}.
	 */
	@Test
	public void testGetNormalPoint3D() {
		Material material = new Material(0, 0, 0);
		Vector normal = new Vector(1, 2, 3);
		Point3D point = new Point3D(1, 1, 1);
		Plane plane = new Plane(material, new Color(0, 0, 0), point, normal);
		normal.normal();
		assertEquals("Didn't get normal correct", normal, plane.getNormal(point));
	}

	@Test
	public void testFindIntersections() {
		Material material = new Material(0, 0, 0);
		Plane plane = new Plane(material, new Color(0, 0, 0), new Point3D(0, 0, 0), new Point3D(1, 0, 0),
				new Point3D(0, 1, 0));
		Ray ray = new Ray(new Point3D(0, 1, 1), new Vector(0, 0, -1));
		List<GeoPoint> list = new ArrayList<GeoPoint>();
		list.add(new GeoPoint(plane, new Point3D(0, 1, 0)));
		assertEquals("Didn't find intersection like exepted", list, plane.findIntersections(ray));
		ray = new Ray(new Point3D(0, 0, 1), new Vector(0, 1, 1));
		assertEquals("Didn't find intersection like exepted", null, plane.findIntersections(ray));
		ray = new Ray(new Point3D(0, 0, 0), new Vector(0, 0, 1));
		assertEquals("Didn't find intersection like exepted", null, plane.findIntersections(ray));
		ray = new Ray(new Point3D(0, 0, 0), new Vector(0, 1, 0));
		assertEquals("Didn't find intersection like exepted", null, plane.findIntersections(ray));
		ray = new Ray(new Point3D(0, 0, 0), new Vector(0, 0, -1));
		assertEquals("Didn't find intersection like exepted", null, plane.findIntersections(ray));

	}

}
