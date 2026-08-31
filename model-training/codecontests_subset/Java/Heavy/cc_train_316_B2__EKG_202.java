//package abbyycup2013;
import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class ProblemB {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));

    ProblemB() throws IOException {
//        reader = new BufferedReader(new FileReader("input.txt"));
//        writer = new PrintWriter(new FileWriter("output.txt"));
    }

    int[] readInts() throws IOException {
        String[] strings = reader.readLine().split(" ");
        int[] ints = new int[strings.length];
        for(int i = 0; i < ints.length; i++) {
            ints[i] = Integer.parseInt(strings[i]);
        }
        return ints;
    }

    int[] tt = null;
    int tx = 0;
    int readInt() throws IOException {
        if(tt == null || tx >= tt.length) {
            tt = readInts();
            tx = 0;
        }
        return tt[tx++];
    }

    void solve() throws IOException {
        int n = readInt();
        int x = readInt();
        int[] prev = readInts();
        int[] next = new int[n];
        for(int i = 1; i <= n; i++) {
            int pr = prev[i - 1];
            if(pr != 0) next[pr - 1] = i;
        }
        List<Integer> groups = new ArrayList<Integer>();
        for(int i = 1; i <= n; i++) {
            if(next[i - 1] == 0) {
                int q = 0;
                boolean beaverGroup = false;
                for(int u = i; u > 0; u = prev[u - 1]) {
                    if(u == x) beaverGroup = true;
                    q++;
                }
                if(!beaverGroup) groups.add(q);
            }
        }
        int bix = 0;
        for(int u = x; u > 0; u = prev[u - 1]) {
            bix++;
        }
        boolean[] used = new boolean[n];
        used[0] = true;
        for(int g: groups) {
            for(int i = n - 1; i >= 0; i--) {
                if(used[i]) used[i + g] = true;
            }
        }
        for(int i = 0; i < n; i++) {
            if(used[i]) {
                writer.println(i + bix);
            }
        }
        writer.flush();
    }

    void multiSolve() throws IOException {
        int n = readInts()[0];
        for(int i = 0; i < n; i++) {
            solve();
        }
        writer.flush();
    }

    public static void main(String[] args) throws IOException{
        new ProblemB().solve();
    }
}
