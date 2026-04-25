package tictactoe.observers;

import tictactoe.TicTacToe;

public interface GameObserver {
    void update(TicTacToe game, String message);
}
