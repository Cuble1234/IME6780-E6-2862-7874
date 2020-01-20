/**
 * 
 */
package unittests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import geometries.*;
import primitives.*;

/**
 * @author elhan
 *
 */
public class SphereTests {

	/**
	 * Test method for {@link geometries.Sphere#getNormal(primitives.Point3D)}.
	 */
	@Test
	public void testGetNormal() {
		Point3D center = new Point3D(0, 0, 0);
		Sphere sphere = new Sphere(new Color(0,0,0),8, center);
		Point3D point = new Point3D(0, 0, 8);
		Vector vec = new Vector(0, 0, 1);
		assertEquals("Didn't get normal correct", vec, sphere.getNormal(point));
	}
	@Test
	public void testFindIntersections() {
		Sphere sphere = new Sphere(new Color(0,0,0),1, new Point3D(0,0,0));
		Ray ray = new Ray(new Point3D(2,0,0),new Vector(0,-1,1));
		List<Point3D> list = new ArrayList<Point3D>();
				assertEquals("Didn't find intersection like exepted", null ,sphere.findIntersections(ray));
				ray = new Ray(new Point3D(-2,0.5,0),new Vector(1,0,0));
				list.add(new Point3D(Math.sqrt(0.75),0.5,0));
				list.add(new Point3D(-Math.sqrt(0.75),0.5,0));
				assertEquals("Didn't find intersection like exepted", list ,sphere.findIntersections(ray));
				list.clear();
				ray = new Ray(new Point3D(0,0.5,0),new Vector(1,0,0));
				list.add(new Point3D(Math.sqrt(0.75),0.5,0));
				assertEquals("Didn't find intersection like exepted", list ,sphere.findIntersections(ray));
				list.clear();
				ray = new Ray(new Point3D(2,0.5,0),new Vector(1,0,0));
				assertEquals("Didn't find intersection like exepted", null ,sphere.findIntersections(ray));
				ray = new Ray(new Point3D(Math.sqrt(0.75),0.5,0),new Vector(1,0,0));
				assertEquals("Didn't find intersection like exepted", null ,sphere.findIntersections(ray));
				ray = new Ray(new Point3D(Math.sqrt(0.75),0.5,0),new Vector(-1,0,0));
				list.add(new Point3D(-Math.sqrt(0.75),0.5,0));
				assertEquals("Didn't find intersection like exepted", list ,sphere.findIntersections(ray));
				list.clear();
				ray = new Ray(new Point3D(1,0,0),new Vector(1,0,0));
				assertEquals("Didn't find intersection like exepted", null ,sphere.findIntersections(ray));
				ray = new Ray(new Point3D(2,0,0),new Vector(1,0,0));
				assertEquals("Didn't find intersection like exepted", null ,sphere.findIntersections(ray));
				ray = new Ray(new Point3D(0,0,0),new Vector(-1,0,0));
				list.add(new Point3D(-1,0,0));
				assertEquals("Didn't find intersection like exepted", list ,sphere.findIntersections(ray));
				list.clear();
				ray = new Ray(new Point3D(1,0,0),new Vector(-1,0,0));
				list.add(new Point3D(-1,0,0));
				assertEquals("Didn't find intersection like exepted", list ,sphere.findIntersections(ray));
				list.clear();
				ray = new Ray(new Point3D(-0.5,0,0),new Vector(-1,0,0));
				list.add(new Point3D(-1,0,0));
				assertEquals("Didn't find intersection like exepted", list ,sphere.findIntersections(ray));
				list.clear();
				ray = new Ray(new Point3D(2,0,0),new Vector(-1,0,0));
				list.add(new Point3D(-1,0,0));
				list.add(new Point3D(1,0,0));
				assertEquals("Didn't find intersection like exepted", list ,sphere.findIntersections(ray));
				list.clear();
				ray = new Ray(new Point3D(2,0,0),new Vector(0,0,1));
				assertEquals("Didn't find intersection like exepted", null ,sphere.findIntersections(ray));
				ray = new Ray(new Point3D(1,0,0),new Vector(1,0,0));
				assertEquals("Didn't find intersection like exepted", null ,sphere.findIntersections(ray));
				ray = new Ray(new Point3D(-1,0,0),new Vector(0,0,1));
				assertEquals("Didn't find intersection like exepted", null ,sphere.findIntersections(ray));
				ray = new Ray(new Point3D(-1,0,1),new Vector(0,0,1));
				assertEquals("Didn't find intersection like exepted", null ,sphere.findIntersections(ray));
				ray = new Ray(new Point3D(-1,0,-1),new Vector(0,0,1));
				list.add(new Point3D(-1,0,0));
				assertEquals("Didn't find intersection like exepted", list ,sphere.findIntersections(ray));
	}

}
