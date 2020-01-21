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
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (!(obj instanceof GeoPoint))
				return false;

			GeoPoint other = (GeoPoint) obj;
			return point.equals(other.point)&&geometry.equals(other.geometry);
		}
	}
	public List<GeoPoint> findIntersections(Ray ray); 
}
