package minesweeperv1;

public class Game {

    public String[][] board = new String[7][7];
    public String[][] boardDisplay = new String[7][7];
    public Boolean finished = false;
    public Boolean won = false;

    private String cell = " ? ";
    private String mine = " * ";
    private String empty = "   ";

    public Game() {

        int row = 0;
        int column = 0;

        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                if ((x == 0 || x == board.length - 1) || (y == 0 || y == board[0].length - 1)) {
                    board[x][y] = empty;
                    boardDisplay[x][y] = empty;
                } else {
                    board[x][y] = cell;
                    boardDisplay[x][y] = cell;
                }
            }
        }
    }

    public static void printDisplay(String[][] str) {
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
    }

    public void updateDisplay() {
        printDisplay(boardDisplay);
        System.out.println();
    }

    public void randomMines(int mineNumber) {
        for (int m = 0; m < mineNumber; m++) {
            while (true) {
                int x, y = 0;
                x = (int) (Math.random() * (board.length - 2) + 1);
                y = (int) (Math.random() * (board[0].length - 2) + 1);

                if (!board[x][y].equals(mine)) {
                    board[x][y] = mine;
                    break;
                }
            }
        }
    }

    public void clear(int x, int y) {
        if(neighbour(x,y)>0) boardDisplay[x][y] = " " + neighbour(x,y)+ " ";
        else{
            for (int i = (x - 1); i <= (x + 1); i++)
            for (int j = (y - 1); j <= (y + 1); j++) {
                if (board[i][j].equals(cell) && neighbour(i,j)==0) { 
                        boardDisplay[i][j] = empty;
                        board[i][j] = empty;
                        clear(i,j);
                    }
                else if(board[i][j].equals(cell) && neighbour(i,j)>0){
                        boardDisplay[i][j]= " " + neighbour(i,j) + " ";
                        board[i][j] = empty;
                    }
            }
    }
    }


    public int neighbour(int x,int y) {
                    int nums = 0;
                    for (int i = (x - 1); i <= (x + 1); i++) {
                        for (int j = (y - 1); j <= (y + 1); j++) {
                            if (board[i][j].equals(mine) == true) {
                                nums++;
                            }
                        }
                    }
                    return nums;
            }

    public void makeTurn(int x, int y) {
        if (board[x][y].equals(cell)) {
            clear(x,y);
            updateDisplay();
        } else if (board[x][y].equals(mine)) {
            finished = true;
            won = false;
            System.out.println("You lost!");
        } else if (boardDisplay[x][y].equals(empty) && board[x][y].equals(empty)) {
            finished = false;
            System.out.println("This was checked already!");
            updateDisplay();
        }
    }

    public void checkWin() {
        int tile = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j].equals(cell)) {
                    tile++;
                }
            }
        }
        if (tile != 0) {
            won = false;
        } else {
            won = true;
            finished = true;
        }
    }

    public Boolean isFinished() {
        return finished;
    }

    public Boolean isWinner() {
        return won;
    }

    public void displayMines() {
        printDisplay(board);
    }

}