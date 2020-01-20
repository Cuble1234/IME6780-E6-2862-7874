package geometries;

import java.util.*;

import primitives.Point3D;
import primitives.Ray;

public class Geometries implements Intersectable{
	private List<Intersectable> geometriesList;
	public Geometries() {
		this.geometriesList = new ArrayList<Intersectable>();
	}
	public Geometries(Intersectable... geometries) {
		for(int i = 0;i<geometries.length;++i) {
			geometriesList.add(geometries[i]);
		}
	}
	public void add(Intersectable... geometries) {
		for(int i = 0;i<geometries.length;++i) {
			geometriesList.add(geometries[i]);
		}
	}

/**
 * get a ray and return the a list of the intersections 
 */
	@Override
	public List<GeoPoint> findIntersections(Ray ray) {
		List<GeoPoint> list = new ArrayList<GeoPoint>();
		List<GeoPoint> list1;
		boolean flag = true;
		for(Intersectable geometries : this.geometriesList) {
			list1 = geometries.findIntersections(ray);
			if(list1 != null) {
				list.addAll(list1);
				flag = false;
			}
		}
		if(flag) {
			list = null;
		}
		return list;
	}
}
