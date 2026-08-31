import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

public class main {

    static StringTokenizer st;
    static BufferedReader br;
    static PrintWriter pw;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
                System.out)));

        long n = nextInt(), all = 0, get1 = 0, get2 = 0;
 
        for(long i=0;i<n;i++)
        {
            all+=nextInt();
        }
        n--;
        
        for(long i=0;i<n;i++)
        {
            get1+=nextInt();
        }
        n--;
        get1=all-get1;
        System.out.println(get1);
        for(long i=0;i<n;i++)
        {
            get2+=nextInt();
        }
        get2=all-get2;
        
        
        System.out.println( get2-get1);
        pw.close();
    }

    private static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    private static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }

}