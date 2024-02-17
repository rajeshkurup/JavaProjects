import java.util.ArrayList;
import java.util.List;

public class WordsBoard {

    private static final int ROWS = 4;
    private static final int COLS = 4;

    private static int[] DROW = {-1, 0, 1, 0};
    private static int[] DCOL = {0, 1, 0, -1};

    public static class Cell {

        private int row;
        private int col;

        public Cell(int row, int col) {
            this.col = col;
            this.row = row;
        }
    }

    public static void main(String[] args) {

        char[][] board2d = new char[ROWS][COLS];
        String[] words = {"book", "pipe", "fool", "mark", "fire", "mall", "road"};
        WordsBoard wordsBoard = new WordsBoard();
        wordsBoard.fillBoard2d(board2d, words);
        wordsBoard.printBoard2d(board2d);

        List<String> wordsFound = new ArrayList<>();
        for(String word : words) {
            if(wordsBoard.findWord(board2d, word)) {
                wordsFound.add(word);
            }
        }
        wordsBoard.log("wordsFound=" + wordsFound.toString());
    }

    private boolean findWord(char[][] board2d, String word) {
        boolean[][] cellVis = new boolean[ROWS][COLS];
        Cell cell = findChar(board2d, word.charAt(0), cellVis);
        while(cell != null) {
            boolean[][] adjCellVis = new boolean[ROWS][COLS];
            adjCellVis[cell.row][cell.col] = true;
            for(int i = 1; i < word.length(); i++) {
                cell = findAdjChar(board2d, word.charAt(i), adjCellVis, cell);
                if(cell == null) {
                    break;
                }
            }

            if(cell == null) {
                cell = findChar(board2d, word.charAt(0), cellVis);
            } else {
                break;
            }
        }
        return (cell != null);
    }

    private Cell findChar(char[][] board2d, char currChar, boolean[][] cellVis) {
        for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLS; j++) {
                if(board2d[i][j] == currChar && !cellVis[i][j]) {
                    cellVis[i][j] = true;
                    return new Cell(i, j);
                }
            }
        }
        return null;
    }

    private Cell findAdjChar(char[][] board2d, char nextChar, boolean[][] adjCellVis, Cell currCell) {
        for(int i = 0; i < 4; i++) {
            Cell nextCell = new Cell(currCell.row + DROW[i], currCell.col + DCOL[i]);
            if(isValid(board2d, adjCellVis, nextCell)) {
                if(board2d[nextCell.row][nextCell.col] == nextChar) {
                    adjCellVis[nextCell.row][nextCell.col] = true;
                    return new Cell(nextCell.row, nextCell.col);
                }
            }
        }
        return null;
    }

    // return false if cell is out of boundary or cell is already visited
    private boolean isValid(char[][] board2d, boolean[][] cellVis, Cell cell) {
        return (cell.col < 0 || cell.col >= COLS || cell.row < 0 || cell.row >= ROWS || cellVis[cell.row][cell.col] ? false : true);
    }

    private void fillBoard2d(char[][] board2d, String[] words) {
        int row = words.length - 1;
        for(int i = 0; i < ROWS; i++) {
            int col = words[row--].length() - 1;
            for(int j = 0; j < COLS; j++) {
                board2d[i][j] = words[row].charAt(col--);
            }
        }
    }

    private void printBoard2d(char[][] board2d) {
        for(int i = 0; i < ROWS; i++) {
            String row = "[";
            for(int j = 0; j < COLS; j++) {
                row += board2d[i][j] + ", ";
            }
            log(row.substring(0, row.length() - 2) + "]");
        }
    }

    private void log(String msg) {
        System.out.println(msg);
    }
    
}
