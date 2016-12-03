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
	}


	public List<Region> getRegions() {
		return regions;
	}


	public void makeMove(Region region) {
		// TODO: change color of all the neighbours
	}
}
