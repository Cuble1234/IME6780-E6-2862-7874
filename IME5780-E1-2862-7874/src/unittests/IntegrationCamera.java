/**
 * 
 */
package unittests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import elements.Camera;
import geometries.Geometry;
import geometries.Plane;
import geometries.Sphere;
import geometries.Triangle;
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
public class IntegrationCamera {
	private int findNumberIntersection(Geometry geometry,Ray[] ray) {
		int counter = 0;
		List<GeoPoint> list = new ArrayList<GeoPoint>();
		for(int i = 0;i<9;++i) {
			list = geometry.findIntersections(ray[i]);
			if(list != null) {
				counter = counter + list.size();
			}
			
	}
		return counter;
	}

	@Test
	public void testIntefretion() {
		Material material = new Material(0, 0, 0);
		Camera camera = new Camera(new Point3D(0,0,0),new Vector (0,1,0),new Vector (0,0,-1));
		Ray[] ray = new Ray[9];
		for(int i=0;i<3;++i) {
			for(int j = 0;j<3;++j) {
				ray[3*i+j] = camera.constructRayThroughPixel(3, 3, i, j, 1, 3,3);
			}
		}
		int counter;
		Sphere sphere = new Sphere(material,new Color(0,0,0),1,new Point3D(0,0,-3));
		counter = findNumberIntersection(sphere,ray);
		assertEquals("Fail intersect correct",2,counter);
		counter = 0;
		sphere = new Sphere(material,new Color(0,0,0),2.4,new Point3D(0,0,-2.5));
		counter = findNumberIntersection(sphere,ray);
		assertEquals("Fail intersect correct",18,counter);
		counter = 0;
		sphere = new Sphere(material,new Color(0,0,0),1.5,new Point3D(0,0,-2));
		counter = findNumberIntersection(sphere,ray);
		assertEquals("Fail intersect correct",10,counter);
		counter = 0;
		sphere = new Sphere(material,new Color(0,0,0),5,new Point3D(0,0,-2.5));
		counter = findNumberIntersection(sphere,ray);
		assertEquals("Fail intersect correct",9,counter);
		sphere = new Sphere(material,new Color(0,0,0),1,new Point3D(0,0,1));
		counter = findNumberIntersection(sphere,ray);
		assertEquals("Fail intersect correct",0,counter);
		Plane plane = new Plane (material,new Color(0,0,0),new Point3D(0,0,-1),new Point3D(0,1,-1),new Point3D(1,0,-1));
		counter = findNumberIntersection(plane,ray);
		assertEquals("Fail intersect correct",9,counter);
		plane = new Plane (material,new Color(0,0,0),new Point3D(0,0,-1),new Point3D(0,1,-1),new Point3D(1,0,-0.5));
		counter = findNumberIntersection(plane,ray);
		assertEquals("Fail intersect correct",9,counter);
		plane = new Plane (material,new Color(0,0,0),new Point3D(0,0,-1),new Point3D(0,1,1),new Point3D(1,0,-1));
		counter = findNumberIntersection(plane,ray);
		assertEquals("Fail intersect correct",6,counter);
		Triangle triangle = new Triangle(material,new Color(0,0,0),new Point3D(0,-1,-2),new Point3D(1,1,-2),new Point3D(-1,1,-2));
		counter = findNumberIntersection(triangle,ray);
		assertEquals("Fail intersect correct",1,counter);
		triangle = new Triangle(material,new Color(0,0,0),new Point3D(0,-20,-2),new Point3D(1,1,-2),new Point3D(-1,1,-2));
		counter = findNumberIntersection(triangle,ray);
		assertEquals("Fail intersect correct",2,counter);
	}
	

	
}
