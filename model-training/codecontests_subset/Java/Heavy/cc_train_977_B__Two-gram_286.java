import java.awt.Point;
import java.io.*;
import java.math.BigInteger;
import java.util.*;
import static java.lang.Math.*;
 
/// Codeforces Round #479 (Div. 3)
public class Solution implements Runnable {
 
        BufferedReader in;
        // PrintWriter out;
        // StringTokenizer tok = new StringTokenizer("");
 
        public static void main(String[] args) {
                new Thread(null, new Solution(), "", 256 * (1L << 20)).start();
        }
 
        public void run() {
                try {
                        long t1 = System.currentTimeMillis();
                        in = new BufferedReader(new InputStreamReader(System.in));
                             
                        solve();
                        in.close();
                        // out.close();
                        long t2 = System.currentTimeMillis();
                        System.err.println("Time = " + (t2 - t1));
                } catch (Throwable t) {
                        t.printStackTrace(System.err);
                        System.exit(-1);
                }
        }
 
     
     
        // solution
 
        void solve() throws IOException {
            int n = Integer.parseInt(in.readLine());
            String s = in.readLine();
            
            HashMap<String, Integer> occurences = new HashMap<String, Integer>();
            String mosTwoGram = "";
            int maxCount = 0;
            
            String curr;
            for(int i = 1; i < n; i++){
                curr = s.charAt(i-1)+ "" + s.charAt(i);
                if(occurences.containsKey(curr)){
                    occurences.put(curr, occurences.get(curr) + 1);
                }else{
                    occurences.put(curr, 1);
                }
                
                if(occurences.get(curr) > maxCount){
                    maxCount = occurences.get(curr);
                    mosTwoGram = curr;
                }
                
            }
            
            System.out.println(mosTwoGram);
        }
 
}