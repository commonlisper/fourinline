package com.github.fourinline;

import java.util.List;

import com.github.fourinline.domain.Board;
import com.github.fourinline.domain.Player;
import com.github.fourinline.domain.Token;
import com.github.fourinline.view.BoardRenderer;

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
        board.put(0, Token.RED);
        board.put(1, Token.GREEN);
        board.put(2, Token.BLUE);
        board.put(3, Token.YELLOW);

        board.put(0, Token.BLUE);
        board.put(0, Token.GREEN);
        board.put(0, Token.YELLOW);

        board.put(2, Token.BLUE);
        board.put(2, Token.BLUE);

        renderer.render(board);
    }
}
