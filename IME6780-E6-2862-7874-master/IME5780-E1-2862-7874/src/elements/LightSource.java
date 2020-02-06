/**
 * 
 */
package elements;

import geometries.Intersectable;
import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

/**
 * @author elhan
 *
 */
public interface LightSource {
	public Color getIntensity(Point3D point);
	public Vector getL(Point3D point);
	
}
