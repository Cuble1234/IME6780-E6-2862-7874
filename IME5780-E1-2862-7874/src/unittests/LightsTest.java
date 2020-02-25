/**package unittests;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import elements.AmbientLight;
import elements.Camera;
import elements.DirectionalLight;
import elements.LightSource;
import elements.PointLight;
import elements.SpotLight;
import geometries.Sphere;
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
	public void SpotLightSphereTest() {

		Scene scene = new Scene("sphere point");
		scene.setCamera(new Camera(new Point3D(0, 0, 0), new Vector(0, -1, 0), new Vector(0, 0, 1)), 100);
		scene.setBackground(new Color(0, 0, 0));
		AmbientLight ambientLight = new AmbientLight(new Color(0, 0, 0), 0);
		scene.setAmbientLight(ambientLight);
		scene.addGeometries(new Sphere(new Material(0.5, 0.5, 300), new Color(0, 0, 100), 150, new Point3D(0, 0, 200)),
				new Triangle(new Material(0.5, 0.5, 300), new Color(0, 0, 0), new Point3D(-250, 250, 90),new Point3D(248, -248, 120), new Point3D(-248, -248, 120)));
		ImageWriter imageWriter = new ImageWriter("sphere spot", 500, 500, 500, 500);
		scene.addLightSorce(
				new SpotLight(new Color(400, 200, 200), new Point3D(-50,50,0), 1, 0.0005, 0.000005, new Vector(1, -1, 2)));
		Render render = new Render(imageWriter, scene);

		render.renderImage();
		render.getImageWriter().writeToimage();
	}

	@Test
	public void PointLightSphereTest() {

		Scene scene = new Scene("sphere spot");
		scene.setCamera(new Camera(new Point3D(0, 0, 0), new Vector(0, -1, 0), new Vector(0, 0, 1)), 100);
		scene.setBackground(new Color(0, 0, 0));
		AmbientLight ambientLight = new AmbientLight(new Color(0, 0, 0), 1);
		scene.setAmbientLight(ambientLight);
		scene.addGeometries(new Sphere(new Material(0.5, 0.5, 300), new Color(0, 0, 100), 60, new Point3D(0, 0, 100)));
		ImageWriter imageWriter = new ImageWriter("sphere point", 500, 500, 500, 500);
		scene.addLightSorce(new PointLight(new Color(400, 200, 200), new Point3D(0, 0, 0), 1, 0.004, 0.004));
		Render render = new Render(imageWriter, scene);

		render.renderImage();
		render.getImageWriter().writeToimage();
	}

	@Test
	public void DirectionLightSphereTest() {

		Scene scene = new Scene("sphere directional");
		scene.setCamera(new Camera(new Point3D(0, 0, 0), new Vector(0, -1, 0), new Vector(0, 0, 1)), 100);
		scene.setBackground(new Color(0, 0, 0));
		AmbientLight ambientLight = new AmbientLight(new Color(0, 0, 0), 1);
		scene.setAmbientLight(ambientLight);
		scene.addGeometries(new Sphere(new Material(0.5, 0.5, 300), new Color(0, 0, 100), 60, new Point3D(0, 0, 100)));
		ImageWriter imageWriter = new ImageWriter("sphere directional", 500, 500, 500, 500);
		scene.addLightSorce(new DirectionalLight(new Color(400, 200, 200), new Vector(1, -1, 2)));
		Render render = new Render(imageWriter, scene);

		render.renderImage();
		render.getImageWriter().writeToimage();
	}

	@Test
	public void SpotLightTrianglesTest() {
		Scene scene = new Scene("triangles spot");
		scene.setCamera(new Camera(new Point3D(0, 0, -1000), new Vector(0, -1, 0), new Vector(0, 0, 1)),500);
		scene.setBackground(new Color(0, 0, 0));
		AmbientLight ambientLight = new AmbientLight(new Color(255,255,255), 0);
		scene.setAmbientLight(ambientLight);
		List<LightSource> lights = new ArrayList<LightSource>();
		scene.addGeometries(
				new Triangle (new Material(0.5, 0.5, 300),(new Color(0, 0, 0)), new Point3D(-250, 250, 90),
						new Point3D(-250, -250, 120), new Point3D(250, 250, 90))
				, new Triangle(new Material(0.5, 0.5, 300), new Color(0, 0, 0), new Point3D(248, 248, 90),
						new Point3D(248, -248, 120), new Point3D(-248, -248, 120))
				);

		ImageWriter imageWriter = new ImageWriter("triangles spot", 500, 500, 600, 600);
		lights.add(
				new SpotLight(new Color(255,0,0),new Point3D(0, -30, 90), 0.0000005, 1, 0.00005, new Vector(0, 0.7, 0.3)));		
				Render render = new Render(imageWriter, scene);
				

		render.renderImage();
		render.getImageWriter().writeToimage();
	}

	@Test
	public void PointLightTrianglesTest() {
		Scene scene = new Scene("Triangles point");
		scene.setCamera(new Camera(new Point3D(0, 0, 0), new Vector(0, -1, 0), new Vector(0, 0, 1)), 100);
		scene.setBackground(new Color(0, 0, 0));
		AmbientLight ambientLight = new AmbientLight(new Color(0, 0, 0), 1);
		scene.setAmbientLight(ambientLight);
		scene.addGeometries(
				new Triangle(new Material(0.5, 0.5, 300), new Color(0, 0, 0), new Point3D(-250, 250, 90),
						new Point3D(-250, -250, 120), new Point3D(250, 250, 90))
				,new Triangle(new Material(0.5, 0.5, 300), new Color(0, 0, 0), new Point3D(248, 248, 90),
						new Point3D(248, -248, 120), new Point3D(-248, -248, 120))
				,new Sphere(new Material(0.5, 0.5, 300), new Color(0, 0, 100), 60, new Point3D(0, 0, 100))
				);
		ImageWriter imageWriter = new ImageWriter("Triangles point", 500, 500, 500, 500);
		scene.addLightSorce(new PointLight(new Color(400, 200, 200), new Point3D(0, 0, 0), 1, 0.004, 0.004));
		Render render = new Render(imageWriter, scene);

		render.renderImage();
		render.getImageWriter().writeToimage();
	}

	@Test
	public void DirectionalLightTrianglesTest() {
		Scene scene = new Scene("triangles directional");
		scene.setCamera(new Camera(new Point3D(0, 0, 0), new Vector(0, -1, 0), new Vector(0, 0, 1)), 100);
		scene.setBackground(new Color(0, 255, 0));
		AmbientLight ambientLight = new AmbientLight(new Color(0, 0, 0), 1);
		scene.setAmbientLight(ambientLight);
		scene.addGeometries(
				new Triangle(new Material(0.5, 0.5, 300), new Color(0, 0, 0), new Point3D(-250, 250, 90),
						new Point3D(-250, -250, 120), new Point3D(250, 250, 90))
				,new Triangle(new Material(0.5, 0.5, 300), new Color(0, 0, 0), new Point3D(248, 248, 90),
						new Point3D(248, -248, 120), new Point3D(-248, -248, 120))
		,new Sphere(new Material(0.5, 0.5, 300), new Color(0, 0, 100), 60, new Point3D(0, 0, 100))
				);
		ImageWriter imageWriter = new ImageWriter("triangles directional", 500, 500, 500, 500);
		scene.addLightSorce(new DirectionalLight(new Color(400, 200, 200), new Vector(1, -1, 2)));
		Render render = new Render(imageWriter, scene);

		render.renderImage();
		render.getImageWriter().writeToimage();
	}

}
**/

