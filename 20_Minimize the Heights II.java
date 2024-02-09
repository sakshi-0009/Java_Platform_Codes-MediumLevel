/* Problem Statement :-
Find out the minimum possible difference between the height of the shortest and tallest towers after you have modified each tower.
You don't need to read input or print anything. Your task is to complete the function getMinDiff() which takes the arr[], n, and k as input parameters and returns an integer denoting the minimum difference.
*/

// Answer :-

class Solution {
    int getMinDiff(int[] arr, int n, int k) {
        Arrays.sort(arr);
        
        int ans = arr[n - 1] - arr[0];
        
        int smallest = arr[0] + k;
        int largest = arr[n - 1] - k;
        
        int min, max;
        
        for (int i = 0; i < n - 1; i++) {
            min = Math.min(smallest, arr[i + 1] - k);
            max = Math.max(largest, arr[i] + k);
            
            if (min < 0) continue;
            
            ans = Math.min(ans, max - min);
        }
        
        return ans;
    }
}
