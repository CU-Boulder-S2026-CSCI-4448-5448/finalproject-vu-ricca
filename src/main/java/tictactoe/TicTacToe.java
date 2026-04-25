package tictactoe;

import tictactoe.states.GameState;
import tictactoe.states.*;
import java.util.List;
import tictactoe.observers.GameObserver;
import java.util.ArrayList;

public class TicTacToe implements ITicTacToe {
    private final Board board;
//    private Mark currentPlayer;
    private GameState currentState;
    //observer stuff
    private final List<GameObserver> observers = new ArrayList<>();

    //this class will be altered, the point of the game state pattern
    //is to remove a bunch of if statements, for example in the playMove method
    //i will comment out the original playMove for comparison in interview
    public TicTacToe(Board board) {
        this.board = board;
//        this.currentPlayer = Mark.X;
        this.currentState = new XTurnState();
    }

    @Override
    public boolean playMove(Position position) {
//        if (board.isOpen(position)) {
//            board.markASpot(position, currentPlayer);
//
//            if (currentPlayer == Mark.X) {
//                currentPlayer = Mark.O;
//            } else {
//                currentPlayer = Mark.X;
//            }
//
//            return true;
//        }
//        return false;
        return currentState.playMove(this, position);
    }

    @Override
    public boolean isGameOver() {

//        return getWinner() != Mark.EMPTY || board.boardIsFull();
        return currentState.isGameOver();
    }

    @Override
    public Mark getWinner() {

//        return board.checkWinner(board);
        return board.checkWinner(board);
    }

    @Override
    public Mark[][] getBoardGrid() {
        return board.getGridCopy();
    }

    @Override
    public Mark getCurrentPlayer() {

//        return currentPlayer;
        return currentState.getCurrentPlayer();
    }

    @Override
    public void reset() {
        board.clear();
        //clear board, start game with X turn
        this.currentState = new XTurnState();
    }
    //stuff for gmae states

    public Board getBoard() {
        return board;
    }

    public void updateStateAfterMove(){
        Mark winner = getWinner();

        if(winner != Mark.EMPTY){
            currentState = new GameOverState(winner);
        }
        else if (board.boardIsFull()){
            currentState = new GameOverState(Mark.EMPTY);
        }
        //if the current state is X turns, change state to O's turn, this will be udated
        //after each state in Play Move
        else if (currentState instanceof XTurnState){
            currentState = new OTurnState();
        }
        else if (currentState instanceof OTurnState){
            currentState = new XTurnState();
        }
    }

    //stuff for observer pattern
    public void addObserver(GameObserver observer){
        observers.add(observer);
    }

    public void removeObserver(GameObserver observer){
        observers.remove(observer);
    }
    public void notifyObservers(String message){
        for(GameObserver observer : observers){
            observer.update(this, message);
        }
    }

}