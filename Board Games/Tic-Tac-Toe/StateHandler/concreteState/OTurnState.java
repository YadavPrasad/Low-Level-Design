package StateHandler.concreteState;

import Symbol.Symbol;
import StateHandler.context.GameContext;
import Utility.Player;
import StateHandler.GameState;

public class OTurnState implements GameState{
    @Override
    public void next(GameContext context, Player player , boolean hasWon) {
        if(hasWon){
            context.setState(player.getSymbol() == Symbol.X ? new XWonState() : new OWonState());
        }else {
            
        context.setState(new OTurnState());
        }}
    @Override
    public boolean isGameOver() {
        return false;
    }
}
