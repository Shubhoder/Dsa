package twoD_Array;
import java.util.*;
/*
You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
DO NOT allocate another 2D matrix and do the rotation.
exp 1
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]
exp2
Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 */

public class rotateImage {
    public void rotate(int[][] matrix) {

        for(int i = 0 ; i < matrix.length; i++){
            for(int j = i; j < matrix[0].length ;j++){
                int temp=matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i]=temp;
            }
        }

        for(int i = 0 ; i < matrix.length; i++){
            int li = 0;
            int hi =  matrix[i].length-1;
            while(li < hi){
                int temp=matrix[i][li];
                matrix[i][li] = matrix[i][hi];
                matrix[i][hi] = temp;
                li++;
                hi--;
            }
        }
        return;
    }
}
