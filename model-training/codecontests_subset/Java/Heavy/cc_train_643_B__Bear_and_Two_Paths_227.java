import java.io.*;
import java.util.*;

public class Codeforces {

    public  void solve() {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int n = fs.nextInt(), k = fs.nextInt();
        int a = fs.nextInt(), b = fs.nextInt(), c = fs.nextInt(), d = fs.nextInt();
        if( n == 4 || k <= n )
            out.println("-1");
        else{
            out.print(a +" "+c+" ");
            for(int i=1;i<=n;i++){
                if( i==a || i == b || i == c || i == d )continue;
                out.print(i+" ");
            }
            out.print(d+" "+b+"\n");
            out.print(c+" "+a+" ");
            for(int i=1;i<=n;i++){
                if( i==a || i == b || i ==c || i == d )continue;
                out.print(i+" ");
            }
            out.print(b+" "+d+"\n");
        }
        out.flush();

    }

    public static void main(String[]args){
        try{
            new Codeforces().solve();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    class FastScanner {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer("");
        String next() {
            while (!st.hasMoreTokens())
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }
        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
        long nextLong() {
            return Long.parseLong(next());
        }
    }
}