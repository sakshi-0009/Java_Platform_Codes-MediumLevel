/* Problem Statement :-
Given an unsorted array Arr of size N of positive integers. One number 'A' from set {1, 2,....,N} is missing and one number 'B' occurs twice in array. Find these two numbers.
*/

// Answer :-

class Solve {
    int[] findTwoElement(int arr[], int n) {
        int[] result = new int[2];
        HashSet<Integer> seen = new HashSet<>();
        int duplicate = -1;
        
        for (int num : arr) {
            if (seen.contains(num)) {
                result[0] = num; // found duplicate
            } else {
                seen.add(num);
            }
        }
        
        for (int i = 1; i <= n; i++) {
            if (!seen.contains(i)) {
                result[1] = i; // found missing
                break;
            }
        }
        
        return result;
    }
}
