package Array;
import java.util.*;

//Given an integer array nums of unique elements, return all possible
//subsets (the power set).
//The solution set must not contain duplicate subsets. Return the solution in any order.
//Example 1:
//
//Input: nums = [1,2,3]
//Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
//Example 2:
//
//Input: nums = [0]
//Output: [[],[0]]
//
//Constraints:
//1 <= nums.length <= 10
//-10 <= nums[i] <= 10
//All the numbers of nums are unique.
public class Subsets_78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        res.add(new ArrayList());

        for(int num:nums){
            int n = res.size();
            for(int j=0;j<n;j++){
                List<Integer> temp= new ArrayList(res.get(j));
                temp.add(num);
                res.add(temp);
            }
        }return res;

    }
}
