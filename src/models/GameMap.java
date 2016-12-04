package models;

import java.util.List;

import generators.ColorGenerator;

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

		double minX = Double.MAX_VALUE;
		double minY = Double.MAX_VALUE;

		ColorGenerator generator = new ColorGenerator();
		for (Region region: regions) {
			for (Point point : region.getBoundary()) {
				// rotating map
				point.setX(-1 * point.getX());
				point.setY(-1 * point.getY());
				
				if (point.getX() < minX) {
					minX = point.getX();
				}

				if (point.getY() < minY) {
					minY = point.getY();
				}

				region.setColor(generator.generate(region.getNeighbours()));
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


	public void makeMove(Player player, Region region) {
		// TODO: check

		if (region.getPlayer() == null) {
			region.setPlayer(player);
			return;
		}

		for (Region r : region.getNeighbours()) {
			if (r.getPlayer() != null && !player.equals(r.getPlayer())) {
				makeMove(player, r);
			}
		}

		region.setPlayer(player);
	}


	public boolean isGameOver() {
		// TODO: doublecheck

		Player player = null;
		for (Region region : regions) {
			Player regionPlayer = region.getPlayer();

			if (player == null) {
				player = regionPlayer;
			}

			if (player != null && regionPlayer != null && !player.equals(regionPlayer)) {
				return true;
			}
		}

		return false;
	}
}
