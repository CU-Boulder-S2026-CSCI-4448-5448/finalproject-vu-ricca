package tictactoe.states;

import tictactoe.Mark;
import tictactoe.Position;
import tictactoe.TicTacToe;

public class OTurnState implements GameState {
    @Override
    public boolean playMove(TicTacToe game, Position position){
        if(!game.getBoard().isOpen(position)){
            return false;
        }

        game.getBoard().markASpot(position, Mark.X);
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
