import java.math.BigInteger;
import java.util.*;
import java.io.*;
public class Main3 {
    static PrintWriter pr;
    static Scanner scan;
    static BufferedReader br;
    static StringTokenizer st;
    static long Mod = 1000000007;
    public static void main(String args[]) throws Exception {
        pr = new PrintWriter(System.out);
        scan = new Scanner(System.in);
        br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt();
        while(t--!=0) {
            int[] a = intArray(3);
            int max = 0;
            for (int i = 0; i <= a[0] && 2 * i <= a[1]; i++) {
                int x = Math.min(a[1]-2*i,(a[2]/2));
                max = Math.max(max, 3*i + 3*x );

            }
            pr.println(max);
        }




        pr.close();

    }
    static long Pow(long a, long b){
        long r=1;
        while(b!=0){
            if(b%2==1) {
                r = (r * a)%Mod;
            }
            a=(a*a)%Mod;
            b/=2;
        }
        return r;
    }

    public static int inputInt() throws IOException{
        return Integer.parseInt(br.readLine());
    }

    public static long inputLong() throws IOException{
        return Long.parseLong(br.readLine());
    }

    public static String inputString() throws IOException{
        return br.readLine();
    }

    public static  int[] intArray(int n) throws IOException{
        int a[] = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        return a;
    }

    public static  long[] longArray(int n) throws IOException{
        long a[] = new long[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            a[i] = Long.parseLong(st.nextToken());
        }
        return a;
    }
    public static  double[] doubleArray(int n) throws IOException{
        double a[] = new double[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            a[i] = Double.parseDouble(st.nextToken());
        }
        return a;
    }

    public static String[] stringArray(int n) throws IOException{
        String a[] = new String[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            a[i] = st.nextToken();
        }
        return a;
    }

    public static long gcd(long a,long b){
        if(b==0){
            return a;
        }
        else{
            return gcd(b,a%b);
        }
    }

}