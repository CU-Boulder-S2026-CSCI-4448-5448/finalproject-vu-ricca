package tictactoe.observers;

import tictactoe.TicTacToe;
import java.util.ArrayList;
import java.util.List;

public class MoveLogObserver implements GameObserver {
    private final List<String> moveLog = new ArrayList<>();

    @Override
    public void update(TicTacToe game, String message) {
        moveLog.add(message);
    }

    public List<String> getMoveLog() {
        return new ArrayList<>(moveLog);
    }

    public void printMoveLog() {
        for (String move : moveLog) {
            System.out.println(move);
        }
    }
}
