/* Problem Statement :-
Given a boolean 2D array of n x m dimensions, consisting of only 1's and 0's, where each row is sorted. Find the 0-based index of the first row that has the maximum number of 1's.
*/

// Answer :-

class Solution {
    int rowWithMax1s(int arr[][], int n, int m) {

        int maxRowIndex = -1;
        int maxCount = 0;

        int row = 0;
        int col = m - 1;

        while (row < n && col >= 0) {

            if (arr[row][col] == 1) {
                col--;
                maxRowIndex = row;
                maxCount = m - col - 1;
            } else {
                row++;
            }
        }

        return maxRowIndex;
    }
}
