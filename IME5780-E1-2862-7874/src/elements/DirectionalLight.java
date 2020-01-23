package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

public class DirectionalLight extends Light implements LightSource{
	private Vector direction;
	public DirectionalLight(Color intensity,Vector direction) {
		super(intensity);
		this.direction = direction;
	}
	public Color getIntensity(Point3D point) {
		return this.intensity;
	}
	public Vector getL(Point3D point) {
		return null;
	}
}
