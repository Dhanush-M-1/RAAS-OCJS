import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 *
 * @author ric_carollo
 */
public class MainCP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FastReader s = new FastReader();
        int n = s.nextInt(); 
        int[] a = new int[n*2];
        int x = 0; 
        
        int[] b = new int[n]; 
        int[] c = new int[n]; 

        
        for (int i = 0; i < n*2; i++){
            a[i] = s.nextInt(); 
        }
        
        for (int i = 0; i < n; i++){
            b[i] = a[i*2];
        }
        for (int i = 0; i < n; i++){
            c[i] = a[i*2+1];
        }
        
        for (int i = 0; i < n; i++){
            for (int k = 0; k < n; k++){
                if (b[i] == c[k])
                    x++; 
            }
        }
        System.out.println(x);
        
        
        
        

            
    } 
    // Working program with FastReader

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        
        public FastReader()
        {
                br = new BufferedReader(
                new InputStreamReader(System.in));
        }

        String next()
        {
                while (st == null || !st.hasMoreElements()) {
                        try {
                                st = new StringTokenizer(br.readLine());
                        }
                        catch (IOException e) {
                        }
                }
                return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }

        long nextLong() { return Long.parseLong(next()); }

        double nextDouble()
        {
                return Double.parseDouble(next());
        }

        String nextLine()
        {
                String str = "";
                try {
                        str = br.readLine();
                }
                catch (IOException e) {
                }
                return str;
        }
    }
}



    
    

