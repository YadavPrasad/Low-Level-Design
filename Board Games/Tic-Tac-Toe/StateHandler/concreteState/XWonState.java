package StateHandler.concreteState;

import StateHandler.GameState;
import StateHandler.context.GameContext;
import Utility.Player;

public class XWonState implements GameState{
    @Override
    public void next(GameContext context, Player player, boolean hasWon){}
    @Override
    public boolean isGameOver(){
        return true;
    }
}
