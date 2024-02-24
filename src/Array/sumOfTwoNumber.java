package Array;
import java.util.*;
/*
Given two numbers represented by two different arrays A and B. The task is to find the sum array.
The sum array is an array representation of addition of two input arrays.

Example 1:

Input:
N = 3, M = 3
A[] = {5, 6, 3}
B[] = {8, 4, 2}
Output: 1 4 0 5
Explanation: As 563 + 842 = 1405.
Example 2:

Input:
N = 6, M = 4
A[] = {2, 2, 7, 5, 3, 3}
B[] = {4, 3, 3, 8}
Output: 2 3 1 8 7 1
Explanation: As 227533 + 4338 = 231871.

 */
public class sumOfTwoNumber {
    ArrayList<Integer> findSum(int a[], int b[]) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        int [] resultArray = new int[Math.max(a.length, b.length) + 1];
        int carry = 0 ;

        int i = a.length-1;
        int j = b.length-1;
        int k = resultArray.length-1;

        while(k>=0){
            int digit= carry;
            if(i>=0){
                digit+=a[i];
            }
            if(j>=0){
                digit+=b[j];
            }

            carry=digit/10;
            digit=digit%10;

            resultArray[k]= digit;

            i--;
            j--;
            k--;


        }
        for (int l = 0; l < resultArray.length; l++) {
            if (l == 0 && resultArray[l] == 0) {
                continue;
            }
            result.add(resultArray[l]);
        }

        if (result.isEmpty()) {
            result.add(0);
        }

        return result;
    }
}
