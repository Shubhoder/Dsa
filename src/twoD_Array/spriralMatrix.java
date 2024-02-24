package twoD_Array;

import java.util.ArrayList;

/*
Given an m x n matrix, return all elements of the matrix in spiral order.
exp 1
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
exp 2
Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]

 */

public class spriralMatrix {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {

        ArrayList<Integer> ans = new ArrayList<Integer>();
        int minr = 0;
        int minc = 0;
        int maxr = matrix.length-1;
        int maxc = matrix[0].length-1;

        int rowCount = matrix.length;
        int colCount = matrix[0].length;
        int allnum = rowCount * colCount;
        int count = 0 ;

        while(count < allnum ){

            //up
            for(int i = minr , j = minc ; j<=maxc && count < allnum ; j++){
                ans.add(matrix[i][j]);
                count++;
            }
            minr++;

            //right
            for(int i = minr , j = maxc ; i<=maxr && count < allnum ; i++){
                ans.add(matrix[i][j]);
                count++;

            }
            maxc--;

            //bottom

            for(int i = maxr , j = maxc ; j>=minc && count < allnum ; j--){
                ans.add(matrix[i][j]);
                count++;
            }
            maxr--;


            //left

            for(int i = maxr , j = minc ; i>=minr && count < allnum ; i--){
                ans.add(matrix[i][j]);
                count++;
            }
            minc++;

        }
        return ans;

    }
}
