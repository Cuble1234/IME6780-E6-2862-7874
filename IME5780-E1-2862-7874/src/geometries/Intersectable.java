package geometries;

import java.util.List;

import primitives.Point3D;
import primitives.Ray;

/**
 * 
 * @author elhanan and yahav represnt a interface of all the geomtries
 */
public interface Intersectable {
	/**
	 * 
	 * represt a type of poit that included the point and her geometry
	 *
	 */
	public static class GeoPoint {
		public Geometry geometry;
		public Point3D point;

		public GeoPoint(Geometry geometry, Point3D point) {
			this.geometry = geometry;
			this.point = point;
		}

		/**
		 * equal function comper between 2 GeoPoints
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (!(obj instanceof GeoPoint))
				return false;

			GeoPoint other = (GeoPoint) obj;
			return this.point.equals(other.point);
		}

	}

	public List<GeoPoint> findIntersections(Ray ray);
}
