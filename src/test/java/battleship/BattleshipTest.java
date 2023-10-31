package battleship;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BattleshipTest {

    /**
     * Method under test: {@link Battleship#addShip(Ship)}
     */
    @Test
    void testAddShipSuccessfullyAddsNewShip() {
        Battleship battleship = new Battleship();
        Ship ship = new Ship(3, 1, 1, true);
        battleship.addShip(ship);
        assertTrue(battleship.overlaps(ship));
    }

    /**
     * Method under test: {@link Battleship#addShip(Ship)}
     */
    @Test
    void addShipShouldThrowExceptionWhenShipBeingAddedIncludesOccupiedSquare() {
        Battleship battleship = new Battleship();
        Ship ship = new Ship(3, 1, 1, true);
        Ship ship2 = new Ship(1, 1, 1, false);

        battleship.addShip(ship);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> battleship.addShip(ship2));

        assertEquals("Cannot put a ship on any occupied square", exception.getMessage());
    }

    /**
     * Method under test: {@link Battleship#attack(int, int)}
     */
    @Test
    void testAttackReturnsAlreadyAttackedWhenAttackingSquareMultipleTimes() {
        Battleship battleship = new Battleship();
        battleship.addShip(new Ship(1, 0, 0, true));
        battleship.addShip(new Ship(1, 1, 1, true));
        assertEquals("Hit and sunk", battleship.attack(0, 0));
        assertEquals("Position already attacked", battleship.attack(0, 0));
    }

    /**
     * Method under test: {@link Battleship#attack(int, int)}
     */
    @Test
    void testAttackReturnsHitAndSunkForHorizontalShipOfSizeOne() {
        Battleship battleship = new Battleship();
        battleship.addShip(new Ship(1, 9, 9, false));
        battleship.addShip(new Ship(1, 0, 0, true));
        assertEquals("Hit and sunk", battleship.attack(0, 0));
    }

    /**
     * Method under test: {@link Battleship#attack(int, int)}
     */
    @Test
    void testAttackReturnsHitAndSunkForHorizontalShipOfSizeTwo() {
        Battleship battleship = new Battleship();
        battleship.addShip(new Ship(1, 9, 9, false));
        battleship.addShip(new Ship(2, 0, 0, true));
        assertEquals("Hit", battleship.attack(0, 0));
        assertEquals("Hit and sunk", battleship.attack(0, 1));
    }

    /**
     * Method under test: {@link Battleship#attack(int, int)}
     */
    @Test
    void testAttackReturnsHitAndSunkForHorizontalShipOfSizeThree() {
        Battleship battleship = new Battleship();
        battleship.addShip(new Ship(1, 9, 9, false));
        battleship.addShip(new Ship(3, 0, 0, true));
        assertEquals("Hit", battleship.attack(0, 0));
        assertEquals("Hit", battleship.attack(0, 1));
        assertEquals("Hit and sunk", battleship.attack(0, 2));
    }

    /**
     * Method under test: {@link Battleship#attack(int, int)}
     */
    @Test
    void testAttackReturnsHitAndSunkForHorizontalShipOfSizeFour() {
        Battleship battleship = new Battleship();
        battleship.addShip(new Ship(1, 9, 9, false));
        battleship.addShip(new Ship(4, 0, 0, true));
        assertEquals("Hit", battleship.attack(0, 0));
        assertEquals("Hit", battleship.attack(0, 1));
        assertEquals("Hit", battleship.attack(0, 2));
        assertEquals("Hit and sunk", battleship.attack(0, 3));
    }

    /**
     * Method under test: {@link Battleship#attack(int, int)}
     */
    @Test
    void testAttackReturnsHitAndSunkForHorizontalShipOfSizeFive() {
        Battleship battleship = new Battleship();
        battleship.addShip(new Ship(1, 9, 9, false));
        battleship.addShip(new Ship(5, 0, 0, true));
        assertEquals("Hit", battleship.attack(0, 0));
        assertEquals("Hit", battleship.attack(0, 1));
        assertEquals("Hit", battleship.attack(0, 2));
        assertEquals("Hit", battleship.attack(0, 3));
        assertEquals("Hit and sunk", battleship.attack(0, 4));
    }

    /**
     * Method under test: {@link Battleship#attack(int, int)}
     */
    @Test
    void testAttackReturnsHitAndSunkForHorizontalShipOfSizeSix() {
        Battleship battleship = new Battleship();
        battleship.addShip(new Ship(1, 9, 9, false));
        battleship.addShip(new Ship(6, 0, 0, true));
        assertEquals("Hit", battleship.attack(0, 0));
        assertEquals("Hit", battleship.attack(0, 1));
        assertEquals("Hit", battleship.attack(0, 2));
        assertEquals("Hit", battleship.attack(0, 3));
        assertEquals("Hit", battleship.attack(0, 4));
        assertEquals("Hit and sunk", battleship.attack(0, 5));
    }

    /**
     * Method under test: {@link Battleship#attack(int, int)}
     */
    @Test
    void testAttackReturnsHitAndSunkForHorizontalShipOfSizeSeven() {
        Battleship battleship = new Battleship();
        battleship.addShip(new Ship(1, 9, 9, false));
        battleship.addShip(new Ship(7, 0, 0, true));
        assertEquals("Hit", battleship.attack(0, 0));
        assertEquals("Hit", battleship.attack(0, 1));
        assertEquals("Hit", battleship.attack(0, 2));
        assertEquals("Hit", battleship.attack(0, 3));
        assertEquals("Hit", battleship.attack(0, 4));
        assertEquals("Hit", battleship.attack(0, 5));
        assertEquals("Hit and sunk", battleship.attack(0, 6));
    }

    /**
     * Method under test: {@link Battleship#attack(int, int)}
     */
    @Test
    void testAttackReturnsHitAndSunkForHorizontalShipOfSizeEight() {
        Battleship battleship = new Battleship();
        battleship.addShip(new Ship(1, 9, 9, false));
        battleship.addShip(new Ship(8, 0, 0, true));
        assertEquals("Hit", battleship.attack(0, 0));
        assertEquals("Hit", battleship.attack(0, 1));
        assertEquals("Hit", battleship.attack(0, 2));
        assertEquals("Hit", battleship.attack(0, 3));
        assertEquals("Hit", battleship.attack(0, 4));
        assertEquals("Hit", battleship.attack(0, 5));
        assertEquals("Hit", battleship.attack(0, 6));
        assertEquals("Hit and sunk", battleship.attack(0, 7));
    }

    /**
     * Method under test: {@link Battleship#attack(int, int)}
     */
    @Test
    void testAttackReturnsHitAndSunkForHorizontalShipOfSizeNine() {
        Battleship battleship = new Battleship();
        battleship.addShip(new Ship(1, 9, 9, false));
        battleship.addShip(new Ship(9, 0, 0, true));
        assertEquals("Hit", battleship.attack(0, 0));
        assertEquals("Hit", battleship.attack(0, 1));
        assertEquals("Hit", battleship.attack(0, 2));
        assertEquals("Hit", battleship.attack(0, 3));
        assertEquals("Hit", battleship.attack(0, 4));
        assertEquals("Hit", battleship.attack(0, 5));
        assertEquals("Hit", battleship.attack(0, 6));
        assertEquals("Hit", battleship.attack(0, 7));
        assertEquals("Hit and sunk", battleship.attack(0, 8));
    }

    /**
     * Method under test: {@link Battleship#attack(int, int)}
     */
    @Test
    void testAttackReturnsHitAndSunkForHorizontalShipOfSizeTen() {
        Battleship battleship = new Battleship();
        battleship.addShip(new Ship(1, 1, 9, false));
        battleship.addShip(new Ship(10, 0, 0, true));
        assertEquals("Hit", battleship.attack(0, 0));
        assertEquals("Hit", battleship.attack(0, 1));
        assertEquals("Hit", battleship.attack(0, 2));
        assertEquals("Hit", battleship.attack(0, 3));
        assertEquals("Hit", battleship.attack(0, 4));
        assertEquals("Hit", battleship.attack(0, 5));
        assertEquals("Hit", battleship.attack(0, 6));
        assertEquals("Hit", battleship.attack(0, 7));
        assertEquals("Hit", battleship.attack(0, 8));
        assertEquals("Hit and sunk", battleship.attack(0, 9));
    }

    /**
     * Method under test: {@link Battleship#attack(int, int)}
     */
    @Test
    void testAttackReturnsHitAndSunkForVerticalShipOfSizeOne() {
        Battleship battleship = new Battleship();
        battleship.addShip(new Ship(1, 9, 9, false));
        battleship.addShip(new Ship(1, 0, 0, false));
        assertEquals("Hit and sunk", battleship.attack(0, 0));
    }

    /**
     * Method under test: {@link Battleship#attack(int, int)}
     */
    @Test
    void testAttackReturnsHitAndSunkForVerticalShipOfSizeTwo() {
        Battleship battleship = new Battleship();
        battleship.addShip(new Ship(1, 9, 9, false));
        battleship.addShip(new Ship(2, 0, 0, false));
        assertEquals("Hit", battleship.attack(0, 0));
        assertEquals("Hit and sunk", battleship.attack(1, 0));
    }

    /**
     * Method under test: {@link Battleship#attack(int, int)}
     */
    @Test
    void testAttackReturnsHitAndSunkForVerticalShipOfSizeThree() {
        Battleship battleship = new Battleship();
        battleship.addShip(new Ship(1, 9, 9, false));
        battleship.addShip(new Ship(3, 0, 0, false));
        assertEquals("Hit", battleship.attack(0, 0));
        assertEquals("Hit", battleship.attack(1, 0));
        assertEquals("Hit and sunk", battleship.attack(2, 0));
    }

    /**
     * Method under test: {@link Battleship#attack(int, int)}
     */
    @Test
    void testAttackReturnsHitAndSunkForVerticalShipOfSizeFour() {
        Battleship battleship = new Battleship();
        battleship.addShip(new Ship(1, 9, 9, false));
        battleship.addShip(new Ship(4, 0, 0, false));
        assertEquals("Hit", battleship.attack(0, 0));
        assertEquals("Hit", battleship.attack(1, 0));
        assertEquals("Hit", battleship.attack(2, 0));
        assertEquals("Hit and sunk", battleship.attack(3, 0));
    }

    /**
     * Method under test: {@link Battleship#attack(int, int)}
     */
    @Test
    void testAttackReturnsHitAndSunkForVerticalShipOfSizeFive() {
        Battleship battleship = new Battleship();
        battleship.addShip(new Ship(1, 9, 9, false));
        battleship.addShip(new Ship(5, 0, 0, false));
        assertEquals("Hit", battleship.attack(0, 0));
        assertEquals("Hit", battleship.attack(1, 0));
        assertEquals("Hit", battleship.attack(2, 0));
        assertEquals("Hit", battleship.attack(3, 0));
        assertEquals("Hit and sunk", battleship.attack(4, 0));
    }

    /**
     * Method under test: {@link Battleship#attack(int, int)}
     */
    @Test
    void testAttackReturnsHitAndSunkForVerticalShipOfSizeSix() {
        Battleship battleship = new Battleship();
        battleship.addShip(new Ship(1, 9, 9, false));
        battleship.addShip(new Ship(6, 0, 0, false));
        assertEquals("Hit", battleship.attack(0, 0));
        assertEquals("Hit", battleship.attack(1, 0));
        assertEquals("Hit", battleship.attack(2, 0));
        assertEquals("Hit", battleship.attack(3, 0));
        assertEquals("Hit", battleship.attack(4, 0));
        assertEquals("Hit and sunk", battleship.attack(5, 0));
    }

    /**
     * Method under test: {@link Battleship#attack(int, int)}
     */
    @Test
    void testAttackReturnsHitAndSunkForVerticalShipOfSizeSeven() {
        Battleship battleship = new Battleship();
        battleship.addShip(new Ship(1, 9, 9, false));
        battleship.addShip(new Ship(7, 0, 0, false));
        assertEquals("Hit", battleship.attack(0, 0));
        assertEquals("Hit", battleship.attack(1, 0));
        assertEquals("Hit", battleship.attack(2, 0));
        assertEquals("Hit", battleship.attack(3, 0));
        assertEquals("Hit", battleship.attack(4, 0));
        assertEquals("Hit", battleship.attack(5, 0));
        assertEquals("Hit and sunk", battleship.attack(6, 0));
    }

    /**
     * Method under test: {@link Battleship#attack(int, int)}
     */
    @Test
    void testAttackReturnsHitAndSunkForVerticalShipOfSizeEight() {
        Battleship battleship = new Battleship();
        battleship.addShip(new Ship(1, 9, 9, false));
        battleship.addShip(new Ship(8, 0, 0, false));
        assertEquals("Hit", battleship.attack(0, 0));
        assertEquals("Hit", battleship.attack(1, 0));
        assertEquals("Hit", battleship.attack(2, 0));
        assertEquals("Hit", battleship.attack(3, 0));
        assertEquals("Hit", battleship.attack(4, 0));
        assertEquals("Hit", battleship.attack(5, 0));
        assertEquals("Hit", battleship.attack(6, 0));
        assertEquals("Hit and sunk", battleship.attack(7, 0));
    }

    /**
     * Method under test: {@link Battleship#attack(int, int)}
     */
    @Test
    void testAttackReturnsHitAndSunkForVerticalShipOfSizeNine() {
        Battleship battleship = new Battleship();
        battleship.addShip(new Ship(1, 9, 9, false));
        battleship.addShip(new Ship(9, 0, 0, false));
        assertEquals("Hit", battleship.attack(0, 0));
        assertEquals("Hit", battleship.attack(1, 0));
        assertEquals("Hit", battleship.attack(2, 0));
        assertEquals("Hit", battleship.attack(3, 0));
        assertEquals("Hit", battleship.attack(4, 0));
        assertEquals("Hit", battleship.attack(5, 0));
        assertEquals("Hit", battleship.attack(6, 0));
        assertEquals("Hit", battleship.attack(7, 0));
        assertEquals("Hit and sunk", battleship.attack(8, 0));
    }

    /**
     * Method under test: {@link Battleship#attack(int, int)}
     */
    @Test
    void testAttackReturnsHitAndSunkForVerticalShipOfSizeTen() {
        Battleship battleship = new Battleship();
        battleship.addShip(new Ship(1, 9, 1, false));
        battleship.addShip(new Ship(10, 0, 0, false));
        assertEquals("Hit", battleship.attack(0, 0));
        assertEquals("Hit", battleship.attack(1, 0));
        assertEquals("Hit", battleship.attack(2, 0));
        assertEquals("Hit", battleship.attack(3, 0));
        assertEquals("Hit", battleship.attack(4, 0));
        assertEquals("Hit", battleship.attack(5, 0));
        assertEquals("Hit", battleship.attack(6, 0));
        assertEquals("Hit", battleship.attack(7, 0));
        assertEquals("Hit", battleship.attack(8, 0));
        assertEquals("Hit and sunk", battleship.attack(9, 0));
    }

    /**
     * Method under test: {@link Battleship#attack(int, int)}
     */
    @Test
    void testAttackReturnsMissWhenAttackSquareDoesNotHaveShip() {
        Battleship battleship = new Battleship();
        battleship.addShip(new Ship(1, 0, 0, true));
        assertEquals("Miss", battleship.attack(1, 1));
    }

    /**
     * Method under test: {@link Battleship#attack(int, int)}
     */
    @Test
    void testAttackReturnsInvalidPositionProvidedWhenPositionIsInvalid() {
        Battleship battleship = new Battleship();
        assertEquals("Invalid position provided", (battleship.attack(-1, 1)));
        assertEquals("Invalid position provided", (battleship.attack(1, -1)));
        assertEquals("Invalid position provided", (battleship.attack(10, 1)));
        assertEquals("Invalid position provided", (battleship.attack(1, 11)));
    }

    /**
     * Method under test: {@link Battleship#hasLost()}
     */
    @Test
    void testHasLostReturnsTrueIfNoShipIsFloating() {
        Battleship battleship = new Battleship();
        battleship.addShip(new Ship(2, 0, 0, true));
        assertEquals("Hit", battleship.attack(0, 0));
        assertEquals("All Battleships Sunk, you lost", battleship.attack(0, 1));
        assertTrue(battleship.hasLost());
    }

    /**
     * Method under test: {@link Battleship#hasLost()}
     */
    @Test
    void testHasLostReturnsFalseIfAnyShipIsFloating() {
        Battleship battleship = new Battleship();
        battleship.addShip(new Ship(2, 0, 0, true));
        battleship.addShip(new Ship(2, 2, 0, true));
        assertEquals("Hit", battleship.attack(0, 0));
        assertEquals("Hit and sunk", battleship.attack(0, 1));
        assertFalse(battleship.hasLost());
    }

    /**
     * Method under test: {@link Battleship#hasLost()}
     */
    @Test
    void testHasLostReturnsFalseIfNoShipIsFloating() {
        Battleship battleship = new Battleship();
        battleship.addShip(new Ship(1, 9, 9, false));
        battleship.addShip(new Ship(2, 0, 0, true));
        assertEquals("Hit", battleship.attack(0, 0));
        assertEquals("Hit and sunk", battleship.attack(0, 1));
        assertFalse(battleship.hasLost());
    }

    /**
     * Method under test: {@link Battleship#overlaps(Ship)}
     */
    @Test
    void testOverlapsWhenOnlyOneShipAdded() {
        Battleship battleship = new Battleship();
        assertFalse(battleship.overlaps(new Ship(3, 1, 1, true)));
    }

    /**
     * Method under test: {@link Battleship#overlaps(Ship)}
     */
    @ParameterizedTest
    @CsvSource({
            "3, 3, 1, true",
            "3, 3, 1, false",
            "1, 1, 0, true"
    })
    void testOverlapsShouldReturnFalseNoOverlapsInOldAndNewShip(
            int size, int row, int col, Boolean horizontal) {
        Battleship battleship = new Battleship();
        battleship.addShip(new Ship(size, row, col, horizontal));
        assertFalse(battleship.overlaps(new Ship(3, 1, 1, true)));
    }

    /**
     * Method under test: {@link Battleship#overlaps(Ship)}
     */
    @ParameterizedTest
    @CsvSource({
            "3, 1, 3, true",
            "3, 1, 1, false",
            "3, 1, 1, true"
    })
    void testOverlapsShouldReturnTrueWhenThereIsOverlapsBetweenOldAndNewShip(
            int size, int row, int col, Boolean horizontal) {
        Battleship battleship = new Battleship();
        battleship.addShip(new Ship(size, row, col, horizontal));
        assertTrue(battleship.overlaps(new Ship(3, 1, 1, true)));
    }

}

