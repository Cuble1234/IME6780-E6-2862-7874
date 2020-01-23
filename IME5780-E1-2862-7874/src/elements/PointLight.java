package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

public class PointLight  extends Light implements LightSource{
	protected Point3D position;
	protected double kC;
	protected double kL;
	protected double kQ;
	public PointLight(Color intensity, Point3D position,double kC,double kL,double kQ) {
		super(intensity);
		this.position = position;
		this.kC = kC;
		this.kL = kL;
		this.kQ = kQ;
	}
	public Color getIntensity(Point3D point) {
		Color color;
		double distance = this.getL(point).length();
		color = this.intensity.scale(1/(kC+kL*distance+kQ*distance*distance));
		return color;
	}
	public Vector getL(Point3D point) {
		return this.position.subtract(point);
	}
}
