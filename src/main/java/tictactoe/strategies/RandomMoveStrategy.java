package tictactoe.strategies;

import tictactoe.*;

import java.util.List;
import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
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