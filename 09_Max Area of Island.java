/* Problem Statement :-
You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
The area of an island is the number of cells with a value 1 in the island.
Return the maximum area of an island in grid. If there is no island, return 0.
*/

// Answer :-

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int ans = 0;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                int dfsR = dfs(grid, i, j);
                ans = Math.max(dfsR, ans);
            }
        }
        return ans;
        
    }

    public int dfs(int[][] grid, int row, int col) {
        if(row<0 || col<0|| row>=grid.length|| col>=grid[0].length || grid[row][col] == 0) {
            return 0;
        }
        grid[row][col] = 0;
        return 1+dfs(grid, row+1, col)+dfs(grid, row-1,col)+dfs(grid, row, col+1)+dfs(grid, row, col-1);
    }
}
