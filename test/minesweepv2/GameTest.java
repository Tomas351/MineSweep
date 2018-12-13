package minesweepv2;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GameTest {

    @Test
    public void test_noMinesPlacedInBorder() {
        GameBoard board = new GameBoard(5, 5, 10);
        Boolean noMines = true;
        for (int i = 0; i < board.getBoardwidth(); i += (board.getBoardwidth() - 1)) {
            for (int j = 0; j < board.getBoardHeight(); j++) {
                if (board.getBoardCell(i, j).equals(GameBoard.MINE)) {
                    noMines = false;
                }
            }
        }
        for (int i = 0; i < board.getBoardwidth(); i++) {
            for (int j = 0; j < board.getBoardHeight(); j += (board.getBoardHeight() - 1)) {
                if (board.getBoardCell(i, j).equals(GameBoard.MINE)) {
                    noMines = false;
                }
            }
        }
        Assert.assertTrue(noMines);
    }

    @Test
    public void test_correctMineNumber() {
        int MINE_NUMBER = 10;
        int ACTUAL_NUMBER = 0;
        GameBoard board = new GameBoard(5, 5, MINE_NUMBER);
        for (int x = 0; x < board.getBoardwidth(); x++) {
            for (int y = 0; y < board.getBoardHeight(); y++) {
                if (board.getBoardCell(x, y).equals(GameBoard.MINE)) {
                    ACTUAL_NUMBER++;
                }
            }
        }
        Assert.assertEquals(ACTUAL_NUMBER, MINE_NUMBER);
    }

}
