import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        for(int rc=0; rc<t; rc++) {
            String[] tokens = in.readLine().split(" ");
            int n = Integer.parseInt(tokens[0]);
            int m = Integer.parseInt(tokens[1]);
            String s = in.readLine();
            tokens = in.readLine().split(" ");
            int[] psa = new int[n+1];
            for(int i=0; i<m; i++) {
                int k = Integer.parseInt(tokens[i])-1;
                psa[0]++;
                psa[k+1]--;
            }
            
            for(int i=1; i<n; i++) psa[i] += psa[i-1];
            int[] arr = new int[26];
            for(int i=0; i<n; i++) {
                arr[s.charAt(i)-'a'] += psa[i]+1;
            }
            for(int i=0; i<26; i++) System.out.print(arr[i]+" ");
            System.out.println();
        }
    }
}
/*
*/