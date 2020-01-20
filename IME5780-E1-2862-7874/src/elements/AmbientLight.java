package elements;

import primitives.Color;

public class AmbientLight {
	
	private Color intensity;
	/**
	 * constructor get
	 * @param iA
	 * @param kA
	 */
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
