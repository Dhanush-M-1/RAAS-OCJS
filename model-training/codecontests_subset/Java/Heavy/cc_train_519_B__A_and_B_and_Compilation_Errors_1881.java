import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *
 * @author abdelrahman
 */
public class JavaApplication7 {


    public static void main(String[] args) {
            FastScanner sc  = new FastScanner();
        int  n = sc.nextInt();
        int initial [] = new int [n];
        int f [] = new int [n-1];
        int s [] = new int [n-2];
        for (int i = 0; i < n; i++) {
            initial[i]= sc.nextInt();
        }
       Arrays.sort(initial);
       int first = 0 ;
       int second = 0 ;
        for (int i = 0; i < n-1; i++) {
         f[i] = sc.nextInt();
        }
         Arrays.sort(f);
         for (int i = 0; i < n-2; i++) {
         s[i] = sc.nextInt();
        }
        Arrays.sort(s);
        for (int i = 0; i <= n-2; i++) {
            if (initial[i]!= f[i] && first == 0) {
                first = initial[i];
            }else if (i !=n-2 &&  f[i] != s[i] && second == 0) {
                second = f[i];
            }
        }
        System.out.println(first != 0 ? first : initial[n-1] );
        System.out.println(second != 0 ? second : f[n-2]);
         
       
        
        }
    
    


   
       
    
    
    static class FastScanner 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastScanner() 
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