package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

public class PointLight  extends Light implements LightSource{
	protected Point3D position;
	protected double kC;
	protected double kL;
	protected double kQ;
	public Color getIntensity(Point3D point) {
		return null;
	}
	public Vector getL(Point3D point) {
		return null;
	}
}
