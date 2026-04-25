package tictactoe;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final Mark[][] grid = new Mark[3][3];
    public Board() {
        for (int i=0; i < 3; i++) {
            for (int j=0; j < 3; j++) {
                grid[i][j] = Mark.EMPTY;
            }
        }
    }
    //want to return a copy of the grid,
    // dont want to return the reference to where the actual board is
    public Mark[][] getGridCopy() {
        Mark[][] copy = new Mark[3][3];
        //clone is shorthand by java to avoid j loop for cpying arrays
        for (int i=0; i < 3; i++) {copy[i]=grid[i].clone();
        }
        return copy;
    }
    public List<Position> getOpenPositions(){
        List<Position> openPositions = new ArrayList<Position>();
        for (int k=0; k < 3; k++) {
            for (int l=0; l < 3; l++) {
                if (grid[k][l] == Mark.EMPTY) {openPositions.add(new Position(k, l));}
            }
        }
        return openPositions;
    }

    public boolean markASpot(Position position, Mark mark){
        if(grid[position.getRow()][position.getColumn()] == Mark.EMPTY){
            grid[position.getRow()][position.getColumn()] = mark;
            return true;
        }
        return false;
    }

    //help fucntions
    public boolean isOpen(Position position){
        return grid[position.getRow()][position.getColumn()] == Mark.EMPTY;
    }

    public Mark getMark(Position position){
        return grid[position.getRow()][position.getColumn()];
    }

    public boolean boardIsFull(){
        return getOpenPositions().isEmpty();
    }

    public Board copyBoard(){
        Board copy = new Board();

        Mark[][] grid = this.getGridCopy();

        for (int i=0; i < 3; i++) {
            for (int j=0; j < 3; j++) {
                if (grid[i][j] != Mark.EMPTY) {
                    copy.markASpot(new Position(i, j), grid[i][j]);
                }
            }
        }
        return copy;
    }

    public Mark checkWinner(Board board) {
        //check all the rows, columns, diagonals, return the empty one
        //this will return the mark of which player is ABOUT to win
        //everything in this is on a simulated board so
        //we dont alter the state of the actual game baord, and we can chek
        //using this function if we can block a winner
        Mark[][] gridCopy = board.getGridCopy();

        //if all of them are equal and one of them is empty that means they're all
        //empty and there is no way to win in this (ith) row
        //if player marked in the empty row woudl they win?: (this is a simulated borad)
        for (int i = 0; i < 3; i++) {
            if (gridCopy[i][0] != Mark.EMPTY
                    && gridCopy[i][0] == gridCopy[i][1]
                    && gridCopy[i][1] == gridCopy[i][2]) {
                return gridCopy[i][0];
            }
        }
        //same idea but for columns
        for (int j = 0; j < 3; j++) {
            if (gridCopy[0][j] != Mark.EMPTY
                    && gridCopy[0][j] == gridCopy[1][j]
                    && gridCopy[1][j] == gridCopy[2][j]) {
                return gridCopy[0][j];
            }
        }
        //diagonals
        if (gridCopy[0][0] != Mark.EMPTY &&
                gridCopy[0][0] == gridCopy[1][1] &&
                gridCopy[1][1] == gridCopy[2][2]) {
            return gridCopy[0][0];
        }
        if (gridCopy[0][2] != Mark.EMPTY &&
                gridCopy[0][2] == gridCopy[1][1] &&
                gridCopy[1][1] == gridCopy[2][0]) {
            return gridCopy[0][2];
        }
        return Mark.EMPTY;
    }
}
