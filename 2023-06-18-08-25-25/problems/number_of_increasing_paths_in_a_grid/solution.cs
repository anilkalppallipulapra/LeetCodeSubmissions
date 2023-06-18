public class Solution {
    private const long Mod = 1000000007L;
    public int CountPaths(int[][] grid) {
        return CountIncreasingPaths(grid);
    }
    
    private long Dfs(int[][] grid, long[,] counts, int y, int x)
    {
        int m = grid.Length;
        int n = grid[0].Length;

        if (counts[y, x] != 0L)
        {
            return counts[y, x];
        }
        else
        {
            long v = grid[y][x];
            long sum = 1L;

            if (x > 0 && v > grid[y][x - 1]) sum = (sum + Dfs(grid, counts, y, x - 1)) % Mod;
            if (y > 0 && v > grid[y - 1][x]) sum = (sum + Dfs(grid, counts, y - 1, x)) % Mod;
            if (y < m - 1 && v > grid[y + 1][x]) sum = (sum + Dfs(grid, counts, y + 1, x)) % Mod;
            if (x < n - 1 && v > grid[y][x + 1]) sum = (sum + Dfs(grid, counts, y, x + 1)) % Mod;

            counts[y, x] = sum;
            return sum;
        }
    }

    private int CountIncreasingPaths(int[][] grid)
    {
        int m = grid.Length;
        int n = grid[0].Length;
        long[,] counts = new long[m, n];

        long result = 0L;
        for (int t = 0; t < m * n; t++)
        {
            int y = t / n;
            int x = t % n;
            result = (result + Dfs(grid, counts, y, x)) % Mod;
        }

        return (int)result;
    }
}