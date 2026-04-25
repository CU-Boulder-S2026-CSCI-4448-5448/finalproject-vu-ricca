package tictactoe.states;

import tictactoe.Mark;
import tictactoe.Position;
import tictactoe.TicTacToe;

public interface GameState {
    boolean playMove(TicTacToe game, Position position);
    Mark getCurrentPlayer();
    boolean isGameOver();
}
