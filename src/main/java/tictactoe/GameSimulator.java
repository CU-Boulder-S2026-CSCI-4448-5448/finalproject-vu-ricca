package tictactoe;

import tictactoe.observers.ConsoleObserver;
import tictactoe.players.Player;
import tictactoe.players.PlayerFactory;

import java.util.Scanner;

public class GameSimulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PlayerFactory playerFactory = new PlayerFactory();

        Player human= playerFactory.createPlayer(PlayerFactory.HUMAN, Mark.X);
        Player npc = playerFactory.createPlayer(PlayerFactory.SMART_NPC, Mark.O);

        TicTacToe game = new TicTacToe(new Board());
        ConsoleObserver observer = new ConsoleObserver();
        game.addObserver(observer);

        System.out.println("Welcome to TicTacToe!");
        System.out.println("You are X, and I am O");
        System.out.println("Enter your move as: row column");
        System.out.println("For example 0 2 will be the top right corner");


        while (!game.isGameOver()){
            if(game.getCurrentPlayer() == human.getMark()){
                System.out.println("X's move");

                int row = scanner.nextInt();
                int column = scanner.nextInt();

                boolean valid = game.playMove(new Position(row, column));

                if(!valid){
                    System.out.println("Invalid move");
                }else{
                    Position npcMove = npc.getMove(game.getBoard());

                    System.out.println("O's move");
                    System.out.println(npcMove);

                    System.out.println("about to play bot move..");
                    boolean val = game.playMove(npcMove);
                    System.out.println("Bot move valid y/n" + val);

                }
            }

        }
        Mark winner = game.getWinner();

        if(winner == Mark.X){
            System.out.println("You won!");
        }else if (winner == Mark.O){
            System.out.println("I won!");
        }else{
            System.out.println("Draw!");
        }
        scanner.close();
    }
}
