package elements;

import primitives.*;

public class Camera {
	private Point3D p0;
	private Vector vUp;
	private Vector vTo;
	private Vector vRight;

	public Camera(Point3D p0, Vector vUp, Vector vTo) {
		this.p0 = p0;
		this.vUp = vUp.normal();
		this.vTo = vTo.normal();
		this.vRight = vTo.crossProduct(vUp).normal();
	}

	/**
	 * @return the p0
	 */
	public Point3D getP0() {
		return p0;
	}

	/**
	 * @return the vUp
	 */
	public Vector getvUp() {
		return vUp;
	}

	/**
	 * @return the vTo
	 */
	public Vector getvTo() {
		return vTo;
	}

	/**
	 * @return the vRight
	 */
	public Vector getvRight() {
		return vRight;
	}
	/**
	 * get a pixel  and return a ray
	 * @param nX
	 * @param nY
	 * @param j
	 * @param i
	 * @param screenDistance
	 * @param screenWidth
	 * @param screenHight
	 * @return
	 */
	public Ray constructRayThroughPixel(int nX, int nY, int j, int i, double screenDistance, double screenWidth,
			double screenHight) {
		Point3D pCenter = this.p0.add(this.vTo.scale(screenDistance));
		double rY = screenHight/nY;
		double rX = screenWidth/nX;
		double yI = ((i-nY/2.0)*rY)+(rY/2);
		double xJ = ((j-nX/2.0)*rX)+(rX/2);
		Point3D pIJ = new Point3D(pCenter);
		if (xJ != 0) pIJ = pIJ.add(vRight.scale(xJ));
		if (yI != 0) pIJ = pIJ.add(vUp.scale(-yI));
		Vector vIJ = new Vector(pIJ.subtract(this.p0));
		Ray ray = new Ray(this.p0,vIJ.normal());
		return ray;
	}

}
