package tictactoe.strategies;
import tictactoe.*;


import java.util.ArrayList;
import java.util.List;

public class FirstOpenSquareStrategy implements MoveStrategy {
    //this startegy will go through the list of open positions on the board and
    //pikc the first one
    @Override
    public Position chooseMove(Board board, Mark myMark, Mark opponentMark){
        List<Position> openPositions = new ArrayList<Position>();

        if (openPositions.isEmpty()){
            return null;
        }

        return openPositions.get(0);
    }

}
