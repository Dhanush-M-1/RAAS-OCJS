import java.util.*;
import java.io.*;
 
public class Solution{
    static PrintWriter out = new PrintWriter(System.out);
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().trim().split(" ");
        int numTestCases = Integer.parseInt(input[0]);
        while(numTestCases-- > 0){
            input = br.readLine().trim().split(" ");
            int n = Integer.parseInt(input[0]);
            char[][] board = new char[n][n];
            for(int i = 0; i < n; i++)
            {
                String row = br.readLine();
                for(int j = 0; j < n; j++){
                    board[i][j] = row.charAt(j);
                }
            }
            printSteps(board);
        }
        
        out.flush();
        out.close();
    }
    public static void printSteps(char[][] board)
    {
        int n = board.length;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(board[0][1] == board[1][0])
        {
            char ch = board[0][1];
            if(board[n - 1][n - 2] == ch)
            {
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(n - 1 + 1);
                arr.add(n - 2 + 1);
                ans.add(arr);
            }
            if(board[n - 2][n - 1] == ch)
            {
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(n - 2 + 1);
                arr.add(n - 1 + 1);
                ans.add(arr);
            }
        }
        else if(board[n - 1][n - 2] == board[n - 2][n - 1])
        {
            char ch = board[n - 1][n - 2];
            if(board[0][1] == ch)
            {
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(0 + 1);
                arr.add(1 + 1);
                ans.add(arr);
            }
            if(board[1][0] == ch)
            {
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(1 + 1);
                arr.add(0 + 1);
                ans.add(arr);
            }
        }
        else{
            if(board[0][1] == '1')
            {
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(0 + 1);
                arr.add(1 + 1);
                ans.add(arr);
            }
            else if(board[1][0] == '1')
            {
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(1 + 1);
                arr.add(0 + 1);
                ans.add(arr);
            }
            
            
            if(board[n - 1][n - 2] == '0')
            {
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(n - 1 + 1);
                arr.add(n - 2 + 1);
                ans.add(arr);
            }
            else if(board[n - 2][n - 1] == '0')
            {
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(n - 2 + 1);
                arr.add(n - 1 + 1);
                ans.add(arr);
            }
        }
        out.println(ans.size());
        for(int i = 0; i < ans.size(); i++){
            ArrayList<Integer> arr = ans.get(i);
            out.println(arr.get(0) + " " + arr.get(1));
        }
    }
}