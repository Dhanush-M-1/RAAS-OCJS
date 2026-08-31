import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args) {
        new Thread(null, new Runnable() {
            public void run() {
                solve();
            }
        }, "1", 1 << 26).start();
    }
    static void solve () {
        FastReader fr =new FastReader();    PrintWriter op =new PrintWriter(System.out);
        
        int n =fr.nextInt() ,u ,v ,i ,dg[] =new int[n] ;
        for (i =1 ; i<n ; ++i) {
            u =fr.nextInt()-1 ; v =fr.nextInt()-1 ; dg[u]++ ;   dg[v]++ ;
        }
        for (i =0 ; i<n ; ++i) {
            if (dg[i]==2)   break;
        }
        if (i<n)    op.println("NO") ;  else    op.println("YES") ;
        op.flush();    op.close();
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br =new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st==null || (!st.hasMoreElements())) 
            {
                try
                {
                    st =new StringTokenizer(br.readLine());
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }
                
            }
            return st.nextToken();
        }

        String nextLine() {
            String str ="";

            try
            {
                str =br.readLine();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }

            return str;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next()) ;
        }
    }
}