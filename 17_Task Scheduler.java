/* Problem Statement :-
Given a characters array tasks, representing the tasks a CPU needs to do, where each letter represents a different task. Tasks could be done in any order. Each task is done in one unit of time. For each unit of time, the CPU could complete either one task or just be idle.
However, there is a non-negative integer n that represents the cooldown period between two same tasks (the same letter in the array), that is that there must be at least n units of time between any two same tasks.
Return the least number of units of times that the CPU will take to finish all the given tasks.
*/

// Answer :-

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] charCount = new int[26];
        for(char c : tasks) {
            charCount[c - 'A'] += 1;
        }

        int maxFreq = 0, numMax = 0;

        for(int count : charCount) {
            if(count > maxFreq) {
                maxFreq = count;
                numMax = 1;
            } else if(count == maxFreq) {
                numMax++;
            }
        }

        int minPossibleTime = (n+1) * (maxFreq - 1) + numMax;
        return Math.max(minPossibleTime, tasks.length);
    }
}
