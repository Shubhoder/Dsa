package Stack;
import java.util.*;
/*
You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent
the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given
 an interval newInterval = [start, end] that represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals
 still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.



Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].


Constraints:

0 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 105
intervals is sorted by starti in ascending order.
newInterval.length == 2
0 <= start <= end <= 105
 */


/**
 * This is not my solution but its important for me because i solved that type or question and i need to dry run
 */
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        Stack<int[]> stack = new Stack<>();
        boolean inserted = false;

        for (int i = 0; i < intervals.length; i++) {
            if (!inserted) {
                if (newInterval[1] < intervals[i][0]) { // Case: newInterval is before intervals[i]
                    stack.push(newInterval);
                    stack.push(intervals[i]);
                    inserted = true;
                } else if (newInterval[0] > intervals[i][1]) { // Case: newInterval is after intervals[i]
                    stack.push(intervals[i]);
                } else { // Case: newInterval overlaps with intervals[i]
                    newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                    newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
                }
            } else { // newInterval has been inserted
                int[] top = stack.peek();
                if (top[1] < intervals[i][0]) { // No overlap, push intervals[i]
                    stack.push(intervals[i]);
                } else { // Merge with top of stack
                    top[1] = Math.max(top[1], intervals[i][1]);
                }
            }
        }

        if (!inserted) { // Handle case where newInterval is after all intervals
            stack.push(newInterval);
        }

        // Convert stack to array
        int[][] result = new int[stack.size()][2];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}
