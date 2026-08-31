import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
public class CP {
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
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
    }
    public static int lowerBound
    (Integer[] array, int length, int value) {
        int l = 0;
        int r = length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (value < array[mid]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
    public static long gcd(long a, long b){
        if (b == 0)
            return a;
        else return gcd(b, a % b);
    }
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
       // int T = sc.nextInt();while (T--!=0)
        {
            solve();
        }
    }
    public static void solve(){
//////////////////////////////////////////////////////////////////////
      Scanner sc = new Scanner(System.in);
       int c1=sc.nextInt();
       int c2=sc.nextInt();
       int r1=sc.nextInt();
       int r2=sc.nextInt();
       int d1=sc.nextInt();
       int d2=sc.nextInt();
       int d = (d1+c2-r1)/2;
       int a=r1-c2+d;
      int c = r2-d;
       int b=c2-d;
       if(a==b || a==c || a==d || b==c || b==d ||  c==d ){
           System.out.println(-1);
           return;
       }
       if(a==0 || b==0 || c==0 || d==0){
           System.out.println(-1);
           return;
       }
       if(a>9 || b>9 || c>9 || d>9){
           System.out.println(-1);
           return;
       }
        System.out.println(a+" " + c+'\n'+b +" " + d);
///////////////////////////////////////////////////////////////////////
    }

}