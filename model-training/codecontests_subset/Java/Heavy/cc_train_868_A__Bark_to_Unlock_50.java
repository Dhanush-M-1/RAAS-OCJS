import java.io.*;
import java.util.*;

/**
 *
 * @author arif_
 * date: 
 * algo: 
 * diff: 
 */
public class TaskA{
    /* START OF I/O ROUTINE */
    // PrintWriter for faster output
    public static PrintWriter out;

    // MyInputReader class for faster input
    public static class MyInputReader {
        BufferedReader br;
        StringTokenizer st;

        public MyInputReader(InputStream stream) {
            br = new BufferedReader(new InputStreamReader(stream), 32768);
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

        String nextLine(){
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    } // end of class MyInputReader
    /* END OF I/O ROUTINE */


    public static void main(String[] args) {
        MyInputReader in = new MyInputReader(System.in);
        out = new PrintWriter(new BufferedOutputStream(System.out));

        String pass = in.next();
        int n = in.nextInt();
        String ans = "NO";
        boolean p1 = false, p2 = false;
        while(n-- > 0) {
            String word = in.next();
            if(word.equals(pass)) ans = "YES";
            if(word.charAt(0) == pass.charAt(1)) p1 = true;
            if(word.charAt(1) == pass.charAt(0)) p2 = true;
        }
        if(p1 && p2) ans = "YES";
        
        out.println(ans);
        out.close();
    } // end of method main()
} // end of class Main
