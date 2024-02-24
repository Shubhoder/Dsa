package Array;
/*
Given an array A of size N of integers. Your task is to find the minimum and maximum elements in the array.

Example 1:

Input:
N = 6
A[] = {3, 2, 1, 56, 10000, 167}
Output: 1 10000
Explanation: minimum and maximum elements of array are 1 and 10000.
 */


class Pair
{
    long first, second;
    public Pair(long first, long second)
    {
        this.first = first;
        this.second = second;
    }
}

public class findMinMax {
    static Pair getMinMax(long a[], long n)
    {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        //Write your code here
        for(int i = 0; i<n ; i++){
            if(a[i]>max){
                max=(int)a[i];
            }
            if(a[i]<min){
                min = (int)a[i];
            }
        }

        Pair result = new Pair(min, max);
        return result;
    }
}
