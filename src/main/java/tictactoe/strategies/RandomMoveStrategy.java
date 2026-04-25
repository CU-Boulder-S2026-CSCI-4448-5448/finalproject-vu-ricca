package tictactoe.strategies;

import tictactoe.*;

import java.util.List;
import java.util.Random;
/*This creates a list of all the open positions on the board and uses rand
* to select a random index of that list (inclusive size of the list so we do have a seg fault*/
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