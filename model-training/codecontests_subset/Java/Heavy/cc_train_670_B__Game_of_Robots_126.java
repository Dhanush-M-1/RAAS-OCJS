import java.io.*;
import java.util.*;

public class Main
{
    static BufferedReader in;
    static PrintWriter out;

    static void solve() throws Exception{
        int n = nextInt();
        int k = nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        b[0] = 1;
        int check = 0;
        boolean f = false;
        boolean fi = false;
        for (int i = 0, l = 1; i < n; i++, l++)
        {
            int x = nextInt();
            if(i > 0){
                b[i] = b[i-1]+ l;

            }
            if(b[i]> k && !f)
            {
                check = i;
                f = true;
            }
            if(b[i] == k){
                out.print(x);
                fi = true;
            }
            a[i] = x;
        }
        if(!fi)
        {
          /*  for (int i = 0; i < b.length; i++)
            {
                System.out.print(b[i] + " ");
            }
            System.out.println("check = " + check);*/
            if (check == 0) out.print(1);
            else
            {
                int z = b[check - 1];
                for (int i = 0; i <= check; i++)
                {
                    z++;
                    if (z == k)
                    {
                        out.print(a[i]);
                    }
                }

            }
        }
    }

    public static void main(String[] args) throws Exception
    {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        solve();
        out.flush();
    }


   /* static int nextInt() throws Exception{
        in.nextToken();
        return (int)in.nval;
    }

    static byte nextByte() throws Exception{
        in.nextToken();
        return (byte)in.nval;
    }

    static long nextLong() throws Exception{
        in.nextToken();
        return (long)in.nval;
    }*/
    static int nextInt() throws Exception{
        char c = (char)in.read();
        while(true){
            if(c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9' || c == '0')
                break;
            c = (char)in.read();
        }
        int k = 0;

        while(c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9' || c == '0'){
            k*=10;
            k+=c-48;
            c = (char)in.read();
        }
        return k;
    }

    static int min(int a,int b){
        return a < b ? a : b;
    }

    static int max(int a,int b){
        return a > b ? a : b;
    }
}
