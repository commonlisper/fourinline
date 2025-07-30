package com.github.fourinline.domain;

public class Board {
    

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
