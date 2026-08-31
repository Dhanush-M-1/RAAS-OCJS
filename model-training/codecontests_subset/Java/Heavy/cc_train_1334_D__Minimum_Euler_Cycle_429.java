
import java.io.*;
import java.util.*;

public class D {

    static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new InputStreamReader(System.in)); 
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

    public static void main (String[] args) throws IOException{
        
        FastReader s = new FastReader();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = s.nextInt();//t: number of test cases
        
        for (int i = 0; i < t; i++) {
            int n = s.nextInt();
            double l = s.nextDouble();
            double r = s.nextDouble();
            
            boolean islLast = l == 1.0 * n * (n-1) + 1;
            boolean isrLast = r == 1.0 * n * (n-1) + 1;
            
            if(!islLast){
                double templ_01 = Math.ceil(((2*n-1)-Math.sqrt(4*Math.pow(n,2)-4*n+1-4*l))/2);
                double templ_02 = (templ_01 - 1) * (2*n - templ_01);
                int templ_11 = (int)(templ_01);
                int templ_12 = (int)((l - 1 - templ_02) / 2 + templ_11 + 1);
                
                if (isrLast) 
                    r--;
                
                boolean isrOdd = r%2==1;
                
                if (isrOdd) {
                    r--;
                }
                
                double tempr_01 = Math.ceil(((2*n-1)-Math.sqrt(4*Math.pow(n,2)-4*n+1-4*r))/2);
                double tempr_02 = (tempr_01 - 1) * (2*n - tempr_01);
                int tempr_11 = (int) (tempr_01);
                int tempr_12 = (int)((r - 1 - tempr_02) / 2 + tempr_11 + 1);
                
                if (l%2==0) {
                    bw.write(templ_12 + " ");
                    
                    templ_12++;
                    if (templ_12 > n) {
                        templ_11 ++;
                        templ_12 = templ_11 + 1;
                    }
                }
                
                while(templ_11 < tempr_11 || templ_11 == tempr_11 && templ_12 <= tempr_12){
                    bw.write(templ_11 + " ");
                    bw.write(templ_12 + " ");
                    
                    templ_12++;
                    if (templ_12 > n) {
                        templ_11 ++;
                        templ_12 = templ_11 + 1;
                    }
                }
                if (isrOdd) {
                    bw.write(templ_11 + " ");
                }
                if (isrLast) {
                    bw.write("1");
                }
            }
            else
                bw.write("1");
            
            bw.write("\n");
            
        }
        
        
        bw.flush();
        bw.close();
    }
    
}