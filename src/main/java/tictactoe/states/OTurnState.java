package tictactoe.states;

import tictactoe.Mark;
import tictactoe.Position;
import tictactoe.TicTacToe;

public class OTurnState implements GameState {
    @Override
    public boolean playMove(TicTacToe game, Position position){
        if(!game.getBoard().isOpen(position)){
            game.notifyObservers("O cannot be marked at" + position);
            return false;
        }

        game.getBoard().markASpot(position, Mark.O);
        //notify observer
        game.notifyObservers("O marked at " + position);
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
