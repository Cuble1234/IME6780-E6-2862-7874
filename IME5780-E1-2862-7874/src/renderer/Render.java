package renderer;

import java.util.List;

import elements.LightSource;
import geometries.*;
import geometries.Intersectable.GeoPoint;
import primitives.*;
import scene.Scene;
import static geometries.Intersectable.GeoPoint;
import static primitives.Util.*;

public class Render {
	Scene scene;
	private ImageWriter imageWriter;

	/**
	 * constructor
	 * 
	 * @param imageWriter
	 * @param scene
	 */
	public Render(ImageWriter imageWriter, Scene scene) {
		this.scene = scene;
		this.imageWriter = imageWriter;
	}

	/**
	 * create the image
	 */
	public void renderImage() {
		int nx = imageWriter.getNx();
		int ny = imageWriter.getNy();
		double d = scene.getDistance(), w = imageWriter.getWidth(), h = imageWriter.getHeight();
		Geometries geos = scene.getGeometries();
		java.awt.Color background = scene.getBackground().getColor();
		for (int i = 0; i < imageWriter.getNy(); ++i)
			for (int j = 0; j < imageWriter.getNx(); ++j) {
				Ray ray = scene.getCamera().constructRayThroughPixel(nx, ny, j, i, d, w, h);
				List<GeoPoint> intersectionPoints = geos.findIntersections(ray);
				if (intersectionPoints != null) {
					GeoPoint closestPoint = getClosestPoint(intersectionPoints);
					imageWriter.writePixel(j, i, closestPoint == null ? scene.getBackground().getColor()
							: calcColor(closestPoint, ray).getColor());
				}
			}
	}

	/**
	 * calculate the color of the point
	 * 
	 * @param p
	 * @return color
	 */
	private static final int MAX_CALC_COLOR_LEVEL = 10;
	private static final double MIN_CALC_COLOR_K = 0.001;

	private Color calcColor(GeoPoint intersection, Ray inRay, int level, double k) {
		if (level == 0 || k < MIN_CALC_COLOR_K)
			return Color.BLACK;
		Color color = intersection.geometry.getEmmission(); // remove Ambient Light
		// color = this.scene.getAmbientLight().getIntensity();
		// color = color.add(intersection.geometry.getEmmission());
		Vector v = intersection.point.subtract(scene.getCamera().getP0()).normal();
		Vector n = intersection.geometry.getNormal(intersection.point);
		int nShininess = intersection.geometry.getMaterial().getnShininess();
		double kd = intersection.geometry.getMaterial().getkD();
		double ks = intersection.geometry.getMaterial().getkS();
		for (LightSource lightSource : scene.getLights()) {
			Vector l = lightSource.getL(intersection.point);
			if ((n.dotProduct(l) * n.dotProduct(v) > 0)) {
				double ktr = transparency(l, n, intersection);
				if (ktr * k > MIN_CALC_COLOR_K) {
					Color lightIntensity = lightSource.getIntensity(intersection.point).scale(ktr);
					color = color.add(calcDiffusive(kd, l, n, lightIntensity),
							calcSpecular(ks, l, n, v, nShininess, lightIntensity));
				}
			}
		}

		double kr = intersection.geometry.getMaterial().getkR(), kkr = k * kr;
		if (kkr > MIN_CALC_COLOR_K) {
			Ray reflectedRay = constructReflectedRay(n, intersection.point, inRay);
			GeoPoint reflectedPoint = findClosestIntersection(reflectedRay);
			if (reflectedPoint != null)
				color = color.add(calcColor(reflectedPoint, reflectedRay, level - 1, kkr).scale(kr));
			double kt = intersection.geometry.getMaterial().getkT(), kkt = k * kt;
			if (kkt > MIN_CALC_COLOR_K) {
				Ray refractedRay = constructRefractedRay(intersection.geometry.getNormal(intersection.point),
						intersection.point, inRay);
				GeoPoint refractedPoint = findClosestIntersection(refractedRay);
				if (refractedPoint != null)
					color = color.add((calcColor(refractedPoint, refractedRay, level - 1, kkt).scale(kt)));

			}
		}
		return color;
	}

	private Color calcColor(GeoPoint closestPoint, Ray inRay) {
		return calcColor(closestPoint, inRay, MAX_CALC_COLOR_LEVEL, 1.0).add(scene.getAmbientLight().getIntensity());
	}

	private static final double EPS = 0.1;

	private boolean unshaded(Vector l, Vector n, GeoPoint intersection) {
		Vector lightDirection = l.scale(-1); // from point to light source
		Vector epsVector = n.scale(n.dotProduct(lightDirection) > 0 ? EPS : -EPS);
		Point3D point = intersection.point.add(epsVector);
		Ray lightRay = new Ray(point, lightDirection);
		List<GeoPoint> intersections = scene.getGeometries().findIntersections(lightRay);
		return intersections == null;
	}

