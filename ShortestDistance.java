import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistance {

    private static final int ROWS = 6;
    private static final int COLS = 6;

    private static final int[] DROW = {-1, 0, 1, 0};
    private static final int[] DCOL = {0, 1, 0, -1};

    private static final int[][] map2d = {{1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}};

    public static class Cell {

        private int row;
        private int col;
        private int dist;

        public Cell(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
    
    public static void main(String[] args) {
        ShortestDistance shortDist = new ShortestDistance();
        shortDist.printMap(map2d);

        boolean[][] arrVis = new boolean[ROWS][COLS];
        shortDist.initArrVis(map2d, arrVis);

        shortDist.log("Dist=" + shortDist.findDist(map2d, arrVis, new Cell(1, 1, 0), new Cell(4, 4, 0)));
    }

    private int findDist(int[][] map2d, boolean[][] arrVis, Cell src, Cell dest) {
        Queue<Cell> queue = new LinkedList<>();
        queue.add(new Cell(src.row, src.col, 0));
        arrVis[src.row][src.col] = true;

        int dist = 0;
        while(!queue.isEmpty()) {
            Cell currCell = queue.poll();
            if(currCell.row == dest.row && currCell.col == dest.col) {
                dist = currCell.dist;
                break;
            } else {
                for(int i = 0; i < 4; i++) {
                    Cell newCell = new Cell(currCell.row + DROW[i], currCell.col + DCOL[i], currCell.dist + 1);
                    if(isValid(arrVis, newCell)) {
                        queue.add(newCell);
                        arrVis[newCell.row][newCell.col] = true;
                    }
                }
            }
        }

        return dist;
    }

    private void initArrVis(int[][] map2d, boolean[][] arrVis) {
        for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLS; j++) {
                if(map2d[i][j] == 0) {
                    arrVis[i][j] = true;
                }
            }
        }
    }

    private boolean isValid(boolean[][] visArr, Cell cell) {
        return (cell.row < 0 || cell.row >= ROWS || cell.col < 0 || cell.col >= COLS || visArr[cell.row][cell.col] ? false : true);
    }

    private void printMap(int[][] map2d) {
        for(int i = 0; i < ROWS; i++) {
            String row = "[";
            for(int j = 0; j < COLS; j++) {
                row += map2d[i][j] + ", ";
            }
            log(row.substring(0, row.length() - 2) + "]");
        }
    }

    private void log(String msg) {
        System.out.println(msg);
    }
}
