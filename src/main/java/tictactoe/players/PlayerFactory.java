package tictactoe;

import tictactoe.strategies.*;

public class PlayerFactory {

    public static final String HUMAN = "Human";
    public static final String RANDOM_NPC = "Random Move Bot";
    public static final String SMART_NPC = "Corner First Bot";
    public static final String BLOCKING_NPC = "Blocking Move Bot";


    public Player createPlayer(String type, Mark mark) {
        return switch (type) {
            case RANDOM_NPC -> new Player(mark, new RandomMoveStrategy());
            case SMART_NPC -> new Player(mark, new CornerFirstStrategy());
            case BLOCKER_NPC -> new Player(mark, new BlockingMoveStrategy());
//            the human player will not have a set strategy, so wwe pass in null
            case HUMAN -> new Player(mark, null);
            default -> throw new IllegalArgumentException("Unknown player type: " + type);
        };
    }
}