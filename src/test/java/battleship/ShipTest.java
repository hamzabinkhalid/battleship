package battleship;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ShipTest {

    /**
     * Method under test: {@link Ship#Ship(int, int, int, boolean)}
     */
    @Test
    void testConstructor() {
        Ship actualShip = new Ship(3, 1, 1, true);
        assertEquals(1, actualShip.col);
        assertEquals(1, actualShip.row);
        assertEquals(3, actualShip.size);
        assertFalse(actualShip.isSunk());
        assertTrue(actualShip.horizontal);
    }

    /**
     * Method under test: {@link Ship#Ship(int, int, int, boolean)}
     */
    @ParameterizedTest
    @CsvSource({
            "3, 11, 0, false",
            "3, 0, 11, false",
            "3, 1, -1, false",
            "3, -1, 1, false",
            "0, 1, 1, false",
            "16, 1, 1, false",
            "3, 11, 0, true",
            "3, 0, 11, true",
            "3, 1, -1, true",
            "3, -1, 1, true",
            "0, 1, 1, true",
            "16, 1, 1, true"
    })
    void testAddShipShouldThrowExceptionWhenShipIsInvalid(
            int size, int row, int col, Boolean horizontal) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Ship(size, row, col, horizontal));

        assertEquals("Invalid ship parameter(s) passed", exception.getMessage());
    }

    /**
     * Method under test: {@link Ship#occupies(int, int)}
     */
    @Test
    void testOccupies() {
        assertTrue((new Ship(3, 1, 1, true)).occupies(1, 1));
        assertFalse((new Ship(3, 4, 1, true)).occupies(1, 1));
        assertFalse((new Ship(3, 1, 4, true)).occupies(1, 1));
        assertTrue((new Ship(3, 1, 1, false)).occupies(1, 1));
        assertFalse((new Ship(3, 1, 1, true)).occupies(1, 4));
        assertFalse((new Ship(3, 4, 1, false)).occupies(1, 1));
        assertFalse((new Ship(3, 1, 4, false)).occupies(1, 1));
        assertFalse((new Ship(3, 1, 1, false)).occupies(4, 1));
    }

    /**
     * Method under test: {@link Ship#isSunk()}
     */
    @Test
    void testIsSunk() {
        Battleship battleship = new Battleship();
        Ship ship = new Ship(1, 0, 0, true);
        Ship ship2 = new Ship(1, 1, 1, true);
        battleship.addShip(ship);
        battleship.addShip(ship2);
        assertFalse((ship).isSunk());
        assertEquals("Hit and sunk", battleship.attack(0, 0));
        assertTrue((ship).isSunk());
    }

}

