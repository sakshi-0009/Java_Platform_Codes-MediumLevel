/* Problem Statement :-
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.
*/

// Answer :-

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        boolean[] bitmap = new boolean[100001];
        //HashSet<Integer> unums = new HashSet();
        for (int n : nums) {
            if (n > 0) {
                //unums.add(n);
                bitmap[n] = true;
            }
        }
        ArrayList<List<Integer>> result = new ArrayList();
        
        int first = -10000000;
        int sec = -10000000;
        int max = nums[nums.length - 1];
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == first) {
                continue;
            }
            first = nums[i];
            if (first > 0) {
                break;
            }
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (nums[j] == sec) {
                    continue;
                }
                sec = nums[j];
                int req = 0 - first - sec;
                if (req > max) {
                    continue;
                }
                if (req < 0) {
                    break;
                }
                if (req == sec && nums[j + 1] == sec) {
                    result.add(List.of(first, sec, req));
                } else if (req > sec && bitmap[req] /*unums.contains(req)*/) {
                    result.add(List.of(first, sec, req));
                }
            }
        }
        
        return result;
    }
}
