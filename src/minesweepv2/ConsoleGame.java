package minesweepv2;

import java.util.Scanner;

public class ConsoleGame extends Game {

    private static final ConsoleGame SINGLE_INSTANCE = new ConsoleGame();

    private ConsoleGame() {
    }

    public static ConsoleGame getInstance() {
        return SINGLE_INSTANCE;
    }

    @Override
    public void run() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter board height, width and mine number:");
        int height = scan.nextInt();
        int width = scan.nextInt();
        int mine_number = scan.nextInt();
        board = new GameBoard(height, width, mine_number);
        game = new GameLogic(board);
        board.printView(board.getBoardDisplay());
        int x, y;

        while (true) {
            if (game.isFinished() && game.isWinner() == true) {
                System.out.println("YOU WIN!");
                board.printView(board.getBoard());
                break;
            } else if (game.isFinished() == true) {
                board.printView(board.getBoard());
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
