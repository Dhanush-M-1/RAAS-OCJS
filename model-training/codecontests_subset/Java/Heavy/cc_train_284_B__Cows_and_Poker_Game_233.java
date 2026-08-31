/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 17.03.13
 * Time: 12:27
 * To change this template use File | Settings | File Templates.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;



public class z {



    public static void main(String... args) throws IOException
    {
       int n =nextInt();
              String s = nextToken();
        int a =0,f=0,in=0;
        for ( int i =0;i<n;i++ ){

            if(s.charAt(i)=='A')  a++;
            if(s.charAt(i)=='I')in++;
            if(s.charAt(i)=='F') f++;

        }


       if(in ==0 ) out.print(a);else
           if(in==1) out.print(1);
              else out.print(0);





        out.close();

    }



    public static PrintWriter out = new PrintWriter(System.out);
    public static StringTokenizer st;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static String nextToken() throws IOException {
        while ( st == null || !st.hasMoreTokens() ) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    public static int nextInt() throws NumberFormatException, IOException {
        return Integer.parseInt(nextToken());
    }

    public static double nextDouble() throws NumberFormatException, IOException {
        return Double.parseDouble(nextToken());
    }

    public static long nextLong() throws NumberFormatException, IOException {
        return Long.parseLong(nextToken());
    }

    public static int[] ReadIntArray(int n) throws IOException {
        int[] a = new int[n];
        for ( int i = 0; i < n; i++ ) {
            a[i] = nextInt();
        }
        return a;

    }

}
