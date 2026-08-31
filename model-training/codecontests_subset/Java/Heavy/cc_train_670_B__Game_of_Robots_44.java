import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class NewClass {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        long[] a = la(in.readLine(), 2);
        int n = (int)a[0];
        long k = a[1];
        long[] id = la(in.readLine(), n);
        long index=1;
        long num1 = 0;
        for (int i=1; i<=n; i++) {
            long num;
            if (i%2==0) {
                num = i/2;
                num *= i+1;
            }
            else {
                num = (i+1)/2;
                num *= i;
            }
            if (k<num) {
                index = i-1;
                break;
            }
            else if (k==num) {
                index=i;
                break;
            }
        }
        
        if (index%2==0) {
                num1 = index/2;
                num1 *= index+1;
            }
            else {
                num1 = (index+1)/2;
                num1 *= index;
            }
        long diff = k-num1;
        int d1 = (int)diff;
        int i1 = (int)index;
        if (diff==0) {
            out.write(id[i1-1]+"");
        }
        else {
            out.write(id[d1-1]+"");
        }
        out.write("\n");
        out.flush();
    }
    
    private static int ip (String s) {
        int n = Integer.parseInt(s);
        return n;
    }
    
    private static long lp(String s) {
        long n = Long.parseLong(s);
        return n;
    }
    
    private static double dp (String s) {
        double n = Double.parseDouble(s);
        return n;
    }
    
    private static int[] ia (String s, int n) {
        String[] s1 = s.split(" ");
        int[] A = new int[n];
        for (int i=0; i<n; i++) {
            A[i] = Integer.parseInt(s1[i]);
        }
        return A;
    }
    
    private static long[] la (String s, int n) {
        String[] s1 = s.split(" ");
        long[] A = new long[n];
        for (int i=0; i<n; i++) {
            A[i] = Long.parseLong(s1[i]);
        }
        return A;
    }
    
    private static double[] da(String s, int n) {
        String[] s1 = s.split(" ");
        double[] A = new double[n];
        for (int i=0; i<n; i++) {
            A[i] = Double.parseDouble(s1[i]);
        }
        return A;
    }
}