import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;

public class Solution {

    public static void main(String args[]) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Problem problem = new Problem();
//        int testcase = Integer.parseInt(in.scanInput());
//        for (int i = 1; i <= testcase; i++)
//            problem.solve(i, in, out);
        problem.solve(1, in, out);
        out.close();
    }

}

class Problem {

    void solve(int testcase, InputReader in, PrintWriter out) {
        String first = in.scanInput();
        String second = in.scanInput();
        int N = Integer.parseInt(in.scanInput());
        out.println(first + " " + second);
        for (int i = 0; i < N; i++) {
            String a = in.scanInput();
            String b = in.scanInput();
            if (a.equals(first))
                first = b;
            else
                second = b;
            out.println(first + " " + second);
        }
    }

}

class InputReader {

    private BufferedReader mReader;
    private StringTokenizer mTokenizer;

    InputReader(InputStream stream) {
        mReader = new BufferedReader(new InputStreamReader(stream));
        mTokenizer = null;
    }

    String scanInput() {
        while (mTokenizer == null || !mTokenizer.hasMoreTokens()) {
            try {
                mTokenizer = new StringTokenizer(mReader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return mTokenizer.nextToken();
    }

}