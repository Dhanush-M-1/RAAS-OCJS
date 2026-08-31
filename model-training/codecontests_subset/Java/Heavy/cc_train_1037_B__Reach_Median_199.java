import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split("\\s");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);
        s = br.readLine().split("\\s");
        int[] arr = new int[N];
        for(int i=0;i<N;++i) arr[i] = Integer.parseInt(s[i]);
        System.out.println(solve(N,K,arr));
    }
    
    private static long solve(int N,int K,int[] arr){
        Arrays.sort(arr);
        long diff = Math.abs(arr[N/2]-K);
        
        if(arr[N/2] <= K){
            arr[N/2] += diff;
            for(int i=N/2+1;i<N;++i){
                if(arr[i] >= arr[i-1]) continue;
                diff += arr[i-1] - arr[i];
                arr[i] = arr[i-1];
            }
        }else{
            arr[N/2] -= diff;
            for(int i=N/2-1;i>=0;--i){
                if(arr[i] <= arr[i+1]) continue;
                diff += arr[i] - arr[i+1];
                arr[i] = arr[i+1];
            }
        }
        
        
        return diff;
    }
}