/* Problem Statement :-
You are given an array arr[] of size n. Find the total count of sub-arrays having their sum equal to 0
*/ 

// Answer :-

class Solution{

    public static long findSubarray(long[] arr ,int n) {
        HashMap<Long, Integer> prefixSumMap = new HashMap<>();

        long prefixSum = 0;
        long totalCount = 0;

        for (int i = 0; i < n; i++) {

            prefixSum += arr[i];

            if (prefixSum == 0) {
                totalCount++;
            }

            if (prefixSumMap.containsKey(prefixSum)) {
                totalCount += prefixSumMap.get(prefixSum);
            }

            prefixSumMap.put(prefixSum, prefixSumMap.getOrDefault(prefixSum, 0) + 1);
        }

        return totalCount;
    }
}
