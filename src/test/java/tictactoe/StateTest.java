package tictactoe;



import org.junit.jupiter.api.Test;
import tictactoe.players.Player;
import tictactoe.players.PlayerFactory;
import tictactoe.states.GameOverState;
import tictactoe.states.GameState;
import tictactoe.states.OTurnState;
import tictactoe.states.XTurnState;

import static org.junit.jupiter.api.Assertions.*;

class StateTest {
    @Test
    void startWithXTurn(){
        TicTacToe game = new TicTacToe(new Board());

        assertEquals(Mark.X, game.getCurrentPlayer());
    }

    @Test
    void switchesToOafterXTurn(){
        TicTacToe game = new TicTacToe(new Board());

        game.playMove(new Position(0, 0));

        assertEquals(Mark.O, game.getCurrentPlayer());
    }

    @Test
    void gameEndsWhenXWins(){
        TicTacToe game = new TicTacToe(new Board());
        game.playMove(new Position(0, 0));//X
        game.playMove(new Position(1, 0));//O
        game.playMove(new Position(0, 1));//X
        game.playMove(new Position(1, 1));//O
        game.playMove(new Position(0, 2));//X wins (top row full)

        assertTrue(game.isGameOver());
        assertEquals(Mark.X, game.getWinner());

    }
    @Test
    void testGameOverStateNoPlayers(){
        GameOverState state = new GameOverState(Mark.X);
         assertEquals(Mark.EMPTY, state.getCurrentPlayer());
    }
    @Test
    void testGameOverWithWinner(){
        GameOverState state = new GameOverState(Mark.X);
        assertEquals(Mark.X, state.getWinner());
    }

    @Test
    void testGameOverGetWinnerRetrunsNullWithDraw(){
        GameOverState state = new GameOverState(Mark.EMPTY);
        assertEquals(Mark.EMPTY, state.getWinner());
    }
    @Test
    void playMoveReturnsFalseWhenGameOver(){
        TicTacToe game = new TicTacToe(new Board());
        GameOverState state = new GameOverState(Mark.X);

        boolean result = state.playMove(game, new Position(0, 0));

        assertFalse(result);
    }
    @Test
    void playMoveDOesNotChangeBoardWhenGameOver(){
        TicTacToe game = new TicTacToe(new Board());
        GameOverState state = new GameOverState(Mark.X);

        Position position = new Position(0, 0);
        state.playMove(game, position);

        assertEquals(Mark.EMPTY, game.getBoard().getMark(position));
    }
    @Test
    void getCurrentPlayerRturnsO(){
        OTurnState state = new OTurnState();

        assertEquals(Mark.O, state.getCurrentPlayer());
    }

    @Test
    void getCurrentPlayerRturnsX(){
        XTurnState state = new XTurnState();

        assertEquals(Mark.X, state.getCurrentPlayer());
    }

    @Test
    void isGameOverReturnsFalseO(){
        OTurnState state = new OTurnState();

        assertFalse(state.isGameOver());
    }

    @Test
    void isGameOverReturnsFalseX(){
        XTurnState state = new XTurnState();
        assertFalse(state.isGameOver());
    }

    @Test
    void playMovePlacesO(){
        TicTacToe game = new TicTacToe(new Board());
        OTurnState state = new OTurnState();

        Position position = new Position(1, 1);

        boolean result = state.playMove(game, position);

        assertTrue(result);
        assertEquals(Mark.O, game.getBoard().getMark(position));
    }
    @Test
    void playMovePlacesX(){
        TicTacToe game = new TicTacToe(new Board());
        OTurnState state = new OTurnState();

        Position position = new Position(1, 1);

        boolean result = state.playMove(game, position);

        assertTrue(result);
        assertEquals(Mark.O, game.getBoard().getMark(position));
    }
}
