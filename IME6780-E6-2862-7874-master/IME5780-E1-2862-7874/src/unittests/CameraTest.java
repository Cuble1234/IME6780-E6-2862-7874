/**
 * 
 */
package unittests;

import static org.junit.Assert.*;
import primitives.*;
import geometries.*;

import org.junit.Test;

import elements.Camera;

/**
 * @author elhan
 *
 */
public class CameraTest {

	/**
	 * Test method for {@link elements.Camera#Camera(primitives.Point3D, primitives.Vector, primitives.Vector)}.
	 */
	@Test
	public void testCamera() {
		Point3D point = new Point3D(0,0,0);
		Vector vUp = new Vector (0,2,0);
		Vector vTo = new Vector (2,0,0);
		Vector vRight = new Vector(0,0,1);
		Camera camera = new Camera(point,vUp,vTo);
		vUp = new Vector (0,1,0);
		vTo = new Vector (1,0,0);
		assertEquals("Fail construct",camera.getvUp(),vUp);
		assertEquals("Fail construct",camera.getvTo(),vTo);
		assertEquals("Fail construct",camera.getvRight(),vRight);
	}

	/**
	 * Test method for {@link elements.Camera#constructRayThroughPixel(int, int, int, int, double, double, double)}.
	 */
	@Test
	public void testConstructRayThroughPixel() {
		Camera camera = new Camera(new Point3D(0,0,0),new Vector (0,1,0),new Vector (1,0,0));
		Ray ray;
		Ray test = new Ray(new Point3D(0,0,0),new Vector(1,0,0));
		ray = camera.constructRayThroughPixel(3, 3, 1, 1, 1, 3,3);
		assertEquals("Don't build ray right",test,ray);
		ray = camera.constructRayThroughPixel(3, 3, 0, 0, 1, 3,3);
		test = new Ray(new Point3D(0,0,0),new Vector(1,1,-1).normal());
		assertEquals("Don't build ray right",test,ray);
		ray = camera.constructRayThroughPixel(3, 3, 0, 1, 1, 3,3);
		test = new Ray(new Point3D(0,0,0),new Vector(1,0,-1).normal());
		assertEquals("Don't build ray right",test,ray);
		ray = camera.constructRayThroughPixel(4, 4, 1, 1, 1, 4,4);
		test = new Ray(new Point3D(0,0,0),new Vector(1,0.5,-0.5).normal());
		assertEquals("Don't build ray right",test,ray);
		ray = camera.constructRayThroughPixel(4, 4, 0, 0, 1, 4,4);
		test = new Ray(new Point3D(0,0,0),new Vector(1,1.5,-1.5).normal());
		assertEquals("Don't build ray right",test,ray);
		ray = camera.constructRayThroughPixel(4, 4, 0, 1, 1, 4,4);
		test = new Ray(new Point3D(0,0,0),new Vector(1,0.5,-1.5).normal());
		assertEquals("Don't build ray right",test,ray);
	}

}
