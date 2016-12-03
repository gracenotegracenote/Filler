package models;

public class RegionJson {
    private String name;
	private double[][] boundary;
	private double[][][] holes;


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double[][] getBoundary() {
		return boundary;
	}


	public void setBoundary(double[][] boundary) {
		this.boundary = boundary;
	}


	public double[][][] getHoles() {
		return holes;
	}


	public void setHoles(double[][][] holes) {
		this.holes = holes;
	}
}
