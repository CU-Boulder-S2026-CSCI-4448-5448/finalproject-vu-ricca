package tictactoe;


import org.junit.jupiter.api.Test;
import tictactoe.strategies.*;

import static org.junit.jupiter.api.Assertions.*;

class StrategyTest {
    @Test
    void chooseWinningMoveWhenAvailable(){
        Board board = new Board();

        board.markASpot(new Position(0,0), Mark.X);
        board.markASpot(new Position(0,1), Mark.X);

        MoveStrategy strategy = new WinningMoveStrategy();

        Position move = strategy.chooseMove(board, Mark.X, Mark.O);

        assertEquals(0, move.getRow());
        assertEquals(2, move.getColumn());
    }

    @Test
    void blockOpponentWinningMove(){
        Board board = new Board();

        board.markASpot(new Position(1,0), Mark.O);
        board.markASpot(new Position(1,1), Mark.O);

        MoveStrategy strategy = new BlockingMoveStrategy();

        Position move = strategy.chooseMove(board, Mark.X, Mark.O);

        assertEquals(1, move.getRow());
        assertEquals(2, move.getColumn());
    }

    @Test
    void choosesCornerFirstIfAvailable(){
        Board board = new Board();

        MoveStrategy strategy = new CornerFirstStrategy();

        Position move = strategy.chooseMove(board, Mark.X, Mark.O);

        assertTrue((move.getRow() == 0 && move.getColumn() == 0) ||
                (move.getRow() == 0 && move.getColumn() == 2) ||
                (move.getRow() == 2 && move.getColumn() == 0) ||
                (move.getRow() == 2 && move.getColumn() == 2));
    }
}
