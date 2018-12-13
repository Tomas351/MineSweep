package minesweepv2;

public class GameLogic {

    private GameBoard board;
    private Boolean FINISHED;
    private Boolean WON;

    public GameLogic(GameBoard board) {
        this.board = board;
        this.FINISHED = false;
        this.WON = false;
    }

    public void clearCell(int x, int y) {
        if (neighbour(x, y) > 0) {
            board.setBoardDisplayCell(x,y," " + neighbour(x, y) + " ");
             board.setBoardCell(x, y, GameBoard.EMPTY);
        } else {
            for (int i = (x - 1); i <= (x + 1); i++) {
                for (int j = (y - 1); j <= (y + 1); j++) {
                    if (board.getBoardCell(i,j).equals(GameBoard.CELL) && neighbour(i, j) == 0) {
                        board.setBoardDisplayCell(i, j, GameBoard.EMPTY);
                        board.setBoardCell(i, j, GameBoard.EMPTY);
                        clearCell(i, j);
                    } else if (board.getBoardCell(i,j).equals(GameBoard.CELL) && neighbour(i, j) > 0) {
                        board.setBoardDisplayCell(i, j, " " + neighbour(i, j) + " ");
                        board.setBoardCell(i, j, GameBoard.EMPTY);
                    }
                }
            }
        }
    }

    public int neighbour(int x, int y) {
        int nums = 0;
        for (int i = (x - 1); i <= (x + 1); i++) {
            for (int j = (y - 1); j <= (y + 1); j++) {
                if (board.getBoardCell(i,j).equals(GameBoard.MINE) == true) {
                    nums++;
                }
            }
        }
        return nums;
    }

    public void makeTurn(int x, int y) {
        if (board.getBoardCell(x,y).equals(GameBoard.CELL)) {
            clearCell(x, y);
            board.printView(board.getBoardDisplay());
        } else if (board.getBoardCell(x,y).equals(GameBoard.MINE)) {
            FINISHED = true;
            WON = false;
            System.out.println("You lost!");
        } else if (board.getBoardDisplayCell(x,y).equals(GameBoard.EMPTY) && board.getBoardCell(x,y).equals(GameBoard.EMPTY)) {
            System.out.println("This was checked already!");
            board.printView(board.getBoardDisplay());
        }
    }

    public void checkWin() {
        int tile = 0;
        for (int i = 0; i < board.getBoardHeight(); i++) {
            for (int j = 0; j < board.getBoardwidth(); j++) {
                if (board.getBoardCell(i,j).equals(GameBoard.CELL)) {
                    tile++;
                }
            }
        }
        if (tile != 0) {
            WON = false;
        } else {
            WON = true;
            FINISHED = true;
        }
    }

    public Boolean isFinished() {
        return FINISHED;
    }

    public Boolean isWinner() {
        return WON;
    }
}
