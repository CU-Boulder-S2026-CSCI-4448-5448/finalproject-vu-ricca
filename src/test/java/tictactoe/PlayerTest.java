package tictactoe;


import org.junit.jupiter.api.Test;
import tictactoe.players.Player;
import tictactoe.players.PlayerFactory;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    @Test
    void createsRandomBot(){
        PlayerFactory factory = new PlayerFactory();

        Player player = factory.createPlayer(PlayerFactory.RANDOM_NPC, Mark.X);

        assertFalse(player.isHuman());
        assertEquals(Mark.X, player.getMark());
        assertNotNull(player);
    }

    @Test
    void createsBlockingBot(){
        PlayerFactory factory = new PlayerFactory();

        Player player = factory.createPlayer(PlayerFactory.BLOCK_NPC, Mark.X);

        assertFalse(player.isHuman());
        assertEquals(Mark.X, player.getMark());
        assertNotNull(player);
    }

    @Test
    void createsSmartBot(){
        PlayerFactory factory = new PlayerFactory();

        Player player = factory.createPlayer(PlayerFactory.SMART_NPC, Mark.X);

        assertFalse(player.isHuman());
        assertEquals(Mark.X, player.getMark());
        assertNotNull(player);
    }

    @Test
    void createsCompetitiveBot(){
        PlayerFactory factory = new PlayerFactory();

        Player player = factory.createPlayer(PlayerFactory.WIN_NPC, Mark.X);

        assertFalse(player.isHuman());
        assertEquals(Mark.X, player.getMark());
        assertNotNull(player);
    }



    @Test
    void createsHumanPlayer(){
        PlayerFactory factory = new PlayerFactory();
        Player player = factory.createPlayer(PlayerFactory.HUMAN, Mark.O);

        assertTrue(player.isHuman());
        assertEquals(Mark.O, player.getMark());
        assertNotNull(player);
    }

    @Test
    void TestPlayerGetMove(){
        PlayerFactory factory = new PlayerFactory();
        Player player = factory.createPlayer(PlayerFactory.HUMAN, Mark.X);

        Board board = new Board();

        Position move = player.getMove(board);

        assertNull(move);

    }

    @Test
    void TestPLayerReturnsOpenPosition(){
        PlayerFactory factory = new PlayerFactory();
        Player player = factory.createPlayer(PlayerFactory.RANDOM_NPC, Mark.X);

        Board board = new Board();
        Position move = player.getMove(board);

        //want to make sure valid open position is returned with aradnom npc
        assertNotNull(move);
        assertTrue(board.isOpen(move));
    }

    @Test
    void TestPLayerReturnsCornerPosition(){
        PlayerFactory factory = new PlayerFactory();
        Player player = factory.createPlayer(PlayerFactory.SMART_NPC, Mark.X);
        Board board = new Board();

        Position move = player.getMove(board);

        assertTrue(
                (move.getRow() == 0 && move.getColumn() == 0)||
                        (move.getRow() == 0 && move.getColumn() == 2)||
                        (move.getRow() == 2 && move.getColumn() == 0) ||
                        (move.getRow() == 2 && move.getColumn() == 2)
        );
    }

    @Test
    void TestBlockNPCBlocks(){
        PlayerFactory factory = new PlayerFactory();
        Player player = factory.createPlayer(PlayerFactory.BLOCK_NPC, Mark.X);
        Board board = new Board();

        board.markASpot(new Position(0,0), Mark.O);
        board.markASpot(new Position(0,1), Mark.O);
        //O O -
        //- - -
        //- - -
        Position move = player.getMove(board);
        assertEquals(0, move.getRow());
        assertEquals(2, move.getColumn());
    }
}
