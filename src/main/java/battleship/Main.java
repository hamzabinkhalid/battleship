package battleship;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

// A class to simulate the battleship and the ships
class Main {
  private static final Logger logger = LogManager.getLogger(Main.class);
  Battleship battleship = null;

  public void playGame() {
    int choice;
    Scanner reader = new Scanner(System.in);
    while (true) {
      StringBuilder sb = new StringBuilder();
      sb.append("\nEnter your choice: ");
      sb.append("\n1: Add a battleship");
      sb.append("\n2: Take attack");
      sb.append("\n3: Exit");
      logger.info(sb);
      logger.info("Enter choice: ");
      choice = reader.nextInt();

      if (choice == 1) {
        if(battleship == null) battleship = new Battleship();

        logger.info("Enter size: ");
        int size = reader.nextInt();

        logger.info("Enter row: ");
        int row = reader.nextInt();

        logger.info("Enter column: ");
        int column = reader.nextInt();

        logger.info("Is ship to be added horizontal? (y/n): ");
        String horString = reader.next();

        boolean horizontal = horString.equals("y");
        battleship.addShip(new Ship(size, row, column, horizontal));
        battleship.printBoard();

      }else if(choice == 2){
        logger.info("Enter row: ");
        int row = reader.nextInt();

        logger.info("Enter column: ");
        int column = reader.nextInt();

        if(logger.isInfoEnabled())
          logger.info(battleship.attack(row, column));
        battleship.printBoard();
      }else if(choice == 3) {
        logger.info("Bye!");
        reader.close();
        return;
      }
      else logger.info("Invalid Choice!");
    }
  }

  public static void main(String[] args) {
      Main main = new Main();
      main.playGame();
    }
}