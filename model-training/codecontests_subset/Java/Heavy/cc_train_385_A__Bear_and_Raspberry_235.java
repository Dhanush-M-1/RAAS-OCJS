import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Collections;

/**
 *
 * @author Aniis
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = null;
    /*    try {
            inputStream = new FileInputStream("test.txt");
        } catch (IOException e) {
           throw new RuntimeException(e);
        }*/
        OutputStream outputStream = System.out;
        FastScanner in = new FastScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
       FuckTheWorld solver = new FuckTheWorld();
       solver.solve(1, in, out);
       out.close();
    }

static String removeCharAt(String s, int pos) {
      return s.substring(0, pos) + s.substring(pos + 1);
   }
   static class FuckTheWorld{
   public void solve (int testNumber,FastScanner in, PrintWriter out ){
 int n = in.nextInt();
int c = in.nextInt();
int[]a=new int[n];int p=in.nextInt();
Vector<Integer> v=new Vector<Integer>();
       for (int i = 0; i < n-1; i++) {
           int k=in.nextInt();
           if(p>=k && p-k>=c)v.add(p-k-c);
           else v.add(0);
           p=k;
       }
       Object obj = Collections.max(v);
       if(!v.isEmpty())
      out.println((int)obj);
} }
    
    static class FastScanner { 
        private BufferedReader br;
        private StringTokenizer st;
        public FastScanner (InputStream inputStream){
            //br = new BufferedReader (new InputStreamReader(inputStream));
             br = new BufferedReader(new InputStreamReader(System.in));
        }
        public String next(){
            while(st == null || !st.hasMoreElements()){
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        public int nextInt(){
            return Integer.parseInt(next());
    }   
    }
    
}