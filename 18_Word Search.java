/* Problem Statement :-
Given an m x n grid of characters board and a string word, return true if word exists in the grid.
The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
*/

// Answer :-

class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (helper(0, i, j, board, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean helper(int pos, int row, int col, char[][] board, String word) {
        if (pos == word.length()) {
            return true;
        }
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
            return false;
        }
        char c = board[row][col];
        if (c == '?') {
            return false;
        }
        if (c != word.charAt(pos)) {
            return false;
        }

        board[row][col] = '?';
        if (helper(pos + 1, row + 1, col, board, word)) {
            return true;
        }

        if (helper(pos + 1, row - 1, col, board, word)) {
            return true;
        }

        if (helper(pos + 1, row, col + 1, board, word)) {
            return true;
        }

        if (helper(pos + 1, row, col - 1, board, word)) {
            return true;
        }

        board[row][col] = c;
        return false;
    }

}
