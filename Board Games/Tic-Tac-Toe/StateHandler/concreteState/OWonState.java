package StateHandler.concreteState;

import StateHandler.GameState;
import Utility.Player;
import StateHandler.context.GameContext;

public class OWonState implements GameState{
    @Override
    public void next(GameContext context, Player player, boolean hasWon){}
    @Override
    public boolean isGameOver(){
        return true;
    }
}
