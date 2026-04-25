package tictactoe.strategies;

import tictactoe.Board;
import tictactoe.Mark;
import tictactoe.MoveStrategy;
import tictactoe.Position;
/*
 * creats a list of all the corners on the 3x3 grid
 *  if there is a position in the corners list that is open we return that position
 *  then if there are no open positions return null
 *  then the default is to just choose the first open positions if all else is untrue*/

public class CornerFirstStrategy implements MoveStrategy {
    //please note that the board will ALWAYS be a 3x3 grid, Sabrina feel free to change
    //this if you would like but I thought it would be easiest to keep
    //a fixed board size
    @Override
    public Position chooseMove(Board board, Mark myMark, Mark oppenentMark){
        //make a list of all the corner positions
        Position[] corners = {
                new Position(0, 0),
                new Position(0, 2),
                new Position(2, 0),
                new Position(2, 2)};
        for (Position corner : corners) {
            if (board.isOpen(corner)) {
                return corner;}
        }

        if(board.getOpenPositions().isEmpty()){
            return null;
        }

        return board.getOpenPositions().get(0);
    }
}
