import java.io.IOException;
import java.io.*;
import java.util.Random;
import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: alexey
 * Date: 01.04.13
 * Time: 19:16
 * To change this template use File | Settings | File Templates.
 */
public class jvcls {
    public static void main(String... args) throws IOException
    {
     String s = nextToken();
        int n = nextInt();
       s= s.toLowerCase();
        for(int i =0;i<s.length();i++)
        {
            char t = s.charAt(i);
            if((int)t<n+97)
            {
                out.print(Character.toUpperCase(t));
            } else
            {
                out.print(Character.toLowerCase(t));
            }

        }



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
    public static void PrintArray(int[] arr) throws IOException{
        for ( int i = 0; i < arr.length; i++ )
            out.print(arr[i] + " ");

    }
    public static long[] ShuffleArray(long [] arr)
    {
        Random rnd = new Random();

        int n = arr.length;
        long    temp;
        int     ind;
        while (n > 1)
        {
            ind = rnd.nextInt(n--);
            temp = arr[ind];
            arr[ind] = arr[n];
            arr[n] = temp;
        }

        return arr;
    }
}







