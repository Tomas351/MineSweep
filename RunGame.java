package minesweeperv1;

import java.util.Scanner;

public class RunGame {

    private static int MINE_NUMBER = 6;

    public static void run() {
        Game game = new Game();
        game.randomMines(MINE_NUMBER);
        System.out.println("There is "+ MINE_NUMBER + " MINES");
        game.updateDisplay();
        Scanner scan = new Scanner(System.in);
        int x, y;

        while (true) {
            if (game.isFinished() && game.isWinner() == true) {
                System.out.println("YOU WIN!");
                game.displayMines();
                break;
            } else if (game.isFinished() == true) {
                game.displayMines();
                break;
            } else if (game.isFinished() == false) {
                System.out.print("Enter x coordinate.");
                y = scan.nextInt();
                System.out.print("Enter y coordinate.");
                x = scan.nextInt();
                game.makeTurn(x, y);
                game.checkWin();
            }

        }
    }
}
