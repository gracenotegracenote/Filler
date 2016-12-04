package models;

/**
 * Created by svchost on 25/11/2016.
 */
public class Point {
	private double x;
	private double y;


	public Point() {}


	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}


	public double getX() {
		return x;
	}


	public void setX(double x) {
		this.x = x;
	}


	public double getY() {
		return y;
	}


	public void setY(double y) {
		this.y = y;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Point that = (Point) o;

		return that.x == x && that.y == y;
	}
}
