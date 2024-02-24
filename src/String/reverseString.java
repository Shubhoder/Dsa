package String;
/*
You are given a string s. You need to reverse the string.

Example 1:

Input:
s = Geeks
Output: skeeG
Example 2:

Input:
s = for
Output: rof
 */
public class reverseString {
    public static String reverseWord(String str) {
        // Reverse the string str
        int s = 0;
        int l = str.length() - 1;

        char[] charArray = str.toCharArray();

        while (s < l) {
            // Swap characters at s and l positions
            char temp = charArray[s];
            charArray[s] = charArray[l];
            charArray[l] = temp;

            // Move towards the center
            s++;
            l--;
        }

        // Convert char array back to string
        return new String(charArray);
    }
}
