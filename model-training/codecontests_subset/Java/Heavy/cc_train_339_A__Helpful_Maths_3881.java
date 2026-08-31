import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.run();
    }


    public void run() throws Exception {
        PrintWriter pr = null;
        InputReader sc = null;
        
        pr=new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        sc = new InputReader(System.in);
    //  sc = new InputReader(new FileInputStream(new File("input.txt")));
        
        String line = sc.next();
        String[] tokens = line.split("\\+");
        Arrays.sort(tokens);
        System.out.printf(tokens[0]);
        for (int i = 1; i < tokens.length; i++) System.out.printf("+%s",tokens[i]); 
        
        pr.close();
    }
    
    static class InputReader {
        public BufferedReader reader;

        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                }
                catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public float nextFloat() {
            return Float.parseFloat(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

    }

}
