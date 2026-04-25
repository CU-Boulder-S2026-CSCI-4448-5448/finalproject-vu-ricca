package tictactoe;

import java.util.List;

//tic tac toe interface file, similar to the Iwordle
public interface ITicTacToe {
    boolean playMove(Position position); // returns true if move was valid
    boolean isGameOver();
    Mark getWinner();
    Mark[][] getBoardGrid();
    Mark getCurrentPlayer();

    void reset();
}