package Array;
/*
iven an unsorted array arr[] of size N. Rotate the array to the left (counter-clockwise direction) by D steps
, where D is a positive integer.



Example 1:

Input:
N = 5, D = 2
arr[] = {1,2,3,4,5}
Output: 3 4 5 1 2
Explanation: 1 2 3 4 5  when rotated
by 2 elements, it becomes 3 4 5 1 2.
Example 2:

Input:
N = 10, D = 3
arr[] = {2,4,6,8,10,12,14,16,18,20}
Output: 8 10 12 14 16 18 20 2 4 6
Explanation: 2 4 6 8 10 12 14 16 18 20
when rotated by 3 elements, it becomes
8 10 12 14 16 18 20 2 4 6.


Your Task:
You need not print or read anything. You need to complete the function rotateArr() which takes the array,
 D and N as input parameters and rotates the array by D elements. The array must be modified in-place without using extra space.



Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)
 */

public class rotateArray {
    static void rotateArr(int arr[], int d, int n)
    {
        d = d%n;
        if(d<0){
            d= d+n;
        }
        // part 1
        reverseArray(arr, 0, d - 1);
        // part 2
        reverseArray(arr, d, n - 1);
        // part 3
        reverseArray(arr, 0, n - 1);
    }


    public static void reverseArray(int arr[], int i , int j){
        int li = i;
        int hi = j;

        while(li<=hi){
            int temp = arr[li];
            arr[li] = arr[hi];
            arr[hi] = temp;


            li++;
            hi--;

        }
    }
}
