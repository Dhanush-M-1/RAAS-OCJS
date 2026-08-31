import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // String[] s = br.readLine().split("\\s");
        // int[] arr1 = new int[s.length];
        // for(int i=0;i<s.length;++i) arr1[i] = Integer.parseInt(s[i]);
        // s = br.readLine().split("\\s");
        // int[] arr2 = new int[s.length];
        // for(int i=0;i<s.length;++i) arr2[i] = Integer.parseInt(s[i]);
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        System.out.println(solve(N,M));   
    }
    
    private static int solve(int N,int M){
       if(N > M) return solve(M,N);
       int tiredness = 0;
       int curr_move = 1;
       while(N != M){
           N++;
           tiredness += curr_move;
           if(N != M){
               M--;
                tiredness += curr_move;
           }
            
            curr_move++;
       }
       
       
       return tiredness;
    }
}