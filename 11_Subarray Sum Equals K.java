/* problem Statement :-
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
A subarray is a contiguous non-empty sequence of elements within an array.
*/

// Answer :-

class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;

        Map<Integer, Integer> sumOccurrences = new HashMap<>();

        sumOccurrences.put(0, 1);

        for (int num : nums) {
            sum += num;
            if (sumOccurrences.containsKey(sum - k)) {
                count += sumOccurrences.get(sum - k);
            }

            sumOccurrences.put(sum, sumOccurrences.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
