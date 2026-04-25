package tictactoe;

public interface MoveStrategy {
    Position chooseMove(Board board, Mark myMark, Mark opponentMark);
}
