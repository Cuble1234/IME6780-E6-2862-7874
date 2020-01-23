package unittests;

import static org.junit.Assert.*;

import org.junit.Test;

import elements.AmbientLight;
import elements.Camera;
import elements.PointLight;
import geometries.Triangle;
import primitives.Color;
import primitives.Material;
import primitives.Point3D;
import primitives.Vector;
import renderer.ImageWriter;
import renderer.Render;
import scene.Scene;

public class LightsTest {

	@Test
	public void SpotLighttest() {
		
		Scene scene = new Scene("Test scene");
		scene.setCamera(new Camera(new Point3D(0, 0, 0), new Vector(0, -1, 0), new Vector(0, 0, 1)), 100);
		scene.setBackground(new Color(0, 0, 0));
		AmbientLight ambientLight = new AmbientLight(new Color(0, 0, 0), 1);
		scene.setAmbientLight(ambientLight);
		scene.addGeometries(
				new Triangle(new Material(0.5,0.5,300),new Color(0,0,0),new Point3D(-250, 250, 90), new Point3D(-250, -250, 120), new Point3D(250, 250, 90)),
				new Triangle(new Material(0.5,0.5,300),new Color(0,0,0),new Point3D(248, 248, 90), new Point3D(248,-248,120),new Point3D(-248,-248,120)));
		ImageWriter imageWriter = new ImageWriter("test1", 500, 500, 500, 500);
		scene.addLightSorce(new PointLight(new Color(400,200,200),new Point3D(1,-1,85),1,0.004,0.004));
		Render render = new Render(imageWriter, scene);
		

		render.renderImage();
		render.getImageWriter().writeToimage();
	}

}
