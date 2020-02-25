package unittests;

import java.util.List;

import org.junit.Test;

import elements.AmbientLight;
import elements.Camera;
import elements.DirectionalLight;
import elements.LightSource;
import geometries.*;
import primitives.*;
import renderer.ImageWriter;
import renderer.Render;
import scene.Scene;

public class RenderTest {
	@Test
	public void basicRendering(){
		Material material = new Material(0, 0, 0);
		Scene scene = new Scene("Test scene");
		scene.setCamera(new Camera(new Point3D(0, 0, 0), new Vector(0, -1, 0), new Vector(0, 0, 1)),100);
		scene.setBackground(new Color(0, 0, 0));
		AmbientLight ambientLight = new AmbientLight(new Color(100,100,100),1);
		scene.setAmbientLight(ambientLight);
		scene.addLightSorce(new DirectionalLight(new Color(0,0,0),new Vector(-1,0,0)));
		scene.addGeometries(new Sphere(material,new Color(0, 0,0 ), 67, new Point3D(0, 0, 150)));

		scene.addGeometries(new Triangle(material,new Color(0, 0,0 ), new Point3D( 150, 0, 149),
				 							new Point3D(  0, 150, 149),
				 							new Point3D( 150, 150, 149)));

		scene.addGeometries(new Triangle(material,new Color(0, 0,0 ), new Point3D( 150, 0, 149),
				 			 				new Point3D( 0, -150, 149),
				 			 				new Point3D(150,-150, 149)));

		scene.addGeometries(new Triangle(material,new Color(155, 0,0 ), new Point3D(-150, 0, 149),
				 							new Point3D(  0, 150, 149),
				 							new Point3D(-150, 150, 149)));

		scene.addGeometries(new Triangle(material,new Color(0, 155,0 ), new Point3D(-150, 0, 149),
				 			 				new Point3D(  0,  -150, 149),
				 			 				new Point3D(-150, -150, 149)));
		
		scene.addGeometries(new Triangle(material,new Color(0, 155,0 ), new Point3D(-150, 0, 149),
	 				new Point3D(  0,  -150, 149),
	 				new Point3D(-150, -150, 149)));

		ImageWriter imageWriter = new ImageWriter("test0", 500, 500, 500, 500);
		Render render = new Render(imageWriter, scene);

		render.renderImage();
		render.printGrid(50);
		render.getImageWriter().writeToimage();
	}
}