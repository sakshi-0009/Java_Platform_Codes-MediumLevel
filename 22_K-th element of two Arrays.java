/* Problem Statement :-
Given two sorted arrays arr1 and arr2 of size N and M respectively and an element K. The task is to find the element that would be at the kth position of the final sorted array.
*/

// Answer :-

class Solution {
    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        
        int i = 0, j = 0;
        int count = 0;
        long result = 0;

        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) {
                count++;
                if (count == k)
                    result = arr1[i];
                i++;
            } else {
                count++;
                if (count == k)
                    result = arr2[j];
                j++;
            }
        }

        while (i < n) {
            count++;
            if (count == k)
                result = arr1[i];
            i++;
        }

        while (j < m) {
            count++;
            if (count == k)
                result = arr2[j];
            j++;
        }

        return result;
    }
}
