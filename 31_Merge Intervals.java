/* Problem Statement :-
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
*/

// Answer :-

class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0) return null;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> list = new ArrayList<>();
        int[] cur = intervals[0];

        for(int[] next : intervals) {
            if(next[0] <= cur[1]) {
                cur[1] = Math.max(cur[1], next[1]);
            } else {
                list.add(cur);
                cur = next;
            }
        }

        list.add(cur);
        int[][] result = new int[list.size()][2];
        for(int i = 0; i < list.size(); ++i) {
            result[i] = list.get(i);
        }

        return result;
    }
}
