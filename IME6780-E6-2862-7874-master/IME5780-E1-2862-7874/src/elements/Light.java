package elements;

import primitives.Color;

public abstract class Light {
	protected Color intensity;
	public Light(Color intensity) {
		this.intensity = intensity;
	}
	public Color getIntensity() {
		return this.intensity;
	}
}
