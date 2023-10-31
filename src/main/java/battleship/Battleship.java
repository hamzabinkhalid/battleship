package battleship;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// A class to represent Battleship, Singleton pattern
class Battleship {
  private static final Logger logger = LogManager.getLogger(Battleship.class);
  // The size of the board
  static final int SIZE = 10;
  // A two-dimensional array to store the board cells
  private final char[][] board;
  // A list of ships on the board
  private final List<Ship> ships;

  // A constructor that takes the size of the board
  public Battleship() {
    this.board = new char[SIZE][SIZE];
    this.ships = new ArrayList<>();
    // Fill the board with empty cells
    for (int i = 0; i < SIZE; i++) {
      Arrays.fill(board[i], '.');
    }
  }

  // A method to add a ship to the board
  public void addShip(Ship ship) {
    // Check if the ship overlaps with any existing ship
    if(overlaps(ship)) throw new IllegalArgumentException("Cannot put a ship on any occupied square");

    ships.add(ship);
    // Mark the board with the ship's symbol
    char symbol = (char) ('A' + ships.size() - 1);
    for (int i = 0; i < ship.size; i++) {
      if (ship.horizontal) {
        board[ship.row][ship.col + i] = symbol;
      } else {
        board[ship.row + i][ship.col] = symbol;
      }
    }
  }

  // A helper method to check if the ship overlaps with any existing ship
  boolean overlaps(Ship ship) {
    for (Ship s : ships) {
      for (int i = 0; i < ship.size; i++) {
        if (ship.horizontal) {
          if (s.occupies(ship.row, ship.col + i)) {
            return true;
          }
        } else {
          if (s.occupies(ship.row + i, ship.col)) {
            return true;
          }
        }
      }
    }
    return false;
  }

  // A method to take an attack at a given position and report back the result
  public String attack(int r, int c) {
      // Check if the position is valid
      if (r < 0 || r >= SIZE || c < 0 || c >= SIZE) {
        return "Invalid position provided";
      }
      // Check if the position has been attacked before
      if (board[r][c] == 'X' || board[r][c] == 'O') {
        return "Position already attacked";
      }
      // Check if the position hits any ship
      for (Ship s : ships) {
        if (s.occupies(r, c)) {
          s.hit();
          board[r][c] = 'X'; // Mark the board with a hit symbol
          if (s.isSunk()) {
            // Return the output after checking if player has lost the game
            return hasLost() ? "All Battleships Sunk, you lost" : "Hit and sunk";
          } else {
            return "Hit";
          }
        }
      }
      // If no ship is hit, mark the board with a miss symbol
      board[r][c] = 'O';
      return "Miss";
  }

  // A method to return whether the player has lost the game yet
  public boolean hasLost() {
    if(!ships.isEmpty()){
      // Check if all the ships are sunk
      for (Ship s : ships) {
        if (!s.isSunk()) {
          return false;
        }
      }
    }
    return true;
  }

  // A method to print the board
  public void printBoard() {
    // Print the column numbers
    StringBuilder sb = new StringBuilder();
    sb.append("\n  ");
    for (int i = 0; i < SIZE; i++) {
      sb.append(i).append(" ");
    }
    sb.append("\n");
    // Print the board cells and the row numbers
    for (int i = 0; i < SIZE; i++) {
      sb.append(i).append(" ");
      for (int j = 0; j < SIZE; j++) {
        sb.append(board[i][j]).append(" ");
      }
      sb.append("\n");
    }
    logger.info(sb);
  }
}