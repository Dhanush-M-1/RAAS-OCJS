import java.io.*;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        File file = new File("in.txt");
        File fileOut = new File("out.txt");
        InputStream inputStream = null;
        OutputStream outputStream = null;
        // try {inputStream= new FileInputStream(file);} catch (FileNotFoundException ex){return;};
//        try {outputStream= new FileOutputStream(fileOut);} catch (FileNotFoundException ex){return;};
        inputStream = System.in;
        outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskB solver = new TaskB();
        solver.solve(1, in, out);
        out.close();
    }


}

class TaskB {


    public void solve(int testNumber, InputReader in, PrintWriter out) {
        String s = in.next();
        Character ch1 = s.charAt(0);
        Character ch2 = s.charAt(1);
        Integer n = in.nextInt();
        Integer minStartIndex = Integer.MAX_VALUE;
        Integer maxStartIndex = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            String q = in.next();
            if(s.equals(q)){
                out.println("YES");
                return;
            }
            if(q.charAt(0) == ch2){
                maxStartIndex = Math.max(maxStartIndex, i);
            }

            if(q.charAt(1) == ch1){
                minStartIndex = Math.min(minStartIndex, i);
            }
        }
        if(maxStartIndex>Integer.MIN_VALUE && minStartIndex < Integer.MAX_VALUE){
            out.println("YES");
        }
        else{
            out.println("NO");
        }

    }


}



class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream), 32768);
        tokenizer = null;
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public String nextLine(){
        try {
            return reader.readLine();
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }
    public long nextLong() { return Long.parseLong(next()); }

}



class Pair<F, S> {
    public final F first;
    public final S second;




    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pair)) {
            return false;
        }
        Pair<?, ?> p = (Pair<?, ?>) o;
        return Objects.equals(p.first, first) && Objects.equals(p.second, second);
    }

    @Override
    public int hashCode() {
        return (first == null ? 0 : first.hashCode()) ^ (second == null ? 0 : second.hashCode());
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ')';
    }
}

class IntPair extends Pair<Integer, Integer>{
    public IntPair(Integer first, Integer second){
        super(first, second);
    }
}