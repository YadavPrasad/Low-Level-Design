package Utility;
import StateHandler.context.GameContext;
import Symbol.Symbol;

public class Board {

    private final int rows;
    private final int columns;
    private Symbol[][] grid;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;

        grid = new Symbol[rows][columns];

        for(int row = 0 ; row < rows ; row++) {
            for(int col = 0 ; col < columns ; col++) {
                grid[row][col] = Symbol.EMPTY;
            }
        }
    }

    public Boolean isValidMove(Position pos) {
        return pos.row >= 0 && pos.row < rows && pos.col >= 0 && pos.col < columns && grid[pos.row][pos.col] == Symbol.EMPTY;
    }

    public void makeMove(Position pos, Symbol symbol) {
        grid[pos.row][pos.col] = symbol;
    } 

    public void checkGameState(GameContext context, Player currentPlayer){
        for(int row = 0 ; row < rows ; row++) {
            if(grid[row][0] != Symbol.EMPTY && isWinningLine(grid[row])) {
                context.next(currentPlayer, true);
                return;
            }
        }

        for(int i = 0; i < columns; i++) {
            Symbol[] column = new Symbol[rows];

            for(int j = 0; j < rows; j++) {
                column[j] = grid[j][i];
            }

            if(column[0] != Symbol.EMPTY && isWinningLine(column)) {
                context.next(currentPlayer, true);
                return;
            }
        }

        Symbol[] diagonal1 = new Symbol[Math.min(rows, columns)];
        Symbol[] diagonal2 = new Symbol[Math.min(rows, columns)];

        for(int i = 0; i < Math.min(rows, columns); i++) {
            diagonal1[i] = grid[i][i];
            diagonal2[i] = grid[i][columns - 1 - i];
        }

        if(diagonal1[0] != Symbol.EMPTY && isWinningLine(diagonal1)) {
            context.next(currentPlayer, true);
            return;
        }

        if(diagonal2[0] != Symbol.EMPTY && isWinningLine(diagonal2)) {
            context.next(currentPlayer, true);
            return;
        }
    }

    public boolean isWinningLine(Symbol[] line) {
        Symbol first = line[0];
        for(Symbol s : line) {
            if(s != first) {
                return false;
            }
        }
        return true;
    }

    public void printBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Symbol symbol = grid[i][j];
                switch(symbol) {
                    case X:
                        System.out.print(" X ");
                        break;
                    case O:
                        System.out.print(" O ");
                        break;
                    case EMPTY:
                    default:
                        System.out.print(" . ");
                }

                if(j<columns-1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < rows - 1) {
                System.out.println("---+---+---");
            }
        }
        System.out.println();
    }
}