package unittests;

import elements.*;
import geometries.*;
import org.junit.Test;
import primitives.Color;
import primitives.Material;
import primitives.Point3D;
import primitives.Vector;
import renderer.ImageWriter;
import renderer.Render;
import scene.Scene;
import java.util.ArrayList;
import java.util.List;

public class LightsTest {
	/*
	 * public Scene createScene(String name) { Scene scene = new Scene(name);
	 * scene.setCamera(new Camera(new Point3D(0, 0, 0), new Vector(0, -1, 0), new
	 * Vector(0, 0, 1))); scene.setDistance(200); scene.setAmbient(new
	 * AmbientLight(new Color(255, 255, 255), 0)); scene.setBackground(Color.BLACK);
	 * scene.setSampleCount(80); return scene; }
	 */
	/**
	 * test case for lighting
	 */
	@Test
	public void lightingTest() {
		Scene scene = new Scene("Basic Light Tests");
		scene.setCamera(new Camera(new Point3D(0, 0, -1000), new Vector(0, -1, 0), new Vector(0, 0, 1)), 1000);
		scene.setAmbientLight(new AmbientLight(new Color(255, 255, 255), 0));
		scene.setBackground(Color.BLACK);
		Triangle triangle1 = new Triangle(new Material(0.5, 0.5, 300), new Color(0, 0, 0), new Point3D(-250, 250, 90),
				new Point3D(-250, -250, 120), new Point3D(250, 250, 90));
		Triangle triangle2 = new Triangle(new Material(0.5, 0.5, 300), new Color(0, 0, 0), new Point3D(248, 248, 90),
				new Point3D(248, -248, 120), new Point3D(-248, -248, 120));
		scene.addGeometries(triangle1, triangle2);
		Point3D pos = new Point3D(0, -30, 90);
		Color color = new Color(java.awt.Color.pink);

		// test 1 - 2 triangles with point light
		ImageWriter imageWriter = new ImageWriter("PL triangles", 500, 500, 600, 600);
		PointLight light1 = new PointLight(color, pos, 1, 0.00005, 0.0000005);
		scene.addLightSorce(light1);
		Render render = new Render(imageWriter, scene);
		render.renderImage();
		render.getImageWriter().writeToimage();

		// test 2 - 2 triangles with spot light
		imageWriter = new ImageWriter("SP triangles", 500, 500, 600, 600);
		SpotLight light2 = new SpotLight(color, pos, 0.0000005, 1, 0.00005, new Vector(0, 0.7, 0.3));
		scene.addLightSorce(light2);
		render = new Render(imageWriter, scene);
		render.renderImage();
		render.getImageWriter().writeToimage();

		// test 3 - 2 triangles with directional light
		imageWriter = new ImageWriter("DL triangles", 500, 500, 600, 600);
		DirectionalLight light3 = new DirectionalLight(new Color(400, 300, 300), new Vector(0, 0, 1));
		scene.addLightSorce(light3);
		render = new Render(imageWriter, scene);
		render.renderImage();
		render.getImageWriter().writeToimage();

		Sphere sphere = new Sphere(new Material(0.5, 0.5, 300), new Color(0, 0, 100), 50, new Point3D(0, 0, 100));
		scene.addGeometries(sphere);
		color = new Color(400, 300, 300);
		pos = new Point3D(-50, 50, 0);

		// test 1 - sphere with point light
		imageWriter = new ImageWriter("PL sphere", 500, 500, 600, 600);
		PointLight pointLight2 = new PointLight(color, pos, 1, 0.0005, 0.000005);
		scene.addLightSorce(pointLight2);
		render = new Render(imageWriter, scene);
		render.renderImage();
		render.getImageWriter().writeToimage();

		// test 2 - sphere with spot light
		imageWriter = new ImageWriter("SL sphere", 500, 500, 600, 600);
		SpotLight spotLight2 = new SpotLight(color, pos, 0.000005, 1, 0.0005, new Vector(1, -1, 2));
		scene.addLightSorce(spotLight2);
		render = new Render(imageWriter, scene);
		render.renderImage();
		render.getImageWriter().writeToimage();

		// test 3 - sphere with directional light
		imageWriter = new ImageWriter("DL sphere", 500, 500, 600, 600);
		DirectionalLight Directional2 = new DirectionalLight(new Color(400, 300, 300), new Vector(1, -1, 2));
		scene.addLightSorce(Directional2);
		render = new Render(imageWriter, scene);
		render.renderImage();
		render.getImageWriter().writeToimage();
	}

