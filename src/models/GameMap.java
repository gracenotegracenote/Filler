package models;

import java.util.List;

/**
 * Author: Liudmila Kachurina (https://github.com/gracenotegracenote)
 * Date: 04-Dec-16
 */
public class GameMap {
	private List<Region> regions;


	public GameMap(List<Region> regions) {
		this.regions = regions;

		for (Region region: regions) {
			region.populateNeighbours(regions);
		}

		double minX = Double.MIN_VALUE;
		double minY = Double.MIN_VALUE;
		for (Region region: regions) {
			for (Point point : region.getBoundary()) {
				if (point.getX() < minX) {
					minX = point.getX();
				}

				if (point.getY() < minY) {
					minY = point.getY();
				}
			}
		}

		for (Region region: regions) {
			for (Point point : region.getBoundary()) {
				point.setX(point.getX() - minX);
				point.setY(point.getY() - minY);
			}
		}
	}


	public List<Region> getRegions() {
		return regions;
	}


	public void makeMove(Region region) {
		// TODO: change color of all the neighbours
	}
}
