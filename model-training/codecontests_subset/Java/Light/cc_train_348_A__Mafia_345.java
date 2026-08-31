import java.util.*;
import java.io.*;

public class CF_349_C_MAFIA
{

    public static void main (String [] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt() - 1 , mx = 0;

        long x = 0 ;

        for( int i = 0 ; i <= n ; i++ )
        {
            int xx = sc.nextInt();

            x += xx;

            mx = Math.max(mx , xx);
        }

        System.out.println(Math.max((x + n - 1) / n , mx));

    }

    static class Scanner
    {
        BufferedReader br ;
        StringTokenizer st ;

        Scanner (InputStream in) throws Exception { br = new BufferedReader(new InputStreamReader(in));}

        String next() throws Exception { while(st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine()); return  st.nextToken() ;}

        int nextInt() throws Exception { return Integer.parseInt(next()) ; }

        long nextLong () throws Exception { return  Long.parseLong(next()) ; }
    }

}