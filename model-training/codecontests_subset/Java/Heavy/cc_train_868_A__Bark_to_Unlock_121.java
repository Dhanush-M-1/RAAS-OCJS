import java.util.*;
import java.io.*;


public class Main {
    static boolean stdout = true;
    static String fileName = "";
    static InputReader in;
    static PrintWriter out;

    static class Solution {
        Solution() {
            String password = in.next();
            int n = in.nextInt();
            String[] words = new String[n];
            for(int i=0; i<n; i++) {
                words[i] = in.next();
            }
            
            String attempt = "";
            boolean flag = false;
            for(int i=0; i<n; i++) {
                attempt = words[i];
                for(int j=0; j<n; j++) {
                    String modified = attempt + words[j];
                    if(modified.equals(password) || modified.contains(password))
                        flag = true;
                }
                if(attempt.equals(password) || attempt.contains(password))
                    flag = true;
            }
            if(flag)
                out.println("YES");
            else out.println("NO");
        }
    }

    public static void main(String[] args) throws IOException {
        if(stdout) {
            in = new InputReader();
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        } else {
            in = new InputReader(fileName+".in");
            out = new PrintWriter(new BufferedWriter(new FileWriter(fileName+".out")));
        }
        new Solution();
        out.close();
    }

    static class InputReader {
        public BufferedReader br;
        public StringTokenizer st;
        public InputReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
            
        }
        public InputReader(String fileToRead) {
            try {
                br = new BufferedReader(new FileReader(fileToRead));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        public String next() {
            while(st==null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }
        public int nextInt() {
            return Integer.parseInt(next());
        }
        public char nextChar() {
            return next().charAt(0);
        }
        public long nextLong() {
            return Long.parseLong(next());
        }
        public double nextDouble() {
            return Double.parseDouble(next());
        }
        public String nextLine() {
            String s = "";
            try {
                s = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return s;
        }
    }
}