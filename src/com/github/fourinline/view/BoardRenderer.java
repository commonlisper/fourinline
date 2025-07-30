package com.github.fourinline.view;

import com.github.fourinline.domain.Board;
import com.github.fourinline.domain.Token;

public class BoardRenderer {
    public void render(Board board) {
        for (int row = 0; row < board.getHeight(); row++) {
            System.out.print(row + " |");
            for (int column = 0; column < board.getWidth(); column++) {
                if (board.isEmpty(row, column)) {
                    System.out.print(" |");
                    continue;
                }

                System.out.print(getSprite(board.get(row, column)) + "|");
            }
            System.out.println();
        }

        System.out.print("  ");
        for (int i = 0; i < board.getWidth(); i++) {
            System.out.print(" " + i);
        }

        System.out.println();
    }

    private String getSprite(Token token) {
        return token.name().substring(0, 1);
    }
}
