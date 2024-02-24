package String;
/*
Given a string s, return the number of palindromic substrings in it.

A string is a palindrome when it reads the same backward as forward.

A substring is a contiguous sequence of characters within the string.



Example 1:

Input: s = "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
Example 2:

Input: s = "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".


Constraints:

1 <= s.length <= 1000
s consists of lowercase English letters.
 */

public class PalindromicSubstrings {
    public int countSubstrings(String str) {

        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                String ch = str.substring(i, j);
                if (ispalindrome(ch)==true) {
                    count++;
                }
            }
        }
        return count;

    }

    boolean ispalindrome(String str) {

        int i = 0;
        int j = str.length() - 1;
        while (i <= j) {
            if (str.charAt(i)!= str.charAt(j)) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;


    }
}
