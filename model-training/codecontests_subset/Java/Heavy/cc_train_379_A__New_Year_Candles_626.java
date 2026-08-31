/**
 * Created by iainws on 1/10/2014.
 */

import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.InputStream;

public class NewYearsCandles {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReaderNewYearsCandles in = new InputReaderNewYearsCandles(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskNewYearsCandles solver = new TaskNewYearsCandles();
        solver.solve(1, in, out);
        out.close();
    }
}

class TaskNewYearsCandles {
    public void solve(int taskNumber, InputReaderNewYearsCandles in, PrintWriter out) {
        int a = in.nextInt();
        int b = in.nextInt();
        int res = 0;
        int burned_out = 0;
        while(a!=0){
            res += a;
            burned_out += a % b;
            int new_candles = a/b;
            if(burned_out >= b){
                burned_out-=b;
                new_candles++;
            }
            a = new_candles;
        }
        out.println(res);
    }
}

class InputReaderNewYearsCandles {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReaderNewYearsCandles(InputStream stream) {
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

    public int nextInt() {
        return Integer.parseInt(next());
    }

}