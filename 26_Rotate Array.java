/* Problem Statement :-
Given an unsorted array arr[] of size N. Rotate the array to the left (counter-clockwise direction) by D steps, where D is a positive integer. 
*/

// Answer :-

class Solution {
    static void rotateArr(int arr[], int d, int n) {
        d = d % n;
        
        reverse(arr, 0, d - 1);
        
        reverse(arr, d, n - 1);
        
        reverse(arr, 0, n - 1);
    }
    
    static void reverse(int arr[], int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
