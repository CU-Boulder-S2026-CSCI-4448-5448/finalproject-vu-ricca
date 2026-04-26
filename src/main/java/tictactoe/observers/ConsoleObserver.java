package tictactoe.observers;

import tictactoe.Mark;
import tictactoe.TicTacToe;

import java.util.Observer;

//should be accurate to each state, initial state is empty board
//notify observer -> print updated console board
public class ConsoleObserver implements GameObserver {

    @Override
    public void update(TicTacToe game, String message){
        System.out.println(message);
        printBoard(game.getBoardGrid());
    }

    private void printBoard(Mark[][] board){
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                System.out.print(board[i][j] == Mark.EMPTY ? "- ": board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