	/**
	 * the closest point to the camera
	 * 
	 * @param intersectionPoints
	 * @return the closest point to the camera
	 */
	private GeoPoint getClosestPoint(List<GeoPoint> intersectionPoints) {
		GeoPoint closestPoint = null;
		Point3D p0 = this.scene.getCamera().getP0();
		double distance = Double.POSITIVE_INFINITY;
		for (GeoPoint point : intersectionPoints) {
			double d = p0.distance(point.point);
			if (d < distance) {
				closestPoint = point;
				distance = d;
			}
		}
		return closestPoint;
	}

	private Color calcDiffusive(double kd, Vector l, Vector n, Color lightIntensity) {
		return lightIntensity.scale(kd * (Math.abs(l.dotProduct(n))));
	}

	private Color calcSpecular(double ks, Vector l, Vector n, Vector v, int nShininess, Color lightIntensity) {
		Vector r = l.subtract(n.scale(2 * l.dotProduct(n)));
		double minusVR = -alignZero(v.dotProduct(r));
		if (minusVR <= 0)
			return Color.BLACK;
		return lightIntensity.scale(ks * Math.pow(minusVR, nShininess));
	}

	/**
	 * @return the scene
	 */
	public Scene getScene() {
		return scene;
	}

	/**
	 * @return the imageWriter
	 */
	public ImageWriter getImageWriter() {
		return imageWriter;
	}

	/**
	 * print grid on the image
	 * 
	 * @param interval
	 */
	public void printGrid(int interval) {
		java.awt.Color grid = java.awt.Color.WHITE;
		for (int i = 0; i < imageWriter.getHeight(); ++i)
			for (int j = 0; j < imageWriter.getWidth(); ++j) {
				if ((i == 0 && j == 0) || (i == 0 && j % interval != 0)
						|| (i == imageWriter.getHeight() && j == this.imageWriter.getNx())
						|| (i == this.imageWriter.getNy() && j % interval != 0) || (j == 0 && i % interval != 0)
						|| (j == imageWriter.getWidth() && i % interval != 0)
						|| (i % interval != 0 && j % interval != 0)) {
				} else
					imageWriter.writePixel(j, i, grid);
			}
		/*
		 * for (int i = 0; i < imageWriter.getHeight(); i += interval) for (int j = 0; j
		 * < imageWriter.getWidth(); ++j) { if ((i == 0 && j == 0) || (i == 0 && j %
		 * interval != 0) || (i == imageWriter.getHeight() && j ==
		 * this.imageWriter.getNx()) || (i == this.imageWriter.getNy() && j % interval
		 * != 0) || (j == 0 && i % interval != 0) || (j == imageWriter.getWidth() && i %
		 * interval != 0)) {
		 * 
		 * } else { if (i < imageWriter.getWidth()) { imageWriter.writePixel(i, j,
		 * grid); } if (j < imageWriter.getHeight()) { imageWriter.writePixel(j, i,
		 * grid); } } }
		 */

	}

	private GeoPoint findClosestIntersection(Ray ray) {
		List<GeoPoint> points = scene.getGeometries().findIntersections(ray);
		if (points == null)
			return null;
		Point3D p0 = ray.getP0();
		double minValue = points.get(0).point.distance(p0);
		GeoPoint minPoint = points.get(0);
		for (GeoPoint p : points) {
			double d0 = p.point.distance(p0);
			if (d0 < minValue) {
				minValue = d0;
				minPoint = p;
			}
		}
		return minPoint;
	}

	private Ray constructReflectedRay(Vector n, Point3D point, Ray inRay) {
		Vector v = inRay.getDirection();
		Vector r = v.subtract(n.scale(v.dotProduct(n) * 2));
		Point3D point2 = point.add(n.scale(n.dotProduct(r) > 0 ? EPS : -EPS));
		Ray ray = new Ray(point2, r);
		if (ray.getDirection().dotProduct(n) > 0)
			return ray;
		return null;
	}

	private Ray constructRefractedRay(Vector n, Point3D point, Ray inRay) {
		Vector v = inRay.getDirection();
		Point3D point2 = point.add(n.scale(n.dotProduct(v) > 0 ? EPS : -EPS));
		return new Ray(point2, v);
	}

	private double transparency(Vector l, Vector n, GeoPoint geopoint) {
		Vector lightDirection = l.scale(-1); // from point to light source
		Vector epsVector = n.scale(n.dotProduct(lightDirection) > 0 ? EPS : -EPS);
		Point3D point = geopoint.point.add(epsVector);
		Ray lightRay = new Ray(point, lightDirection);
		List<GeoPoint> intersections = scene.getGeometries().findIntersections(lightRay);
		if (intersections != null) {
			double ktr = 1;
			for (GeoPoint gp : intersections)
				ktr *= gp.geometry.getMaterial().getkT();
			return ktr;
		}
		return 1;
		}

}
