package primitives;

/**
 *  @author Yahav & Elchanan
 *Describes the Characteristics of the object
 */
public class Material {
	private double kD;
	private double kS;
	private int nShininess;
	
	/**
	 * Material parameters constructor.<br>
	 * For a realistic picture we usually want k<sub>D</sub>+k<sub>S</sub><=1 to keep the <strong>Energy Conservation Law</strong> in tact
	 * @param kD diffusive light reflection multiplier (0 to 1)
	 * @param kS specular light reflection multiplier (0 to 1)
	 * @param nShininess shininess level (exponential power) - usually several hundreds
	 */
	 public Material(double kD,double kS,int nShininess) {
		this.kD = kD;
		this.kS = kS;
		this.nShininess = nShininess;
	}
	 
	/**
	 * Getter for diffusive light reflection multiplier for the material
	 * @return the Kd
	 */
	public double getkD() {
		return kD;
	}
	
	/**
	 * Getter for specular light reflection multiplier for the material
	 * @return the Ks
	 */
	public double getkS() {
		return kS;
	}
	
	/**
	 * Getter for shininess level (exponential power) for the material
	 * @return the n-Shininess
	 */
	public int getnShininess() {
		return nShininess;
	}

}
