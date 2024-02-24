package RecursionAndBacktracking;
import java.util.*;

/*
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a
queen and an empty space, respectively.
Example 1:
Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
Example 2:

Input: n = 1
Output: [["Q"]]
 */

public class N_Queens {
    public List<List<String>> solveNQueens(int n) {

        char [][] chess = new char[n][n];
        for(int i = 0 ; i<n; i++){
            for(int j = 0; j<n;j++){
                chess[i][j]='.';
            }
        }
        List<List<String>> ans = new ArrayList<>();
        helper(chess , 0 , ans);
        return ans;
    }
    public void helper(char [][] chess , int row , List<List<String>> ans ){
        int n = chess.length;
        if(row==n){
            List<String> l = new ArrayList<>();
            for(int i  = 0 ; i < n;i++){
                String str = "";
                for(int j = 0 ; j < n  ; j++){
                    str+=chess[i][j];
                }
                l.add(str);
            }
            ans.add(l);
            return;
        }

        for(int col = 0 ; col<n ; col++){
            if(isSafe(chess , row , col )){
                chess[row][col]='Q';
                helper(chess , row+1 , ans);
                chess[row][col]='.';

            }
        }

    }
    public boolean isSafe(char [][] chess , int row , int col){
        int n = chess.length;
        for(int i = row ; i >= 0 ; i--){
            if(chess[i][col]=='Q')return false;
        }


        for(int i = row , j = col ; i >= 0 && j>=0 ; i-- , j-- ){
            if(chess[i][j]=='Q')return false;
        }



        for(int i = row , j = col ; i>= 0 && j<n ; i-- , j++ ){
            if(chess[i][j]=='Q')return false;
        }


        return true;

    }
}
