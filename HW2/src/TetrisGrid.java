public class TetrisGrid {
    private boolean[][] grid;

    public  TetrisGrid(boolean[][] grid) {
        this.grid = grid;
    }

    public void clearRows() {
        for (int i = 1; i < grid.length ; i++) {
            grid[i-1] = grid[i];
        }
        grid[grid.length - 1] = new boolean[grid[0].length];
    }

    public boolean[][] getGrid() {
        return grid;
    }

    public void printGrid() {
        for (int i = 0; i < grid.length ; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        boolean[][] grid = new boolean[][] {
                {true,  false, true,  false, true},
                {false, true,  false, true,  false},
                {true,  true,  true,  true,  true},
                {false, false, true,  false, false},
                {true,  false, false, false, true}
        };
        TetrisGrid tetris = new TetrisGrid(grid);
        tetris.printGrid();
        System.out.println();
        tetris.clearRows();
        tetris.printGrid();



    }
}
