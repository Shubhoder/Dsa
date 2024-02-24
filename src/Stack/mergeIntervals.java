package Stack;
import java.util.*;

import java.util.Stack;

/*
Given a collection of Intervals, the task is to merge all of the overlapping Intervals.

Example 1:

Input:
Intervals = {{1,3},{2,4},{6,8},{9,10}}
Output: {{1, 4}, {6, 8}, {9, 10}}
Explanation: Given intervals: [1,3],[2,4]
[6,8],[9,10], we have only two overlapping
intervals here,[1,3] and [2,4]. Therefore
we will merge these two and return [1,4],
[6,8], [9,10].
Example 2:

Input:
Intervals = {{6,8},{1,9},{2,4},{4,7}}
Output: {{1, 9}}
Your Task:
Complete the function overlappedInterval() that takes the list N intervals as input parameters and returns sorted list of intervals after merging.

Expected Time Complexity: O(N*Log(N)).
Expected Auxiliary Space: O(Log(N)) or O(N).

Constraints:
1 ≤ N ≤ 100
0 ≤ x ≤ y ≤ 1000
 */

public class mergeIntervals {
    public int[][] overlappedInterval(int[][] Intervals)
    {
        // Code here // Code here
        Arrays.sort(Intervals , (a,b)->Integer.compare(a[0], b[0]));
        Stack<int[]> st = new Stack<>();
        st.push(Intervals[0]);

        for(int i = 1 ; i < Intervals.length ; i++){
            int startpoint2 = Intervals[i][0];
            int endpoint2 = Intervals[i][1];

            int[] poparray = st.pop();

            int startpoint1 = poparray[0];
            int endpoint1 = poparray[1];

            int endmax = Math.max(endpoint1 , endpoint2);

            if(endpoint1>=startpoint2){
                int merge[] = new int[]{startpoint1 ,endmax };
                st.push(merge);
            }else{
                st.push(poparray);
                st.push(Intervals[i]);
            }
        }

        int output[][] = new int[st.size()][2];

        for(int i = output.length-1 ; i>=0 ; i--){
            int[] poparray = st.pop();
            output[i][0] = poparray[0];
            output[i][1] = poparray[1];
        }

        return output;
    }
}
