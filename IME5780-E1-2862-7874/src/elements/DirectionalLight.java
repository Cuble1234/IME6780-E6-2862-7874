package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

public class DirectionalLight extends Light implements LightSource{
	private Vector direction;
	public Color getIntensity(Point3D point) {
		return null;
	}
	public Vector getL(Point3D point) {
		return null;
	}
}
