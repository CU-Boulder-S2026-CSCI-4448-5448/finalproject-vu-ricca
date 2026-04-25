package tictactoe.strategies;
import tictactoe.*;


import java.util.ArrayList;
import java.util.List;

public class FirstOpenSquareStrategy implements MoveStrategy {
    //this startegy will go through the list of open positions on the board and
    //pikc the first one
    @Override
    public Position chooseMove(Board board, Mark myMark, Mark opponentMark){
//        swapped out the previous, to utilize the getOpenPositions function that you made
        List<Position> openPositions = board.getOpenPositions();

        if (openPositions.isEmpty()){
            return null;
        }

        return openPositions.get(0);
    }

}
