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
    //some more edge cases
    @Test
    void boardIsFullAndShouldReturnTrue() {
        Board board = new Board();
        // Fill all 9 spots
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                board.markASpot(new Position(r, c), Mark.X);
            }
        }
        assertTrue(board.boardIsFull());
        assertEquals(0, board.getOpenPositions().size());
    }

    @Test
    void checksWinnerDetectsADiagonal() {
        Board board = new Board();
        board.markASpot(new Position(0, 0), Mark.X);
        board.markASpot(new Position(1, 1), Mark.X);
        board.markASpot(new Position(2, 2), Mark.X);

        assertEquals(Mark.X, board.checkWinner(board));
    }

}
