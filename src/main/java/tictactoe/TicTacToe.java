package tictactoe;

import java.util.List;

public class TicTacToe implements ITicTacToe {
    private final Board board;
    private Mark currentPlayer;

    public TicTacToe(Board board) {
        this.board = board;
        this.currentPlayer = Mark.X;
    }

    @Override
    public boolean playMove(Position position) {
        if (board.isOpen(position)) {
            board.markASpot(position, currentPlayer);

            if (currentPlayer == Mark.X) {
                currentPlayer = Mark.O;
            } else {
                currentPlayer = Mark.X;
            }

            return true;
        }
        return false;
    }

    @Override
    public boolean isGameOver() {
        return getWinner() != Mark.EMPTY || board.boardIsFull();
    }

    @Override
    public Mark getWinner() {
        return board.checkWinner(board);
    }

    @Override
    public Mark[][] getBoardGrid() {
        return board.getGridCopy();
    }

    @Override
    public Mark getCurrentPlayer() {
        return currentPlayer;
    }

    @Override
    public void reset() {

//        may wanna implement a clear() method for here
        this.currentPlayer = Mark.X;
    }
}