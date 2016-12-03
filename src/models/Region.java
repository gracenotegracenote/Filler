package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by svchost on 25/11/2016.
 */
public class Region {
	private static int currentId;

	private int id = 0;
	private String name;
	private List<Coordinates> boundary;
	private List <Coordinates> holes;
	private List<Region> neighbours;

	private Player player;
	private String color;


	public Region() {
		currentId++;
		this.id = currentId;
	}


	public Region(String name) {
		this();
		this.name = name;
		this.boundary = new ArrayList<>();
		this.holes = new ArrayList<>();
		this.neighbours = new ArrayList<>();
	}


	public Region(RegionJson region) {
		this(region.getName());

		double[][] boundaryArray = region.getBoundary();
		for (int i = 0; i < boundaryArray.length; i++) {
			boundary.add(new Coordinates(boundaryArray[i][0], boundaryArray[i][1]));
		}

		if (region.getHoles().length > 0) {
			double[][] holeArray = region.getHoles()[0]; // 1 dimension is completely useless... therefore there is [0] at the end...
			for (int i = 0; i < holeArray.length; i++) {
				boundary.add(new Coordinates(holeArray[i][0], holeArray[i][1]));
			}
		}
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<Coordinates> getBoundary() {
		return boundary;
	}


	public void setBoundary(List<Coordinates> boundary) {
		this.boundary = boundary;
	}


	public List<Coordinates> getHoles() {
		return holes;
	}


	public void setHoles(List<Coordinates> holes) {
		this.holes = holes;
	}


	public List<Region> getNeighbours() {
		return neighbours;
	}


	public void setNeighbours(List<Region> neighbours) {
		this.neighbours = neighbours;
	}


	public String getColor() {
		return player != null ? player.getColor() : color;
	}


	public boolean isNeighbour(Region region) {
		for (Coordinates boundary : this.boundary) {
			for (Coordinates boundary2 : region.getBoundary()) {
				if (boundary.equals(boundary2)) {
					return true;
				}
			}
		}

		return false;
	}


	public void populateNeighbours(List<Region> regions) {
		for (Region region : regions) {
			if (!this.equals(region) && this.isNeighbour(region)) {
				neighbours.add(region);
			}
		}
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Region region = (Region) o;

		return id == region.id;
	}


	@Override
	public int hashCode() {
		return id;
	}
}
