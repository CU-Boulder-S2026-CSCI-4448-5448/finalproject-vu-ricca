package tictactoe.strategies;

import tictactoe.Mark;
import tictactoe.Board;
import tictactoe.MoveStrategy;
import tictactoe.Position;

import java.util.ArrayList;
import java.util.List;


public class BlockingMoveStrategy implements MoveStrategy {

    @Override
    public Position chooseMove(Board board, Mark myMark, Mark opponentMark){
        List<Position> openPositions = board.getOpenPositions();

        //create a copy of the board to check/simulate possible moves
        //without changing the state of the board
        for(Position position : openPositions){

            Board copyOfBoard = board.copyBoard();
            //simulate opp move/NPC move
            copyOfBoard.markASpot(position, opponentMark);
            //see Board.java for checkWinner method
            if(copyOfBoard.checkWinner(copyOfBoard) == opponentMark){
                return position; //this blocks
            }
        }
        return null; //no blocking needed
    }
}
