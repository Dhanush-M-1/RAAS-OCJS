import java.io.*;
import java.util.*;
import java.io.IOException;
import java.io.InputStream;

import static java.lang.Math.ceil;

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
        Task solver = new Task();
        solver.solve(1, in, out);
        out.close();
    }


}

class Task {

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        Integer n = in.nextInt();
        long[] pos = new long[n];
        int[] height = new int[n];
        for(int i=0; i<n; i++){
            pos[i] = in.nextLong();
            height[i] = in.nextInt();
        }

        Integer count = 1;
        Long curPos = pos[0];
        for(int i=1; i<n; i++){
            if( pos[i] - curPos > height[i]){
                count++;
                curPos = pos[i];
                continue;
            }
            if(i<n-1){
                if(pos[i+1] - pos[i] > height[i]){
                    count++;
                    curPos = pos[i] + height[i];
                }
                else{
                    curPos = pos[i];
                }
            }
            else{
                count++;
            }

        }
        out.println(count);


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

class LPair extends Pair<Long, Long>{
    public LPair(Long first, Long second){
        super(first, second);
    }
}
