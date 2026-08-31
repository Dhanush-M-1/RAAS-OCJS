import java.util.*;
import java.io.*;

public class PairProg {
    
    static class FastReader {

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
    
        public int nextInt() 
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
    
        public String nextLine() 
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
    public static void main(String[] args) {
        
        FastReader sc = new FastReader();

        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0) {

            int k = sc.nextInt();
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] mono = new int[n];
            int[] poly = new int[m];
            for(int i = 0; i < n; i++) {
                mono[i] = sc.nextInt();
            }
            for(int i = 0; i < m; i++) {
                poly[i] = sc.nextInt();
            }

            int i = 0;
            int j = 0;

            StringBuilder sb = new StringBuilder();
            boolean flag = true;
            while(i < n && j < m) {

                if(mono[i] == 0) {
                    k++;
                    i++;
                    sb.append("0 ");
                }
                else if(poly[j] == 0) {
                    k++;
                    j++;
                    sb.append("0 ");
                }

                else if(mono[i] <= k) {
                    sb.append(mono[i]+" ");
                    i++;
                }
                else if(poly[j] <= k) {
                    sb.append(poly[j]+" ");
                    j++;
                }
                else {
                    flag = false;
                    break;
                }   
            }

            while(i < n) {
                if(mono[i] == 0) {
                    k++;
                    i++;
                    sb.append("0 ");
                }
                else if(mono[i] <= k) {
                    sb.append(mono[i]+" ");
                    i++;
                }
                else {
                    flag = false;
                    break;
                }   
            }

            while(j < m) {
                if(poly[j] == 0) {
                    k++;
                    j++;
                    sb.append("0 ");
                }
                else if(poly[j] <= k) {
                    sb.append(poly[j]+" ");
                    j++;
                }
                else {
                    flag = false;
                    break;
                }   
            }

            // System.out.println("TestCase:- "+t);
            if(flag) System.out.println(sb.toString());
            else System.out.println(-1);
        }
    }
}
