package StateHandler.context;

import StateHandler.GameState;
import StateHandler.concreteState.XTurnState;
import Utility.Player;


public class GameContext {
    
    private GameState currentState;

    public GameContext() {
        currentState = new XTurnState();
    }

    public void setState(GameState state) {
        this.currentState = state;
    }

    public GameState getCurrentState() {
        return currentState;
    }

    public boolean isGameOver() {
        return currentState.isGameOver();
    }
    
    public void next(Player player, boolean hasWon) {
        currentState.next(this, player , hasWon);
    }
}
