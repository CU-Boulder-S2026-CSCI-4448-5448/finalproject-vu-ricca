package tictactoe;

public class Player {
    private final Mark mark;
    private final MoveStrategy strategy;

    public Player(Mark mark, MoveStrategy strategy) {
        this.mark = mark;
        this.strategy = strategy;
    }

    public Mark getMark() {
        return mark;
    }

    public boolean isHuman() {
        return strategy == null;
    }

    public Position getMove(Board board) {
        if (strategy == null) { // human player
            return null;
        }
        Mark opponent;
        if (this.mark == Mark.X) {
            opponent = Mark.O;
        } else {
            opponent = Mark.X;
        }
        return strategy.chooseMove(board, mark, opponent);
    }
}