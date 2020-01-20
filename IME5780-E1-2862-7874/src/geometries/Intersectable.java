package geometries;

import java.util.List;

import primitives.Point3D;
import primitives.Ray;

public interface Intersectable {
	static class GeoPoint{
		public Geometry geometry;
		public Point3D point;
		public GeoPoint(Geometry geometry, Point3D point) {
			this.geometry = geometry;
			this.point = point;
		}
	}
	public List<GeoPoint> findIntersections(Ray ray); 
}
