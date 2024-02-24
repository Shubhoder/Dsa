package Stack;
import java.util.*;

/*
Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i], nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] < nums[j].

Return true if there is a 132 pattern in nums, otherwise, return false.



Example 1:

Input: nums = [1,2,3,4]
Output: false
Explanation: There is no 132 pattern in the sequence.
Example 2:

Input: nums = [3,1,4,2]
Output: true
Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
Example 3:

Input: nums = [-1,3,2,0]
Output: true
Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].

 */


// Me yaha 3 java code likh rha hu kyuki me abhi confuse hu ki kon sa mujhe smjh aaya tha jaise hi mujhe
// jo code smjh aayega waise me vo code ko rakhunga with proper logic ki maine kya logic se e question smjh aaya

/*1st*/

//public class _132_Pattern {
//    public boolean find132pattern(int[] nums) {
//        int n = nums.length;
//        Stack<Integer> st = new Stack<>();
//        st.push(nums[n-1]);
//        int thirdElement = Integer.MIN_VALUE;
//
//        for(int i = n-2 ; i>=0; i--){
//            if(thirdElement > nums[i])return true;
//            while(!st.isEmpty()&&nums[i]>st.peek()){
//                thirdElement = st.peek();
//                st.pop();
//            }
//            st.push(nums[i]);
//        }
//
//
//        return false;
//    }
//}
//
//}

/*2nd*/

//class Solution {
//    public boolean find132pattern(int[] nums) {
//        int n = nums.length;
//        int num3 = Integer.MIN_VALUE; // Change to MIN_VALUE to represent that no value has been found yet
//        Stack<Integer> st = new Stack<>();
//
//        for (int i = n - 1; i >= 0; i--) {
//            if (nums[i] < num3) {
//                return true;
//            }
//            while (!st.isEmpty() && st.peek() < nums[i]) {
//                num3 = st.peek();
//                st.pop();
//            }
//            st.push(nums[i]);
//        }
//        return false;
//    }
//}

/*3rd*/

//
//class Solution {
//    public boolean find132pattern(int[] nums) {
//        int n = nums.length;
//        Stack<Integer> stack = new Stack<>();
//        int[] minArray = new int[n];
//
//        // Calculate minimum value up to index i
//        minArray[0] = nums[0];
//        for (int i = 1; i < n; i++) {
//            minArray[i] = Math.min(minArray[i - 1], nums[i]);
//        }
//
//        // Iterate from right to left to find 132 pattern
//        for (int j = n - 1; j >= 0; j--) {
//            if (nums[j] > minArray[j]) { // Check if nums[j] can be the '3' in '132'
//                // Pop elements from stack smaller than minArray[j]
//                while (!stack.isEmpty() && stack.peek() <= minArray[j]) {
//                    stack.pop();
//                }
//                // If we find an element in stack that's smaller than nums[j], return true
//                if (!stack.isEmpty() && stack.peek() < nums[j]) {
//                    return true;
//                }
//                // Push nums[j] onto the stack
//                stack.push(nums[j]);
//            }
//        }
//
//        return false;
//    }
//}