import java.io.*;
import java.util.*;


public class Main {

    static StringBuilder data = new StringBuilder();
    final static FastReader in = new FastReader();


    public static void main(String[] args) {
       int n=in.nextInt();
       int [][]a=new int[26][26];
       String s=in.nextLine();
        for (int i = 0; i < s.length()-1; i++) {
            a[s.charAt(i)-'A'][s.charAt(i+1)-'A']++;
        }
        int max=0;
        char f='A',b='A';
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if(a[i][j]>max){
                    f=(char)('A'+i);
                    b=(char)('A'+j);
                    max=a[i][j];
                }
            }
        }
        System.out.println(f+""+b);
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