	@Test
	public void shadowTest() {
		Scene scene = new Scene("Shadow tests");
		scene.setCamera(new Camera(new Point3D(0, 0, -1000), new Vector(0, -1, 0), new Vector(0, 0, 1)), 1000);
		scene.setAmbientLight(new AmbientLight(new Color(255, 255, 255), 0));
		scene.setBackground(Color.BLACK);
		scene.addGeometries(new Sphere(new Material(0.5, 0.5, 300), new Color(0, 0, 100), 50, new Point3D(0, 0, 100)),
				new Triangle(new Material(0.5, 0.5, 300), new Color(0, 0, 100), new Point3D(-30, 25, 40),
						new Point3D(-30, 15, 40), new Point3D(-20, 25, 40)));
		Color color = new Color(400, 300, 300);
		Point3D pos = new Point3D(-35, 30, 0);

		ImageWriter imageWriter = new ImageWriter("PL sphere shadow", 500, 500, 600, 600);
		PointLight point_light = new PointLight(color, pos, 1, 0.0005, 0.000005);
		scene.addLightSorce(point_light);
		Render render = new Render(imageWriter, scene);
		render.renderImage();
		render.getImageWriter().writeToimage();

		imageWriter = new ImageWriter("DL sphere shadow", 500, 500, 600, 600);
		DirectionalLight directional_light = new DirectionalLight(new Color(400, 300, 300), new Vector(1, -1, 2));
		scene.addLightSorce(directional_light);
		render = new Render(imageWriter, scene);
		render.renderImage();
		render.getImageWriter().writeToimage();

		imageWriter = new ImageWriter("SL sphere shadow", 500, 500, 600, 600);
		SpotLight spot_light = new SpotLight(color, pos, 0.000005, 1, 0.0005, new Vector(1, 2, 3));
		scene.addLightSorce(spot_light);
		render = new Render(imageWriter, scene);
		render.renderImage();
		render.getImageWriter().writeToimage();

		scene.addGeometries(new Sphere(new Material(0.5, 0.5, 300), new Color(0, 0, 100), 50, new Point3D(0, 0, 100)),
		(new Sphere(new Material(0.5, 0.5, 300), new Color(0, 0, 100), 50, new Point3D(0, 0, 100))),new Triangle(new Material(0.5, 0.5, 300), new Color(0, 0, 100), new Point3D(-30, 20, 40),
				new Point3D(-30, 10, 40), new Point3D(-20, 20, 40)));

		imageWriter = new ImageWriter("PL sphere shadow pos2", 500, 500, 600, 600);
		point_light = new PointLight(color, pos, 1, 0.0005, 0.000005);
		scene.addLightSorce(point_light);
		render = new Render(imageWriter, scene);
		render.renderImage();
		render.getImageWriter().writeToimage();

		scene.addGeometries(new Triangle(new Material(0.5, 0.5, 300), new Color(0, 0, 100), new Point3D(-20, 20, 40),
				new Point3D(-20, 10, 40), new Point3D(-10, 20, 40)));

		imageWriter = new ImageWriter("PL sphere shadow pos3", 500, 500, 600, 600);
		point_light = new PointLight(color, pos, 1, 0.0005, 0.000005);
		scene.addLightSorce(point_light);
		render = new Render(imageWriter, scene);
		render.renderImage();
		render.getImageWriter().writeToimage();
	}
}