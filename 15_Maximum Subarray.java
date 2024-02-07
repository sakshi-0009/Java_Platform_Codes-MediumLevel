/* Problem Statement :-
Given an integer array nums, find the subarray with the largest sum, and return its sum.
*/

// Answer :-

class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int Sum = 0;
       
        for(int i=0;i<nums.length;i++){
            Sum = Sum + nums[i];
            if(Sum>max){
                max = Sum;
            }
            if(Sum<0){
                Sum = 0;
            }
        }
        return max;
    }
}
