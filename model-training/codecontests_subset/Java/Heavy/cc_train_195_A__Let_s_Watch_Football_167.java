import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;


public class Main
{
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    static StringTokenizer datos = new StringTokenizer(""); 

    public static String next() throws IOException
    {
        while(!datos.hasMoreTokens()){
            String s = in.readLine();
            if(s==null) return null;
            datos = new StringTokenizer(s);
        }
        return datos.nextToken();
    }
    
    public static int nextInt() throws IOException
    {
        return Integer.parseInt(next());
    }
    
    public static void main(String[] args)throws IOException
    {
        int a = nextInt();
        int b = nextInt();
        int c = nextInt();
        int l = 0;
        int r = (a * c) / b;
        int res = Integer.MAX_VALUE;
        w:while(l<=r){
            int mid = l + (r - l) / 2;
            int datos = mid * b;
            for(int i=0;i<=c;i++){
                if(datos<i*a){
                    l = mid + 1;
                    continue w;
                }
                datos += b;
            }
            res = Math.min(res, mid);
            r = mid - 1;
        }
        out.println(res);
        out.flush();
    }
}
