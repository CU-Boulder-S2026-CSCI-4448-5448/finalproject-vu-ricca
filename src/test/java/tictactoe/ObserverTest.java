package tictactoe;

import org.junit.jupiter.api.Test;
import tictactoe.observers.ConsoleObserver;
import tictactoe.observers.GameObserver;
import tictactoe.observers.MoveLogObserver;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

class ObserverTest implements GameObserver {

    private final List<String> messages = new ArrayList<>();

    @Override
    public void update(TicTacToe game, String message) {
        messages.add(message);
    }

    public List<String> getMessages() {
        return messages;
    }

    @Test
    void ObserverRecievesNotifications(){
        TicTacToe game = new TicTacToe(new Board());

        ObserverTest observer = new ObserverTest();

        game.addObserver(observer);

        game.playMove(new Position(0, 0));

        assertFalse(observer.getMessages().isEmpty());
        System.out.println(observer.getMessages());
    }

    @Test
    void TestConsoleObserver(){
        TicTacToe game = new TicTacToe(new Board());
        ConsoleObserver observer = new ConsoleObserver();

        game.addObserver(observer);


        //testing consoel output with ByteArrayOutPutStream
        //this was googled

        ByteArrayOutputStream output = new ByteArrayOutputStream();

        PrintStream originalOut = System.out;

        System.setOut(new PrintStream(output));

        try{
            game.playMove(new Position(0, 0));
        }finally{
            System.setOut(originalOut);
        }

        String message = output.toString();

        assertTrue(message.contains("X"));
        assertTrue(message.contains(" - "));
    }

    @Test
    void ObserverMoveLogTest(){
        TicTacToe game = new TicTacToe(new Board());
        MoveLogObserver observer = new MoveLogObserver();

        game.addObserver(observer);

        game.playMove(new Position(0, 0));

        assertFalse(observer.getMoveLog().isEmpty());
        assertTrue(observer.getMoveLog().get(0).contains("X"));
    }
    @Test
    void TestObserverMoveLog(){
        TicTacToe game = new TicTacToe(new Board());
        MoveLogObserver observer = new MoveLogObserver();

        game.addObserver(observer);

        game.playMove(new Position(0, 0));
        game.playMove(new Position(1, 1));

        assertFalse(observer.getMoveLog().isEmpty());
        assertTrue(observer.getMoveLog().get(0).contains("X"));
        assertTrue(observer.getMoveLog().get(1).contains("O"));
        assertTrue(observer.getMoveLog().size() >= 2);

        //for debugginf
        System.out.println(observer.getMoveLog());
    }

    @Test
    void TestMoveLogObserverPrint(){
        TicTacToe game = new TicTacToe(new Board());
        MoveLogObserver observer = new MoveLogObserver();
        game.addObserver(observer);

        game.playMove(new Position(0, 0));
        game.playMove(new Position(1, 1));

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;

        System.setOut(new PrintStream(output));

        try{
            observer.printMoveLog();
        }finally{
            System.setOut(originalOut);
        }
        String message = output.toString();
        assertTrue(message.contains("X"));
        assertTrue(message.contains("O"));
    }

}
