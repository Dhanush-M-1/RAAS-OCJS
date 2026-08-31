import java.util.*;
import java.io.*;

public class Prb18 {


    static FastReader sc = new FastReader();


    public static void main(String[] args) {
        int t=sc.nextInt();
        while(t-- != 0){
          int n = sc.nextInt();
          int arr[] = new int[n];
          for(int i = 0; i < n; i ++){
              arr[i] = sc.nextInt();
          }
          if(arr[0]+arr[1] > arr[n-1] && arr[0]+arr[n-1] > arr[1] && arr[n-1]+arr[1] > arr[0]){
              System.out.println(-1);
          }
          else{
              System.out.println("1 2 "+n);
          }
        }
    }

    static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    } 



}