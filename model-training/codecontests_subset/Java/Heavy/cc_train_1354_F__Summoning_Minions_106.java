/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

import java.util.*;
import java.io.*;
public class Main{
     public static void main(String []args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter out = new PrintWriter(System.out);
        int trials = Integer.parseInt(st.nextToken());
        for(int trial = 0; trial < trials; trial++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[][] minion = new int[n][3];
            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                minion[i][0] = a;
                minion[i][1] = b;
                minion[i][2] = i+1;
            }
            sort(minion, 0, n-1);
            int[][] dp = new int[n+1][k+1];
            for(int i = 1; i <= n; i++){
                dp[i][0] = dp[i-1][0] + (k-1)*minion[i-1][1];
                for(int j = 1; j <= k; j++){
                    if(j < i)
                        dp[i][j] = Math.max(dp[i-1][j] + (k-1)*minion[i-1][1], dp[i-1][j-1] + (j-1)*minion[i-1][1] + minion[i-1][0]);
                    else if(j == i)
                        dp[i][j] = dp[i-1][j-1] + (j-1)*minion[i-1][1] + minion[i-1][0];
                }
            }
            int i = n;
            int j = k;
            Stack<Integer> stay = new Stack<Integer>();
            HashSet<Integer> remove = new HashSet<Integer>();
            while(j > 0){
                if(dp[i][j] == dp[i-1][j-1] + (j-1)*minion[i-1][1] + minion[i-1][0]){
                    stay.push(minion[i-1][2]);
                    j--;
                }
                else
                    remove.add(minion[i-1][2]);
                i--;
            }
            while(i > 0){
                remove.add(minion[i-1][2]);
                i--;
            }
            StringJoiner sj = new StringJoiner(" ");
            for(i = 0; i < k-1; i++)
                sj.add(Integer.toString(stay.pop()));
            for(int l:remove){
                sj.add(Integer.toString(l));
                sj.add(Integer.toString(-l));
            }
            sj.add(Integer.toString(stay.pop()));
            out.println(2*n-k);
            out.println(sj);
        }
        out.close();
     }
     static void sort(int[][] arr, int l, int r){
         if (l < r) 
        { 
            // Find the middle point 
            int m = (l+r)/2; 
  
            // Sort first and second halves 
            sort(arr, l, m); 
            sort(arr , m+1, r); 
  
            // Merge the sorted halves 
            merge(arr, l, m, r); 
        } 
     }
     static void merge(int[][] arr, int l, int m, int r) 
    { 
        // Find sizes of two subarrays to be merged 
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        /* Create temp arrays */
        int L[][] = new int [n1][3]; 
        int R[][] = new int [n2][3]; 
  
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i){
            L[i][0] = arr[l + i][0]; 
            L[i][1] = arr[l+i][1];
            L[i][2] = arr[l+i][2];
        }
        for (int j=0; j<n2; ++j){
            R[j][0] = arr[m + 1+ j][0];
            R[j][1] = arr[m+1+j][1];
            R[j][2] = arr[m+1+j][2];
        }
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays 
        int i = 0, j = 0; 
  
        // Initial index of merged subarry array 
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i][1] < R[j][1] || (L[i][1] == R[j][1] && L[i][0] < R[j][0])) 
            { 
                arr[k][0] = L[i][0];
                arr[k][1] = L[i][1];
                arr[k][2] = L[i][2];
                i++; 
            } 
            else
            { 
                arr[k][0] = R[j][0]; 
                arr[k][1] = R[j][1];
                arr[k][2] = R[j][2];
                j++; 
            } 
            k++; 
        } 
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) 
        { 
            arr[k][0] = L[i][0]; 
            arr[k][1] = L[i][1];
            arr[k][2] = L[i][2];
            i++; 
            k++; 
        } 
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) 
        { 
            arr[k][0] = R[j][0]; 
            arr[k][1] = R[j][1];
            arr[k][2] = R[j][2];
            j++; 
            k++; 
        } 
    }
}