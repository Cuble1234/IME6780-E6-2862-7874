package unittests;

import static org.junit.Assert.*;

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
		scene.setCamera(new Camera(new Point3D(0, 0, 0), new Vector(0, -1, 0), new Vector(0, 0, 1)), 100);
		scene.setBackground(new Color(0, 0, 0));
		AmbientLight ambientLight = new AmbientLight(new Color(0, 0, 0), 1);
		scene.setAmbientLight(ambientLight);
		scene.addGeometries(
				new Triangle(new Material(0.5, 0.5, 300), new Color(0, 0, 0), new Point3D(-250, 250, 90),
						new Point3D(-250, -250, 120), new Point3D(250, 250, 90))
				,new Triangle(new Material(0.5, 0.5, 300), new Color(0, 0, 0), new Point3D(248, 248, 90),
						new Point3D(248, -248, 120), new Point3D(-248, -248, 120))
				//,new Sphere(new Material(0.5, 0.5, 300), new Color(0, 0, 100), 60, new Point3D(0, 0, 100))
				);

		ImageWriter imageWriter = new ImageWriter("triangles spot", 500, 500, 500, 500);
		scene.addLightSorce(
				new SpotLight(new Color(400, 200, 200), new Point3D(-50,50,0), 1, 0.0005, 0.000005, new Vector(1, -1, 2)));
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
				//,new Sphere(new Material(0.5, 0.5, 300), new Color(0, 0, 100), 60, new Point3D(0, 0, 100))
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
		scene.setBackground(new Color(0, 0, 0));
		AmbientLight ambientLight = new AmbientLight(new Color(0, 0, 0), 1);
		scene.setAmbientLight(ambientLight);
		scene.addGeometries(
				new Triangle(new Material(0.5, 0.5, 300), new Color(0, 0, 0), new Point3D(-250, 250, 90),
						new Point3D(-250, -250, 120), new Point3D(250, 250, 90))
				,new Triangle(new Material(0.5, 0.5, 300), new Color(0, 0, 0), new Point3D(248, 248, 90),
						new Point3D(248, -248, 120), new Point3D(-248, -248, 120))
		//,new Sphere(new Material(0.5, 0.5, 300), new Color(0, 0, 100), 60, new Point3D(0, 0, 100))
				);
		ImageWriter imageWriter = new ImageWriter("triangles directional", 500, 500, 500, 500);
		scene.addLightSorce(new DirectionalLight(new Color(400, 200, 200), new Vector(1, -1, 2)));
		Render render = new Render(imageWriter, scene);

		render.renderImage();
		render.getImageWriter().writeToimage();
	}

}
