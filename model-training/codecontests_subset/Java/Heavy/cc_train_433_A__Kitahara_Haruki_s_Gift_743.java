
import java.io.*;
import java.util.*;

public class Main {

    static int mod=1000000007;
    public static int[] sort(int[] a){
        int n=a.length;
        ArrayList<Integer> ar=new ArrayList<>();
        for(int i=0;i<a.length;i++){
            ar.add(a[i]);
        }
        Collections.sort(ar);
        for(int i=0;i<n;i++){
            a[i]=ar.get(i);
        }
        return a;
    }
    public static long pow(long a, long b){
        long result=1;
        while(b>0){
            if (b % 2 != 0){
                result=(result*a)%mod;
                b--;
            }
            a=(a*a)%mod;
            b /= 2;
        }
        return result;
    }
    public static long gcd(long a, long b){
        if (a == 0){
            return b;
        }
        return gcd(b%a, a);
    }
    public static long lcm(long a, long b){
        return a*(b/gcd(a,b));
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }

        long nextLong() { return Long.parseLong(next()); }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    public static void main(String args[]) throws IOException {
        FastReader sc = new FastReader();
      int n = sc.nextInt();
      
      int count=0;
      
        if(n==1)
            System.out.println("NO");
        else {
            for (int i = 0; i < n; i++) {
                int a = sc.nextInt();
                if (a == 100)
                    count++;
            }
            if ( count%2==1)
                System.out.println("NO");
            else if(count ==0 && n%2==1 )
                System.out.println("NO");
                else
                System.out.println("YES");
        }
      
    }


}


