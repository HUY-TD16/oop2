import java.util.HashSet;

public class CharGrid {
    private char[][] grid;

    public void setGrid(char[][] grid) {
        this.grid = grid;
    }

    public CharGrid(char[][] grid) {
        this.grid = grid;
    }

    public int charArea(char ch) {
        int row = grid.length;
        int col = grid[0].length;
        int minCow = col, maxCow = -1;
        int minRow = row, maxRow = -1;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == ch) {
                    if (minCow > j) {
                        minCow = j;
                    }
                    if (maxCow < j) {
                        maxCow = j;
                    }
                    if (minRow > i) {
                        minRow = i;
                    }
                    if (maxRow < i) {
                        maxRow = i;
                    }
                }
            }
        }
        if (maxCow == -1) {
            return 0;
        }
        return (maxCow - minCow + 1) * (maxRow - minRow + 1);
    }

    public int countPlus() {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (isPlus(i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isPlus(int row, int col) {
        char ch = grid[row][col];
        int up = 0;
        for (int i = row - 1; i >= 0 && ch == grid[i][col]; i--) {
            up++;
        }
        int down = 0;
        for (int i = row + 1; i < grid.length && ch == grid[i][col]; i++) {
            down++;
        }
        int left = 0;
        for (int i = col - 1; i >= 0 && ch == grid[row][i]; i--) {
            left++;
        }
        int right = 0;
        for (int i = col + 1; i < grid[row].length && ch == grid[row][i]; i++) {
            right++;
        }
        if (up >= 2 && down >= 2 && left >= 2 && right >= 2) {
            if (up == down && left == right) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] grid = {
                {' ', ' ', 'p', ' ', ' '},
                {' ', ' ', 'p', ' ', 'x'},
                {'p', 'p', 'p', 'p', 'p'},
                {' ', ' ', 'p', ' ', 'x'},
                {' ', ' ', 'p', 'y', 'y'},
                {'z', 'z', 'z', 'z', 'z'},
                {' ', ' ', 'x', 'x', ' '}
        };

        CharGrid charGrid = new CharGrid(grid);
        int result = charGrid.countPlus();
        System.out.println("Số chữ thập trong bảng: " + result); // mong đợi = 2
    }
}

