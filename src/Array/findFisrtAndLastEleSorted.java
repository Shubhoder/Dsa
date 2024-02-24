package Array;
/*
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 */

public class findFisrtAndLastEleSorted {
    public int[] searchRange(int[] nums, int target) {

        int left = findLeftIndex(nums, target);
        int right = findRightIndex(nums,target );

        return new int[]{left, right};

    }
    private int findLeftIndex(int[] nums, int target ){
        int low = 0;
        int high = nums.length-1;
        int findex = -1;

        while(low<=high){
            int mid = low + (high-low)/2;

            if(target<nums[mid]){
                high = mid-1;
            }
            else if(target>nums[mid]){
                low = mid+1;
            }
            else{
                findex = mid;
                high=mid-1;
            }
        }

        return findex;
    }


    private int findRightIndex(int[] nums, int target ){
        int low = 0;
        int high = nums.length-1;
        int lindex = -1;

        while(low<=high){
            int mid = low + (high-low)/2;

            if(target<nums[mid]){
                high = mid-1;
            }
            else if(target>nums[mid]){
                low = mid+1;
            }
            else{
                lindex = mid;
                low=mid+1;
            }
        }
        return lindex;
    }

}
