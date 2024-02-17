import java.util.LinkedList;
import java.util.Queue;

public class BfsSample {

    private static final int ROWS = 4;
    private static final int COLS = 4;

    private static final int[] DROW = {-1, 0, 1, 0};
    private static final int[] DCOL = {0, 1, 0, -1};

    public static class Cell {

        private int row;
        private int col;

        public Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) {

        int[][] arr2d = new int[ROWS][COLS];
        BfsSample bfs = new BfsSample();
        bfs.fillArr2d(arr2d);
        bfs.printArr2d(arr2d);

        boolean[][] arrVis = new boolean[ROWS][COLS];
        bfs.bfsTraverse(arr2d, arrVis, new Cell(0, 0));
    }

    // visit given cell
    // visit adjescent cells if they are not visited already
    private void bfsTraverse(int[][] arr2d, boolean[][] arrVis, Cell cell) {
        Queue<Cell> queue = new LinkedList<>();
        queue.add(new Cell(cell.row, cell.col)); // visit cell
        arrVis[cell.row][cell.col] = true; // mark visited cell

        while(!queue.isEmpty()) {
            Cell currCell = queue.poll();
            log("" + arr2d[currCell.row][currCell.col]);

            // visit adjescent cells
            for(int i = 0; i < 4; i++) {
                Cell newCell = new Cell(currCell.row + DROW[i], currCell.col + DCOL[i]);
                if(isValid(arr2d, arrVis, newCell)) {
                    queue.add(newCell);
                    arrVis[newCell.row][newCell.col] = true;
                }
            }
        }
    }

    // return false if current cell is out of boundary or it is already visited
    private boolean isValid(int[][] arr2d, boolean[][] arrVis, Cell cell) {
        return (cell.row < 0 || cell.row >= ROWS || cell.col < 0 || cell.col >= COLS || arrVis[cell.row][cell.col] ? false : true);
    }

    private void fillArr2d(int[][] arr2d) {
        int count = 1;
        for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLS; j++) {
                arr2d[i][j] = count++;
            }
        }
    }

    private void printArr2d(int[][] arr2d) {
        for(int i = 0; i < ROWS; i++) {
            String row = "[";
            for(int j = 0; j < COLS; j++) {
                row += arr2d[i][j] + ", ";
            }
            log(row.substring(0, row.length() - 2) + "]");
        }
    }

    private void log(String msg) {
        System.out.println(msg);
    }
    
}
