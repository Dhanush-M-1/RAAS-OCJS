// package Round_93;

import java.io.*;
import java.math.*;
import java.util.*;

public class Problem_A {  
    public static void main(String[] args) {
        FastReader in = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        
        int numTrials = in.nextInt();
        while(numTrials --> 0) {
            int len = in.nextInt();
            
            int[] nums = new int[len];
            for(int i = 0; i < nums.length; i++) {
            	nums[i] = in.nextInt();
            }
            
            if(nums[0] + nums[1] > nums[nums.length - 1]) {
            	out.println(-1);
            }
            else {
            	out.println(1 + " " + 2 + " " + "" + (nums.length));
            }
        }
        
        out.flush();
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
