import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

import java.io.*;
import java.util.*;

public class E1066 {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader inp = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Solver1066D solver = new Solver1066D();
        solver.solve(inp, out);
        out.close();
    }

    static class InputReader {
        StringTokenizer tokenizer;
        InputStreamReader sReader;
        BufferedReader reader;

        InputReader(InputStream stream) {
            sReader = new InputStreamReader(stream);
            reader = new BufferedReader(sReader, 32768);
            tokenizer = null;
        }

        String next() {
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

        public long nextLong() {
            return Long.parseLong(next());
        }

        public List<Integer> intLine(int size) {
            List<Integer> ls = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                ls.add(nextInt());
            }
            return ls;
        }

        int nextC() {
            try {
                return reader.read();
            } catch (IOException e) {
                return -1;
            }
        }

        public int[] intArr(int size) {
            int[] ls = new int[size];
            for (int i = 0; i < size; i++){
                ls[i] = nextInt();
            }
            return ls;
        }
    }
static class Solver1066D {
       public void solve(InputReader inp, PrintWriter out) {
           int n = inp.nextInt(), m = inp.nextInt();
           int[] ls = new int[n], pointers = new int[n], options = new int[n];
           ArrayList<Integer>[] deps = new ArrayList[n];
           for (int i = 0; i < n; i++){
               int val = inp.nextInt()-1;
               ls[i] = val;
               pointers[val] = i;
               deps[i] = new ArrayList<>();
           }
           for (int i = 0; i < m; i++){
               int k = inp.nextInt()-1, l = inp.nextInt()-1;
               if (pointers[k] < pointers[l]){
                   deps[l].add(k);
                   options[k]++;
               }
           }
           int important = n-1;
           for (int i = n-2; i > -1; i--){
               int val = ls[i];
               if (important == i+options[val]){
                   for (int d : deps[val]) options[d]--;
                   important-=1;
               }
           }
           out.println(n-important-1);

        }
    }
}


