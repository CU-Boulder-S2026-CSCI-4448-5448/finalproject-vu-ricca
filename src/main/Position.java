package main;

import java.util.List;
import java.util.Random;

public class Position {
    private final int row;
    private final int column;

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }
    public int getColumn() {
        return column;
    }

    public static class RandomMoveStrategy implements MoveStrategy {
        private final Random rand = new Random();

        @Override
        public Position chooseMove(Board board, Mark myMark, Mark opponentMark) {
            List<Position> openPositions = board.getOpenPositions();
            if (openPositions.isEmpty()) {
                return null;
            }
            return openPositions.get(rand.nextInt(openPositions.size()));
        }

    }
}
