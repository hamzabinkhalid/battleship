package battleship;

// A class to represent a ship
class Ship {
  // The size of the ship
  int size;
  // The coordinates of the ship on the board
  int row;
  int col;
  // The orientation of the ship: true for horizontal, false for vertical
  boolean horizontal;
  // The number of hits the ship has taken
  private int hits;

  // A constructor that takes the size, row, col and orientation of the ship
  public Ship(int size, int row, int col, boolean horizontal) {
    if(!isValid(size, row, col, horizontal))
      throw new IllegalArgumentException("Invalid ship parameter(s) passed");
    this.size = size;
    this.row = row;
    this.col = col;
    this.horizontal = horizontal;
    this.hits = 0;

  }

  // A method to check if a given position is occupied by the ship
  public boolean occupies(int r, int c) {
    if (horizontal) {
      return r == row && c >= col && c < col + size;
    } else {
      return c == col && r >= row && r < row + size;
    }
  }

  // A method to check if the ship is sunk
  public boolean isSunk() {
    return hits == size;
  }

  // A method to increase the hit count of the ship
  public void hit() {
    hits++;
  }

  // A helper method to check if a ship is valid
  private boolean isValid(int size, int row, int col, boolean horizontal) {
    // Check if the ship fits within the board boundaries
    if (horizontal) {
      return size >= 1 && row >= 0 && row < Battleship.SIZE && col >= 0 && col + size <= Battleship.SIZE;
    } else {
      return size >= 1 && col >= 0 && col < Battleship.SIZE && row >= 0 && row + size <= Battleship.SIZE;
    }
  }

}

