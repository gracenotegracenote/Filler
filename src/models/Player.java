package models;

/**
 * Author: Liudmila Kachurina (https://github.com/gracenotegracenote)
 * Date: 04-Dec-16
 */
public class Player {
	private int score;
	private String color;


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	@Override
	public boolean equals(Object o) {
		Player other = (Player) o;

		return color.equals(other.getColor()) && score == other.getScore();
	}
}
