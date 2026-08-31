import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Codeforces {

    PrintWriter out = new PrintWriter(System.out);
    int n,k,a,b,q;
    int[]A;
    int[]B;
    void updateA(int i, int val) {
        while (i < n) {
            A[i] += val;
            i |= i + 1;
        }
    }
    void updateB(int i, int val) {
        while (i < n) {
            B[i] += val;
            i |= i + 1;
        }
    }
    int readA(int i) {
        int sum=0;
        while (i >= 0) {
            sum += A[i];
            i &= i + 1;
            i--;
        }
        return sum;
    }
    int readB(int i) {
        int sum=0;
        while (i >= 0) {
            sum += B[i];
            i &= i + 1;
            i--;
        }
        return sum;
    }

    public  void solve() {
        FastScanner fs = new FastScanner();
        n = fs.nextInt();
        k = fs.nextInt();
        a = fs.nextInt();
        b = fs.nextInt();
        q = fs.nextInt();
        A = new int[n];
        B = new int[n];
        int[]thimbles = new int[n];
        for(int i=0;i<q;i++){
            int type = fs.nextInt();
            if(type == 1){
                int di = fs.nextInt() - 1,ai = fs.nextInt();

                if(thimbles[di] < a)
                    updateA(di,Math.min(ai,a-thimbles[di]));

                if(thimbles[di] < b)
                    updateB(di,Math.min(ai,b-thimbles[di]));

                thimbles[di] += ai;
            }else{
                int pi = fs.nextInt()-1;
                long ans = readA(n-1)-readA(pi+k-1)+readB(pi-1);
                out.println(ans);
            }
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
    static class FastScanner {
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