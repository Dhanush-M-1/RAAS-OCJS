

import org.omg.PortableInterceptor.INACTIVE;

import java.io.*;
import java.util.*;


public class Main {

    static class Task {
        HashMap<Integer, Integer> read(int n, InputReader in){
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for (int i = 0; i < n; i++){
                int k = in.nextInt();
                if (hashMap.containsKey(k)) hashMap.put(k, hashMap.get(k)+1);
                else hashMap.put(k, 1);
            }
            return hashMap;
        }
        void del(HashMap<Integer, Integer> a, HashMap<Integer, Integer> b){
            Set<Integer> keySet = b.keySet();
            for (int x: keySet){
                a.put(x, a.get(x)-b.get(x));
            }
        }
        void print(HashMap<Integer, Integer> a){
            Set<Integer> keySet = a.keySet();
            for (int x: keySet) if (a.get(x) > 0){ System.out.println(x); return; }
        }
        //////////////////  Solution    /////////////////////////////////////
        public void solve(InputReader in, PrintWriter out) throws Exception {
            int n = in.nextInt();
            HashMap<Integer, Integer> a = read(n, in), b = read(n-1, in), c = read(n-2, in);
            del(a, b);
            del(b, c);
            print(a);
            print(b);
        }
        //////////////////////////////////////////////////////////////////////
    }

    public static void main(String[] args) throws Exception{
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task task = new Task();
        task.solve(in, out);
        out.close();
    }


    static class InputReader {
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
        public Character nextChar(){
            return next().charAt(0);
        }
        public String nextLine() throws IOException {
            return reader.readLine();
        }
        public long nextLong(){ return Long.parseLong(next()); }
        public int nextInt() {
            return Integer.parseInt(next());
        }
        public double nextDouble() { return Double.parseDouble(next()); }

    }
}