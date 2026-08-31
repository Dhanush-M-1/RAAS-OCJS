import java.io.*;
import java.util.*;
import java.math.*;
/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Erasyl Abenov
 * 
 * 
 */
public class Main {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
            try (PrintWriter out = new PrintWriter(outputStream)) {
                TaskB solver = new TaskB();
                solver.solve(1, in, out);
            }
    }
}
class TaskB {
    
    public void solve(int testNumber, InputReader in, PrintWriter out) throws IOException{
       int n = in.nextInt();
       int m = in.nextInt();
       int a[] = new int[m];
       int bit = 0;
       for(int i = 0; i < n; ++i){
           String s = in.next();
           if(s.equals("defragment")){
               int ii = 0;
               int b[] = new int[m];
               for(int j = 0; j < m; ++j){
                   if(a[j] > 0){
                       b[ii] = a[j];
                       ii++;
                   }
               }
               a = b;
           }
           else{
               int x = in.nextInt();
               if(s.equals("alloc")){
                   boolean boo = false;
                   for(int j = 0; j <= m - x; ++j){
                       boolean ok = true;
                       for(int k = j; k < j + x; ++k){
                           if(a[k] != 0){
                               ok = false;
                               break;
                           }
                       }
                       if(ok){
                           bit++;
                           for(int k = j; k < j + x; ++k) a[k] = bit;
                           boo = true;
                           out.println(bit);
                           break;
                       }
                   }
                   if(!boo) out.println("NULL");
               }
               else{
                   boolean ok = false;
                   for(int j = 0; j < m; ++j){
                       if(a[j] == x){
                           a[j] = 0;
                           ok = true;
                       }
                   }
                   if(!ok || x == 0) out.println("ILLEGAL_ERASE_ARGUMENT");
               }
           }
       }
    }
} 

class InputReader {
    private final BufferedReader reader;
    private StringTokenizer tokenizer;
    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream));
        tokenizer = null;
    }
       
    public String nextLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
       
    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(nextLine());
        }
        return tokenizer.nextToken();
    }
       
    public int nextInt() {
        return Integer.parseInt(next());
    }
    public BigInteger nextBigInteger(){
        return new BigInteger(next());
    }
    public BigDecimal nextBigDecimal(){
        return new BigDecimal(next());
    }
    public long nextLong() {
        return Long.parseLong(next());
    }
    public double nextDouble() {
        return Double.parseDouble(next());
    }
}