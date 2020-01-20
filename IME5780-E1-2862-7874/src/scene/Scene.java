package scene;

import elements.AmbientLight;
import elements.Camera;
import geometries.Geometries;
import geometries.Intersectable;
import primitives.Color;

public class Scene {
	private String name;
	private Color background;
	private AmbientLight ambientLight;
	private Geometries geometries;
	private Camera camera;
	private double distance;
	public Scene(String name) {
		this.name = name;
		this.geometries = new Geometries();
	}
	/**
	 * @return the background
	 */
	public Color getBackground() {
		return background;
	}
	/**
	 * @param background the background to set
	 */
	public void setBackground(Color background) {
		this.background = background;
	}
	/**
	 * @return the ambientLight
	 */
	public AmbientLight getAmbientLight() {
		return ambientLight;
	}
	/**
	 * @param ambientLight the ambientLight to set
	 */
	public void setAmbientLight(AmbientLight ambientLight) {
		this.ambientLight = ambientLight;
	}
	/**
	 * @return the geometries
	 */
	public Geometries getGeometries() {
		return geometries;
	}
	/**
	 * @return the camera
	 */
	public Camera getCamera() {
		return camera;
	}
	/**
	 * @param camera the camera to set
	 */
	public void setCamera(Camera camera,double distance) {
		this.camera = camera;
		this.distance = distance;
	}
	/**
	 * @return the distance
	 */
	public double getDistance() {
		return distance;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * add new geometries
	 * @param geometries
	 */
	public void addGeometries(Intersectable... geometries) {
		this.geometries.add(geometries);
	}
	
}
