package tictactoe.states;
import tictactoe.Mark;
import tictactoe.TicTacToe;
import tictactoe.Position;

public class GameOverState implements GameState {
    private final Mark winner;

    public GameOverState(Mark winner) {
        this.winner = winner;
    }

    @Override
    public boolean playMove(TicTacToe game, Position position) {
        return false;
    }

    @Override
    public Mark getCurrentPlayer() {
        return Mark.EMPTY;
    }

    public Mark getWinner() {
        return winner;
    }

    @Override
    public boolean isGameOver() {
        return true;
    }
}
