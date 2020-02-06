package unittests;

import static org.junit.Assert.*;

import org.junit.Test;

import primitives.Vector;

public class VectorTests {
	/**
	 * Vectors test
	 */
	public static Vector vec1 = new Vector(3.5,-5,10);
	public static Vector vec2 = new Vector(-3.5,5,-10);
	public static Vector vec3 = new Vector(5,6,8);
	/**
	 * test Method for {@link primitives.Vector#add(primitives.Vector)}.
	 */
	@Test
	public void testAdd() {
		try {
			vec1.add(vec2);
			fail("Didn't throw vector 0 exception");
		}
		catch(IllegalArgumentException e) {
			assertTrue(true);
		}
		Vector vec4 = new Vector (1.5,11,-2);
		assertEquals("Didn't add correct",vec4,vec3.add(vec2));
	}
	/**
	 * test Method for {@link primitives.Vector#subtract(primitives.Vector)}.
	 */
	@Test
	public void testSubtract() {
		Vector vec4 = new Vector (8.5,1,18);
		assertEquals("Didn't subtract correct",vec4,vec3.subtract(vec2));
	}
	/**
	 * test Method for {@link primitives.Vector#scale(double)}.
	 */
	@Test
	public void testScale() {
		Vector vec4 = new Vector (10,12,16);
		assertEquals("Didn't scale correct",vec4,vec3.scale(2));
	}
	/**
	 * test Method for {@link primitives.Vector#dotProduct(primitives.Vector)}.
	 */
	@Test
	public void testDotProduct() {
		assertEquals("Didn't do dot product correct",-67.5,vec3.dotProduct(vec2),1e-10);
	}
	/**
	 * test Method for {@link primitives.Vector#crossProduct(primitives.Vector)}.
	 */
	@Test
	public void testCrossProduct() {
		Vector vec4 = new Vector(100,-22,-46);
		assertEquals("Didn't do cross product correct",vec4,vec2.crossProduct(vec3));
	}

	@Test
	public void testLength() {
		assertEquals("Didn't calculate length correct",11.18,vec3.length(),1e-2);
	}

	@Test
	public void testNormal() {
		vec1.normal();
		assertEquals("",1,vec1.length(),1e-10);
	}

}
