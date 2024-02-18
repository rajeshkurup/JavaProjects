import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPaths {

    private static final int ROWS = 6;
    private static final int COLS = 6;

    private static int[] DROW = {0, 1, 0, -1};
    private static int[] DCOL = {1, 0, -1, 0};

    private static int[][] map2d = {{1, 1, 1, 1, 1, 1}, {0, 1, 1, 0, 0, 1}, {0, 0, 1, 0, 0, 1}, {1, 1, 1, 0, 0, 0}, {1, 1, 1, 1, 0, 0}, {1, 1, 1, 1, 1, 1}};

    public static class Cell {

        private int row;
        private int col;
        private int dist;
        private String path;

        public Cell(int row, int col, int dist, String path) {
            this.row = row;
            this.col = col;
            this.dist = dist + 1;
            this.path = (path.isEmpty() ? "(" : path + " -> (") + row + ", " + col + ")";
        }

        @Override
        public String toString() {
            return this.path + " => " + this.dist;
        }
    }
    
    public static void main(String[] args) {
        ShortestPaths shortPaths = new ShortestPaths();
        shortPaths.print2dMap(map2d);

        boolean[][] arrVisited = new boolean[ROWS][COLS];
        Cell src = new Cell(0, 0, 0, "");
        Cell dest = new Cell(5, 5, 0, "");

        for(String path : shortPaths.findPaths(map2d, arrVisited, src, dest)) {
            shortPaths.log("path=" + path);
        }
    }

    private List<String> findPaths(int[][] map2d, boolean[][] arrVis, Cell src, Cell dest) {
        List<String> paths = new ArrayList<>();
        Queue<Cell> queue = new LinkedList<>();
        queue.add(src);

        while(!queue.isEmpty()) {
            Cell curCell = queue.poll();
            arrVis[curCell.row][curCell.col] = true;

            if(curCell.row == dest.row && curCell.col == dest.col) {
                paths.add(curCell.toString());
            } else {
                for(int i = 0; i < 4; i++) {
                    Cell newCell = new Cell(curCell.row + DROW[i], curCell.col + DCOL[i], curCell.dist, curCell.path);
                    if(isValid(map2d, arrVis, newCell)) {
                        queue.add(newCell);
                    }
                }
            }
        }

        return paths;
    }

    private boolean isValid(int[][] map2d, boolean[][] arrVis, Cell cell) {
        return (cell.row >= 0 && cell.row < ROWS && cell.col >= 0 && cell.col < COLS && map2d[cell.row][cell.col] == 1 && !arrVis[cell.row][cell.col]);
    }

    private void print2dMap(int[][] map2d) {
        for(int i = 0; i < ROWS; i++) {
            String row = "[";
            for(int j = 0; j < COLS; j++) {
                row += map2d[i][j] + (j + 1 < COLS ? ", " : "");
            }
            log(row + "]");
        }
    }

    private void log(String msg) {
        System.out.println(msg);
    }

}
