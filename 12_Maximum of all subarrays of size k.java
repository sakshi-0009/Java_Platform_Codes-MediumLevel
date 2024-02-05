/* Problem Statement :-
Given an array arr[] of size N and an integer K. Find the maximum for each and every contiguous subarray of size K.
*/

// Answer :-

class Solution {
    static ArrayList <Integer> max_of_subarrays(int arr[], int n, int k) {
        
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < k; i++) {

            while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }

        for (int i = k; i < n; i++) {

            result.add(arr[deque.peekFirst()]);

            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.removeFirst();
            }

            while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]) {
                deque.removeLast();
            }

            deque.addLast(i);
        }

        result.add(arr[deque.peekFirst()]);

        return result;
    }
}
