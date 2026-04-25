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

    public boolean isMarked(){
        return getOpenPositions().isEmpty();
    }
}
