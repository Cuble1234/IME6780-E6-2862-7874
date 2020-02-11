/**
 * 
 */
package unittests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import primitives.*;
import geometries.*;
import static geometries.Intersectable.GeoPoint;


/**
 * @author elhan
 *
 */
public class TriangleTests {

	/**
	 * Test method for {@link geometries.Triangle#getNormal(primitives.Point3D)}.
	 */
	@Test
	public void testGetNormal() {
		Material material = new Material(0, 0, 0);
		Point3D p1 = new Point3D(5,9,3);
		Point3D p2 = new Point3D(4,2,6);
		Point3D p3 = new Point3D(8,4,1);
		Triangle triangle = new Triangle (material,new Color(0,0,0),p1,p2,p3);
		Vector vec = new Vector(29,7,26).normal();
		assertEquals("Didn't get normal correct",vec,triangle.getNormal(p1));
	}
	@Test
	public void testFindIntersections() {
		Material material = new Material(0, 0, 0);
		Point3D p1 = new Point3D(0,0,0);
		Point3D p2 = new Point3D(1,0,0);
		Point3D p3 = new Point3D(0,1,0);
		Triangle triangle = new Triangle (material,new Color(0,0,0),p1,p2,p3);
		Ray ray = new Ray(new Point3D(-1, -1, 0), new Vector(0, 0, 1));
		List<GeoPoint> list = new ArrayList<GeoPoint>();
		assertEquals("Didn't find intersection like exepted", null, triangle.findIntersections(ray));
		ray = new Ray(new Point3D(2, -1, 0), new Vector(0, 0, 1));
				assertEquals("Didn't find intersection like exepted", null ,triangle.findIntersections(ray));
				ray = new Ray(new Point3D(4,0,0),new Vector(0,0,1));
				assertEquals("Didn't find intersection like exepted", null ,triangle.findIntersections(ray));
				ray = new Ray(new Point3D(2,0,0),new Vector(0,0,1));
				assertEquals("Didn't find intersection like exepted", null ,triangle.findIntersections(ray));
				ray = new Ray(new Point3D(0,-1,0),new Vector(0,0,1));
				assertEquals("Didn't find intersection like exepted", null ,triangle.findIntersections(ray));
				ray = new Ray(new Point3D(1,1,0),new Vector(0,0,1));
				assertEquals("Didn't find intersection like exepted", null ,triangle.findIntersections(ray));
				ray = new Ray(new Point3D(1,1,-1),new Vector(0,0,1));
				list.add(new GeoPoint(triangle,new Point3D(1,1,0)));
				assertEquals("Didn't find intersection like exepted", list ,triangle.findIntersections(ray));
	}
}
