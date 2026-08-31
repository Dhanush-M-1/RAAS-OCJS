import java.io.*;
import java.util.StringTokenizer;


public class Main {

    static StringBuilder data;


    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        FastReader in = new FastReader();
        String n=in.nextLine();
data= new StringBuilder(in.nextLine());
        int s = -1, e = -1;
        for (int i = 0; i < data.length() - 1; i++) {
            if (data.codePointAt(i) > data.codePointAt(i + 1)) {
                s = i + 1;
                e = i + 2;
                break;
            }
        }
        if (s != -1) {
            System.out.println("YES");
            System.out.println(s + " " + e);
        } else {
            System.out.println("NO");
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

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        float nextFloat() {
            return Float.parseFloat(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }


        String nextLine() {
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