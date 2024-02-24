package twoD_Array;
import java.util.*;
/*
Given two square Matrices A[][] and B[][]. Your task is to complete the function multiply which stores the multiplied matrices in a new matrix C[][].


    Example 1:

    Input:
    N = 2
    A[][] = {{7, 8}, {2 , 9}}
    B[][] = {{14, 5}, {5, 18}}

    Output:
    C[][] = {{138, 179}, {73, 172}}

 */

public class multiplyMatrix {
    public static void multiply(int A[][], int B[][], int C[][], int N)
    {
        //add code here.
        for(int i=0; i<A.length;i++){
            for(int j=0;j<B[i].length;j++){
                for(int k=0;k<N;k++){
                    C[i][j]+=A[i][k] * B[k][j];
                }
            }
        }
        return;

    }

}
