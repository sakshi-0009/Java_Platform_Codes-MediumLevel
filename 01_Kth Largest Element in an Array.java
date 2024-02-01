/* Problem Statement :-
Given an integer array nums and an integer k, return the kth largest element in the array.
Note that it is the kth largest element in the sorted order, not the kth distinct element.
*/

// Answer :-

class Solution {
    public int findKthLargest(int[] nums, int k) {
         int[] a = new int[2 * 10000 + 1];
        int offset = 10000;

        for (int i = 0; i < nums.length; i++) {
            a[nums[i] + offset] += 1;
        }

        int i = a.length - 1;
        while (k > 0) {
            k -= a[i];
            i--;
        }

        return i - offset + 1;
    }
}
