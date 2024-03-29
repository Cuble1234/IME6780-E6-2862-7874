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
import static geometries.Intersectable.GeoPoint;

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
		Material material = new Material(0, 0, 0);
		Point3D center = new Point3D(0, 0, 0);
		Sphere sphere = new Sphere(material,new Color(0,0,0),8, center);
		Point3D point = new Point3D(0, 0, 8);
		Vector vec = new Vector(0, 0, 1);
		assertEquals("Didn't get normal correct", vec, sphere.getNormal(point));
	}
	@Test
	public void testFindIntersections() {
		Material material = new Material(0, 0, 0);
		Sphere sphere = new Sphere(material,new Color(1,0,0),1, new Point3D(1,0,0));
		Ray ray = new Ray(new Point3D(3,0,0),new Vector(0,-1,1));
		List<GeoPoint> list = new ArrayList<GeoPoint>();
				assertEquals("Didn't find intersection like exepted", null ,sphere.findIntersections(ray));//���� ��� �����
				ray = new Ray(new Point3D(-2,0.5,0),new Vector(1,0,0));
				list.add(new GeoPoint(sphere,new Point3D(1+Math.sqrt(0.75),0.5,0))); 
				list.add(new GeoPoint(sphere,new Point3D(1-Math.sqrt(0.75),0.5,0)));
				assertEquals("Didn't find intersection like exepted", list ,sphere.findIntersections(ray));  // ���� �� ����� �2 ������
				list.clear();
				ray = new Ray(new Point3D(1,0.5,0),new Vector(1,0,0));
				list.add(new GeoPoint(sphere,new Point3D(1+Math.sqrt(0.75),0.5,0)));
				assertEquals("Didn't find intersection like exepted", list ,sphere.findIntersections(ray)); // ���� ���� �����
				list.clear();
				ray = new Ray(new Point3D(2,0.5,0),new Vector(1,0,0));
				assertEquals("Didn't find intersection like exepted", null ,sphere.findIntersections(ray)); // ����� ���� �����
				ray = new Ray(new Point3D(1+Math.sqrt(0.75),0.5,0),new Vector(1,0,0));
				assertEquals("Didn't find intersection like exepted", null ,sphere.findIntersections(ray)); // ����� ������ ������� ����� �����
				ray = new Ray(new Point3D(Math.sqrt(0.75),0.5,0),new Vector(-1,0,0));
				list.add(new GeoPoint(sphere,new Point3D(1-Math.sqrt(0.75),0.5,0)));
				assertEquals("Didn't find intersection like exepted", list ,sphere.findIntersections(ray)); //����� ������ ������� ����� �����
				list.clear();
				ray = new Ray(new Point3D(3,0,0),new Vector(1,0,0));
				assertEquals("Didn't find intersection like exepted", null ,sphere.findIntersections(ray)); // ���� �� ����� ����� �� ����� ���� �����
				ray = new Ray(new Point3D(2,0,0),new Vector(1,0,0));
				assertEquals("Didn't find intersection like exepted", null ,sphere.findIntersections(ray)); // ���� ������ ������� �����
				ray = new Ray(new Point3D(2,0,0),new Vector(-1,0,0));
				list.add(new GeoPoint(sphere,new Point3D(0,0,0)));
				assertEquals("Didn't find intersection like exepted", list ,sphere.findIntersections(ray)); //����� ������ ����� �����
				list.clear();
				ray = new Ray(new Point3D(1,0,0),new Vector(-1,0,0));
				list.add(new GeoPoint(sphere,new Point3D(0,0,0)));
				assertEquals("Didn't find intersection like exepted", list ,sphere.findIntersections(ray)); // ����� ������ ����� �����
				list.clear();
				ray = new Ray(new Point3D(0.5,0,0),new Vector(-1,0,0));
				list.add(new GeoPoint(sphere,new Point3D(0,0,0)));
				assertEquals("Didn't find intersection like exepted", list ,sphere.findIntersections(ray)); //������ �����
				list.clear();
				ray = new Ray(new Point3D(3,0,0),new Vector(-1,0,0));
				list.add(new GeoPoint(sphere,new Point3D(0,0,0)));
				list.add(new GeoPoint(sphere,new Point3D(2,0,0)));
				assertEquals("Didn't find intersection like exepted", list ,sphere.findIntersections(ray)); // ����� ����� ����� �����
				list.clear();
				ray = new Ray(new Point3D(3,0,0),new Vector(0,0,1));
				assertEquals("Didn't find intersection like exepted", null ,sphere.findIntersections(ray)); // ����� �����
				ray = new Ray(new Point3D(2,0,0),new Vector(1,0,0));
				assertEquals("Didn't find intersection like exepted", null ,sphere.findIntersections(ray)); //����� ������ ����
				ray = new Ray(new Point3D(0,0,0),new Vector(0,0,1));
				assertEquals("Didn't find intersection like exepted", null ,sphere.findIntersections(ray)); //���� ���� �����
	}

}
