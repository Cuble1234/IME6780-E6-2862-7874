package elements;

import primitives.Color;

public class AmbientLight {
	
	private Color intensity;
	
	public AmbientLight(Color iA, double kA) {
		this.intensity = iA.scale(kA);
	}

	/**
	 * @return the intensity
	 */
	public Color getIntensity() {
		return intensity;
	}
	
}
