/* Problem Statement :-
Given a matrix mat[][] of size N x M, where every row and column is sorted in increasing order, and a number X is given. The task is to find whether element X is present in the matrix or not.
*/

// Answer :-

class Sol {
    public static int matSearch(int mat[][], int N, int M, int X) {
        int row = 0;
        int col = M - 1;
        
        while (row < N && col >= 0) {
            if (mat[row][col] == X) {
                return 1; // Element found
            } else if (mat[row][col] > X) {
                col--;
            } else {
                row++;
            }
        }
        
        return 0;
    }
}
