import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Main mm = new Main();
        mm.problemA(new Input(new BufferedReader(new InputStreamReader(System.in))), out);
        out.close();
    }

    static void problemA(Input in, PrintWriter out) throws IOException {
        int q=in.nextInt();
        for (; q > 0; q--) {
            int l=in.nextInt(),r=in.nextInt(),d=in.nextInt();
            if(d<l || d>r){
                out.println(d);
                continue;
            }
            out.println((r/d+1)*d);
        }
    }

    static class Input {
        BufferedReader in;
        StringBuilder sb = new StringBuilder();

        public Input(BufferedReader in) {
            this.in = in;
        }

        public Input(String s) {
            this.in = new BufferedReader(new StringReader(s));
        }

        public String next() throws IOException {
            sb.setLength(0);
            while (true) {
                int c = in.read();
                if (c == -1) {
                    return null;
                }
                if (" \n\r\t".indexOf(c) == -1) {
                    sb.append((char) c);
                    break;
                }
            }
            while (true) {
                int c = in.read();
                if (c == -1 || " \n\r\t".indexOf(c) != -1) {
                    break;
                }
                sb.append((char) c);
            }
            return sb.toString();
        }

        public char nextChar() throws IOException {
            while (true) {
                int c = in.read();
                if (c == -1) {
                    return (char) c;
                }
                if (" \n\r\t".indexOf(c) == -1) {
                    return (char) c;
                }
            }
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }
}