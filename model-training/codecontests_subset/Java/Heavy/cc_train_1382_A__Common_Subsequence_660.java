import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class CF{
    //---- SOLUTION STARTS HERE
    static void solve() throws IOException {

        int x[]=ai(2);
        int a[]=ai(x[0]);
        int b[]=ai(x[1]);
        Arrays.sort(a);
        HashMap<Integer,Integer> p=new HashMap<Integer, Integer>();
        for(int i=0;i<x[1];i++)
        {
            if (p.containsKey(b[i]))
                p.put(b[i],(p.get(b[i]) + 1));
            else
                p.put(b[i],1);
        }
        int flag=0,z=0;
        for(int i=0;i<x[0];i++)
        {

            if(p.containsKey(a[i]))
            {
                flag=-1;
                z=a[i];
                break;
            }
        }
        if(flag==-1)
        {
            System.out.println("YES");
            System.out.println("1"+" "+z);
        }
        else
            System.out.println("NO");
    }
    //----SOLUTION ENDS HERE

    public static void main(String[] args) throws IOException {
        int test = i();
        for (int i = 0; i < test; i++) {
            solve();
        }

    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static String s() throws IOException {
        return (br.readLine());
    }

    static int i() throws IOException {
        return (Integer.parseInt(br.readLine().trim()));
    }

    static long l() throws IOException {
        return (Long.parseLong(br.readLine()));
    }

    static int[] ai(int n) throws IOException {
        int a[] = new int[n];
        String s = s();
        StringTokenizer st =new StringTokenizer(s);
        int i = 0;
        while (st.hasMoreTokens()) {

            a[i] = Integer.parseInt(st.nextToken());
            i += 1;
        }
        return a;

    }

    static char[] ci(int n) throws IOException {
        char a[] = new char[n];
        String s = s();
        StringTokenizer st = new StringTokenizer(s);
        int i = 0;
        while (st.hasMoreTokens()) {

            a[i] = st.nextToken().charAt(0);
            i += 1;
        }
        return a;
    }

    static double[] ad(int n) throws IOException {
        double a[] = new double[n];
        String s = s();
        StringTokenizer st = new StringTokenizer(s);
        int i = 0;
        while (st.hasMoreTokens()) {

            a[i] = Double.parseDouble(st.nextToken());
            i += 1;
        }
        return a;
    }

    static long[] al(int n) throws IOException {
        long a[] = new long[n];
        String s = s();
        StringTokenizer st = new StringTokenizer(s);
        int i = 0;
        while (st.hasMoreTokens()) {

            a[i] = Long.parseLong(st.nextToken());
            i += 1;
        }
        return a;
    }

    static int bit(long n) {
        return (n == 0) ? 0 : (1 + bit(n & (n - 1)));
    }

    static String[] as(int n) throws IOException {
        String a[] = new String[n];
        String s = s();
        StringTokenizer st = new StringTokenizer(s);
        int i = 0;
        while (st.hasMoreTokens()) {

            a[i] = st.nextToken();
            i += 1;
        }
        return a;
    }


}
