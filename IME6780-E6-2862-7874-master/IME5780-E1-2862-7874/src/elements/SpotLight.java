package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

public class SpotLight	extends PointLight {
	private Vector direction;
	public SpotLight(Color intensity, Point3D position, double kC, double kL, double kQ,Vector direction) {
		super(intensity, position, kC, kL, kQ);
		this.direction = direction;
	}
	public Color getIntensity(Point3D point) {
		Color color;
		double max = this.direction.dotProduct(this.getL(point));
		if (max<0) {
			max = 0;
		}
		double distance = this.getL(point).length();
		color = this.intensity.scale(max).scale(1/(kC+kL*distance+kQ*distance*distance));
		return color;
	}
	
}
