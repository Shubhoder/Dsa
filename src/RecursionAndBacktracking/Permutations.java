package RecursionAndBacktracking;
import java.util.*;

/*
Given an array nums of distinct integers, return all the possible permutations. You can return the
answer in any order.



Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]


Constraints:

1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.
 */

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums , 0 , ans );
        return ans;
    }

    private static void helper(int[] nums , int idx , List<List<Integer>> ans  ){

        if(idx==nums.length-1){
            ArrayList<Integer> ds = new ArrayList<>();
            for(int i=0 ; i<nums.length; i++){
                ds.add(nums[i]);
            }
            ans.add(ds);
            return;
        }

        for(int i = idx ; i<nums.length ; i++){
            swap(nums , i , idx);
            helper(nums , idx+1 , ans);
            swap(nums , i , idx);
        }
    }

    private static void swap(int[] nums , int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j]=temp;
    }
}

//Here is one 0ms leetcode solution for learning

/*
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, 0);
        return ans;
    }
    public void backtrack(int nums[], int curr) {
        if(curr == nums.length){
            List<Integer> oneAns = new ArrayList<>();
            for(int i = 0; i < nums.length; i++) {
                oneAns.add(nums[i]);
            }
            ans.add(oneAns);
        }
        for(int i = curr; i < nums.length; i++) {
            swap(curr, i, nums);
            backtrack(nums, curr+1);
            swap(curr, i, nums);
        }
    }
    public void swap(int i, int j, int nums[]) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
 */
