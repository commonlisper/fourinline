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
    private final BoardRenderer renderer;

    public Game(Board board, List<Player> players) {
        this.board = board;
        this.players = players;
        this.renderer = new BoardRenderer();
    }

    public void start() {
        while (true) {
            for (Player player : players) {
                renderer.render(board);

                System.out.println("Player: " + player.getName() + " makes a move.");
                System.out.println("His token55 is: " + player.getToken().name());

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
    }
}
