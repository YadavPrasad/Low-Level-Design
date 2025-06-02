package Utility;

import PlayerStrategies.PlayerStrategy;
import Symbol.Symbol;


public class Player {

	Symbol symbol;
	PlayerStrategy playerstrategy;

	public Player(Symbol symbol, PlayerStrategy playerstrategy) {
		this.symbol = symbol;
		this.playerstrategy = playerstrategy;
	}

	public Symbol getSymbol() {
		return this.symbol;
	}

	public PlayerStrategy getPlayerStrategy() {
		return this.playerstrategy;
	}
}
