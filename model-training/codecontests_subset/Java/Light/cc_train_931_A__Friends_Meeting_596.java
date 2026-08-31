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
       int dist = M - N;
       int half1 = (M - N) / 2;
       int half2 = half1 + 1;
       if(half1 > 0 && (M-N) % half1 == 0) half2 = half1;
       return half1 * (half1 + 1) / 2 + half2 * (half2 + 1) / 2;
    }
}