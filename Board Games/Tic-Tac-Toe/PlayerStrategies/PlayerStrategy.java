package PlayerStrategies;

import Utility.Position;
import Utility.Board;

public interface PlayerStrategy {
    Position makeMove(Board board);
}