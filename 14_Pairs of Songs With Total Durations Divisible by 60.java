/* Problem Statement :-
You are given a list of songs where the ith song has a duration of time[i] seconds.
Return the number of pairs of songs for which their total duration in seconds is divisible by 60. Formally, we want the number of indices i, j such that i < j with (time[i] + time[j]) % 60 == 0.
*/

// Answer :-

class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] remainders = new int[60];
        int result = 0;

        for (var t : time) {
            result += remainders[(60 - t % 60) % 60];
            remainders[t % 60]++;
        }

        return result;
    }
}
