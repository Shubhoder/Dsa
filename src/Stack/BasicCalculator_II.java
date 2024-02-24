package Stack;
import java.util.*;

/*
Given a string s which represents an expression, evaluate this expression and return its value.

The integer division should truncate toward zero.

You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].

Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().



Example 1:

Input: s = "3+2*2"
Output: 7
Example 2:

Input: s = " 3/2 "
Output: 1
Example 3:

Input: s = " 3+5 / 2 "
Output: 5


Constraints:

1 <= s.length <= 3 * 105
s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
s represents a valid expression.
All the integers in the expression are non-negative integers in the range [0, 231 - 1].
The answer is guaranteed to fit in a 32-bit integer.
 */

public class BasicCalculator_II {
    public int calculate(String s) {
        Stack<Character> opends = new Stack<>();
        Stack<Integer> opratesNum = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                opends.push(ch);
            } else if (ch == ')') {
                while (!opends.isEmpty() && opends.peek() != '(') {
                    char operators = opends.pop();
                    int v2 = opratesNum.pop();
                    int v1 = opratesNum.pop();

                    int ops = oprations(v1, v2, operators);
                    opratesNum.push(ops);
                }
                if (!opends.isEmpty() && opends.peek() == '(') {
                    opends.pop(); // This will remove '(' from the stack
                } else {
                    // Handle mismatched parentheses
                    return -1; // Or throw an exception or return an error message
                }
            } else if (Character.isDigit(ch)) {
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                opratesNum.push(num);
                i--;
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (!opends.isEmpty() && opends.peek() != '(' && priority(ch) <= priority(opends.peek())) {
                    char operators = opends.pop();
                    int v2 = opratesNum.pop();
                    int v1 = opratesNum.pop();

                    int ops = oprations(v1, v2, operators);
                    opratesNum.push(ops);
                }
                opends.push(ch);
            }
        }

        while (!opends.isEmpty()) {
            char operators = opends.pop();
            int v2 = opratesNum.pop();
            int v1 = opratesNum.pop();

            int ops = oprations(v1, v2, operators);
            opratesNum.push(ops);
        }
        return opratesNum.peek();
    }

    public static int priority(char operators) {
        if (operators == '+' || operators == '-') {
            return 1;
        } else {
            return 2;
        }
    }

    public static int oprations(int v1, int v2, char operators) {
        if (operators == '+') {
            return v1 + v2;
        } else if (operators == '-') {
            return v1 - v2;
        } else if (operators == '*') {
            return v1 * v2;
        } else {
            return v1 / v2;
        }
    }

}
