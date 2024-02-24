package Stack;
import java.util.Stack;
/*
Given an expression string x. Examine whether the pairs and the orders of {,},(,),[,] are correct in exp.
For example, the function should return 'true' for exp = [()]{}{[()()]()} and 'false' for exp = [(]).

Note: The drive code prints "balanced" if function return true, otherwise it prints "not balanced".

Example 1:

Input:
{([])}
Output:
true
Explanation:
{ ( [ ] ) }. Same colored brackets can form
balanced pairs, with 0 number of
unbalanced bracket.
Example 2:

Input:
()
Output:
true
Explanation:
(). Same bracket can form balanced pairs,
and here only 1 type of bracket is
present and in balanced way.
 */

public class balanceBracket {
    static boolean ispar(String x)
    {
        Stack<Character> st = new Stack<>();
        for(int i = 0 ; i<x.length() ; i++){
            char ch = x.charAt(i);
            if(ch=='(' || ch =='{' || ch == '['){
                st.push(ch);
            }else if(ch==')'){
                if(st.size()==0 || st.peek()!= '('){
                    return false;
                }st.pop();
            }else if(ch=='}'){
                if(st.size()==0 || st.peek()!= '{'){
                    return false;
                }st.pop();
            }else if(ch==']'){
                if(st.size()==0 || st.peek()!= '['){
                    return false;
                }st.pop();
            }else{
                return false;
            }
        }if(st.size()!=0){
        return false;
    }else{
        return true;
    }




    }
}
