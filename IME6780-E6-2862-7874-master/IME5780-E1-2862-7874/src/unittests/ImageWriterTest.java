package unittests;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

import renderer.ImageWriter;

public class ImageWriterTest {

	@Test
	public void testImageWriterStringDoubleDoubleIntInt() {
		ImageWriter image = new ImageWriter("First image", 1000, 1000, 500, 500);
		Color grid = new Color(0, 255, 0);
		for (int i = 0; i < 500; i += 50)
			for (int j = 0; j < 500; ++j) {
				if ((i == 0 && j == 0) || (i == 0 && j % 50 != 0) || (i == 500 && j == 500) || (i == 500 && j % 50 != 0)
						|| (j == 0 && i % 50 != 0) || (j == 500 && i % 50 != 0)) {

				} else {
					image.writePixel(i, j, grid);
					image.writePixel(j, i, grid);
				}

			}

		image.writeToimage();
	}

}
