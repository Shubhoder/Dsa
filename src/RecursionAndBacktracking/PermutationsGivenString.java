package RecursionAndBacktracking;
import java.util.*;
/*
Given a string S. The task is to print all unique permutations of the given string that may contain dulplicates in lexicographically sorted order.

Example 1:

Input: ABC
Output:
ABC ACB BAC BCA CAB CBA
Explanation:
Given string ABC has permutations in 6
forms as ABC, ACB, BAC, BCA, CAB and CBA .
Example 2:

Input: ABSG
Output:
ABGS ABSG AGBS AGSB ASBG ASGB BAGS
BASG BGAS BGSA BSAG BSGA GABS GASB
GBAS GBSA GSAB GSBA SABG SAGB SBAG
SBGA SGAB SGBA
Explanation:
Given string ABSG has 24 permutations.
Your Task:
You don't need to read input or print anything. Your task is to complete the function find_permutation() which takes the string S as input parameter and returns a vector of string in lexicographical order.

Expected Time Complexity: O(n! * n)
Expected Space Complexity: O(n! * n)

Constraints:
1 <= length of string <= 5
 */

public class PermutationsGivenString {
    public List<String> find_permutation(String S) {
        HashSet<String> ans = new HashSet<>();
        findPer(S, "" , ans);
        List<String> ansC = new ArrayList<>(ans);
        Collections.sort(ansC);
        return ansC;
        // Code here
    }
    private static void findPer(String str , String combi , HashSet<String> ans ){

        if(str.length()==0){
            ans.add(combi);
            return;
        }

        for(int i = 0 ; i <str.length() ; i++){
            char ch = str.charAt(i);
            String lpart = str.substring(0 , i);
            String rpart = str.substring(i+1);
            String totalPart= lpart + rpart;
            findPer(totalPart , combi+ch  , ans);
        }
    }
}
