class Solution {
    public int countNegatives(int[][] grid) { 
        // Number of rows
        int m = grid.length;
        // Number of columns
        int n = grid[0].length;
        // Number of negative numbers
        int count = 0;
        // Starting row top left corner
        int row = 0;
        // Starting column top right corner
        int col = n - 1;
        while (row < m && col >= 0) {
            if (grid[row][col] < 0) {
                // add the number of negative elements in this column to the count
                count += m - row;
                // move left to the next column
                col--;
            } else {
                // move down to the next row
                row++;
            }
        }
        return count;        
    }
}