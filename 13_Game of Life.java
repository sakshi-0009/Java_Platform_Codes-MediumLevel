/* Problem Statement :-
According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population.
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.
*/

// Answer :-

class Solution {
    
    int[][] board;
    int n, m;
    
    private int getLiveNeighbourCount(int x, int y) {
        int count = 0;
        for (int i=-1; i<=1; i++) {
            for (int j=-1; j<=1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int nx = x + i, ny = y + j;
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny]%2 == 1) {
                    count++;
                }
            }
        }
        return count;
    }
    
    public void gameOfLife(int[][] board) {
        
        this.board = board;
        n = board.length;
        m = board[0].length;
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                int count = getLiveNeighbourCount(i, j);
                int curr;
                if (board[i][j] == 0) {
                    curr = count == 3 ? 1 : 0;
                } else {
                    curr = count < 2 ? 0 : (count > 3 ? 0 : 1);
                }
                board[i][j] += curr*2;
                // System.out.printf("%d ", curr);
            }
            // System.out.println();
        }
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                board[i][j] /= 2;
            }
        }
        
    }
}
