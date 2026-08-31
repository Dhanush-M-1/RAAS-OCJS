
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Test {

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
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

    public static void main(String args[]) {
        FastScanner in = new FastScanner();
        double a = in.nextDouble();
        double b = in.nextDouble();
        double c = in.nextDouble();

        if(a==0&&b==0&&c==0){
            System.out.println(-1);
            return;
        }
        if(a==0&&b==0){
            System.out.println(0);
            return;
        }
        if(a==0){
            System.out.println(1);
            System.out.println(-1*c/b);
            return;
        }
        double d = b*b-4*a*c;
        if(d<0){
            System.out.println(0);
            return;
        }
        if(d==0){
            System.out.println(1);
            System.out.println(-1*b/(2*a));
            return;
        }
        System.out.println(2);
        double root1 = (-b+Math.sqrt(d))/(2*a);
        double root2 = (-b-Math.sqrt(d))/(2*a);
        System.out.println(Math.min(root2,root1));
        System.out.println(Math.max(root1,root2));
    }
}