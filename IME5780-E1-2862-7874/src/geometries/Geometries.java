package geometries;

import java.util.*;

import primitives.Ray;

/**
 * 
 * @author elhanan and yahav organizer all the geometries shapes on one
 *         interface
 *
 */
public class Geometries implements Intersectable {
	private List<Intersectable> geometriesList = new ArrayList<>();

	public Geometries() {
	}

	/**
	 * constructor
	 * 
	 * @param geometries any geomtry create new list and add it to the list
	 */
	public Geometries(Intersectable... geometries) {
		this.add(geometries);
	}

	/**
	 * get any geometry and add it to rhe list
	 * 
	 * @param geometries
	 */
	public void add(Intersectable... geometries) {
		for (Intersectable geometry : geometries)
			geometriesList.add(geometry);
	}

	/**
	 * get a ray and return the a list of the intersections between the geometry and
	 * th list
	 */
	@Override
	public List<GeoPoint> findIntersections(Ray ray) {
		List<GeoPoint> list = null;
		for (Intersectable geometries : this.geometriesList) {
			List<GeoPoint> list1 = geometries.findIntersections(ray);
			if (list1 != null) {
				if (list == null)
					list = new ArrayList<>();
				list.addAll(list1);
			}
		}
		return list;
	}
}
