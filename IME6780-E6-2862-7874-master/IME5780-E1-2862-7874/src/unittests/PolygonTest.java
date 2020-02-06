/**
 * 
 */
package unittests;

import static org.junit.Assert.*;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import geometries.Polygon;
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
public class PolygonTest {

	/**
	 * Test method for {@link geometries.Polygon#findIntersections(primitives.Ray)}.
	 */
	@Test
	public void testFindIntersections() {
		Material material = new Material(0, 0, 0);
		Polygon polygon = new Polygon(material,new Color(0,0,0),new Point3D(1, -1, -1), new Point3D(1, 1, -1), new Point3D(1, 1, 1),
				new Point3D(1, -1, 1)) {
			@Override
			public Vector getNormal(Point3D point) {
				return null;
			}

		};
		Ray ray = new Ray(new Point3D(0, 0, 0), new Vector(1, 0, 0));
		List<GeoPoint> list = new ArrayList<GeoPoint>();
		list.add(new GeoPoint(polygon,new Point3D(1, 0, 0)));
		assertEquals("Don't find intersection correct", list, polygon.findIntersections(ray));
	}

}
