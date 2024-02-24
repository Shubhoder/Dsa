package RecursionAndBacktracking;
import java.util.*;
/*

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number
could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map
to any letters.

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]


Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
 */

public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }

        String[] codes = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        return letterCombinationsHelper(digits, codes, 0);
    }

    private List<String> letterCombinationsHelper(String digits, String[] codes, int index) {
        if (digits.length() == index) {
            ArrayList<String> emp = new ArrayList<>();
            emp.add("");
            return emp;
        }

        char ch = digits.charAt(index);
        String str = digits.substring(index + 1);

        List<String> rstr = letterCombinationsHelper(str, codes, 0);
        ArrayList<String> rres = new ArrayList<>();

        String codesforch = codes[ch - '0'];
        for (int i = 0; i < codesforch.length(); i++) {
            char charc = codesforch.charAt(i);
            for (String lopps : rstr) {
                rres.add(charc + lopps);
            }
        }

        return rres;
    }
}

//Optimize soli=ution on leetcode
/*
class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> res = new LinkedList<>();

        String[][] phone = {{}, {}, {"a", "b", "c"}, {"d", "e", "f"},
        {"g", "h", "i"}, {"j", "k", "l"}, {"m", "n", "o"}, {"p", "q", "r", "s"}, {"t", "u", "v"},
        {"w", "x", "y", "z"}};

        if (digits.length() == 0)
            return res;

        order(digits, phone, res, "", 0);

        return res;
    }

    public void order(String digits, String[][] phone, LinkedList<String> res, String cur, int level){
        if (level >= digits.length()){
            res.add(cur);
            return;
        }

        int pos = digits.charAt(level) - '0';

        for (int j = 0; j < phone[pos].length; j++){
            order(digits, phone, res, cur + phone[pos][j], level + 1);
        }
    }
}
 */
