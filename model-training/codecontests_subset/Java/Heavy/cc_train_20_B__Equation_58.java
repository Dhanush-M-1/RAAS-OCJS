import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.TreeSet;
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
        long a = in.nextLong();
        long b = in.nextLong();
        long c = in.nextLong();
        ArrayList<Double> list = new ArrayList<>();
        int count = 0;
        if(a == b && b == c && c != 0) list.add(0.0);
        else if(a == 0){
            if(b == 0){
                if(c == 0) count--;
                else list.add(0.0);
            }
            else{
                 count++;
                 list.add((-1.0*c)/b);
            }
        }
        else if(b == 0){
            if(c <= 0){
                count++;
                list.add(Math.sqrt((-1.0*c)/a));
            }
            else list.add(0.0);
        }
        else if(c == 0){
            count += 2;
            list.add(-0.0);
            list.add((-1.0*b)/a);
        }
        else{
            long D = b*b*1L - 1L*4*a*c;
            if(D < 0) count = -1;
            else if(D == 0){
                count++;
                list.add((-b*1.0)/(1L*2*a));
            }
            else{
                count = 2;
                list.add((-b + Math.sqrt(D))/(1L*2*a));
                list.add((-b - Math.sqrt(D))/(1L*2*a));
            }
        }
        if(count != 0) out.println(count);
        Collections.sort(list);
        for(double ans : list){
            out.printf("%.10f", ans);
            out.println();
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
    public long nextLong() {
        return Long.parseLong(next());
    }
    public double nextDouble() {
        return Double.parseDouble(next());
    }
}