// 
import java.math.*;
import java.util.*;
import java.io.*;
  
public class A { 
  
    static int test = 10; // 0 for local testing, 1 for std input

    static BufferedReader in;
    static PrintWriter out = new PrintWriter(System.out);
    static String file = "../in";
    static int inf = 1_000_000;

    static void swap(int[]ary, int i, int j)
    {
        int t = ary[i];
        ary[i] = ary[j];
        ary[j] = t;
    }
    
    static String[] split() throws Exception
    {
        return in.readLine().split(" ");
    }

    static int readInt() throws Exception
    {
        return Integer.valueOf(in.readLine());
    }

    static int[] toIntArray() throws Exception
    {
        String[] sp = split();
        int n = sp.length;
        int[] ary = new int[n];
        for(int i = 0; i < n; i++) ary[i] = Integer.valueOf(sp[i]);
        return ary;
    }

    static long[] toLongArray() throws Exception
    {
        String[] sp = split();
        int n = sp.length;
        long[] ary = new long[n];
        for(int i = 0; i < n; i++) ary[i] = Long.valueOf(sp[i]);
        return ary;
    }    

    public static void main(String[] args) throws Exception
    {
        int _k = Integer.valueOf("1");
        if(test > 0) in = new BufferedReader(new InputStreamReader(System.in));
        else in = new BufferedReader(new FileReader(file));
        if(test < 0) {String[] str = in.readLine().split(" ");
            char[] cc = str[0].toCharArray();
        }

        
        
        /****************************************************/  
        /****************************************************/
        /****************************************************/
        /****************************************************/

        int n = readInt();
        for(int i = 0; i < n; i++)
        {
            int m = readInt();
            int[] ary = toIntArray();
            if(ary[0] + ary[1] <= ary[m - 1])
            {
                // impossible
                out.printf("1 2 %d\n", m);
            }
            else out.printf("-1\n");
        }
        
        /****************************************************/
        /****************************************************/
        /****************************************************/
        /****************************************************/

        out.flush();
    }

    static boolean canPass(int initial, int[] ary)
    {
        int n = ary.length;
        int enegy = 0;
        for(int i = 0; i < n; i++)
        {
            enegy += initial - ary[i];
            if(enegy < 0) return false;
            initial = ary[i];
        }
        return true;
    }
}