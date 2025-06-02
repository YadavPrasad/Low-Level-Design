package StateHandler;

import Utility.Player;
import StateHandler.context.GameContext;


public interface GameState {
    void next(GameContext context, Player player , boolean hasWon);
    boolean isGameOver();
}