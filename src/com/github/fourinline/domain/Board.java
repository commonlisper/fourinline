package com.github.fourinline.domain;

public class Board {
    private final int width;
    private final int height;
    private final Token[][] field;

    public Board(Size size) {
        width = size.getColumns();
        height = size.getRows();
        field = new Token[height][width];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Token get(int row, int column) {
        if (isEmpty(row, column)) {
            throw new IllegalArgumentException("The cell[" + row + ", " + column + "] is empty!");
        }

        return field[row][column];
    }

    public boolean isEmpty(int row, int column) {
        return field[row][column] == null;
    }

    public void put(int column, Token token) {
        if (isFilled(column)) {
            throw new IllegalArgumentException("The column `" + column + "` is filled!");
        }

        for (int row = height - 1; row >= 0; row--) {
            if (isEmpty(row, column)) {
                field[row][column] = token;
                return;
            }
        }
    }

    public boolean isFilled(int column) {
        return !isEmpty(0, column);
    }

    public enum Size {
        DEFAULT(6, 7),
        ROW7_COLUMN8(7, 8),
        ROW7_COLUMN9(7, 9),
        ROW7_COLUMN10(7, 10);

        private final int rows;
        private final int columns;

        Size(int rows, int columns) {
            this.rows = rows;
            this.columns = columns;
        }

        public int getRows() {
            return rows;
        }

        public int getColumns() {
            return columns;
        }
    }
}
