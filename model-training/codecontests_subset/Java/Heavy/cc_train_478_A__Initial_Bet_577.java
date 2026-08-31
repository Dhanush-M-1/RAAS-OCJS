import java.util.*;
import java.io.*;

public class Main {
//            File file = new File("input.txt");
//            Scanner in = new Scanner(file);
//            PrintWriter out = new PrintWriter(new FileWriter("output.txt"));
	static char[] arr = new char[140000];
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
        FastReader in = new FastReader();
        
        int sum = 0;
        for(int i = 0; i<5; i++)
        	sum+=in.nextInt();
        if(sum%5==0 && sum>=5) {
        	System.out.println(sum/5);
        }else System.out.println(-1);
        
        
        
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
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