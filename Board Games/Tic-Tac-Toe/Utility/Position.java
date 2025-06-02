package Utility;

public class Position {

	public int row, col;

	public Position(int row, int col) {
		this.row = row;
		this.col = col;
	}

	@Override
	public String toString() {
		return "(" + row + ", " + col + ")";
	}

}