package minesweepv2;

public class GameBoard {

    private String[][] board;
    private String[][] boardDisplay;
    public static final String CELL = " ? ";
    public static final String MINE = " * ";
    public static final String EMPTY = "   ";

    public GameBoard(int height, int width, int mineCount) {
        this.board = new String[height+2][width+2];
        this.boardDisplay = new String[height+2][width+2];

        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                if ((x == 0 || x == board.length - 1) || (y == 0 || y == board[0].length - 1)) {
                    board[x][y] = EMPTY;
                    boardDisplay[x][y] = EMPTY;
                } else {
                    board[x][y] = CELL;
                    boardDisplay[x][y] = CELL;
                }
            }
        }

        for (int m = 0; m < mineCount; m++) {
            while (true) {
                int x, y;
                x = (int) (Math.random() * (board.length - 2) + 1);
                y = (int) (Math.random() * (board[0].length - 2) + 1);

                if (!board[x][y].equals(MINE)) {
                    board[x][y] = MINE;
                    break;
                }
            }
        }

    }

    public String[][] getBoard() {
        return board;
    }

    public String[][] getBoardDisplay() {
        return boardDisplay;
    }

    public int getBoardHeight() {
        return board.length;
    }

    public int getBoardwidth() {
        return board[0].length;
    }

    public String getBoardCell(int x, int y) {
        return board[x][y];
    }

    public void setBoardCell(int x, int y, String str) {
        board[x][y] = str;
    }

    public String getBoardDisplayCell(int x, int y) {
        return boardDisplay[x][y];
    }

    public void setBoardDisplayCell(int x, int y, String str) {
        boardDisplay[x][y] = str;
    }

    public void printView(String[][] str) {
        for (int x = 1; x < str.length - 1; x++) {
            for (int y = 0; y < str[0].length; y++) {
                if (y > 0 && y < str[0].length) {
                    System.out.print("|");
                } else {
                    System.out.println("");
                }

                System.out.print(str[x][y]);
            }
        }
        System.out.println();
    }
}