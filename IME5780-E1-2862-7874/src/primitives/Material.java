package primitives;

/**
 *  @author Yahav & Elchanan
 *Describes the Characteristics of the object
 */
public class Material {
	private double kD;
	private double kS;
	private int nShininess;
	double kR;
	double kT;
	
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
		this.kR = 0;
		this.kT = 0;
	}
	 
	 /**
		 * Material parameters constructor.<br>
		 * For a realistic picture we usually want k<sub>D</sub>+k<sub>S</sub><=1 to keep the <strong>Energy Conservation Law</strong> in tact
		 * @param kD diffusive light reflection multiplier (0 to 1)
		 * @param kS specular light reflection multiplier (0 to 1)
		 * @param nShininess shininess level (exponential power) - usually several hundreds
		 * @param kR reflection from the object
		 * @param kT transparency of the object
		 */
		 public Material(double kD,double kS,int nShininess,double kR,double kT) {
			this.kD = kD;
			this.kS = kS;
			this.nShininess = nShininess;
			this.kR = kR;
			this.kT = kT;
		}
	 
	/**
	 * Getter for reflection multipplier for the material
	 * @return the kR
	 */
	public double getkR() {
		return kR;
	}

	/**
	 * Getter for transparency multipplier for the material
	 * @return the kT
	 */
	public double getkT() {
		return kT;
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
