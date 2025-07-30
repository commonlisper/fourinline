package com.github.fourinline;

import com.github.fourinline.domain.Board;
import com.github.fourinline.domain.Token;

public class GameAnalyzer {
    private final Board board;

    public GameAnalyzer(Board board) {
        this.board = board;
    }

    public boolean isWin(Token token) {
        if (isColumnWin(token)) {
            return true;
        }

        if (isRowWin(token)) {
            return true;
        }

        // if (isDiagonalWin(token)) {
        // return true;
        // }

        // if (isOtherDiagonalWin(token)) {
        // return true;
        // }

        return false;
    }

    private boolean isOtherDiagonalWin(Token token) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isOtherDiagonalWin'");
    }

    private boolean isDiagonalWin(Token token) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isDiagonalWinOther'");
    }

    private boolean isRowWin(Token token) {
        int tokenCount = 0;
        Token prevToken = null;
        Token currentToken = null;

        for (int row = 0; row < board.getHeight(); row++) {
            tokenCount = 0;
            for (int column = 0; column < board.getWidth(); column++) {
                if (board.isEmpty(row, column)) {
                    continue;
                }

                currentToken = board.get(row, column);

                if (currentToken == token) {
                    if (prevToken == currentToken) {
                        tokenCount++;
                    } else {
                        tokenCount = 1;
                    }

                    if (tokenCount == 4) {
                        return true;
                    }
                }

                prevToken = currentToken;
            }
        }

        return false;
    }

    private boolean isColumnWin(Token token) {
        int tokenCount = 0;
        Token prevToken = null;
        Token currentToken = null;

        for (int column = 0; column < board.getWidth(); column++) {
            tokenCount = 0;
            for (int row = 0; row < board.getHeight(); row++) {
                if (board.isEmpty(row, column)) {
                    continue;
                }

                currentToken = board.get(row, column);

                if (currentToken == token) {
                    if (prevToken == currentToken) {
                        tokenCount++;
                    } else {
                        tokenCount = 1;
                    }

                    if (tokenCount == 4) {
                        return true;
                    }
                }

                prevToken = currentToken;
            }
        }

        return false;
    }
}
