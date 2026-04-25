package tictactoe.strategies;

import tictactoe.*;

import java.util.List;

public class WinningMoveStrategy implements MoveStrategy {

    @Override
    public Position chooseMove(Board board, Mark myMark, Mark opponentMark) {
        List<Position> openPositions = board.getOpenPositions();

        for (Position openPosition : openPositions) {
            Board copyOfBoard = board.copyBoard();

            //simulate my move
            copyOfBoard.markASpot(openPosition, myMark);

            //if that move wins, chose it
            if(copyOfBoard.checkWinner(copyOfBoard) == myMark){
                return openPosition;
            }
        }
        return null;
    }
}
