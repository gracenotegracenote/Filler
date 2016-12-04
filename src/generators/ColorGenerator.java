package generators;

import java.util.List;

import models.Region;

/**
 * Author: Liudmila Kachurina (https://github.com/gracenotegracenote)
 * Date: 04-Dec-16
 */
public class ColorGenerator {
	private static final int DEFAULT_BASELINE = 169;
	private static final int STEP = 15;

	private int baseline;


	public ColorGenerator() {
		this(DEFAULT_BASELINE);
	}


	public ColorGenerator(int baseline) {
		this.baseline = baseline;
	}


	public String generate(List<Region> regions) {
		return generate(regions, baseline);
	}


	public String generate(List<Region> regions, int color) {
		String stringColor = toHexString(color);
		for (Region region : regions) {
			if (stringColor.equals(region.getColor())) {
				return generate(regions, color + STEP);
			}

		}

		return stringColor;
	}


	private static String toHexString(int color) {
		return Integer.toHexString(color) + Integer.toHexString(color) + Integer.toHexString(color);
	}
}
