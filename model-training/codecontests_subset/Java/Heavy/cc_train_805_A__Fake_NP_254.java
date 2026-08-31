
import java.io.*;
import java.util.*;


public class Main {

    static StringBuilder data = new StringBuilder();
    final static FastReader in = new FastReader();


    public static void main(String[] args) {
        int l = in.inT(), r = in.inT();
        if (l == r) {
            System.out.println(l);
        } else {
           int tw=(r-l)/2+(l%2==0?1:0);
            int th=(r-l)/3+(l%3==0?1:0);
            System.out.println(tw>=th?2:3);
        }
    }


    static void fileOut(String s) {
        File out = new File("output.txt");
        try {
            FileWriter fw = new FileWriter(out);
            fw.write(s);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        public FastReader(String path) {
            try {
                br = new BufferedReader(new
                        InputStreamReader(new FileInputStream(path)));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int inT() {
            return Integer.parseInt(next());
        }

        long lonG() {
            return Long.parseLong(next());
        }

        float floaT() {
            return Float.parseFloat(next());
        }

        double doublE() {
            return Double.parseDouble(next());
        }


        String line() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

}