package com.github.fourinline;

import java.util.List;

import com.github.fourinline.domain.Board;
import com.github.fourinline.domain.Player;
import com.github.fourinline.view.BoardRenderer;
import com.github.fourinline.view.Dialog;
import com.github.fourinline.view.MinMaxDialog;

public class Game {
    private final Board board;
    private final List<Player> players;
    private final GameAnalyzer analyzer;
    private final BoardRenderer renderer;

    public Game(Board board, GameAnalyzer analyzer, List<Player> players) {
        this.board = board;
        this.analyzer = analyzer;
        this.players = players;
        this.renderer = new BoardRenderer();
    }

    public void start() {
        while (true) {
            for (Player currentPlayer : players) {
                renderer.render(board);

                System.out.println("Player: " + currentPlayer.getName() + " makes a move.");
                System.out.println("His token is: " + currentPlayer.getToken().name());

                makeMove(currentPlayer);
                boolean isWin = analyzer.isWin(currentPlayer.getToken());

                System.out.println("Is token: " +
                        currentPlayer.getToken() +
                        " win? => " +
                        isWin);

                System.out.println();
            }
        }
    }

    private void makeMove(Player player) {
        int column;

        while (true) {
            Dialog<Integer> dialog = new MinMaxDialog("Enter column for move: ",
                    "You entered an incorrect number:",
                    0,
                    board.getWidth() - 1);

            column = dialog.input();
            if (board.isFilled(column)) {
                System.out.println("The column `" + column + "` is filled!");
                continue;
            }

            break;
        }

        board.put(column, player.getToken());
    }
}
