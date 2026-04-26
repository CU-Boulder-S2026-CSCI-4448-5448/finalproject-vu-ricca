package tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    @Test
    void newBoardShouldBeEmpty() {
        Board board = new Board();
        assertEquals(9, board.getOpenPositions().size());
    }

    @Test
    void markASpotShouldMarkASpot() {
        Board board = new Board();
        Position position = new Position(0, 0);

        assertTrue(board.markASpot(position, Mark.X));
        assertEquals(Mark.X, board.getMark(position));
    }

    @Test
    void markedSpotCantBeOverwritten(){
        Board board = new Board();
        Position position = new Position(0, 0);

        assertTrue(board.markASpot(position, Mark.X));
        assertFalse(board.markASpot(position, Mark.O));
        assertEquals(Mark.X, board.getMark(position));
    }

}
