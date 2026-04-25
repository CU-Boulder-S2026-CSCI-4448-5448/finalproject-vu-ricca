package tictactoe.states;

import tictactoe.Mark;
import tictactoe.Position;
import tictactoe.Board;
import tictactoe.TicTacToe;

public class XTurnState implements GameState {
    @Override
    public boolean playMove(TicTacToe game, Position position){
        if(!game.getBoard().isOpen(position)){
            game.notifyObservers("X cannot be marked at" + position);
            return false;
        }

        game.getBoard().markASpot(position, Mark.X);
        //notify observer
        game.notifyObservers("X marked at " + position);
        game.updateStateAfterMove();
        return true;
    }

    @Override
    public Mark getCurrentPlayer() {
        return Mark.X;
    }

    public boolean isGameOver() {
        return false;
    }
}
