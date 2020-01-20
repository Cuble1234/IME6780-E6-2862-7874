package renderer;

import java.util.List;

import primitives.Color;
import primitives.Point3D;
import primitives.Ray;
import scene.Scene;
import static geometries.Intersectable.GeoPoint;

public class Render {
	Scene scene;
	private ImageWriter imageWriter;

	public Render(ImageWriter imageWriter, Scene scene) {
		this.scene = scene;
		this.imageWriter = imageWriter;
	}

	public void renderImage() {

		for (int i = 0; i < imageWriter.getNy(); ++i)
			for (int j = 0; j < imageWriter.getNx(); ++j) {
				Ray ray = scene.getCamera().constructRayThroughPixel(imageWriter.getNx(), imageWriter.getNy(), j, i,
						scene.getDistance(), imageWriter.getWidth(), imageWriter.getHeight());
				List<GeoPoint> intersectionPoints = scene.getGeometries().findIntersections(ray);
				if (intersectionPoints == null)
					imageWriter.writePixel(j, i, scene.getBackground().getColor());
				else {
					GeoPoint closestPoint = getClosestPoint(intersectionPoints);
					imageWriter.writePixel(j, i, calcColor(closestPoint).getColor());
				}
			}
	}

	private Color calcColor(GeoPoint p) {
		Color color = this.scene.getAmbientLight().getIntensity();
		color = color.add(p.geometry.getEmmission());
		return color;
	}

	private GeoPoint getClosestPoint(List<GeoPoint> intersectionPoints) {
		GeoPoint closestPoint = intersectionPoints.get(0);
		for(GeoPoint point : intersectionPoints) {
			if (point.point.dictance(this.scene.getCamera().getP0())<closestPoint.point.dictance(this.scene.getCamera().getP0())) {
				closestPoint = point;
			}
		}
		return closestPoint;
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

	public void printGrid(int interval) {
		java.awt.Color grid = new java.awt.Color(255, 255, 255);
		for (int i = 0; i < imageWriter.getHeight(); i += interval)
			for (int j = 0; j < imageWriter.getWidth(); ++j) {
				if ((i == 0 && j == 0) || (i == 0 && j % interval != 0) || (i == imageWriter.getHeight() && j == 500)
						|| (i == 500 && j % 50 != 0) || (j == 0 && i % interval != 0)
						|| (j == imageWriter.getWidth() && i % interval != 0)) {

				} else {
					imageWriter.writePixel(i, j, grid);
					imageWriter.writePixel(j, i, grid);
				}

			}

	}
}
